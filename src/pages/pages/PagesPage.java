package pages.pages;

import domen.PagesDomen;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Page;

/**
 *
 * @author Dejan
 */

public class PagesPage extends Page {
    
    @FindBy(how = How.CSS, using = "a[href='/page/createpage']") private WebElement addNewPage;
    
    @FindBy(how = How.ID, using = "title") private WebElement title;
    
    @FindBy(how = How.ID, using = "cke_1_contents") private WebElement parent;
    
    @FindBy(how = How.NAME, using = "page_photo") private WebElement image;  
    
    @FindBy(how = How.ID, using = "inputError") private WebElement seoTitle;
    
    @FindBy(how = How.ID, using = "location_id") private WebElement location;
    
    @FindBy(how = How.CLASS_NAME, using = "btn-success") private WebElement savePages;
    
    @FindBy(how = How.XPATH, using = "//*[@id='DataTables_Table_0']/tbody") private WebElement tableBody;
    
    @FindBy(how = How.CLASS_NAME, using = "input-small") private WebElement searchField;
    
    @FindBy(how = How.CLASS_NAME, using = "icon-pencil") private WebElement editButton;
    
    @FindBy(how = How.CLASS_NAME, using = "icon-trash") private WebElement deleteButton;
    
    @FindBy(how = How.CSS, using = "#buttonTextIcon") private WebElement confirmDelete;
    
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[3]/div[2]/div/div/div/div/div[2]/form/div[1]/div[4]/div/div/label[1]")
    private WebElement bothRadio;
    
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[3]/div[2]/div/div/div/div/div[2]/form/div[1]/div[4]/div/div/label[2]")
    private WebElement sidebarRadio;
    
//    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[3]/div[2]/div/div/div/div/div[2]/form/div[1]/div[4]/div/div/label[3]")
    @FindBy(how = How.XPATH, using = "/html/body/div/div[3]/div[2]/div/div/div/div/div[2]/form/div[1]/div[5]/div/div/label[3]/span")
    private WebElement footerRadio;
    
    public PagesDomen createNewPage (WebDriver driver) {
        
        PagesDomen page = new PagesDomen();
        
        clickOnElement(driver, addNewPage);
        
        String titleName = sendText(driver, title);
        page.setTitle(titleName);
        System.out.println("Title of pages: " + titleName);
                
        WebElement content = waitForElement(driver, parent);
        String contentArea = sendTextToFrame(driver, content);
        page.setText("<p>" + contentArea + "</p>");
        System.out.println("Text of pages: " + "<p>" + contentArea + "</p>");
        
        File file = new File("smiley.png");
        String imageName = "smiley.png";
        chooseFile(driver, image, file.getAbsolutePath());
        page.setPage_photo("/uploads/pages/" + imageName);
        System.out.println("Image of pages: " + "/uploads/pages/" + imageName);
        
//        ovde se mora inspektovati label da bi radio!
        WebElement sidebar = waitForElement(driver, sidebarRadio);
        sidebar.click();
        page.setSidebar(1);
        page.setFooter(0);
        
//        ovde radi i footer ali se mora inspektovati label!
//        WebElement footer = waitForVisibilityOfElement(driver, footerRadio);
//        footer.click();
//        page.setSidebar(0);
//        page.setFooter(1);
                
        int location_ = selectComboInteger(driver, location, "value");
        page.setLocation_id(location_);
        System.out.println("Location_id of pages: " + location_);
        
        String seo = sendText(driver, seoTitle);
        page.setSeo_title(seo);
        System.out.println("SEO title of pages: " + seo);
        
        clickOnElement(driver, savePages);
        
        waitForElement(driver, tableBody);
        
        int id = getIdFromWeb(driver, tableBody, "data-id");
        page.setId(id);
        System.out.println("Pages id from web: " + id);
                                
        return page;
        
    }
    
    public PagesDomen editPage(WebDriver driver) {
        
        PagesDomen page = new PagesDomen();
        
        sendSearchText(driver, tableBody, searchField, 0);
        
        clickOnElement(driver, editButton);
        
        String titleName = sendText(driver, title);
        page.setTitle(titleName);
        System.out.println("Title of pages: " + titleName);
                
        WebElement content = waitForElement(driver, parent);
        String contentArea = sendTextToFrame(driver, content);
        page.setText("<p>" + contentArea + "</p>");
        System.out.println("Text of pages: " + "<p>" + contentArea + "</p>");
        
        File file = new File("hearteyes.jpg");
        String imageName = "hearteyes.jpg";
        chooseFile(driver, image, file.getAbsolutePath());
        page.setPage_photo("/uploads/pages/" + imageName);
        System.out.println("Image of pages: " + "/uploads/pages/" + imageName);
        
//        mora se inspektovati direktno radio button - dugme da bi radio!
        WebElement footer = waitForVisibilityOfElement(driver, footerRadio);
        footer.click();
        page.setSidebar(0);
        page.setFooter(1);
        
//        WebElement sidebar = waitForElement(driver, sidebarRadio);
//        sidebar.click();
//        page.setSidebar(1);
//        page.setFooter(0);
        
        int location_ = selectComboInteger(driver, location, "value");
        page.setLocation_id(location_);
        System.out.println("Location_id of pages: " + location_);
        
        String seo = sendText(driver, seoTitle);
        page.setSeo_title(seo);
        System.out.println("SEO title of pages: " + seo);
        
        clickOnElement(driver, savePages);
        
        waitForElement(driver, tableBody);
        
        int id = getIdFromWeb(driver, tableBody, "data-id");
        page.setId(id);
        System.out.println("Pages id from web: " + id);
        
        return page;
        
    }
        
    public int deletePage(WebDriver driver) {
        
        sendSearchText(driver, tableBody, searchField, 0);
        
        int id = getIdFromWeb(driver, tableBody, "data-id");
        
        clickOnElement(driver, deleteButton);
        
        clickOnElement(driver, confirmDelete);
        
        return id;
        
    }
    
}
