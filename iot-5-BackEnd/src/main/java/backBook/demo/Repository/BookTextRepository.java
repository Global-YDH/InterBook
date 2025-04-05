package backBook.demo.Repository;

import backBook.demo.DTO.BookTextDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;




@Repository
public interface BookTextRepository extends JpaRepository<BookTextDTO,Long> {
    List<BookTextDTO> findAllByBookid(int id);
    Optional<BookTextDTO> findByBookid(int id);
    Optional<BookTextDTO> findByTextIndex(int id);
    Optional<BookTextDTO.BookMapping> findByBookidAndPage(int bookid, int page);

}


