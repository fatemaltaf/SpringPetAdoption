package FurryPal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepo extends JpaRepository<Donation,Integer>{
    
}
