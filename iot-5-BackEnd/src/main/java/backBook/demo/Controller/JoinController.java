package backBook.demo.Controller;

import backBook.demo.DTO.JoinRequest;
import backBook.demo.Service.AdminService;
import backBook.demo.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class JoinController {

    private final AdminService adminService;
    private final UserService userService;

    public JoinController(AdminService adminService, UserService userService) {
        this.adminService = adminService;
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> userAdd(@RequestBody JoinRequest req) {
        System.out.println(req);
        boolean flag = userService.checkLoginIdDuplication(req.getuserId());
        boolean flag2 = userService.checkLoginNickDuplication(req.getNickName());
        System.out.println("회원가입 진행중");
        if (flag == true) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("ID가 중복되었습니다.");
        } else if (flag2 == true) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("닉네임이 중복되었습니다.");
        } else {
            JoinRequest request = new JoinRequest();
            request.setUserId(req.getuserId());
            request.setPassword(req.getPassword());
            request.setNickname(req.getNickName());
            request.setUserRole(req.getUserRole());
            request.setEmail(req.getEmail());
            request.setThema(req.getThema());
            userService.join(request);
            return ResponseEntity.status(HttpStatus.OK).body("계정이 만들어 졌습니다."); // or any other error message
        }

    }

    @PostMapping("/checkEmail")
    public boolean checkEmail(@RequestBody Map<String, String> requestData) {
        String email = requestData.get("email");
        boolean flag = userService.checkLoginEmailDuplication(email);
        if (flag == true) {
            return flag;
        } else {

            return flag;
        }
    }

    @PostMapping("/checkId")
    public boolean checkId(@RequestBody Map<String, String> requestData) {
        String Id = requestData.get("userId");
        System.out.println(requestData + " " + Id);
        boolean flag = userService.checkLoginIdDuplication(Id);
        if (flag == true) {
            return flag;
        } else {
            System.out.println("중복 없어요");
            return flag;
        }
    }

    @PostMapping("/checkNickName")
    public boolean checkNickName(@RequestBody Map<String, String> requestData) {
        System.out.println(requestData);
        String NickName = requestData.get("nickname");
        boolean flag = userService.checkLoginNickDuplication(NickName);
        if (flag == true) {
            return flag;
        } else {
            return flag;
        }
    }
}