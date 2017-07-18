package db;

import com.mysql.jdbc.Connection;
import domen.AdvertisingDomen;
import domen.CitiesDomen;
import domen.CompaniesDomen;
import domen.PagesDomen;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dejan
 */

public class DbConnection {
    
    private static Connection conn = null;
    
    public static void getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://136.243.5.37:33062/tg_test", "root", "cubesqa");
            
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static CompaniesDomen getCompany(String query) {
        CompaniesDomen company = new CompaniesDomen();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                String contactPerson = rs.getString("contact_person");
                String phoneNumber = rs.getString("phone_number");
                String emailAddress = rs.getString("email_address");
                String companyName = rs.getString("company_name");
                String companyWebsite = rs.getString("company_website");
                String locations = rs.getString("location_ids");
                String comapnyAddress = rs.getString("company_address");
                String vatNumber = rs.getString("vat_number");
                int moderator = rs.getInt("moderator_id");
                String notes = rs.getString("notes");
                
                company.setCompanies_id(id);
                company.setContact_person(contactPerson);
                company.setPhone_number(phoneNumber);
                company.setEmail_address(emailAddress);
                company.setCompany_name(companyName);
                company.setCompany_website(companyWebsite);
                company.setLocation_ids(locations);
                company.setCompany_address(comapnyAddress);
                company.setVat_number(vatNumber);
                company.setModerator_id(moderator);
                company.setNotes(notes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return company;
    }
    
    public static AdvertisingDomen getAdvert(String query) {
        AdvertisingDomen ad = new AdvertisingDomen();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                int type = rs.getInt("type");
                int location = rs.getInt("location");
                int interest_Category = rs.getInt("interest_category_id");
                int company_Id = rs.getInt("company_id");
                String image_Path = rs.getString("image_path");
                String link = rs.getString("link");
                
                ad.setAdvertise_id(id);
                ad.setTitle(title);
                ad.setDescription(description);
                ad.setType(type);
                ad.setLocation(location);
                ad.setInterest_category_id(interest_Category);
                ad.setCompany_id(company_Id);
                ad.setImage_path(image_Path);
                ad.setLink(link);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ad;
    }
    
    public static PagesDomen getPage(String query) {
        PagesDomen page = new PagesDomen();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String text = rs.getString("text");
                String image_path = rs.getString("page_photo");
                int location = rs.getInt("location_id");
                String seoTitle = rs.getString("seo_title");
                int sideB = rs.getInt("sidebar");
                int foot = rs.getInt("footer");
                
                page.setId(id);
                page.setTitle(title);
                page.setText(text);
                page.setPage_photo(image_path);
                page.setLocation_id(location);
                page.setSeo_title(seoTitle);
                page.setSidebar(sideB);
                page.setFooter(foot);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return page;
    }
    
    public static CitiesDomen getCity(String query) {
        CitiesDomen city = new CitiesDomen();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println(query);
            while(rs.next()) {
                int id = rs.getInt("city_id");
                String seoTitle = rs.getString("seo_title");
                String seoDescription = rs.getString("seo_description");
                String seoKeywords = rs.getString("seo_keywords");
                String name = rs.getString("name");
                String description = rs.getString("description");
                
                city.setId(id);
                city.setSeo_title(seoTitle);
                city.setSeo_description(seoDescription);
                city.setSeo_keywords(seoKeywords);
                city.setName(name);
                city.setDescription(description);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return city;        
    }
        
    public static int getCount(String query) {
        int result = 0;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            System.out.println(query);
            while (rs.next()) {
                result = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    public static void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
