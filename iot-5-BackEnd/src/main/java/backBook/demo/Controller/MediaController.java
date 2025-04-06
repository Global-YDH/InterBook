package backBook.demo.Controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.sun.jdi.request.EventRequest;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
@RestController
public class MediaController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String MEDIA_DIR = "src/main/resources/static/media/";
    private static final String MUSIC_FILE_PATH = MEDIA_DIR + "output_music.wav";
    private static final String IMAGE_FILE_PATH = MEDIA_DIR + "output_image.png";
    @value("${aiServer})
    privatr string ai;
    @PostMapping("/fetch-media")
    public ResponseEntity<String> fetchMedia(@RequestBody EventRequest eventRequest) {
        
        String url = ai;
        try {
            ResponseEntity<JsonNode> mediaResponse = restTemplate.postForEntity(url, eventRequest, JsonNode.class);

            if (mediaResponse.getStatusCode().is2xxSuccessful() && mediaResponse.getBody() != null) {
                String musicStr = mediaResponse.getBody().get("music").asText();
                String imageStr = mediaResponse.getBody().get("image").asText();

                // Base64 디코딩
                byte[] musicBytes = Base64.getDecoder().decode(musicStr);
                byte[] imageBytes = Base64.getDecoder().decode(imageStr);

                // 디렉토리 생성
                File mediaDir = new File(MEDIA_DIR);
                if (!mediaDir.exists()) {
                    mediaDir.mkdirs();
                }

                // 음악 파일 저장
                try (FileOutputStream musicOutputStream = new FileOutputStream(MUSIC_FILE_PATH)) {
                    musicOutputStream.write(musicBytes);
                }

                // 이미지 파일 저장
                try (FileOutputStream imageOutputStream = new FileOutputStream(IMAGE_FILE_PATH)) {
                    imageOutputStream.write(imageBytes);
                }

                return ResponseEntity.ok("Files decoded and saved successfully");
            } else {
                return ResponseEntity.status(500).body("Failed to fetch media");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(500).body("Error decoding Base64 string: " + e.getMessage());
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            return ResponseEntity.status(500).body("FastAPI server error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/media/music")
    @ResponseBody
    public ResponseEntity<Resource> getMusicFile() {
        File file = new File(MUSIC_FILE_PATH);
        if (!file.exists()) {
            return ResponseEntity.status(404).body(null);
        }
        Resource resource = (Resource) new FileSystemResource(file);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"output_music.wav\"")
                .body(resource);
    }

    @GetMapping("/media/image")
    @ResponseBody
    public ResponseEntity<Resource> getImageFile() {
        File file = new File(IMAGE_FILE_PATH);
        if (!file.exists()) {
            return ResponseEntity.status(404).body(null);
        }
        Resource resource = (Resource) new FileSystemResource(file);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"output_image.png\"")
                .body(resource);
    }
}
