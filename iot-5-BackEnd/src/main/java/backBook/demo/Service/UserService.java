package backBook.demo.Service;

import backBook.demo.DTO.*;
import backBook.demo.Repository.UserLikeBookRepository;
import backBook.demo.Repository.UserReadBookRepository;
import backBook.demo.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Base64;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final UserLikeBookRepository userLikeBookRepository;
    private final UserReadBookRepository userReadBookRepository;

    @Autowired
    public UserService(UserLikeBookRepository userLikeBookRepository, UserRepository userRepository, UserReadBookRepository userReadBookRepository) {
        this.userRepository = userRepository;
        this.userLikeBookRepository = userLikeBookRepository;
        this.userReadBookRepository = userReadBookRepository;
    }
    public boolean checkLoginEmailDuplication(String email) {return userRepository.existsByEmail(email);}

    // id 중복 검사
    public boolean checkLoginIdDuplication(String Id) {
        System.out.println("Checking duplication for ID: " + Id); // 추가된 로그
        boolean exists = userRepository.existsByUserId(Id);
        System.out.println("ID exists in DB: " + exists); // 추가된 로그
        return exists;
    }


    // 닉네임 중복 검사
    public boolean checkLoginNickDuplication(String nickname) {
        return userRepository.existsByNickname(nickname);
    }

    //회원 가입
    public void join(JoinRequest req) {
        userRepository.save(req.toEntity());
    }
    //비밀번호 암호화
    public void join2(JoinRequest req) {
        String encodedPassword = Base64.getEncoder().encodeToString(req.getPassword().getBytes());
        userRepository.save(req.toEntity(encodedPassword));
    }
    public UserDTO login(LoginRequest req) {
        Optional<UserDTO> optionalUser = userRepository.findByUserId(req.getuserId());

        // loginId와 일치하는 User가 없으면 null return
        if(optionalUser.isEmpty()) {
            return null;
        }

        UserDTO user = optionalUser.get();

        // 찾아온 User의 password와 입력된 password가 다르면 null return
        if(!user.getPassword().equals(req.getPassword())) {
            return null;
        }

        return user;
    }

    /**
     * userId(Long)를 입력받아 User을 return 해주는 기능
     * 인증, 인가 시 사용
     * userId가 null이거나(로그인 X) userId로 찾아온 User가 없으면 null return
     * userId로 찾아온 User가 존재하면 User return
     */
    public UserDTO getLoginUserById(Long Id) {
        if(Id == null) return null;

        Optional<UserDTO> optionalUser = userRepository.findById(Id);
        if(optionalUser.isEmpty()) return null;

        return optionalUser.get();
    }

    /**
     * loginId(String)를 입력받아 User을 return 해주는 기능
     * 인증, 인가 시 사용
     * loginId가 null이거나(로그인 X) userId로 찾아온 User가 없으면 null return
     * loginId로 찾아온 User가 존재하면 User return
     */
    public UserDTO getLoginUserByLoginId(String Id) {
        if(Id == null) return null;

        Optional<UserDTO> optionalUser = userRepository.findByUserId(Id);
        if(optionalUser.isEmpty()) return null;

        return optionalUser.get();
    }
    public List<UserReadBookDTO> getUserReadBooks (String nickname){
        List<UserReadBookDTO> userBooks = userReadBookRepository.findAllByNickName(nickname);
        return userBooks;
    }

    //사용자 읽은 책 등록하기
    public ResponseEntity<String> AddUserRead(UserReadBookDTO userReadBookDTO){

        userReadBookRepository.save(userReadBookDTO);
        return ResponseEntity.ok("good");
    }
    public int CountUserRead(String nickName){
        int cnt = userReadBookRepository.countAllByNickName(nickName);
        return cnt;
    }
    // 사용자 좋아요 담고 , 있으면 삭제하기
    public ResponseEntity<String> AddUserLike(UserLikeBookDTO userLikeBookDTO) {
        boolean existingRecord = userLikeBookRepository.existsByUserIdAndBookId(userLikeBookDTO.getUserId(), userLikeBookDTO.getBookId());
        System.out.println(existingRecord + " 출력되노?!!@!@?");
        if (existingRecord) {
            System.out.println("지우러 들어옴");

            UserLikeBookDTO existingUserLike = userLikeBookRepository.findByUserIdAndBookId(userLikeBookDTO.getUserId(), userLikeBookDTO.getBookId());

            userLikeBookRepository.delete(existingUserLike);
            return ResponseEntity.ok("Already exists");
        } else {
            userLikeBookRepository.save(userLikeBookDTO);
            return ResponseEntity.ok("Saved successfully");
        }
    }

}




