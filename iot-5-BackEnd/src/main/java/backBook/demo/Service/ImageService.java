package backBook.demo.Service;

import backBook.demo.DTO.ImageDTO;
import backBook.demo.DAO.Image;
import backBook.demo.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
public class ImageService {

    private Image image;


    @Autowired
    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository){
        this.imageRepository = imageRepository;
    }

//    public String findImage(long bookId, int page) {
//        Optional<ImageDAO> img = imageRepository.findByBookidAndPage(bookId, page);
//        String img2 = img.get().getImage();
//
//        System.out.println(img2);
//
//        return  img2;
//    }

    public String findImage(long bookId, int page) {
        Optional<ImageDTO> img = imageRepository.findByBookidAndPage(bookId, page);
        byte[] decodedBytes = Base64.getDecoder().decode(img.get().getImage());
        String decodedStr = new String(decodedBytes);
        return decodedStr;
    }
    public void addImage(ImageDTO imageDTO){
        imageRepository.save(imageDTO);
    }

}
