package FurryPal;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PetsRepo extends JpaRepository<Pets,Integer>{
    List<Pets> findAll();
    List<Pets> findByType(String type);
    void deleteById(Integer id);
    Optional<Pets> findById(Integer id);
}
