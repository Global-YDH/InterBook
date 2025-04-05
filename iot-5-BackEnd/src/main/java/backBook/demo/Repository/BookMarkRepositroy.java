package backBook.demo.Repository;

import backBook.demo.DTO.BookMarkDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookMarkRepositroy extends JpaRepository<BookMarkDTO,Long> {
//    Long findByNicknameAndBookid(String nickname, Long bookid);
    Optional<BookMarkDTO> findByNicknameAndBookid(String nickname, Long bookid);
    boolean existsByBookidAndNickname(Long bookid, String nickname);
    @Query("SELECT b.page FROM BookMarkDTO b WHERE b.nickname = :nickname AND b.bookid = :bookid")
    Optional<Integer> findPageByNicknameAndBookid(@Param("nickname") String nickname, @Param("bookid") Long bookid);
}