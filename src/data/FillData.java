package data;

/**
 *
 * @author Dejan
 */

public class FillData {
    
    public static String getRandomText() {
        return "Test".concat(String.valueOf((int)(Math.random()*10000)));
    }
    
    public static String getRandomCompanyName() {
        return "Company".concat(String.valueOf((int)(Math.random()*10000)));
    }
    
    public static String getRandomCompanyAddress() {
        return "St.Regious ".concat(String.valueOf((int)(Math.random() * 1000)));
    }
    
    public static String getRandomUrl() {
        return "http://".concat(getRandomText()).concat(".te");
    }
    
    public static String getRandomEmail() {
        return "company".concat(String.valueOf((int)(Math.random()*1000))).concat("@gmail.com");
    }
    
    public static String getRandomPhoneNumber() {
        return "+381" + String.valueOf((int)(Math.random()*100000));
    }
    
    public static int getRandomNumber(int number) {
        return ((int)(Math.random() * number));
    }
            
}
