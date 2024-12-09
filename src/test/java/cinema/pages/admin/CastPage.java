package cinema.pages.admin;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.UUID;

public class CastPage {
    WebDriver driver;

    public CastPage(WebDriver driver) {
        this.driver = driver;
    }

    private String url ="/admin/cast";
    private By addCastBtn = By.xpath("//span[contains(text(),'Thêm mới diễn viên')]");
    private By addNameCastInput = By.id("basic_castName");
    private By addBirthdayCastInput = By.id("basic_birthday");
    private By addDescripCastInput = By.id("basic_description");
    private By addImgCastInput = By.xpath("//span[@class='ant-upload']");
    private By addSaveBtn = By.xpath("//button[@type='submit']");

    private By deleteCastBtn = By.xpath("(//button[@type='button'])[4]");
    private By yesDeteleBtn = By.xpath("//span[normalize-space()='Có']");

    private By updateCastBtn = By.xpath("(//button[@type='button'])[5]");
    private By updateNameCastInput = By.id("basic1_castName");
    private By updateBirthdayCastInput = By.id("basic1_birthday");
    private By updateDescripCastInput = By.id("basic1_description");
    private By updateSaveBtn = By.xpath("//span[contains(text(),'Cập nhật')]");

    private By searchNameBtn = By.xpath("//span[@role='button']");
    private By getSearchNameInput = By.xpath("//input[@placeholder='Tìm kiếm tên diễn viên']");
    private By searchBtn = By.xpath("//span[contains(text(),'Tìm kiếm')]");
    private By resetBtn = By.xpath("//span[contains(text(),'Đặt lại')]");
    private By sortBtn= By.xpath("//span[contains(text(),'Tên diễn viên')]");

    private By closeBtn = By.xpath("(//button[@aria-label='Close'])[1]");
    private By notif = By.xpath("//div[@class='ant-message-notice-content']");

    private  By messNameCast = By.xpath("//div[contains(text(),'Hãy nhập tên diễn viên!')]");
    private  By messBirthdayCast = By.xpath("//div[contains(text(),'Hãy nhập ngày sinh của bạn!')]");

    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }

    private String generateRandomName() {
        return UUID.randomUUID().toString().substring(0, 6);
    }

    public void addCast() throws InterruptedException, IOException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Cast");
        Thread.sleep(2000);
        String random = generateRandomName();
        driver.findElement(addCastBtn).click();
        driver.findElement(addNameCastInput).sendKeys("Add Cast Name" + random);
        driver.findElement(addBirthdayCastInput).sendKeys("2002-08-09");
        driver.findElement(addDescripCastInput).sendKeys("Add description test");
        driver.findElement(addImgCastInput).click();
        Thread.sleep(2000);
        Runtime.getRuntime().exec("C://Users//Admin//Desktop//CinemaTest//AddImg.exe");
        Thread.sleep(2000);
        driver.findElement(addSaveBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        org.testng.Assert.assertEquals("Success", message_actual);
    }

    public void deleteCast() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Cast");
        Thread.sleep(2000);
        driver.findElement(deleteCastBtn).click();
        Thread.sleep(1000);
        driver.findElement(yesDeteleBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        org.testng.Assert.assertEquals("Đã xoá thành công.", message_actual);
    }

    public void updateCast() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Cast");
        Thread.sleep(2000);
        String random = generateRandomName();
        driver.findElement(updateCastBtn).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement input_name = wait.until(ExpectedConditions.elementToBeClickable(updateNameCastInput));
        input_name.sendKeys(Keys.CONTROL + "a");
        input_name.sendKeys(Keys.DELETE);
        input_name.sendKeys("Update Cast Name" + random);

        WebElement input_day = wait.until(ExpectedConditions.elementToBeClickable(updateBirthdayCastInput));
        input_day.sendKeys(Keys.CONTROL + "a");
        input_day.sendKeys(Keys.DELETE);
        input_day.sendKeys("2003-10-12");

        WebElement input_descrip = wait.until(ExpectedConditions.elementToBeClickable(updateDescripCastInput));
        input_descrip.sendKeys(Keys.CONTROL + "a");
        input_descrip.sendKeys(Keys.DELETE);
        input_descrip.sendKeys("Update Description Test");

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
        driver.findElement(searchNameBtn).click();
        driver.findElement(getSearchNameInput).sendKeys("Tom Holland");
        driver.findElement(searchBtn).click();
        Thread.sleep(1000);
        driver.findElement(searchNameBtn).click();
        Thread.sleep(1000);
        driver.findElement(resetBtn).click();
        driver.findElement(searchBtn).click();
    }

    public void addCastBlankName() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Cast");
        Thread.sleep(2000);
        driver.findElement(addCastBtn).click();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(addNameCastInput));

        inputField.sendKeys(Keys.CONTROL + "a");
        inputField.sendKeys(Keys.DELETE);
        driver.findElement(addBirthdayCastInput).sendKeys("2002-08-09");
        driver.findElement(addDescripCastInput).sendKeys("Description Test");
        driver.findElement(addSaveBtn).click();
        Thread.sleep(2000);
        String message_actual = driver.findElement(messNameCast).getText();
        Assert.assertEquals("Hãy nhập tên diễn viên!", message_actual);
        driver.findElement(closeBtn).click();
    }

    public void addCastBlankBirthday() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Cast");
        Thread.sleep(2000);
        driver.findElement(addCastBtn).click();
        Thread.sleep(2000);
        driver.findElement(addNameCastInput).sendKeys("Nguyễn Tiến Thành");
        driver.findElement(addDescripCastInput).sendKeys("Nhiệt tình, lãnh đạo tốt.");
        driver.findElement(addSaveBtn).click();
        Thread.sleep(2000);
        String message_actual = driver.findElement(messBirthdayCast).getText();
        Assert.assertEquals("Hãy nhập ngày sinh của bạn!", message_actual);
        driver.findElement(closeBtn).click();
    }

    public void addCastBlankNameAndBirthday() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Cast");
        Thread.sleep(2000);
        driver.findElement(addCastBtn).click();
        Thread.sleep(2000);
        driver.findElement(addDescripCastInput).sendKeys("Nhiệt tình, lãnh đạo tốt.");
        driver.findElement(addSaveBtn).click();
        Thread.sleep(2000);
        String message_actual_1 = driver.findElement(messNameCast).getText();
        String message_actual_2 = driver.findElement(messBirthdayCast).getText();
        Assert.assertEquals("Hãy nhập tên diễn viên!", message_actual_1);
        Assert.assertEquals("Hãy nhập ngày sinh của bạn!", message_actual_2);
        driver.findElement(closeBtn).click();
    }

}
