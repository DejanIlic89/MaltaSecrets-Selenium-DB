package news;

import db.DbConnection;
import domen.NewsDomen;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LogInPage;
import pages.Page;
import pages.news.NewsPage;
import setup.SetUp;

/**
 *
 * @author Dejan
 */

public class TestNews {
    
    private static WebDriver driver;
    private static SetUp setUp;
    private static LogInPage logInPage;
    private static HomePage homePage;
    
    private NewsPage newsPage;
    private NewsDomen newsWeb;
    private NewsDomen newsDb;
        
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
        newsPage = homePage.clickOnNews(driver);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddNewNews() {
        newsWeb = newsPage.createNewNews(driver);
        
    }
}
