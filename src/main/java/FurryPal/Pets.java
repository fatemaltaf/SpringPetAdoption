package FurryPal;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
@Entity
public class Pets implements Serializable{
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    @Column(length=5)
    private Integer id;
    @Column(length=30)
    private String name;
    @Column(length=30,nullable=false)
    private String color;
    @Column(length=30,nullable=false)
    private String size;
    @Column(length=2,nullable=false)
    private String age;
    @Column(length=7,nullable=false)
    private String gender;
    @Column(length=3,nullable=false)
    private String type;
    @Column(length=30)
    private String breed;
    @Column(length=10)
    private String vaccination;
    @Column(length=100)
    private String location;
    @Column(length=100)
    private String description;
    @Column(nullable = true, length = 64)
    private String photos;

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    @Transient
    public String getPhotosImagePath() {
        if (photos == null || id == null) return null;
         
        return "/pet-photos/" + id + "/" + photos;
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
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public String getVaccination() {
        return vaccination;
    }
    public void setVaccination(String vaccination) {
        this.vaccination = vaccination;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
}
