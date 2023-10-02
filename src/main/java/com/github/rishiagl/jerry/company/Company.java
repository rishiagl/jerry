package com.github.rishiagl.jerry.company;

public class Company {
    private long id;
    private String name;
    private String legal_name;
    private String address;
    private String gstn;
    private String phone_no;
    private String email;
    private String website;
    private String owner_email;

    public Company() {
    }

    public Company(long id, String name, String legal_name, String address, String gstn, String phone_no, String email, String website, String owner_email) {
        this.id = id;
        this.name = name;
        this.legal_name = legal_name;
        this.address = address;
        this.gstn = gstn;
        this.phone_no = phone_no;
        this.email = email;
        this.website = website;
        this.owner_email = owner_email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLegal_name() {
        return legal_name;
    }

    public void setLegal_name(String legal_name) {
        this.legal_name = legal_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGstn() {
        return gstn;
    }

    public void setGstn(String gstn) {
        this.gstn = gstn;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getOwner_email() {
        return owner_email;
    }

    public void setOwner_email(String owner_email) {
        this.owner_email = owner_email;
    }
}
