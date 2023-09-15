package com.github.rishiagl.jerry;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping("")
    public ArrayList<Product> getAll() {

        ProductDAO dao = new ProductDAO();
        try {
            ArrayList<Product> products = new ArrayList<Product>();
            products = dao.getAll();
            return products;
        } catch (SQLException e) {
            return null;
        }
    }
    @PostMapping( value = "",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Product> addOne(@RequestBody Product product) {
        ProductDAO dao = new ProductDAO();
        try {
            dao.addOne(product);
        } catch (SQLException e) {

        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
