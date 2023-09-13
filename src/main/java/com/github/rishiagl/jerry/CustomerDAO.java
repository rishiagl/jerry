package com.github.rishiagl.jerry;

import java.sql.SQLException;
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
    public List<Customer> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<Customer> getByProperty(CustomerProperty p, Object value) throws SQLException {
        return null;
    }
}
