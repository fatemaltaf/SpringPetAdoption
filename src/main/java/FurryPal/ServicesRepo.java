package FurryPal;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesRepo extends JpaRepository<Services,Integer>{
    List<Services> findByType(String type);
    List<Services> findAll(); 
    void deleteById(Integer id);
    Optional<Services> findById(Integer id);
}
