package backBook.demo.Repository;

import backBook.demo.DTO.ImageDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<ImageDTO, Long> {
    Optional<ImageDTO> findByBookidAndPage(long bookid, int page);
// / /    Optional<ImageDAO.ImageMapping> findByBookidAndPage(long bookid, int page);
//    ImageDAO.ImageMapping findByBookidAndPage(long bookid, int page);
}
