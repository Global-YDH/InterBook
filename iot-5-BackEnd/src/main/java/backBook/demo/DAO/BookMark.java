package backBook.demo.DAO;


import lombok.Data;

@Data
public class BookMark {
    private Long id;
    private Long bookid;
    private String nickname;
    private int page;

    public BookMark(Long bookid, String nickname, int page){
        this.bookid = bookid;
        this.nickname = nickname;
        this.page = page;
    }

}
