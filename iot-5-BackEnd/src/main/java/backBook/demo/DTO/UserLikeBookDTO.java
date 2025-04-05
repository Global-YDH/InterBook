package backBook.demo.DTO;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="userLikeBook")
public class UserLikeBookDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    private String userId;
    private int bookId;


    public UserLikeBookDTO(String userId, int bookId){
        this.userId = userId;
        this.bookId =bookId;
    }
    public UserLikeBookDTO(){

    }

}
