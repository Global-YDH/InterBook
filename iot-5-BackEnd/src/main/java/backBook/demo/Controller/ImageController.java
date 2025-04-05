package backBook.demo.Controller;

import backBook.demo.DTO.ImageDTO;
import backBook.demo.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ImageController {
    @Autowired
    private ImageService imageService;
    //책 가져오기
    @GetMapping("/image/{bookid}/{page}")
    public void findImage(@PathVariable long bookid , @PathVariable int page){
        System.out.println("출력 되나요?");

    }
    //책 저장
    @PostMapping("/image/save")
    public void saveImage(@RequestBody ImageDTO imageDTO){
        imageService.addImage(imageDTO);
    }
    // 이미지 수정 엔드포인트
//    @PostMapping("/image/update/{bookid}/{page}")
//    public ResponseEntity<String> updateImage(@PathVariable long bookid,@PathVariable int page, @RequestBody Image image) {
//        imageService.updateImage(bookid, page,image);
//        return ResponseEntity.ok("변경 되었습니다.");
//    }
//    @GetMapping("/test/img")
//    public String testImg(){
//        return imageService.findImage(2,3);
//
//    }
//    @GetMapping("/img/{bookId}/page/{page}")
//    public String getImageByBookIdAndPage(@PathVariable Long bookId, @PathVariable int page) {
//        return imageService.findImage(bookId,page);
//    }

}
