package com.company.entity;

import java.sql.Date;
import java.util.List;


public class User {
    private int id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String profileDesc;
    private String number;
    private String address;
    private Date birthdate;
    private Country country;
    private NameNationality nationality;
    private NameBirthplace birthplace;
    private List<UserSkill> skills;


    public User() {

    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String name, String surname, Integer age, String email, String profileDesc, String number, String address, Date birthdate, Country country, NameNationality nationality, NameBirthplace birthplace) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.profileDesc = profileDesc;
        this.number = number;
        this.address = address;
        this.birthdate = birthdate;
        this.country = country;
        this.nationality = nationality;
        this.birthplace = birthplace;
    }


    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileDesc() {
        return profileDesc;
    }

    public void setProfileDesc(String profileDesc) {
        this.profileDesc = profileDesc;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public NameNationality getNationality() {
        return nationality;
    }

    public void setNationality(NameNationality nationality) {
        this.nationality = nationality;
    }

    public NameBirthplace getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(NameBirthplace birthplace) {
        this.birthplace = birthplace;
    }

    public List<UserSkill> getSkills() {
        return skills;
    }

    public void setSkills(List<UserSkill> skills) {
        this.skills = skills;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + ", email=" + email + ", profileDesc=" + profileDesc + ", number=" + number + ", address=" + address + ", birthdate=" + birthdate + ", country=" + country + ", nationality=" + nationality + ", birthplace=" + birthplace + ", skills=" + skills + '}';
    }

}
