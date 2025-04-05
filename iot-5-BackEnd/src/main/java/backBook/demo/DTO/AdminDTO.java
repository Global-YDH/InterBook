package backBook.demo.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "admin")
public class AdminDTO {
    @Id
    private String id;
    private String password;

    public AdminDTO(String id, String password){
        this.id = id;
        this.password = password;
    }
    public AdminDTO(){

    }


}
