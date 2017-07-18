package pages;

import db.DbConnection;
import domen.PagesDomen;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.pages.PagesPage;
import setup.SetUp;

/**
 *
 * @author Dejan
 */

public class TestPages {
    
    private static WebDriver driver;
    private static SetUp setUp;
    private static LogInPage logInPage;
    private static HomePage homePage;
    
    private PagesPage pagesPage;
    private PagesDomen pages;
    private PagesDomen pagesDb;

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
        pagesPage = homePage.clickOnPages(driver);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddNewPage() {
        pages = pagesPage.createNewPage(driver);
        pagesDb = DbConnection.getPage("SELECT pages.*, pages_contents.* "
                + "FROM pages "
                + "LEFT JOIN pages_contents ON pages.id = pages_contents.page_id "
                + "WHERE pages.id = " + pages.getId());
        
        Assert.assertEquals(pages.getId(), pagesDb.getId());
        Assert.assertEquals(pages.getTitle(), pagesDb.getTitle());
        Assert.assertEquals(pages.getText(), pagesDb.getText().trim());
        Assert.assertEquals(pages.getPage_photo(), pagesDb.getPage_photo());
        Assert.assertEquals(pages.getLocation_id(), pagesDb.getLocation_id());
        Assert.assertEquals(pages.getSeo_title(), pagesDb.getSeo_title());
        Assert.assertEquals(pages.getSidebar(), pagesDb.getSidebar());
        Assert.assertEquals(pages.getFooter(), pagesDb.getFooter());
    }
    
    @Test
    public void testEditPage() {
        pages = pagesPage.editPage(driver);
        pagesDb = DbConnection.getPage("SELECT pages.*, pages_contents.* "
                + "FROM pages "
                + "LEFT JOIN pages_contents ON pages.id = pages_contents.page_id "
                + "WHERE pages.id = " + pages.getId());
        
        Assert.assertEquals(pages.getId(), pagesDb.getId());
        Assert.assertEquals(pages.getTitle(), pagesDb.getTitle());
        Assert.assertEquals(pages.getText(), pagesDb.getText().trim());
        Assert.assertEquals(pages.getPage_photo(), pagesDb.getPage_photo());
        Assert.assertEquals(pages.getLocation_id(), pagesDb.getLocation_id());
        Assert.assertEquals(pages.getSeo_title(), pagesDb.getSeo_title());
        Assert.assertEquals(pages.getSidebar(), pagesDb.getSidebar());
        Assert.assertEquals(pages.getFooter(), pagesDb.getFooter());
    }
    
    @Test
    public void testDeletePage() {
        
        int id = pagesPage.deletePage(driver);
        
        int countDb = DbConnection.getCount("SELECT COUNT(*) FROM pages WHERE id = " + id);
        
        Assert.assertEquals(0, countDb);
        
    }
    
}
