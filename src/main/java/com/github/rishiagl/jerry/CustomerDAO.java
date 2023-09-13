package com.github.rishiagl.jerry;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements DAO<Customer, CustomerProperty>{
    @Override
    public long addOne(Customer e) throws SQLException {
        return 0;
    }

    @Override
    public boolean updateOne(Customer e) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteOne(Customer e) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<Customer> getAll() throws SQLException {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        try {
            String query = "SELECT * FROM customer";
            Statement st = DatabaseConnection.Connector().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                Customer cus = new Customer();
                cus.setId(rs.getInt((1)));
                cus.setPhone_no(rs.getString(2));
                cus.setName(rs.getString(3));
                cus.setAddress(rs.getString(4));
                customers.add(cus);
            }
        } catch(Exception e) {
            System.out.println(e);
            throw e;
        }
        return customers;
    }

    @Override
    public List<Customer> getByProperty(CustomerProperty p, Object value) throws SQLException {
        return null;
    }
}
