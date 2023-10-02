package com.github.rishiagl.jerry.company;

import com.github.rishiagl.jerry.customer.Customer;
import com.github.rishiagl.jerry.customer.CustomerDAO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@CrossOrigin(origins = {"http://localhost:5173", "https://jerry-ui-gold.vercel.app/"}, maxAge = 3600)
@RestController
@RequestMapping("/company")
public class CompanyController {

    @GetMapping("")
    public ArrayList<Company> getAll() {

        CompanyDAO dao = new CompanyDAO();
        try {
            ArrayList<Company> companies = new ArrayList<Company>();
            companies = dao.getAll();
            return companies;
        } catch (SQLException e) {
            return null;
        }
    }
    @GetMapping("/{id}")
    public ArrayList<Company> getByProperty(@PathVariable(value="id") final String id) {
        CompanyDAO dao = new CompanyDAO();
        try {
            ArrayList<Company> companies = new ArrayList<Company>();
            companies = dao.getByProperty(CompanyProperty.ID, Integer.valueOf(id));
            return companies;
        } catch (SQLException e) {
            return null;
        }
    }
    @PostMapping( value = "",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Company> addOne(@RequestBody Company company) {
        CompanyDAO dao = new CompanyDAO();
        try {
            dao.addOne(company);
        } catch (SQLException e) {

        }
        return new ResponseEntity<>(company, HttpStatus.OK);
    }
}
