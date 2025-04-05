package backBook.demo.DTO;

import lombok.Data;

@Data
public class LoginRequest {
    private String userId;
    private String password;

    public String getuserId(){
        return userId;
    }
}
