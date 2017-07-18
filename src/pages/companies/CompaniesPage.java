package pages.companies;

import data.FillData;
import domen.CompaniesDomen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Page;

/**
 *
 * @author Dejan
 */

public class CompaniesPage extends Page {
    
    @FindBy(how = How.CLASS_NAME, using = "pull-right") private WebElement addNewCompany;
    
    @FindBy(how = How.ID, using = "contact_person") private WebElement contactPerson;
    
    @FindBy(how = How.ID, using = "phone_number") private WebElement phoneNumber;
    
    @FindBy(how = How.ID, using = "email_address") private WebElement emailAddress;
    
    @FindBy(how = How.ID, using = "company_name") private WebElement companyName;
    
    @FindBy(how = How.ID, using = "company_website") private WebElement companyWebsite;
    
    @FindBy(how = How.ID, using = "location_ids") private WebElement selectParent;
    
    @FindBy(how = How.ID, using = "company_address") private WebElement companyAddress;
    
    @FindBy(how = How.ID, using = "vat_number") private WebElement vatNo;
    
    @FindBy(how = How.ID, using = "moderator_id") private WebElement moderator;
    
    @FindBy(how = How.ID, using = "notes") private WebElement companyNote;
    
    @FindBy(how = How.ID, using = "submit") private WebElement createCompany;
    
    @FindBy(how = How.CSS, using = "#DataTables_Table_0 > tbody") private WebElement tableBody;
    
    @FindBy(how = How.CLASS_NAME, using = "input-small") private WebElement searchField;
    
    @FindBy(how = How.CLASS_NAME, using = "icon-pencil") private WebElement editButton;
    
    @FindBy(how = How.CLASS_NAME, using = "btn-success ") private WebElement editCompany;
    
    @FindBy(how = How.CLASS_NAME, using = "icon-trash") private WebElement deleteButton;
    
    @FindBy(how = How.CSS, using = "#buttonTextIcon") private WebElement confirmDelete;
    
    public CompaniesDomen createNewCompany(WebDriver driver) {
        
        CompaniesDomen company = new CompaniesDomen();
        
        clickOnElement(driver, addNewCompany);
        
        String contact_Person = sendText(driver, contactPerson);
        company.setContact_person(contact_Person);
        
        String phone_Number = sendText(driver, phoneNumber, FillData.getRandomPhoneNumber());
        company.setPhone_number(phone_Number);
        
        String email_Address = sendText(driver, emailAddress, FillData.getRandomEmail());
        company.setEmail_address(email_Address);
        
        String company_Name = sendText(driver, companyName, FillData.getRandomCompanyName());
        company.setCompany_name(company_Name);
        
        String company_Website = sendText(driver, companyWebsite, FillData.getRandomUrl());
        company.setCompany_website(company_Website);
        
        String locations = selectCombo(driver, selectParent, "value");
        company.setLocation_ids(locations);
        
        String company_Address = sendText(driver, companyAddress, FillData.getRandomCompanyAddress());
        company.setCompany_address(company_Address);
        
        String vat_Number = sendText(driver, vatNo, FillData.getRandomPhoneNumber());
        company.setVat_number(vat_Number);
        
        int moderator_ = chooseComboItem(driver, moderator);
        company.setModerator_id(moderator_);
        
        String notes_ = sendText(driver, companyNote);
        company.setNotes(notes_);
        
        clickOnElement(driver, createCompany);
        
        int id = getIdFromWeb(driver, tableBody, "data-id");
        company.setCompanies_id(id);
        
        return company;
    }
    
    public CompaniesDomen editCompany(WebDriver driver) {
        
        CompaniesDomen company = new CompaniesDomen();
        
        sendSearchText(driver, tableBody, searchField, 0);
        
        clickOnElement(driver, editButton);
        
        String contact_Person = sendText(driver, contactPerson);
        company.setContact_person(contact_Person);
        
        String phone_Number = sendText(driver, phoneNumber, FillData.getRandomPhoneNumber());
        company.setPhone_number(phone_Number);
        
        String email_Address = sendText(driver, emailAddress, FillData.getRandomEmail());
        company.setEmail_address(email_Address);
        
        String company_Name = sendText(driver, companyName, FillData.getRandomCompanyName());
        company.setCompany_name(company_Name);
        
        String company_Website = sendText(driver, companyWebsite, FillData.getRandomUrl());
        company.setCompany_website(company_Website);
        
        String locations = selectCombo(driver, selectParent, "value");
        company.setLocation_ids(locations);
        
        String company_Address = sendText(driver, companyAddress, FillData.getRandomCompanyAddress());
        company.setCompany_address(company_Address);
        
        String vat_Number = sendText(driver, vatNo, FillData.getRandomPhoneNumber());
        company.setVat_number(vat_Number);
        
        int moderator_ = chooseComboItem(driver, moderator);
        company.setModerator_id(moderator_);
        
        String notes_ = sendText(driver, companyNote);
        company.setNotes(notes_);
        
        clickOnElement(driver, editCompany);
        
        int id = getIdFromWeb(driver, tableBody, "data-id");
        company.setCompanies_id(id);
        
        return company;
        
    }
    
    public int deleteCompany(WebDriver driver) {
//        CompaniesDomen company = new CompaniesDomen();
        
        sendSearchText(driver, tableBody, searchField, 0);
        
        int id = getIdFromWeb(driver, tableBody, "data-id");
//        company.setCompanies_id(id);
        
//        String company_Name = getCompanyNameFromWeb(driver, tableBody);
//        company.setCompany_name(company_Name);
        
        
        clickOnElement(driver, deleteButton);
        
        clickOnElement(driver, confirmDelete);
        
        return id;
        
    }
}
