package backBook.demo.DAO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class UserLikeBook {
    private Long id;
    private int likebook;
    private Long cartId;

}
