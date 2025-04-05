package backBook.demo.Controller;


import backBook.demo.DTO.JoinRequest;
import backBook.demo.DTO.UserDTO;
import backBook.demo.Service.UserService;
import backBook.demo.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final UserService userService;
    private final JwtUtil jwtUtil;
    @Autowired

    public LoginController(UserService userService,JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody JoinRequest req) {
        String id = req.getuserId();  // getuserId -> getUserId (확인)
        String password = req.getPassword();

        try {
            UserDTO user = userService.getLoginUserByLoginId(id);

            if (user == null) {
                // 사용자 없음
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }

            if (user.getPassword().equals(password)) {
                String token = jwtUtil.generateToken(id);
                return ResponseEntity.ok(token);
            } else {
                // 비밀번호 불일치
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("400");
            }
        } catch (Exception e) {
            // 기타 예외 처리
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("500");
        }
    }
}