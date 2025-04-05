package backBook.demo.DAO;


import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Table(name="user")

public class User {

    private long userIndex;
    private String id;
    private String password;
    private int bookmark;
//    private int likebook;
//    private String readbook;
    private UserRole userRole;
    private String nickName;
    private String email;
    private String thema;


    public int getBookmark() {
        return bookmark;
    }

//    public int getLikebook() {
//        return likebook;
//    }

    public long getUserIndex() {
        return userIndex;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

//    public String getReadbook() {
//        return readbook;
//    }

    public void setBookmark(int bookmark) {
        this.bookmark = bookmark;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public void setLikebook(int likebook) {
//        this.likebook = likebook;
//    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public void setReadbook(String readbook) {
//        this.readbook = readbook;
//    }

    public void setUserIndex(long userIndex) {
        this.userIndex = userIndex;
    }
    public String getNickName(){
        return nickName;
    }
    public String getEmail(){return email;}
}
