package backBook.demo.DAO;


import lombok.Builder;
import lombok.Data;

@Data
public class BookText {
    private long textIndex;
    private int bookid;
    private int page;
    private String bookwrite;

    @Builder
    public BookText(long textIndex, int bookid, int page,String bookwrite){
        this.textIndex = textIndex;
        this.bookid = bookid;
        this.page = page;
        this.bookwrite = bookwrite;
    }
    public String getBookWrite(){
        return bookwrite;
    }

}
