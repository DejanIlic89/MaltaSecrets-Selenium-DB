package advertising;

import db.DbConnection;
import domen.AdvertisingDomen;
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
import pages.advertising.AdvertisingPage;
import setup.SetUp;

/**
 *
 * @author Dejan
 */

public class TestAdvertising {
    
    private static WebDriver driver;
    private static SetUp setUp;
    private static LogInPage logInPage;
    private static HomePage homePage;
    
    private AdvertisingPage advertisingPage;
    private AdvertisingDomen advertising;
    private AdvertisingDomen advertisingDb;

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
        advertisingPage = homePage.clickOnAdvertising(driver);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddNewAdvertising() {
        advertising = advertisingPage.createNewAdvertising(driver);
//        advertisingDb = DbConnection.getAdvert("SELECT * FROM `advertise` WHERE `id` = " + advertising.getAdvertise_id());
        advertisingDb = DbConnection.getAdvert("SELECT advertise.*, advertise_content.title,advertise_content.description\n" +
                                            "FROM advertise\n" +
                                            "LEFT JOIN advertise_content ON advertise.id = advertise_content.advertise_id\n" +
                                            "WHERE advertise.id = " + advertising.getAdvertise_id());
        
        Assert.assertEquals(advertising.getAdvertise_id(), advertisingDb.getAdvertise_id());
        Assert.assertEquals(advertising.getCompany_id(), advertisingDb.getCompany_id());
        Assert.assertEquals(advertising.getDescription(), advertisingDb.getDescription());
        Assert.assertEquals(advertising.getImage_path(), advertisingDb.getImage_path());
        Assert.assertEquals(advertising.getInterest_category_id(), advertisingDb.getInterest_category_id());
        Assert.assertEquals(advertising.getLink(), advertisingDb.getLink());
        Assert.assertEquals(advertising.getLocation(), advertisingDb.getLocation());
        Assert.assertEquals(advertising.getTitle(), advertisingDb.getTitle());
        Assert.assertEquals(advertising.getType(), advertisingDb.getType());
    }
    
    @Test
    public void testEditAdvertising() {
        advertising = advertisingPage.editAdvertising(driver);
        advertisingDb = DbConnection.getAdvert("SELECT advertise.*, advertise_content.title,advertise_content.description\n" +
                                            "FROM advertise\n" +
                                            "LEFT JOIN advertise_content ON advertise.id = advertise_content.advertise_id\n" +
                                            "WHERE advertise.id = " + advertising.getAdvertise_id());
        
        Assert.assertEquals(advertising.getAdvertise_id(), advertisingDb.getAdvertise_id());
        Assert.assertEquals(advertising.getCompany_id(), advertisingDb.getCompany_id());
        Assert.assertEquals(advertising.getDescription(), advertisingDb.getDescription());
        Assert.assertEquals(advertising.getImage_path(), advertisingDb.getImage_path());
        Assert.assertEquals(advertising.getInterest_category_id(), advertisingDb.getInterest_category_id());
        Assert.assertEquals(advertising.getLink(), advertisingDb.getLink());
        Assert.assertEquals(advertising.getLocation(), advertisingDb.getLocation());
        Assert.assertEquals(advertising.getTitle(), advertisingDb.getTitle());
        Assert.assertEquals(advertising.getType(), advertisingDb.getType());
    }
    
    @Test
    public void testDeleteAdvertising() {
        
        int id = advertisingPage.deleteAdvertising(driver);
        
        int countDb = DbConnection.getCount("SELECT COUNT(*) FROM advertise WHERE id = " + id + " AND " + "is_deleted = " + 0);
                
        Assert.assertEquals(0, countDb);
        
    }
    
}
