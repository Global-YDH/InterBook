package backBook.demo.Repository;

import backBook.demo.DTO.AdminDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<AdminDTO,String> {
    Optional<AdminDTO> findById(String id);

}
