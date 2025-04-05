package backBook.demo.Repository;

import backBook.demo.DTO.RankBookDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankRepository extends JpaRepository<RankBookDTO, Long> {

}
