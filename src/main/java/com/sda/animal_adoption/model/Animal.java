package com.sda.animal_adoption.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private int age;
    @Column
    private String name;
    @Column
    private String sex;
    @Column
    private String breed;
    @Column
    private String description;
    @Column
    private String photo;

    @OneToOne(mappedBy = "animal", fetch = FetchType.LAZY)
    private Meeting meeting;
    @JsonIgnore
    @OneToMany(mappedBy = "animal", fetch = FetchType.LAZY)
    private List<Adoption> animalsAdoptions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_shelter")
    private Shelter shelter;

    public Animal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String race) {
        this.breed = race;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    public List<Adoption> getAnimalsAdoptions() {
        return animalsAdoptions;
    }

    public void setAnimalsAdoptions(List<Adoption> animalsAdoptions) {
        this.animalsAdoptions = animalsAdoptions;
    }

    public Shelter getShelter() {
        return shelter;
    }

    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }

}
