package cinema.pages.client;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CinemaPage {
    WebDriver driver;

    public CinemaPage(WebDriver driver) {
        this.driver = driver;
    }

    private String url ="/cinema";
    private By searchInput = By.xpath("//input[@placeholder='Tìm kiếm...']");
    private By resultSearch = By.xpath("(//div[@class='CinemaCart_container__ugNPD CinemaCart_active__qEcJl'])[1]");
    private By cinemaName = By.xpath("//div[@class='MainPageCinema_info___fYvs']//h4");

    private By mapBtn = By.xpath("//span[contains(text(),'[ Bản đồ ]')]");
    private By closeMapBtn = By.xpath("//div[@class='Button_text__FcN3u']");

    private By invalidCinemaNotif = By.xpath("//p[contains(text(),'Không tìm thấy rạp chiếu phù hợp!')]");


    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }

    public void SearchCinema() throws InterruptedException {
        Thread.sleep(2000);
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Cinema");
        driver.findElement(searchInput).sendKeys("Trương Định");
        Thread.sleep(1000);
        driver.findElement(resultSearch).click();
        Thread.sleep(1000);
        String result_name = driver.findElement(resultSearch).getText();
        String name_actual = driver.findElement(cinemaName).getText();
        Assert.assertEquals(name_actual, result_name);
    }

    public void SearchInvalidCinema() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Cinema");
        driver.findElement(searchInput).sendKeys("Test Search Invalid");
        Thread.sleep(1500);
        String messenger_actual = driver.findElement(invalidCinemaNotif).getText();
        Assert.assertEquals("Không tìm thấy rạp chiếu phù hợp!", messenger_actual);
    }

    public void ViewMapCinema() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Cinema");
        Thread.sleep(1000);
        driver.findElement(mapBtn).click();
        Thread.sleep(2500);
        driver.findElement(closeMapBtn).click();
    }


}
