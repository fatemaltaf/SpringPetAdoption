package FurryPal;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User{
    
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
    @Column(length=50)
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Column(length=50)
    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Column(length=50)
    private Integer phone;
    public Integer getPhone() {
        return phone;
    }
    public void setPhone(Integer phone) {
        this.phone = phone;
    }
    @Column(length=250)
    private String q1;
    public String getQ1() {
        return q1;
    }
    public void setQ1(String q1) {
        this.q1 = q1;
    }
    @Column(length=250)
    private String q2;
    public String getQ2() {
        return q2;
    }
    public void setQ2(String q2) {
        this.q2 = q2;
    }
    @Column(length=250)
    private String q3;
    public String getQ3() {
        return q3;
    }
    public void setQ3(String q3) {
        this.q3 = q3;
    }
    @Column(length=250)
    private String q4;
    public String getQ4() {
        return q4;
    }
    public void setQ4(String q4) {
        this.q4 = q4;
    }
    @Column(length=250)
    private String q5;
    public String getQ5() {
        return q5;
    }
    public void setQ5(String q5) {
        this.q5 = q5;
    }
}

