package pages;

import data.FillData;
import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Dejan
 */
public class Page {
    
    public WebElement waitForElement(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }
    
    public WebElement waitForElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        return targetElement;
    }
    
    public WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement targetElement = wait.until(ExpectedConditions.visibilityOf(element));
        return targetElement;
    }
    
    public void clickOnElement(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
    
    public void clickOnElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        targetElement.click();
    }
    
//    public void sendText(WebDriver driver, WebElement element) {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement targetElement = wait.until(ExpectedConditions.visibilityOf(element));
//        targetElement.clear();
//        targetElement.sendKeys(FillData.getRandomText());
//    }
    
    public String sendText(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement targetElement = wait.until(ExpectedConditions.visibilityOf(element));
        targetElement.clear();
        String text = FillData.getRandomText();
        targetElement.sendKeys(text);
        return text;
    }
    
    public String sendTextToFrame(WebDriver driver, WebElement parent) {
        WebElement frame = parent.findElement(By.className("cke_wysiwyg_frame"));
        WebElement targetElement = driver.switchTo().frame(frame).findElement(By.tagName("body"));
        targetElement.clear();
        String text = FillData.getRandomText();
        targetElement.sendKeys(text);
        
        driver.switchTo().defaultContent();
        return text;
    }
    
    public int getIdFromWeb(WebDriver driver, WebElement tableBody, String attribute) {
        WebElement targetElement = waitForElement(driver, tableBody);
        List<WebElement> rows = targetElement.findElements(By.tagName("tr"));
        WebElement firstRow = rows.get(0);
        String id = firstRow.getAttribute(attribute);
        return Integer.valueOf(id);
    }
    
    public String getCompanyNameFromWeb(WebDriver driver, WebElement tableBody) {
        WebElement parent = waitForElement(driver, tableBody);
        List<WebElement> rows = parent.findElements(By.tagName("tr"));
        WebElement firstRow = rows.get(0);
        List<WebElement> tdRows = firstRow.findElements(By.tagName("td"));
        WebElement firstTd = tdRows.get(0);
        String text = firstTd.getText();
        return text;
    }
    
    public void sendText(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(FillData.getRandomText());
    }
    
    public void sendSearchText(WebDriver driver, WebElement tableBody, WebElement searchField, int tdOrder) {
        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
        WebElement firstRow = rows.get(0);
        List<WebElement> tdRows = firstRow.findElements(By.tagName("td"));
        WebElement td = tdRows.get(tdOrder);
        String text = td.getText();
        sendText(driver, searchField, text);
    }
    
//    public void sendText(WebDriver driver, WebElement element, String text) {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement targetElement = wait.until(ExpectedConditions.visibilityOf(element));
//        targetElement.clear();
//        targetElement.sendKeys(text);
//    }
    
    public String sendText(WebDriver driver, WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement targetElement = wait.until(ExpectedConditions.visibilityOf(element));
        targetElement.clear();
        targetElement.sendKeys(text);
        return text;
    }
    
    public void sendText(WebDriver driver, By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }
    
    public int checkboxFeatured(WebDriver driver, WebElement element) {
        WebElement elem = waitForElement(driver, element);
        elem.click();
        WebElement targetValue = elem.findElement(By.id("featured"));
        String text = targetValue.getAttribute("value");
        int j = Integer.valueOf(text);
        return j;
    }
    
    public void chooseOption(WebElement parentElement, By optionLocator) {
        List<WebElement> rows = parentElement.findElements(By.tagName("tr"));
        WebElement lastRow = rows.get(rows.size()-1);
        WebElement option = lastRow.findElement(optionLocator);
        option.click();
    }
        
//    public void selectCombo(WebDriver driver, WebElement element) {
//        WebElement targetCombo = waitForElement(driver, element);
//        Select comboSelect = new Select(targetCombo);
//        comboSelect.selectByIndex(FillData.getRandomNumber(comboSelect.getOptions().size()));
//    }
    
//    public String selectCombo(WebDriver driver, WebElement element, String attribute) {
//        WebElement targetCombo = waitForElement(driver, element);
//        Select comboSelect = new Select(targetCombo);
//        List<WebElement> elements = comboSelect.getOptions();
//        int i = FillData.getRandomNumber(comboSelect.getOptions().size());
//        WebElement elem = elements.get(i);
//        String text = elem.getAttribute(attribute);
//        comboSelect.selectByIndex(i);
//        return text;
//    }
    
    public String selectCombo(WebDriver driver, WebElement element, String attribute) {
        WebElement targetCombo = waitForElement(driver, element);
        Select comboSelect = new Select(targetCombo);
        List<WebElement> elements = comboSelect.getOptions();
        String string = null;
        for (int i = 0; i < elements.size(); i++) {
            WebElement get = elements.get(i);
            String text = get.getText();
            if (text.equals("Malta")) {
                string = get.getAttribute(attribute);
                break;
            }
        }
        comboSelect.selectByVisibleText("Malta");
        return string;
    }
    
    public int selectComboRegion(WebDriver driver, WebElement select, String region) {
        WebElement targetCombo = waitForVisibilityOfElement(driver, select);
        Select selectCombo = new Select(targetCombo);
        selectCombo.selectByVisibleText(region);
        WebElement item = selectCombo.getFirstSelectedOption();
        String text = item.getAttribute("value");
        int j = Integer.valueOf(text);
        return j;
    }
    
    public int selectComboInteger(WebDriver driver, WebElement element, String attribute) {
        WebElement targetCombo = waitForElement(driver, element);
        Select comboSelect = new Select(targetCombo);
        List<WebElement> elements = comboSelect.getOptions();
        String string = null;
        int j = 0;
        for (int i = 0; i < elements.size(); i++) {
            WebElement get = elements.get(i);
            String text = get.getText();
            if (text.equals("Malta")) {
                string = get.getAttribute(attribute);
                break;
            }
        }
        j = Integer.valueOf(string);
        comboSelect.selectByVisibleText("Malta");
        return j;
    }
    
    public int chooseComboItem(WebDriver driver, WebElement parent){
        WebElement targetElement = waitForElement(driver, parent);
        Select combo = new Select(targetElement);
//        combo.selectByIndex(FillData.getRandomNumber(combo.getOptions().size()));
        combo.selectByIndex(combo.getOptions().size()-1);
        WebElement element = combo.getFirstSelectedOption();
        String value = element.getAttribute("value");
        return Integer.valueOf(value);
    }
    
    
//    public String selectCombo(WebDriver driver, WebElement element) {
//        WebElement targetCombo = waitForElement(driver, element);
//        Select comboSelect = new Select(targetCombo);
//        int i = FillData.getRandomNumber(comboSelect.getOptions().size());
//        List<WebElement> elements = comboSelect.getOptions();
//        WebElement elem = elements.get(i);
//        String text = elem.getText();
//        comboSelect.selectByIndex(i);
//        return text;
//    }
    
    public void chooseFile(WebDriver driver, WebElement element, String filePath) {
        WebElement upload = waitForElement(driver, element);
        upload.sendKeys(filePath);
    }
    
    public static void logOut(WebDriver driver) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(By.className("toast-top-right")));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement logOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[3]/ul/li/a/span")));
        logOut.click();
        WebElement logOutClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/adminuser/logout']")));
        logOutClick.click();
    }
    
}
