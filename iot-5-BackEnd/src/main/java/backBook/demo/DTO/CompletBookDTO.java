package backBook.demo.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="completbook")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompletBookDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long bookid;
    private String nickname;

    public CompletBookDTO(long bookid, String nickname){
        this.bookid = bookid;
        this.nickname = nickname;
    }

}
