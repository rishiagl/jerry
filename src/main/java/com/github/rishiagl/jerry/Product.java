package com.github.rishiagl.jerry;

public class Product {
    private long id;
    private String name;
    private String hsn;
    private int tax_rate;

    public Product() {
    }

    public Product(long id, String name, String hsn, int tax_rate) {
        this.id = id;
        this.name = name;
        this.hsn = hsn;
        this.tax_rate = tax_rate;
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

    public String getHsn() {
        return hsn;
    }

    public void setHsn(String hsn) {
        this.hsn = hsn;
    }

    public int getTax_rate() {
        return tax_rate;
    }

    public void setTax_rate(int tax_rate) {
        this.tax_rate = tax_rate;
    }
}
