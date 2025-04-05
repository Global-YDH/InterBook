package backBook.demo.Controller;

import backBook.demo.DTO.UserDTO;
import backBook.demo.DTO.UserLikeBookDTO;
import backBook.demo.DTO.UserReadBookDTO;
import backBook.demo.Service.UserService;
import backBook.demo.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserService userService;

    //유저 정보 전달하는 코드 * /user 붙여야됨
    @GetMapping("/user-info")
    public ResponseEntity<UserDTO> getUserInfo(@RequestHeader("Authorization") String token) {
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String username = jwtUtil.extractUsername(token);
        UserDTO user = userService.getLoginUserByLoginId(username);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(user);
    }
    //유저가 읽은 책 다 가져오기
    @GetMapping("/user/{nickname}/books")
    public List<UserReadBookDTO> getUserReadBooks(@PathVariable String nickname){
        return userService.getUserReadBooks(nickname);
    }
    //유저가 읽은 책 갯수
    @GetMapping("/user/{nickname}/count")
    public int getUserReadCnt(@PathVariable String nickname){
        return userService.CountUserRead(nickname);
    }
    // 사용자가 좋아한 책 담기
    @PostMapping("/user/likeBook")
    public void saveUserLike(@RequestBody UserLikeBookDTO userLikeBookDTO){

        System.out.println(userLikeBookDTO.getUserId()+" "+ userLikeBookDTO.getBookId());
        userService.AddUserLike(userLikeBookDTO);
    }



}
