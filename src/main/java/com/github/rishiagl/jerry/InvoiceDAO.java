package com.github.rishiagl.jerry;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InvoiceDAO implements DAO<Invoice, InvoiceProperty>{
    @Override
    public long addOne(Invoice e) throws SQLException {
        try {
            String query = "INSERT INTO invoice(date_created, customer_name, customer_id) VALUES ('"
                    + e.getDate_created() + "', '"
                    + e.getCustomer_name() + "', "
                    + e.getCustomer_id()
                    + ");";
            Connection conn = DatabaseConnection.Connector();
            Statement st = conn.createStatement();
            st.execute(query);
            ResultSet rs = st.executeQuery("SELECT last_insert_rowid()");
            rs.next();
            return rs.getInt((1));
        } catch (Exception exp) {
            System.out.println(exp);
            return -1;
        }
    }

    @Override
    public boolean updateOne(Invoice e) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteOne(Invoice e) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<Invoice> getAll() throws SQLException {
        ArrayList<Invoice> invoices = new ArrayList<Invoice>();
        try {
            String query = "SELECT * FROM invoice";
            Statement st = DatabaseConnection.Connector().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                Invoice inv = new Invoice();
                inv.setId(rs.getInt((1)));
                inv.setDate_created(rs.getString(2));
                inv.setCustomer_name(rs.getString(3));
                inv.setCustomer_id(rs.getInt(4));
                invoices.add(inv);
            }
        } catch(Exception e) {
            System.out.println(e);
            throw e;
        }
        return invoices;
    }

    @Override
    public ArrayList<Invoice> getByProperty(InvoiceProperty p, Object value) throws SQLException {
        return null;
    }
}
