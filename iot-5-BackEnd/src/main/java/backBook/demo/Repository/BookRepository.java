package backBook.demo.Repository;

import backBook.demo.DTO.BookDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.*;

public interface BookRepository extends JpaRepository<BookDTO,Long> {
    @Override
    Optional<BookDTO> findById(Long s);
//    List<BookTextDAO> findAllByBookid(int bookid);
    Optional<BookDTO> findByTitle(String title);
    List<BookDTO> findByTitleContaining(String title);
    List<BookDTO> findByThemeContaining(String theme);
    Optional<BookDTO.BookDAOMapping> findByBookid(long bookId);
    Optional<BookDTO> findByBookid(int  bookId);

    @Query("SELECT b FROM BookDTO b WHERE b.theme IN :theme AND b.bookid BETWEEN 0 AND 16")
    List<BookDTO> findByThemeAndBookIdRange(List<String> theme);

}
