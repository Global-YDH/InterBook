package backBook.demo.Repository;

import backBook.demo.DTO.UserLikeBookDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserLikeBookRepository extends JpaRepository<UserLikeBookDTO,Long> {
    List<UserLikeBookDTO> findAllByUserId(String id);
    boolean existsByUserIdAndBookId(String userId, int bookId);
    UserLikeBookDTO findByUserIdAndBookId (String userId, int bookId);
}
