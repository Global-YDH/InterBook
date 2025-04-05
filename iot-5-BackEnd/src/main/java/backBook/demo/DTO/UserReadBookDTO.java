package backBook.demo.DTO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="userreadbook")
@Entity
@NoArgsConstructor
public class UserReadBookDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userreadbookindex;
    private String nickName;
    private long bookId;

    public UserReadBookDTO(long userreadbookindex, String nickName, long bookId){
        this.userreadbookindex= userreadbookindex;
        this.nickName = nickName;
        this.bookId = bookId;
    }


}
