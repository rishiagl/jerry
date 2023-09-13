package com.github.rishiagl.jerry;

public class Customer {
    private long id;
    private String phone_no;
    private String name;
    private String address;

    public Customer() {
    }

    public Customer(long id, String phone_no, String name, String address) {
        this.id = id;
        this.phone_no = phone_no;
        this.name = name;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
