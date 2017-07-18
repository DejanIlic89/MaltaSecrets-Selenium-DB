package companies;

import db.DbConnection;
import domen.CompaniesDomen;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LogInPage;
import pages.Page;
import pages.companies.CompaniesPage;
import setup.SetUp;

/**
 *
 * @author Dejan
 */

public class TestCompanies {
    
    private static WebDriver driver;
    private static SetUp setUp;
    private static LogInPage logInPage;
    private static HomePage homePage;
    
    private CompaniesPage companiesPage;
    private CompaniesDomen company;
    private CompaniesDomen companyDb;

    @BeforeClass
    public static void setUpClass() {
        setUp = new SetUp();
        driver = setUp.initializeDriver(driver);
        logInPage = setUp.openLogInPage(driver);
        homePage = logInPage.clickOnLogin(driver);
        
        DbConnection.getConnection();
    }

    @AfterClass
    public static void tearDownClass() {
        DbConnection.close();
        Page.logOut(driver);
        driver.quit();
    }

    @Before
    public void setUp() {
        homePage.clickOnDropdown(driver);
        homePage.chooseLocation(driver, "Malta");
        companiesPage = homePage.clickOnCompanies(driver);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddNewCompany() {
        company = companiesPage.createNewCompany(driver);
        companyDb = DbConnection.getCompany("SELECT * FROM `companies` WHERE `id` = " + company.getCompanies_id());
        
        Assert.assertEquals(company.getCompanies_id(), companyDb.getCompanies_id());
        Assert.assertEquals(company.getCompany_address(), companyDb.getCompany_address());
        Assert.assertEquals(company.getCompany_name(), companyDb.getCompany_name());
        Assert.assertEquals(company.getCompany_website(), companyDb.getCompany_website());
        Assert.assertEquals(company.getContact_person(), companyDb.getContact_person());
        Assert.assertEquals(company.getEmail_address(), companyDb.getEmail_address());
        Assert.assertEquals(company.getLocation_ids(), companyDb.getLocation_ids());
        Assert.assertEquals(company.getModerator_id(), companyDb.getModerator_id());
        Assert.assertEquals(company.getNotes(), companyDb.getNotes());
        Assert.assertEquals(company.getPhone_number(), companyDb.getPhone_number());
        Assert.assertEquals(company.getVat_number(), companyDb.getVat_number());
    }
    
    @Test
    public void testEditCompany() {
        company = companiesPage.editCompany(driver);
        companyDb = DbConnection.getCompany("SELECT * FROM `companies` WHERE `id` = " + company.getCompanies_id());
        
        Assert.assertEquals(company.getCompanies_id(), companyDb.getCompanies_id());
        Assert.assertEquals(company.getCompany_address(), companyDb.getCompany_address());
        Assert.assertEquals(company.getCompany_name(), companyDb.getCompany_name());
        Assert.assertEquals(company.getCompany_website(), companyDb.getCompany_website());
        Assert.assertEquals(company.getContact_person(), companyDb.getContact_person());
        Assert.assertEquals(company.getEmail_address(), companyDb.getEmail_address());
        Assert.assertEquals(company.getLocation_ids(), companyDb.getLocation_ids());
        Assert.assertEquals(company.getModerator_id(), companyDb.getModerator_id());
        Assert.assertEquals(company.getNotes(), companyDb.getNotes());
        Assert.assertEquals(company.getPhone_number(), companyDb.getPhone_number());
        Assert.assertEquals(company.getVat_number(), companyDb.getVat_number());
    }
    
    @Test
    public void testDeleteCompany() {
        
        int id = companiesPage.deleteCompany(driver);
        
        int countDb = DbConnection.getCount("SELECT COUNT(*) FROM companies WHERE id = " + id + " AND "+"deleted = "+ 0);
//        int countDb = DbConnection.getCount("SELECT COUNT(*) FROM companies WHERE id = '"+company.getCompanies_id()+"'"+" AND "+"deleted = "+ 0);
        
        Assert.assertEquals(0, countDb);
        
    }
}
