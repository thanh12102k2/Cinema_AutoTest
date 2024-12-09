package cinema.pages.admin;

import org.openqa.selenium.WebDriver;

public class SalesPage {
    WebDriver driver;
    public SalesPage(WebDriver driver) {
        this.driver = driver;
    }

    private String url ="/admin/dashboard";
    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }


}
