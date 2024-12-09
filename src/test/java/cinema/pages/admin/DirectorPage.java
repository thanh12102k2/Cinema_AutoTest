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

public class DirectorPage {
    WebDriver driver;

    public DirectorPage(WebDriver driver) {
        this.driver = driver;
    }
    private String url ="/admin/director";
    private By addDirectorBtn = By.xpath("//span[contains(text(),'Thêm mới đạo diễn')]");
    private By addNameDirectorInput = By.id("basic_directorName");
    private By addBirthdayDirectorInput = By.id("basic_birthday");
    private By addDescripDirectorInput = By.id("basic_description");
    private By addImgDirectorInput = By.xpath("//span[@class='ant-upload']");
    private By addSaveBtn = By.xpath("//button[@type='submit']");

    private By deleteDirectorBtn = By.xpath("(//button[@type='button'])[4]");
    private By yesDeteleBtn = By.xpath("//span[normalize-space()='Có']");

    private By updateDirectorBtn = By.xpath("(//button[@type='button'])[5]");
    private By updateNameDirectorInput = By.id("basic1_directorName");
    private By updateBirthdayDirectorInput = By.id("basic1_birthday");
    private By updateDescripDirectorInput = By.id("basic1_description");
    private By updateSaveBtn = By.xpath("//span[contains(text(),'Cập nhật')]");

    private By searchNameBtn = By.xpath("//span[@role='button']");
    private By getSearchNameInput = By.xpath("//input[@placeholder='Tìm kiếm đạo diễn']");
    private By searchBtn = By.xpath("//span[contains(text(),'Tìm kiếm')]");
    private By resetBtn = By.xpath("//span[contains(text(),'Đặt lại')]");
    private By sortBtn= By.xpath("//span[contains(text(),'Tên đạo diễn')]");

    private By closeBtn = By.xpath("(//button[@aria-label='Close'])[1]");
    private By notif = By.xpath("//div[@class='ant-message-notice-content']");

    private  By messNameDirector = By.xpath("//div[contains(text(),'Hãy nhập tên đạo diễn!')]");
    private  By messBirthdayDirector = By.xpath("//div[contains(text(),'Hãy nhập ngày sinh của bạn!')]");

    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }

    private String generateRandomName() {
        return UUID.randomUUID().toString().substring(0, 6);
    }

    public void addDirector() throws InterruptedException, IOException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Director");
        Thread.sleep(2000);
        String random = generateRandomName();
        driver.findElement(addDirectorBtn).click();
        driver.findElement(addNameDirectorInput).sendKeys("Director Name" + random);
        driver.findElement(addBirthdayDirectorInput).sendKeys("2002-08-09");
        driver.findElement(addDescripDirectorInput).sendKeys("Test add description");
        driver.findElement(addImgDirectorInput).click();
        Thread.sleep(2000);
        Runtime.getRuntime().exec("C://Users//Admin//Desktop//CinemaTest//AddImg.exe");
        Thread.sleep(2000);
        driver.findElement(addSaveBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        org.testng.Assert.assertEquals("Success", message_actual);
    }

    public void deleteDirector() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Director");
        Thread.sleep(2000);
        driver.findElement(deleteDirectorBtn).click();
        Thread.sleep(1000);
        driver.findElement(yesDeteleBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        org.testng.Assert.assertEquals("Đã xoá thành công.", message_actual);
    }

    public void updateDirector() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Director");
        Thread.sleep(2000);
        String random = generateRandomName();
        driver.findElement(updateDirectorBtn).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement input_name = wait.until(ExpectedConditions.elementToBeClickable(updateNameDirectorInput));
        input_name.sendKeys(Keys.CONTROL + "a");
        input_name.sendKeys(Keys.DELETE);
        input_name.sendKeys("Update Name" + random);

        WebElement input_day = wait.until(ExpectedConditions.elementToBeClickable(updateBirthdayDirectorInput));
        input_day.sendKeys(Keys.CONTROL + "a");
        input_day.sendKeys(Keys.DELETE);
        input_day.sendKeys("2003-10-12");

        WebElement input_descrip = wait.until(ExpectedConditions.elementToBeClickable(updateDescripDirectorInput));
        input_descrip.sendKeys(Keys.CONTROL + "a");
        input_descrip.sendKeys(Keys.DELETE);
        input_descrip.sendKeys("Update description");

        Thread.sleep(1000);
        driver.findElement(updateSaveBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        org.testng.Assert.assertEquals("Success", message_actual);
    }

    public void sortAndSearchNameDirector() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Director");
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(searchNameBtn).click();
        driver.findElement(getSearchNameInput).sendKeys("James Cameron");
        driver.findElement(searchBtn).click();
        Thread.sleep(1000);
        driver.findElement(searchNameBtn).click();
        Thread.sleep(1000);
        driver.findElement(resetBtn).click();
        driver.findElement(searchBtn).click();
    }

    public void addDirectorBlankName() throws InterruptedException, IOException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Director");
        Thread.sleep(2000);
        driver.findElement(addDirectorBtn).click();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(addNameDirectorInput));

        inputField.sendKeys(Keys.CONTROL + "a");
        inputField.sendKeys(Keys.DELETE);
        driver.findElement(addBirthdayDirectorInput).sendKeys("2002-08-09");
        driver.findElement(addDescripDirectorInput).sendKeys("Nhiệt tình, lãnh đạo tốt.");
        driver.findElement(addSaveBtn).click();
        Thread.sleep(2000);
        String message_actual = driver.findElement(messNameDirector).getText();
        Assert.assertEquals("Hãy nhập tên đạo diễn!", message_actual);
        driver.findElement(closeBtn).click();
    }

    public void addDirectorBlankBirthday() throws InterruptedException, IOException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Director");
        Thread.sleep(2000);
        driver.findElement(addDirectorBtn).click();
        Thread.sleep(2000);
        driver.findElement(addNameDirectorInput).sendKeys("Nguyễn Tiến Thành");
        driver.findElement(addDescripDirectorInput).sendKeys("Nhiệt tình, lãnh đạo tốt.");
        driver.findElement(addSaveBtn).click();
        Thread.sleep(2000);
        String message_actual = driver.findElement(messBirthdayDirector).getText();
        Assert.assertEquals("Hãy nhập ngày sinh của bạn!", message_actual);
        driver.findElement(closeBtn).click();
    }

    public void addDirectorBlankNameAndBirthday() throws InterruptedException, IOException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Director");
        Thread.sleep(2000);
        driver.findElement(addDirectorBtn).click();
        Thread.sleep(2000);
        driver.findElement(addDescripDirectorInput).sendKeys("Nhiệt tình, lãnh đạo tốt.");
        driver.findElement(addSaveBtn).click();
        Thread.sleep(2000);
        String message_actual_1 = driver.findElement(messNameDirector).getText();
        String message_actual_2 = driver.findElement(messBirthdayDirector).getText();
        Assert.assertEquals("Hãy nhập tên đạo diễn!", message_actual_1);
        Assert.assertEquals("Hãy nhập ngày sinh của bạn!", message_actual_2);
        driver.findElement(closeBtn).click();
    }

}
