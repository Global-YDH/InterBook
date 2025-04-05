package backBook.demo.Repository;

import backBook.demo.DTO.UserReadBookDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserReadBookRepository extends JpaRepository<UserReadBookDTO,Long> {
    List<UserReadBookDTO> findAllByNickName(String nickName);
    int countAllByNickName(String nickName);
}
