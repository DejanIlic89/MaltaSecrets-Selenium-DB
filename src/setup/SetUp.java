package setup;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import pages.LogInPage;

/**
 *
 * @author Dejan
 */

public class SetUp {

    public WebDriver initializeDriver(WebDriver driver) {
        
//        FirefoxProfile newProfile = new FirefoxProfile();
//        newProfile.setPreference("browser.cache.disk.enable", false);
//        driver = new FirefoxDriver(newProfile);
        
//        driver = new FirefoxDriver();
        
        ChromeOptions options = new ChromeOptions();

        options.addArguments("disable-infobars");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    public LogInPage openLogInPage(WebDriver driver) {
        driver.get("http://admin:admin@maltatest.school.cubes.rs/adminuser/login");
        
        return PageFactory.initElements(driver, LogInPage.class);
    }
    
}
