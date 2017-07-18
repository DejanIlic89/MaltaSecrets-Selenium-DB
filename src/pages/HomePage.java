package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.advertising.AdvertisingPage;
import pages.cities.CitiesPage;
import pages.companies.CompaniesPage;
import pages.news.NewsPage;
import pages.pages.PagesPage;

/**
 *
 * @author Dejan
 */

public class HomePage extends Page {
    
    @FindBy(className = "navbar-nav")
    private WebElement parent;
        
    @FindBy(className = "dropdown-menu-default")
    private WebElement selectAll;
    
    @FindBy(css = "a[href='/companies/list']")
    private WebElement companies;
    
    @FindBy(css = "a[href='/advertising/list']")
    private WebElement advertising;
    
    @FindBy(css = "a[href='/page/list']")
    private WebElement pages;
    
    @FindBy(css = "a[href='/cities/list']")
    private WebElement cities;
    
    @FindBy(css = "a[href='/news/list']")
    private WebElement news;
    
    public void clickOnDropdown(WebDriver driver) {
        WebElement parentField = waitForElement(driver, parent);
        WebElement arrow = parentField.findElement(By.className("fa-angle-down"));
        arrow.click();
    }

    public void chooseLocation(WebDriver driver, String destination) {
        WebElement parentElement = waitForElement(driver, selectAll);
        List<WebElement> items = parentElement.findElements(By.className("nav-link "));
        for (int i = 0; i < items.size(); i++) {
            WebElement get = items.get(i);
            String text = get.getText();
            if (text.equals(destination)) {
                get.click();
                break;
            }
            parentElement = waitForElement(driver, selectAll);
            items = parentElement.findElements(By.className("nav-link "));
        }
    }
    
    public CompaniesPage clickOnCompanies(WebDriver driver) {
        clickOnElement(driver, companies);
        return PageFactory.initElements(driver, CompaniesPage.class);
    }
    
    public AdvertisingPage clickOnAdvertising(WebDriver driver) {
        clickOnElement(driver, advertising);
        return PageFactory.initElements(driver, AdvertisingPage.class);
    }
    
    public PagesPage clickOnPages(WebDriver driver) {
        clickOnElement(driver, pages);
        return PageFactory.initElements(driver, PagesPage.class);
    }
    
    public CitiesPage clickOnCities(WebDriver driver) {
        clickOnElement(driver, cities);
        return PageFactory.initElements(driver, CitiesPage.class);
    }
    
    public NewsPage clickOnNews(WebDriver driver) {
        clickOnElement(driver, news);
        return PageFactory.initElements(driver, NewsPage.class);
    }
    
}
