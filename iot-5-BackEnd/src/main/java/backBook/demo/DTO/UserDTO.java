package backBook.demo.DTO;

import backBook.demo.DAO.UserRole;
import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Table(name="user")
@Entity
@Builder
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userIndex;
    private String userId;
    private String password;
    private int bookmark;
    private int likebook;
//    private String readbook;
    private UserRole userRole;
    private String nickname;
    private String email;
    @Convert(converter = StringArrayConverter.class) // 컨버터 사용
    private String [] thema;

    @Builder
    public UserDTO(long userIndex, String userId, String password, int bookmark, int likebook, UserRole userRole, String nickname, String email, String [] thema){
        this.userIndex = userIndex;
        this.userId = userId;
        this.password = password;
        this.thema = thema;
        this.bookmark = bookmark;
        this.likebook = likebook;
//        this.readbook = readbook;
        this.nickname = nickname;
        this.userRole = userRole;
        this.email = email;
    }

    public UserDTO() {

    }
}
