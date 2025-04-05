package backBook.demo.DAO;


import lombok.Data;

@Data

public class Image {

    private long imageindex;
    private int bookid;
    private int page;
    private String prompt;
    private String imgae;

    public Image(Long imageindex, String image , int bookid, int page,String prompt){
        this.imageindex = imageindex;
        this.bookid = bookid;
        this.page = page;
        this.imgae = image;
        this.prompt = prompt;
    }
}
