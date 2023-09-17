package com.github.rishiagl.jerry.Controllers;

import com.github.rishiagl.jerry.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

class InvoiceItemJSON {
    private Product product;
    private int qty;
    private int rate;

    public InvoiceItemJSON() {
    }
    public InvoiceItemJSON(Product product, int qty, int rate) {
        this.product = product;
        this.qty = qty;
        this.rate = rate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
class InvoiceJSON {
    private Customer customer;
    private ArrayList<InvoiceItemJSON> invoiceItemJSONS;

    public InvoiceJSON() {
    }

    public InvoiceJSON(Customer customer, ArrayList<InvoiceItemJSON> invoiceItemJSONS) {
        this.customer = customer;
        this.invoiceItemJSONS = invoiceItemJSONS;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<InvoiceItemJSON> getInvoiceItemJSONS() {
        return invoiceItemJSONS;
    }

    public void setInvoiceItemJSONS(ArrayList<InvoiceItemJSON> invoiceItemJSONS) {
        this.invoiceItemJSONS = invoiceItemJSONS;
    }
}

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @GetMapping("")
    public ArrayList<Invoice> getAll() {

        InvoiceDAO dao = new InvoiceDAO();
        try {
            ArrayList<Invoice> invoices = new ArrayList<Invoice>();
            invoices = dao.getAll();
            return invoices;
        } catch (SQLException e) {
            return null;
        }
    }
    @PostMapping( value = "",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<String> addOne(@RequestBody InvoiceJSON invoiceJSON) {
        LocalDate date_created = LocalDate.now();
        Invoice invoice = new Invoice(0, date_created.toString(), invoiceJSON.getCustomer().getName(), invoiceJSON.getCustomer().getId());
        DAO dao = new InvoiceDAO();
        long invoice_id;
        try {
            invoice_id = dao.addOne(invoice);
        } catch (SQLException e) {
            System.out.println(e);
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        dao = new InvoiceItemDAO();
        for(int i = 0; i < invoiceJSON.getInvoiceItemJSONS().size(); i++) {
            InvoiceItem item = new InvoiceItem();
            item.setId(0);
            item.setInvoice_id(invoice_id);
            item.setProduct_id(invoiceJSON.getInvoiceItemJSONS().get(i).getProduct().getId());
            item.setQty(invoiceJSON.getInvoiceItemJSONS().get(i).getQty());
            item.setRate(invoiceJSON.getInvoiceItemJSONS().get(i).getRate());
            try {
                dao.addOne(item);
            } catch (SQLException e) {
                System.out.println(e);
                return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
}
