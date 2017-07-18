package domen;

/**
 *
 * @author Dejan
 */

public class CompaniesDomen {
    
    private int companies_id;
    private String contact_person;
    private String phone_number;
    private String email_address;
    private String company_name;
    private String company_website;
    private String location_ids;
    private String company_address;
    private String vat_number;
    private int moderator_id;
    private String notes;
    
    public CompaniesDomen() {
    }

    public CompaniesDomen(int companies_id, String contact_person, String phone_number, String email_address, String company_name, String company_website, String location_ids, String company_address, String vat_number, int moderator_id, String notes) {
        this.companies_id = companies_id;
        this.contact_person = contact_person;
        this.phone_number = phone_number;
        this.email_address = email_address;
        this.company_name = company_name;
        this.company_website = company_website;
        this.location_ids = location_ids;
        this.company_address = company_address;
        this.vat_number = vat_number;
        this.moderator_id = moderator_id;
        this.notes = notes;
    }
    
    

    public int getCompanies_id() {
        return companies_id;
    }

    public void setCompanies_id(int companies_id) {
        this.companies_id = companies_id;
    }

    public String getContact_person() {
        return contact_person;
    }

    public void setContact_person(String contact_person) {
        this.contact_person = contact_person;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_website() {
        return company_website;
    }

    public void setCompany_website(String company_website) {
        this.company_website = company_website;
    }

    public String getLocation_ids() {
        return location_ids;
    }

    public void setLocation_ids(String location_ids) {
        this.location_ids = location_ids;
    }

    public String getCompany_address() {
        return company_address;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }

    public String getVat_number() {
        return vat_number;
    }

    public void setVat_number(String vat_number) {
        this.vat_number = vat_number;
    }

    public int getModerator_id() {
        return moderator_id;
    }

    public void setModerator_id(int moderator_id) {
        this.moderator_id = moderator_id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
}
