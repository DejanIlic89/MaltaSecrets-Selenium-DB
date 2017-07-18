package cities;

import db.DbConnection;
import domen.CitiesDomen;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LogInPage;
import pages.Page;
import pages.cities.CitiesPage;
import setup.SetUp;

/**
 *
 * @author Dejan
 */

public class TestCities {
    
    private static WebDriver driver;
    private static SetUp setUp;
    private static LogInPage logInPage;
    private static HomePage homePage;
    
    private CitiesPage citiesPage;
    private CitiesDomen citiesDomen;
    private CitiesDomen citiesDb;
    
    @BeforeClass
    public static void setUpClass() {
        setUp = new SetUp();
        driver = setUp.initializeDriver(driver);
        logInPage = setUp.openLogInPage(driver);
        homePage = logInPage.clickOnLogin(driver);
        homePage.clickOnDropdown(driver);
        homePage.chooseLocation(driver, "Malta");
        
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
        citiesPage = homePage.clickOnCities(driver);
    }
    
    @After
    public void tearDown() {
    }

    @Ignore@Test
    public void testAddNewCity() {
        citiesDomen = citiesPage.createNewCity(driver);
    }
    
    @Test
    public void testChangeCityOrder() {
        CitiesPage.changeOrder(driver);
    }
    
    @Test
    public void testEditCity() {
        citiesDomen = citiesPage.editCity(driver);
        citiesDb = DbConnection.getCity("SELECT * FROM `cities_content` WHERE `city_id` = " + citiesDomen.getId());
        
        Assert.assertEquals(citiesDomen.getId(), citiesDb.getId());
        Assert.assertEquals(citiesDomen.getSeo_title(), citiesDb.getSeo_title());
        Assert.assertEquals(citiesDomen.getSeo_description(), citiesDb.getSeo_description());
        Assert.assertEquals(citiesDomen.getSeo_keywords(), citiesDb.getSeo_keywords());
        Assert.assertEquals(citiesDomen.getName(), citiesDb.getName());
        Assert.assertEquals(citiesDomen.getDescription(), citiesDb.getDescription().trim());
    }
}
