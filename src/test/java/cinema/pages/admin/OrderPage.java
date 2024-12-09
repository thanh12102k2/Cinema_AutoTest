package cinema.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.UUID;

public class OrderPage {
    WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    private String url ="/admin/order";
    private By viewOrderBtn = By.xpath("(//button[@type='button'])[3]");
    private By titleViewOrder = By.xpath("//div[text()=\"Thông tin đơn hàng\"]");
    private By closeViewBtn = By.xpath("//button[@aria-label='Close']");

    private By searchCodeBtn = By.xpath("//span[@role='button']");
    private By getSearchCodeInput = By.xpath("//input[@placeholder='Tìm kiếm đơn hàng']");
    private By searchBtn = By.xpath("//span[contains(text(),'Tìm kiếm')]");
    private By resetBtn = By.xpath("//span[contains(text(),'Đặt lại')]");
    private By sortBtn= By.xpath("//span[contains(text(),'Mã đơn hàng')]");

    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }

    public void viewOrderDetail() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Order");
        Thread.sleep(2000);
        driver.findElement(viewOrderBtn).click();
        Thread.sleep(3000);
        String message_actual = driver.findElement(titleViewOrder).getText();
        Assert.assertEquals("Thông tin đơn hàng", message_actual);
        driver.findElement(closeViewBtn).click();
    }

    public void sortAndSearchNameMovie() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Movie");
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(searchCodeBtn).click();
        driver.findElement(getSearchCodeInput).sendKeys("202412025113");
        driver.findElement(searchBtn).click();
        Thread.sleep(1000);
        driver.findElement(searchCodeBtn).click();
        Thread.sleep(1000);
        driver.findElement(resetBtn).click();
        driver.findElement(searchBtn).click();
    }
}
