package backBook.demo.Repository;

import backBook.demo.DTO.CompletBookDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompletBookRepository extends JpaRepository<CompletBookDTO,Long> {
    List<CompletBookDTO> findByNickname(String nickname);
    boolean existsByNicknameAndBookid(String nickname, Long bookid);

}
