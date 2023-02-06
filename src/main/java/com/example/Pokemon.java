package com.example;

public class Pokemon {
    private Integer id;
    private String name;
    private String imageUrl;

    private String speciality;

    public Pokemon() {}


    public Pokemon(Integer id, String name, String imageUrl, String speciality) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.speciality = speciality;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
