package backBook.demo.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; // Correct import for JPA
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "recent")
@Data
@Entity
public class RecentDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recentIndex;
    private long bookId;
    private String userId;

    public RecentDTO(int recentIndex, long bookId, String userId){
        this.recentIndex = recentIndex;
        this.bookId = bookId;
        this.userId = userId;
    }

    public RecentDTO(){
    }
}
