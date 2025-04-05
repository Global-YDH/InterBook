package backBook.demo.DTO;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name ="image")
@NoArgsConstructor
public class ImageDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int imageindex;
    @Column(columnDefinition="LONGTEXT")
    private String image;
    private int page;
    private String prompt;
    private int bookid;

    @Builder
    public ImageDTO(int imageindex, int bookid, int page, String image, String prompt) {
        this.imageindex = imageindex;
        this.image = image;
        this.bookid = bookid;
        this.page = page;
        this.prompt = prompt;
    }

    public interface ImageMapping {
        String getImage();
    }
}
