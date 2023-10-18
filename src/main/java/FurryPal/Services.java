package FurryPal;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Services implements Serializable{
  
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(length=5)
    private Integer id;
    @Column(length=20,nullable=false)
    private String name;
    @Column(length=20,nullable=false)
    private String type;
    @Column(length=5)
    private Double fees;
    @Column(length=250)
    private String qualification;
    @Column(length=250)
    private String experience;
    @Column(length=11,nullable=false)
    private Integer phone_no;
    private String location;

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Double getFees() {
        return fees;
    }
    public void setFees(Double fees) {
        this.fees = fees;
    }
    public String getExperience() {
        return experience;
    }
    public void setExperience(String experience) {
        this.experience = experience;
    }
    public Integer getPhone_no() {
        return phone_no;
    }
    public void setPhone_no(Integer phone_no) {
        this.phone_no = phone_no;
    }
 
    @Column(nullable=false)
    public String getQualification() {
        return qualification;
    }
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    

}

