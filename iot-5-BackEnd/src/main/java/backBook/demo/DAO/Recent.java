package backBook.demo.DAO;

import lombok.Data;

@Data

public class Recent {
    private int recentIndex;
    private long bookId;
    private String userId;

    public Recent(int recentIndex,long bookId, String userId){
        this.recentIndex = recentIndex;
        this.bookId = bookId;
        this.userId = userId;
    }
}
