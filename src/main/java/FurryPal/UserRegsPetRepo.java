package FurryPal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegsPetRepo extends JpaRepository<UserRegsPet,Integer>{
    List<UserRegsPet> findAll();
}