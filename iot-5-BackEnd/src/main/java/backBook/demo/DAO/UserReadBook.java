package backBook.demo.DAO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserReadBook {

    private long userreadbookindex;
    private String nickName;
    private long bookId;
}
