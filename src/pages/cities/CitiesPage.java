package pages.cities;

import domen.CitiesDomen;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Page;

/**
 *
 * @author Dejan
 */

public class CitiesPage extends Page {
    
    @FindBy(how = How.CLASS_NAME, using = "btn-circle") private WebElement addNewCity;
    
    @FindBy(how = How.ID, using = "region_id") private WebElement comboRegion;
    
    @FindBy(how = How.ID, using = "seo_title") private WebElement seoTitle;
    
    @FindBy(how = How.ID, using = "seo_description") private WebElement seoDescription;
    
    @FindBy(how = How.ID, using = "seo_keywords") private WebElement seoKeyword;
    
    @FindBy(how = How.ID, using = "name") private WebElement name;
    
    @FindBy(how = How.CSS, using = "body > div.page-wrapper > div.page-container > div.page-content-wrapper > div > div > div > div > div.portlet-body > form > div.form-body > div:nth-child(7) > div.col-md-1 > div > label")
    private WebElement checkFeatured;
    
    @FindBy(how = How.ID, using = "cke_1_contents") private WebElement parentFrame;
    
    @FindBy(how = How.ID, using = "main_image") private WebElement mainImage;
    
    @FindBy(how = How.ID, using = "image1") private WebElement image1;
    
    @FindBy(how = How.ID, using = "image2") private WebElement image2;
    
    @FindBy(how = How.ID, using = "nextrecord") private WebElement saveButton;
    
    @FindBy(how = How.XPATH, using = "//*[@id='DataTables_Table_0']/tbody") private WebElement tableBody;
    
    @FindBy(how = How.CLASS_NAME, using = "input-small") private WebElement searchField;
    
    @FindBy(how = How.CLASS_NAME, using = "icon-pencil") private WebElement editButton;
    
    @FindBy(how = How.CLASS_NAME, using = "pull-right") private WebElement saveAndGo;
    
    @FindBy(how = How.CSS, using = "a[href='/cities/list']") private WebElement cities;
        
    public CitiesDomen createNewCity(WebDriver driver) {
        
        CitiesDomen cd = new CitiesDomen();
        
        clickOnElement(driver, addNewCity);
        
        int region = selectComboRegion(driver, comboRegion, "Gozo Region");
        cd.setRegion_id(region);
        System.out.println("Region_id: " + region);
        
        String seoTitle_ = sendText(driver, this.seoTitle);
        cd.setSeo_title(seoTitle_);
        System.out.println("Seo Title: " + seoTitle_);
        
        String seoDescription_ = sendText(driver, this.seoDescription);
        cd.setSeo_description(seoDescription_);
        System.out.println("Seo Description: " + seoDescription_);
        
        String seoKeyword_ = sendText(driver, this.seoKeyword);
        cd.setSeo_keywords(seoKeyword_);
        System.out.println("Seo Keywords: " + seoKeyword_);
        
        String name_ = sendText(driver, name);
        cd.setName(name_);
        System.out.println("Name: " + name_);
        
        int featured_ = checkboxFeatured(driver, checkFeatured);
        cd.setFeatured(featured_);
        System.out.println("Featured: " + featured_);
        
        String description_ = sendTextToFrame(driver, parentFrame);
        cd.setDescription(description_);
        System.out.println("Description: " + description_);
        
        File file = new File("animal.jpg");
        String imageName = "animal.jpg";
        chooseFile(driver, mainImage, file.getAbsolutePath());
        cd.setMain_image("/uploads/cities/" + imageName);
        System.out.println("Main Image of cities: " + "/uploads/cities/" + imageName);
        
        file = new File("smiley.png");
        imageName = "smiley.png";
        chooseFile(driver, image1, file.getAbsolutePath());
        cd.setImage1("/uploads/cities/" + imageName);
        System.out.println("Image1 of cities: " + "/uploads/cities/" + imageName);
        
        file = new File("hearteyes.png");
        imageName = "hearteyes.png";
        chooseFile(driver, image2, file.getAbsolutePath());
        cd.setImage2("/uploads/cities/" + imageName);
        System.out.println("Image2 of cities: " + "/uploads/cities/" + imageName);
        
        clickOnElement(driver, saveButton);
        
        return cd;
        
    }
    
    public static void changeOrder(WebDriver driver) {
        driver.findElement(By.cssSelector("#DataTables_Table_0 > thead > tr > th:nth-child(3)")).click();
        WebElement changeOrder = driver.findElement(
                By.cssSelector("body > div.page-wrapper > div.page-container > div.page-content-wrapper > div > div.row > div > div > div.portlet-title > div.actions > a:nth-child(2)"));
        changeOrder.click();
        
        WebElement from = driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr[1]/td[1]/i"));
//        WebElement to = driver.findElement(By.cssSelector("#DataTables_Table_0 > tbody > tr:nth-child(5) > td:nth-child(1)"));
//        to find location of an element, (x, y) coordinates
//        System.out.println(to.getLocation()); 
//        int x = to.getLocation().getX();
//        int y = to.getLocation().getY();
        
        Actions act = new Actions(driver);
        
//        I nacin
//        act.dragAndDrop(from, to).perform();
        
//        II nacin
//        act.clickAndHold(from).build().perform();
//        act.moveToElement(to).build().perform();
//        act.release(to).build().perform();
        
//        III nacin
        act.dragAndDropBy(from, 0, 200).build().perform();
        
        WebElement save = driver.findElement(By.className("fa-plus"));
        save.click();
        
        driver.navigate().refresh();
        driver.findElement(By.cssSelector("#DataTables_Table_0 > thead > tr > th:nth-child(3)")).click();
    }
    
    public CitiesDomen editCity(WebDriver driver) {
        
        CitiesDomen cd = new CitiesDomen();
        
        sendSearchText(driver, tableBody, searchField, 4);
        
        clickOnElement(driver, editButton);
        
        String seoTitle_ = sendText(driver, this.seoTitle);
        cd.setSeo_title(seoTitle_);
        System.out.println("Seo Title: " + seoTitle_);
        
        String seoDescription_ = sendText(driver, this.seoDescription);
        cd.setSeo_description(seoDescription_);
        System.out.println("Seo Description: " + seoDescription_);
        
        String seoKeyword_ = sendText(driver, this.seoKeyword);
        cd.setSeo_keywords(seoKeyword_);
        System.out.println("Seo Keywords: " + seoKeyword_);
        
        String name_ = sendText(driver, name);
        cd.setName(name_);
        System.out.println("Name: " + name_);
                
        String description_ = sendTextToFrame(driver, parentFrame);
        cd.setDescription("<p>" + description_ + "</p>");
        System.out.println("Description: " + "<p>" + description_ + "</p>");
        
        clickOnElement(driver, saveAndGo);
        
        clickOnElement(driver, cities);
        
        int id = getIdFromWeb(driver, tableBody, "data-city-id");
        cd.setId(id);
        System.out.println("id from web: " + id);
        
        return cd;
        
    }
}
