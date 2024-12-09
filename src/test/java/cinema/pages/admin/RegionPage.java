package cinema.pages.admin;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

public class RegionPage {
    WebDriver driver;

    public RegionPage(WebDriver driver) {
        this.driver = driver;
    }

    private String url ="/admin/region";
    private By addRegionBtn = By.xpath("//span[contains(text(),'Thêm mới quốc gia')]");
    private By addNameRegionInput = By.id("basic_regionName");
    private By addSaveBtn = By.xpath("//button[@type='submit']");

    private By deleteRegionBtn = By.xpath("(//button[@type='button'])[4]");
    private By yesDeteleBtn = By.xpath("//span[normalize-space()='Có']");

    private By updateRegionBtn = By.xpath("(//button[@type='button'])[5]");
    private By updateNameRegionInput = By.id("basic1_regionName");
    private By updateSaveBtn = By.xpath("(//button[@type='submit'])[2]");

    private By searchNameBtn = By.xpath("//span[@role='button']");
    private By getSearchNameInput = By.xpath("//input[@placeholder='Tìm kiếm quốc gia']");
    private By searchBtn = By.xpath("//span[contains(text(),'Tìm kiếm')]");
    private By resetBtn = By.xpath("//span[contains(text(),'Đăt lại')]");
    private By sortBtn= By.xpath("//span[contains(text(),'Tên quốc gia')]");

    private By notif = By.xpath("//div[@class='ant-message-notice-content']");
    private By closeBtn = By.xpath("(//button[@aria-label='Close'])[1]");

    private  By messRegion = By.xpath("//div[@class='ant-form-item-explain-error']");

    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }

    private String generateRandomName() {
        return UUID.randomUUID().toString().substring(0, 6);
    }

    public void addRegion() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Region");
        Thread.sleep(2000);
        String randomTitle = generateRandomName();
        driver.findElement(addRegionBtn).click();
        driver.findElement(addNameRegionInput).sendKeys("Region Add" + randomTitle);
        Thread.sleep(2000);
        driver.findElement(addSaveBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        org.testng.Assert.assertEquals("Success", message_actual);
    }

    public void deleteRegion() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Region");
        Thread.sleep(2000);
        driver.findElement(deleteRegionBtn).click();
        Thread.sleep(1000);
        driver.findElement(yesDeteleBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        org.testng.Assert.assertEquals("Đã xoá thành công.", message_actual);
    }

    public void updateRegion() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Region");
        Thread.sleep(2000);
        String randomTitle = generateRandomName();
        driver.findElement(updateRegionBtn).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(updateNameRegionInput));

        inputField.sendKeys(Keys.CONTROL + "a");
        inputField.sendKeys(Keys.DELETE);

        inputField.sendKeys("Update Region" + randomTitle);
        Thread.sleep(1000);
        driver.findElement(updateSaveBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        org.testng.Assert.assertEquals("Success", message_actual);
    }

    public void sortAndSearchTypeRegion() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Region");
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(searchNameBtn).click();
        driver.findElement(getSearchNameInput).sendKeys("Việt Nam");
        driver.findElement(searchBtn).click();
        Thread.sleep(1000);
        driver.findElement(searchNameBtn).click();
        Thread.sleep(1000);
        driver.findElement(resetBtn).click();
        driver.findElement(searchBtn).click();
    }

    public void addRegionAvail() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Region");
        Thread.sleep(2000);
        driver.findElement(addRegionBtn).click();
        driver.findElement(addNameRegionInput).sendKeys("Việt Nam");
        Thread.sleep(2000);
        driver.findElement(addSaveBtn).click();
        Thread.sleep(2000);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Đã có quốc gia này", message_actual);
        driver.findElement(closeBtn).click();
    }

    public void addRegionBlank() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Region");
        Thread.sleep(2000);
        driver.findElement(addRegionBtn).click();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(addNameRegionInput));

        inputField.sendKeys(Keys.CONTROL + "a");
        inputField.sendKeys(Keys.DELETE);
        driver.findElement(addSaveBtn).click();
        Thread.sleep(2000);
        String message_actual = driver.findElement(messRegion).getText();
        Assert.assertEquals("Nhập tên quốc gia!", message_actual);
        driver.findElement(closeBtn).click();
    }
}
