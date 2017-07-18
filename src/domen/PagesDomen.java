package domen;

/**
 *
 * @author Dejan
 */

public class PagesDomen {
    
    private int id;
    private String title;
    private String text;
    private String page_photo;
    private int location_id;
    private String seo_title;
    private int sidebar;
    private int footer;

    public PagesDomen() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPage_photo() {
        return page_photo;
    }

    public void setPage_photo(String page_photo) {
        this.page_photo = page_photo;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public String getSeo_title() {
        return seo_title;
    }

    public void setSeo_title(String seo_title) {
        this.seo_title = seo_title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFooter() {
        return footer;
    }

    public void setFooter(int footer) {
        this.footer = footer;
    }

    public int getSidebar() {
        return sidebar;
    }

    public void setSidebar(int sidebar) {
        this.sidebar = sidebar;
    }
    
    
}
