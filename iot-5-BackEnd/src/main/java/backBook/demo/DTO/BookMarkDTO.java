package backBook.demo.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "bookmark")
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BookMarkDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long bookid;
    private String nickname;
    private int page;


}
