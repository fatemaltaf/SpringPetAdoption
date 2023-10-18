package FurryPal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
public class Donation implements Serializable{

   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(length=5)
   private Integer id;
   @Column(nullable=false, length=10)
   private Double amount;

   public Integer getId() {
      return id;
   }
   public void setId(Integer id) {
      this.id = id;
   }
   
   public Double getAmount() {
      return amount;
   }
   public void setAmount(Double amount) {
      this.amount = amount;
   }

   
}
