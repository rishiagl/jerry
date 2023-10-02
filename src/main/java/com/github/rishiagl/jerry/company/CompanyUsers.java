package com.github.rishiagl.jerry.company;

public class CompanyUsers {
    private long id;
    private long company_id;
    private String company_name;
    private String user_email;

    public CompanyUsers() {
    }

    public CompanyUsers(long id, long company_id, String company_name, String user_email) {
        this.id = id;
        this.company_id = company_id;
        this.company_name = company_name;
        this.user_email = user_email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(long company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
