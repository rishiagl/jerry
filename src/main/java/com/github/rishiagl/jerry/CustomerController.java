package com.github.rishiagl.jerry;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/customers")
public class CustomerController {

    public ArrayList<Customer> arr = new ArrayList<Customer>();

    @PostConstruct
    public void initialize() {
        arr.add(new Customer("7970460076", "RIshi Agarwal", "dnfewi ewduewbfiy iuheiwhf"));
        arr.add(new Customer("8789961675", "Priya Agarwal", "ncd wdicbwi wcwc"));
    }
    @GetMapping("")
    public List<Customer> getAll() {
        return arr;
    }
    @PostMapping( value = "",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Customer> addOne(@RequestBody Customer customer) {
        arr.add(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
