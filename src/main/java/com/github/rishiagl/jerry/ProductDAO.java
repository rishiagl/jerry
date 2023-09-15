package com.github.rishiagl.jerry;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements DAO<Product, ProductProperty>{

    @Override
    public long addOne(Product e) throws SQLException {
        try {
            String query = "INSERT INTO product(name, hsn, tax_rate) VALUES ('"
                    + e.getName() + "', '"
                    + e.getHsn() + "', "
                    + e.getTax_rate()
                    + ");";
            Connection conn = DatabaseConnection.Connector();
            Statement st = conn.createStatement();
            st.execute(query);
            return 1;

        } catch (Exception exp) {
            System.out.println(exp);
            return 0;
        }
    }

    @Override
    public boolean updateOne(Product e) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteOne(Product e) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<Product> getAll() throws SQLException {
        ArrayList<Product> products = new ArrayList<Product>();
        try {
            String query = "SELECT * FROM product";
            Statement st = DatabaseConnection.Connector().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                Product pro = new Product();
                pro.setId(rs.getInt((1)));
                pro.setName(rs.getString(2));
                pro.setHsn(rs.getString(3));
                pro.setTax_rate(rs.getInt(4));
                products.add(pro);
            }
        } catch(Exception e) {
            System.out.println(e);
            throw e;
        }
        return products;
    }

    @Override
    public ArrayList<Product> getByProperty(ProductProperty p, Object value) throws SQLException {
        return null;
    }
}
