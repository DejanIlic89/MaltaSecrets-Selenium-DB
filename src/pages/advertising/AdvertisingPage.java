package pages.advertising;

import data.FillData;
import domen.AdvertisingDomen;
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

public class AdvertisingPage extends Page {
    
    @FindBy(how = How.CSS, using = "a[href='/advertising/create']") private WebElement addNewAd;
    
    @FindBy(how = How.ID, using = "title") private WebElement title;
    
    @FindBy(how = How.ID, using = "description") private WebElement description;
    
    @FindBy(how = How.CSS, using = "#type") private WebElement type;
    
    @FindBy(how = How.ID, using = "location") private WebElement location;
    
    @FindBy(how = How.NAME, using = "interest_category_id") private WebElement interest_category;
    
    @FindBy(how = How.ID, using = "company_id") private WebElement company;
    
    @FindBy(how = How.NAME, using = "image_path") private WebElement image;
    
    @FindBy(how = How.ID, using = "link") private WebElement link;
    
    @FindBy(how = How.ID, using = "newrecord") private WebElement saveAdvert;
    
    @FindBy(how = How.XPATH, using = "//*[@id='DataTables_Table_0']/tbody") private WebElement tableBody;
    
    @FindBy(how = How.CLASS_NAME, using = "input-small") private WebElement searchField;
    
    @FindBy(how = How.CLASS_NAME, using = "icon-pencil") private WebElement editButton;
    
    @FindBy(how = How.CLASS_NAME, using = "icon-trash") private WebElement deleteButton;
    
    @FindBy(how = How.CSS, using = "#buttonTextIcon") private WebElement confirmDelete;
    
    public AdvertisingDomen createNewAdvertising(WebDriver driver) {
        
        AdvertisingDomen ad = new AdvertisingDomen();
        
        clickOnElement(driver, addNewAd);
        
        String title_ = sendText(driver, title);
        ad.setTitle(title_);
        System.out.println("Title of advertising: " + title_);
        
        String description_ = sendText(driver, description);
        ad.setDescription(description_);
        System.out.println("Description of advertising: " + description_);
        
        int type_ = chooseComboItem(driver, type);
        ad.setType(type_);
        System.out.println("Type of advertising: " + type_);
        
        int location_ = selectComboInteger(driver, location, "value");
        ad.setLocation(location_);
        
        int interest_Category = chooseComboItem(driver, interest_category);
        ad.setInterest_category_id(interest_Category);
        System.out.println("Interest_category of advertising: " + interest_Category);
        
        int company_Id = chooseComboItem(driver, company);
        ad.setCompany_id(company_Id);
        System.out.println("Company_id of advertising: " + company_Id);
        
        File file = new File("smiley.png");
        String imageName = "smiley.png";
        String path = file.getAbsolutePath();
        chooseFile(driver, image, file.getAbsolutePath());
        ad.setImage_path("/uploads/advertise/" + imageName);
        System.out.println("Image of advertising: " + "/uploads/advertise/" + imageName);
        
        String link_ = sendText(driver, link, FillData.getRandomUrl());
        ad.setLink(link_);
        System.out.println("link of advertising: " + link_);
        
        clickOnElement(driver, saveAdvert);
        
        driver.navigate().back();
        
        driver.navigate().back();
        
        driver.navigate().refresh();
        
        waitForElement(driver, tableBody);
        
        int id = getIdFromWeb(driver, tableBody, "data-id");
        ad.setAdvertise_id(id);
        System.out.println("id from web: " + id);
        
        return ad;
        
    }
    
    public AdvertisingDomen editAdvertising(WebDriver driver) {
        
        AdvertisingDomen ad = new AdvertisingDomen();
        
        sendSearchText(driver, tableBody, searchField, 0);
        
        clickOnElement(driver, editButton);
        
        String title_ = sendText(driver, title);
        ad.setTitle(title_);
        System.out.println("Title of advertising: " + title_);
        
        String description_ = sendText(driver, description);
        ad.setDescription(description_);
        System.out.println("Description of advertising: " + description_);
        
        int type_ = chooseComboItem(driver, type);
        ad.setType(type_);
        System.out.println("Type of advertising: " + type_);
        
        int location_ = selectComboInteger(driver, location, "value");
        ad.setLocation(location_);
        
        int interest_Category = chooseComboItem(driver, interest_category);
        ad.setInterest_category_id(interest_Category);
        System.out.println("Interest_category of advertising: " + interest_Category);
        
        int company_Id = chooseComboItem(driver, company);
        ad.setCompany_id(company_Id);
        System.out.println("Company_id of advertising: " + company_Id);
        
        File file = new File("hearteyes.jpg");
        String imageName = "hearteyes.jpg";
        chooseFile(driver, image, file.getAbsolutePath());
        ad.setImage_path("/uploads/advertise/" + imageName);
        System.out.println("Image of advertising: " + "/uploads/advertise/" + imageName);
        
        String link_ = sendText(driver, link, FillData.getRandomUrl());
        ad.setLink(link_);
        System.out.println("link of advertising: " + link_);
        
        clickOnElement(driver, saveAdvert);
        
        driver.navigate().back();
        
        driver.navigate().back();
        
        driver.navigate().refresh();
        
        waitForElement(driver, tableBody);
        
        int id = getIdFromWeb(driver, tableBody, "data-id");
        ad.setAdvertise_id(id);
        System.out.println("id from web: " + id);
        
        return ad;
        
    }
    
    public int deleteAdvertising(WebDriver driver) {
        
        sendSearchText(driver, tableBody, searchField, 0);
        
        int id = getIdFromWeb(driver, tableBody, "data-id");
        
        clickOnElement(driver, deleteButton);
        
        clickOnElement(driver, confirmDelete);
        
        return id;
        
    }
    
}
