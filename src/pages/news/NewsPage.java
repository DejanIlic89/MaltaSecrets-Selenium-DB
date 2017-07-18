package pages.news;

import domen.NewsDomen;
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

public class NewsPage extends Page {
    
    @FindBy(how = How.CLASS_NAME, using = "btn-circle") private WebElement addNews;
    
    @FindBy(how = How.ID, using = "title") private WebElement title;
    
    @FindBy(how = How.ID, using = "cke_1_contents") private WebElement parent;
    
    @FindBy(how = How.ID, using = "seo_title") private WebElement seoTitle;
    
    @FindBy(how = How.ID, using = "seo_description") private WebElement seoDescription;
    
    @FindBy(how = How.ID, using = "seo_keywords") private WebElement seoKeywords;
    
    @FindBy(how = How.ID, using = "main_image") private WebElement mainImage;
    
    @FindBy(how = How.ID, using = "backtolist") private WebElement submit;
    
    
    
    public NewsDomen createNewNews(WebDriver driver) {
        
        NewsDomen nd = new NewsDomen();
        
        clickOnElement(driver, addNews);
        
        String title_ = sendText(driver, title);
        nd.setTitle(title_);
        System.out.println("Title is: " + title_);
        
        WebElement content = waitForElement(driver, parent);
        String contentArea = sendTextToFrame(driver, content);
        nd.setContent("<p>" + contentArea + "</p>");
        System.out.println("Text of news: " + "<p>" + contentArea + "</p>");
        
        
        
        String seoTitle_ = sendText(driver, seoTitle);
        nd.setSeoTitle(seoTitle_);
        System.out.println("SeoTitle: " + seoTitle_);
        
        String seoDescription_ = sendText(driver, seoTitle);
        nd.setSeoDescription(seoDescription_);
        System.out.println("SeoDesc: " + seoDescription_);
        
        String seoKeywords_ = sendText(driver, seoKeywords);
        nd.setSeoKeyword(seoKeywords_);
        System.out.println("SeoKey: " + seoKeywords_);
        
        File file = new File("animal.jpg");
        String imageName = "animal.jpg";
        chooseFile(driver, mainImage, file.getAbsolutePath());
        nd.setMainImage("/uploads/news/" + imageName);
        System.out.println("Main Image of news: " + "/uploads/news/" + imageName);
        
        clickOnElement(driver, submit);
        
        
        
        return nd;
        
    }
    
}
