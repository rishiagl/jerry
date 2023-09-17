package com.github.rishiagl.jerry;

public class Invoice {
    private long id;
    private String date_created;
    private String customer_name;
    private long customer_id;

    public Invoice() {
    }

    public Invoice(long id, String date_created, String customer_name, long customer_id) {
        this.id = id;
        this.date_created = date_created;
        this.customer_name = customer_name;
        this.customer_id = customer_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }
}
