package backBook.demo.DTO;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name ="booktext")
public class BookTextDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long textIndex;
    private int bookid;
    private int page;
    @Column(columnDefinition="LONGTEXT")
    private String bookwrite;



    public BookTextDTO(long textIndex, int bookid, String bookwrite, int page){
        this.textIndex = textIndex;
        this.bookid = bookid;
        this.page = page;
        this.bookwrite = bookwrite;
    }
    public BookTextDTO(){

    }
    public interface BookMapping{
        String getBookwrite();
    }

}
