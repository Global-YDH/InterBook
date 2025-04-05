package backBook.demo.DTO;

import backBook.demo.DAO.UserRole;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class JoinRequest {

    @NotBlank(message = "id가 비어있습니다.")
    private String userId;
    @NotBlank(message = "password가 비어있습니다.")
    private String password;
    private String passwordCheck;
    @NotBlank(message = "닉네임이 비어있습니다.")
    private String nickname;
    private UserRole userRole;
    private String email;
    private String [] thema;

    public UserDTO toEntity() {
        return UserDTO.builder()
                .userId(this.userId)
                .password(this.password)
                .nickname(this.nickname)
                .userRole(UserRole.USER)
                .email(this.email)
                .thema(this.thema)
                .build();
    }

    // 비밀번호 암호화
    public UserDTO toEntity(String encodedPassword) {
        return UserDTO.builder()
                .userId(this.getuserId())
                .password(encodedPassword)
                .nickname(this.nickname)
                .userRole(UserRole.USER)
                .email(this.email)
                .build();
    }
    public String getPassword(){
        return password;
    }
    public String getuserId(){
        return userId;
    }
    public String getNickName() {return nickname;}
    public UserRole getRole() {return userRole;}
    public String getEmail() {return email;}
    public String [] getThema() {return thema;}

}
