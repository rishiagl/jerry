package com.github.rishiagl.jerry.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@CrossOrigin(origins = {"http://localhost:5173", "https://jerry-ui-gold.vercel.app/"}, maxAge = 3600)
@RestController
@RequestMapping("/company-users")
public class CompanyUsersController {

    @GetMapping("")
    public ArrayList<CompanyUsers> getAll() {

        CompanyUsersDAO dao = new CompanyUsersDAO();
        try {
            ArrayList<CompanyUsers> companyUsers = new ArrayList<CompanyUsers>();
            companyUsers = dao.getAll();
            return companyUsers;
        } catch (SQLException e) {
            return null;
        }
    }

    @GetMapping("/byEmail")
    public ArrayList<CompanyUsers> getCompanyByUserEmail(@RequestParam String user_email) {

        CompanyUsersDAO dao = new CompanyUsersDAO();
        try {
            ArrayList<CompanyUsers> companyUsers = new ArrayList<CompanyUsers>();
            companyUsers = dao.getByProperty(CompanyUsersProperty.USER_EMAIL, user_email);
            System.out.println(user_email);
            return companyUsers;
        } catch (SQLException e) {
            return null;
        }
    }
    @PostMapping( value = "",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<CompanyUsers> addOne(@RequestBody CompanyUsers companyUsers) {
        CompanyUsersDAO dao = new CompanyUsersDAO();
        try {
            dao.addOne(companyUsers);
        } catch (SQLException e) {

        }
        return new ResponseEntity<>(companyUsers, HttpStatus.OK);
    }
}
