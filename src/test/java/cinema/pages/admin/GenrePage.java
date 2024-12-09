package cinema.pages.admin;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.UUID;

public class GenrePage {
    WebDriver driver;

    public GenrePage(WebDriver driver) {
        this.driver = driver;
    }
    private String url ="/admin/genre";
    private By addGenreBtn = By.xpath("//span[contains(text(),'Thêm mới thể loại')]");
    private By addNameGenreInput = By.id("basic_genreName");
    private By addSaveBtn = By.xpath("//button[@type='submit']");

    private By deleteGenreBtn = By.xpath("(//button[@type='button'])[4]");
    private By yesDeteleBtn = By.xpath("//span[normalize-space()='Có']");

    private By updateGenreBtn = By.xpath("(//button[@type='button'])[5]");
    private By updateNameGenreInput = By.id("basic1_genreName");
    private By updateSaveBtn = By.xpath("(//button[@type='submit'])[2]");

    private By searchTypeBtn = By.xpath("//span[@role='button']");
    private By getSearchTypeInput = By.xpath("//input[@placeholder='Tìm kiếm thê loại']");
    private By searchBtn = By.xpath("//span[contains(text(),'Tìm kiếm')]");
    private By resetBtn = By.xpath("//span[contains(text(),'Đặt lại')]");
    private By sortBtn= By.xpath("//span[contains(text(),'Tên thể loại')]");

    private By notif = By.xpath("//div[@class='ant-message-notice-content']");
    private By closeBtn = By.xpath("(//button[@aria-label='Close'])[1]");

    private  By messGenre = By.xpath("//div[@class='ant-form-item-explain-error']");

    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }
    private String generateRandomTitle() {
        return UUID.randomUUID().toString().substring(0, 6);
    }

    public void addGenre() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Genre");
        Thread.sleep(2000);
        driver.findElement(addGenreBtn).click();
        String randomTitle = generateRandomTitle();
        driver.findElement(addNameGenreInput).sendKeys("Genre Add" + randomTitle);
        Thread.sleep(2000);
        driver.findElement(addSaveBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        org.testng.Assert.assertEquals("Success", message_actual);
    }

    public void deleteGenre() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Genre");
        Thread.sleep(2000);
        driver.findElement(deleteGenreBtn).click();
        Thread.sleep(1000);
        driver.findElement(yesDeteleBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        org.testng.Assert.assertEquals("Đã xoá thành công.", message_actual);
    }

    public void updateGenre() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Genre");
        Thread.sleep(2000);
        driver.findElement(updateGenreBtn).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(updateNameGenreInput));

        inputField.sendKeys(Keys.CONTROL + "a");
        inputField.sendKeys(Keys.DELETE);
        String randomTitle = generateRandomTitle();
        inputField.sendKeys("Genre update " + randomTitle );
        Thread.sleep(1000);
        driver.findElement(updateSaveBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        org.testng.Assert.assertEquals("Success", message_actual);
    }

    public void sortAndSearchTypeGenre() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Genre");
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(searchTypeBtn).click();
        driver.findElement(getSearchTypeInput).sendKeys("Thể thao");
        driver.findElement(searchBtn).click();
        Thread.sleep(1000);
        driver.findElement(searchTypeBtn).click();
        Thread.sleep(1000);
        driver.findElement(resetBtn).click();
        driver.findElement(searchBtn).click();
    }

    public void addGenreAvail() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Genre");
        Thread.sleep(2000);
        driver.findElement(addGenreBtn).click();
        driver.findElement(addNameGenreInput).sendKeys("Chính trị");
        Thread.sleep(2000);
        driver.findElement(addSaveBtn).click();
        Thread.sleep(2000);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Đã có thể loại này", message_actual);
        driver.findElement(closeBtn).click();
    }

    public void addGenreBlank() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Genre");
        Thread.sleep(2000);
        driver.findElement(addGenreBtn).click();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(addNameGenreInput));

        inputField.sendKeys(Keys.CONTROL + "a");
        inputField.sendKeys(Keys.DELETE);
        driver.findElement(addSaveBtn).click();
        Thread.sleep(2000);
        String message_actual = driver.findElement(messGenre).getText();
        Assert.assertEquals("Nhập tên thể loại!", message_actual);
        driver.findElement(closeBtn).click();
    }
}
