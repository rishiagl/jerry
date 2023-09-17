package com.github.rishiagl.jerry;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InvoiceItemDAO implements DAO<InvoiceItem, InvoiceItemProperty>{
    @Override
    public long addOne(InvoiceItem e) throws SQLException {
        try {
            String query = "INSERT INTO invoice_item_list(invoice_id, product_id, qty, rate) VALUES ("
                    + e.getInvoice_id() + ", "
                    + e.getProduct_id() + ", "
                    + e.getQty() + ", "
                    + e.getRate()
                    + ");";
            Connection conn = DatabaseConnection.Connector();
            Statement st = conn.createStatement();
            st.execute(query);
            ResultSet rs = st.executeQuery("SELECT last_insert_rowid()");
            rs.next();
            return rs.getInt((1));

        } catch (Exception exp) {
            System.out.println(exp);
            return 0;
        }
    }

    @Override
    public boolean updateOne(InvoiceItem e) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteOne(InvoiceItem e) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<InvoiceItem> getAll() throws SQLException {
        ArrayList<InvoiceItem> invoiceItems = new ArrayList<InvoiceItem>();
        try {
            String query = "SELECT * FROM invoiceItems";
            Statement st = DatabaseConnection.Connector().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                InvoiceItem invoiceItem = new InvoiceItem();
                invoiceItem.setId(rs.getInt((1)));
                invoiceItem.setInvoice_id(rs.getInt(2));
                invoiceItem.setProduct_id(rs.getInt(3));
                invoiceItem.setQty(rs.getInt(4));
                invoiceItem.setRate(rs.getInt(5));
                invoiceItems.add(invoiceItem);
            }
        } catch(Exception e) {
            System.out.println(e);
            throw e;
        }
        return invoiceItems;
    }

    @Override
    public ArrayList<InvoiceItem> getByProperty(InvoiceItemProperty p, Object value) throws SQLException {
        ArrayList<InvoiceItem> invoiceItems = new ArrayList<InvoiceItem>();
        try {
            String query = "SELECT * FROM invoice_item_list WHERE "
                    + p + "=" + value + ";";
            Statement st = DatabaseConnection.Connector().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                InvoiceItem invoiceItem = new InvoiceItem();
                invoiceItem.setId(rs.getInt((1)));
                invoiceItem.setInvoice_id(rs.getInt(2));
                invoiceItem.setProduct_id(rs.getInt(3));
                invoiceItem.setQty(rs.getInt(4));
                invoiceItem.setRate(rs.getInt(5));
                invoiceItems.add(invoiceItem);
            }
        } catch(Exception e) {
            System.out.println(e);
            throw e;
        }
        return invoiceItems;
    }
}
