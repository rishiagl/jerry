package com.github.rishiagl.jerry;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements DAO<Customer, CustomerProperty>{
    @Override
    public long addOne(Customer cus) throws SQLException {
        try {
            String query = "INSERT INTO customer(phone_no, name, address) VALUES ('"
                    + cus.getPhone_no() + "', '"
                    + cus.getName() + "', '"
                    + cus.getAddress()
                    + "');";
            Connection conn = DatabaseConnection.Connector();
            Statement st = conn.createStatement();
            st.execute(query);
            ResultSet rs = st.executeQuery("SELECT last_insert_rowid()");
            rs.next();
            return rs.getInt((1));

        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
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
    public ArrayList<Customer> getByProperty(CustomerProperty p, Object value) throws SQLException {
        return null;
    }
}
