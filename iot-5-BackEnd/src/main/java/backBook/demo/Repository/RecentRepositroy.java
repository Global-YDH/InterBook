package backBook.demo.Repository;

import backBook.demo.DTO.RecentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface RecentRepositroy extends JpaRepository<RecentDTO, Long> {
    List<RecentDTO> findByUserId(String userId, Pageable pageable);
    boolean  existsByBookIdAndUserId(long bookId,String nickName);

}
