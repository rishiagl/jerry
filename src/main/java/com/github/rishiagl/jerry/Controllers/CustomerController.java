package com.github.rishiagl.jerry.Controllers;

import com.github.rishiagl.jerry.Customer;
import com.github.rishiagl.jerry.CustomerDAO;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping("")
    public ArrayList<Customer> getAll() {

        CustomerDAO dao = new CustomerDAO();
        try {
            ArrayList<Customer> customers = new ArrayList<Customer>();
            customers = dao.getAll();
            return customers;
        } catch (SQLException e) {
            return null;
        }
    }
    @PostMapping( value = "",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Customer> addOne(@RequestBody Customer customer) {
        CustomerDAO dao = new CustomerDAO();
        try {
            dao.addOne(customer);
        } catch (SQLException e) {

        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
