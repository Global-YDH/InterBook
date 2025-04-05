package backBook.demo.Service;

import backBook.demo.DTO.AdminDTO;
import backBook.demo.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    //관리자는 삭제 , 생성을 할 수 있어야 됨
    private BookService bookService;

    @Autowired
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    //어드민 체크
    public boolean adminCheck(String id){
        Optional<AdminDTO> adminOptinal = adminRepository.findById(id);
        if(adminOptinal.isPresent()){
            return true;
        }
        else{
            return false;
        }
    }
}
