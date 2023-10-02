package com.github.rishiagl.jerry.company;

import com.github.rishiagl.jerry.DAO;
import com.github.rishiagl.jerry.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CompanyDAO implements DAO<Company, CompanyProperty> {
    @Override
    public long addOne(Company comp) throws SQLException {
        try {
            String query = "INSERT INTO company(name, legal_name, address, gstn, phone_no, email, website, owner_email) VALUES ('"
                    + comp.getName() + "', '"
                    + comp.getLegal_name() + "', '"
                    + comp.getAddress() + "', '"
                    + comp.getGstn() + "', '"
                    + comp.getPhone_no() + "', '"
                    + comp.getEmail() + "', '"
                    + comp.getWebsite() + "', '"
                    + comp.getOwner_email()
                    + "');";
            Connection conn = DatabaseConnection.Connector();
            Statement st = conn.createStatement();
            st.execute(query);
            ResultSet rs = st.executeQuery("SELECT last_insert_rowid()");
            rs.next();
            long id = rs.getInt((1));
            CompanyUsers cu = new CompanyUsers();
            cu.setCompany_id(id);
            cu.setCompany_name(comp.getName());
            cu.setUser_email(comp.getOwner_email());
            CompanyUsersDAO dao = new CompanyUsersDAO();
            dao.addOne(cu);
            return id;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public boolean updateOne(Company e) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteOne(Company e) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<Company> getAll() throws SQLException {
        ArrayList<Company> companies = new ArrayList<Company>();
        try {
            String query = "SELECT * FROM company";
            Statement st = DatabaseConnection.Connector().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                Company cus = new Company();
                cus.setId(rs.getInt((1)));
                cus.setName(rs.getString(2));
                cus.setLegal_name(rs.getString(3));
                cus.setAddress(rs.getString(4));
                cus.setGstn(rs.getString(5));
                cus.setPhone_no(rs.getString(6));
                cus.setEmail(rs.getString(7));
                cus.setWebsite(rs.getString(8));
                cus.setOwner_email(rs.getString(9));
                companies.add(cus);
            }
        } catch(Exception e) {
            System.out.println(e);
            throw e;
        }
        return companies;
    }

    @Override
    public ArrayList<Company> getByProperty(CompanyProperty p, Object value) throws SQLException {
        ArrayList<Company> companies = new ArrayList<Company>();
        try {
            String query = "SELECT * FROM company WHERE " + p + "=" + value + ";";
            Statement st = DatabaseConnection.Connector().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                Company cus = new Company();
                cus.setId(rs.getInt((1)));
                cus.setName(rs.getString(2));
                cus.setLegal_name(rs.getString(3));
                cus.setAddress(rs.getString(4));
                cus.setGstn(rs.getString(5));
                cus.setPhone_no(rs.getString(6));
                cus.setEmail(rs.getString(7));
                cus.setWebsite(rs.getString(8));
                cus.setOwner_email(rs.getString(9));
                companies.add(cus);
            }
        } catch(Exception e) {
            System.out.println(e);
            throw e;
        }
        return companies;
    }
}
