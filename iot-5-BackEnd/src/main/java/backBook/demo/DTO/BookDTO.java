package backBook.demo.DTO;

import backBook.demo.DAO.Book;
import jakarta.persistence.*;
import lombok.Data;


@Table(name="book")
@Data
@Entity
public class BookDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY를 사용하여 자동 생성되는 ID를 사용
    private Long bookid; // bookId 필드를 Long으로 변경
    private int page;
    private String author;
//    @Lob
//    private byte[] picture;
    private String publisher;
    @Column(columnDefinition="LONGTEXT")
    private String story;

    private String title;
    private String theme;
    private int age;
    private int price;
    private String language;
    private String publication_date;
    private String summary;

    // getter, setter, 생성자 등 생략
    public BookDTO(Long bookid, int page, String author, String publisher, String story, String title, String theme, int age, int price, String language,
                   String publication_date, String summary){
        this.bookid = bookid;
        this.page = page;
        this.author = author;
//        this.picture = picture;
        this.publisher = publisher;
        this.story= story;
        this.title = title;
        this.theme = theme;
        this.age = age;
        this.price = price;
        this.language = language;
        this.publication_date = publication_date;
        this.summary = summary;
    }

    public BookDTO() {

    }
    public void update(Book book){
        this.bookid = book.getBookId();
        this.page = book.getPage();
        this.author = book.getAuthor();
        this.title = book.getTitle();
//        this.picture = book.getPicture();

        this.story = book.getStory();
        this.publisher = book.getPublisher();
        this.theme = book.getTheme();
        this.price = book.getPrice();
        this.language = book.getLanguage();
        this.publication_date = book.getPublication_date();
    }
    public interface BookDAOMapping{
        String getTitle();
    }
}
