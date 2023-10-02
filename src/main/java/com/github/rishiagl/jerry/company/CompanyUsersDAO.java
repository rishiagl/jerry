package com.github.rishiagl.jerry.company;

import com.github.rishiagl.jerry.DAO;
import com.github.rishiagl.jerry.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CompanyUsersDAO implements DAO<CompanyUsers, CompanyUsersProperty> {
    @Override
    public long addOne(CompanyUsers cu) throws SQLException {
        try {
            String query = "INSERT INTO company_users(company_id, company_name, user_email)  VALUES ("
                    + cu.getCompany_id() + ", '"
                    + cu.getCompany_name() + "', '"
                    + cu.getUser_email()
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
    public boolean updateOne(CompanyUsers e) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteOne(CompanyUsers e) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<CompanyUsers> getAll() throws SQLException {
        ArrayList<CompanyUsers> companyUsers = new ArrayList<CompanyUsers>();
        try {
            String query = "SELECT * FROM company_users";
            Statement st = DatabaseConnection.Connector().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                CompanyUsers cus = new CompanyUsers();
                cus.setId(rs.getInt((1)));
                cus.setCompany_id(rs.getInt(2));
                cus.setCompany_name(rs.getString(3));
                cus.setUser_email(rs.getString(4));
                companyUsers.add(cus);
            }
        } catch(Exception e) {
            System.out.println(e);
            throw e;
        }
        return companyUsers;
    }

    @Override
    public ArrayList<CompanyUsers> getByProperty(CompanyUsersProperty p, Object value) throws SQLException {
        ArrayList<CompanyUsers> companyUsers = new ArrayList<CompanyUsers>();
        try {
            String query = "SELECT * FROM company_users WHERE " + p + "='" + value + "';";
            Statement st = DatabaseConnection.Connector().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                CompanyUsers cus = new CompanyUsers();
                cus.setId(rs.getInt((1)));
                cus.setCompany_id(rs.getInt(2));
                cus.setCompany_name(rs.getString(3));
                cus.setUser_email(rs.getString(4));
                companyUsers.add(cus);
            }
        } catch(Exception e) {
            System.out.println(e);
            throw e;
        }
        return companyUsers;
    }
}
