package backBook.demo.Repository;

import backBook.demo.DTO.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, Long> {
    boolean existsByUserId(String id);
    boolean existsByNickname(String nickname);
    Optional<UserDTO> findByUserId(String id);
    boolean existsByEmail(String email);


}
