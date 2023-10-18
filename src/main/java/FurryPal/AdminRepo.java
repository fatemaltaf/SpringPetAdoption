package FurryPal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository <Admin,String>{
    Admin findByUsername(String username);
}
