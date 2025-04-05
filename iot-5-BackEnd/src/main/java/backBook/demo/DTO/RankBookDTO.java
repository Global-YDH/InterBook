package backBook.demo.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "RankBook")
@AllArgsConstructor
@NoArgsConstructor
public class RankBookDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Long bookid;
    private String title;
    private int cnt;
    private String thema;



}
