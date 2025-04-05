package backBook.demo.DAO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class RankBook {

    private int bookid;
    private String title;
    private int cnt;
    private String thema;

    public RankBook(int bookid, String title, int cnt, String thema){
        this.bookid = bookid;
        this.title = title;
        this.cnt = cnt;
        this.thema = thema;

    }
}
