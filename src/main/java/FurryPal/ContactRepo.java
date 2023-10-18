package FurryPal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository <Contact,Integer> {
    List<Contact> findAll();   
}
