package FurryPal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
public class Contact implements Serializable{

   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(length=5)
   private Integer id;
   public Integer getId() {
    return id;
    }
    public void setId(Integer id) {
        this.id = id;
    } 
   @Column(nullable=false, length=50)
   private String username;
   
    public String getUsername() {
    return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @Column(nullable=false, length=100)
    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Column(nullable=false, length=10)
    private Integer phone;
    public Integer getPhone() {
            return phone;
        }
    public void setPhone(Integer phone) {
        this.phone = phone;
    }
    @Column(nullable=false, length=500)
    private String subject;
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    @Column(nullable=false, length=1000)
    private String message;

   public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}
