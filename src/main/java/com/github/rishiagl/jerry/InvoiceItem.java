package com.github.rishiagl.jerry;

public class InvoiceItem {
    private long id;
    private long invoice_id;
    private long product_id;
    private long qty;
    private long rate;

    public InvoiceItem() {
    }

    public InvoiceItem(long id, long invoice_id, long product_id, long qty, long rate) {
        this.id = id;
        this.invoice_id = invoice_id;
        this.product_id = product_id;
        this.qty = qty;
        this.rate = rate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(long invoice_id) {
        this.invoice_id = invoice_id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public long getQty() {
        return qty;
    }

    public void setQty(long qty) {
        this.qty = qty;
    }

    public long getRate() {
        return rate;
    }

    public void setRate(long rate) {
        this.rate = rate;
    }
}
