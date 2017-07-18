package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Dejan
 */

public class LogInPage extends Page {
    
    @FindBy(how = How.ID, using = "email")
    private WebElement email;
    
    @FindBy(how = How.ID, using = "password")
    private WebElement password;
    
    @FindBy(how = How.ID, using = "submit")
    private WebElement signIn;
    
    public HomePage clickOnLogin(WebDriver driver) {
        email.sendKeys("ivan.stepanovic@cubes.rs");
        password.sendKeys("Ivan123");
        signIn.click();
        return PageFactory.initElements(driver, HomePage.class);
    }
    
}
