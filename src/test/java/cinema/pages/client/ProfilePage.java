package cinema.pages.client;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

public class ProfilePage {
    WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    private String url ="/profile";
    private By profileAvatar = By.xpath("//label[@class='Avatar_input__HV1JM']");
    private By profileName = By.xpath("//input[@placeholder='Họ và tên']");
    private By profilePhoneNumber = By.xpath("//input[@placeholder='Nhập số điện thoại']");
    private By profileBirthday = By.xpath("//input[@placeholder='dd/mm/yyyy']");
    private By profileMaleGender = By.id("male");
    private By profileFemaleGender = By.id("female");
    private By profileOtherGender = By.id("other");
    private By profileSubmitBtn = By.xpath("//div[@class='Button_text__FcN3u']");

    private By notif = By.xpath("//div[@role='alert']");

    private By messBlankName = By.xpath("(//p[@class='Input_errorText__Py9Rk'][contains(text(),'Vui lòng nhập trường này')])[1]");
    private By messBlankPhoneNumber = By.xpath("(//p[@class='Input_errorText__Py9Rk'][contains(text(),'Vui lòng nhập trường này')])[2]");
    private By messFailPhoneNumber = By.xpath("//p[contains(text(),'Định dạng số điện thoại không đúng')]");

    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }

    public void editProfile() throws InterruptedException, IOException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Profile");
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.findElement(profileAvatar).click();
        Thread.sleep(1000);
        Runtime.getRuntime().exec("C://Users//Admin//Desktop//CinemaTest//AddImg.exe");
        Thread.sleep(1000);

        WebElement input_name = wait.until(ExpectedConditions.elementToBeClickable(profileName));
        input_name.sendKeys(Keys.CONTROL + "a");
        input_name.sendKeys("Trươngg Thànhh Đô");
        Thread.sleep(1000);

        WebElement input_phone = wait.until(ExpectedConditions.elementToBeClickable(profilePhoneNumber));
        input_phone.sendKeys(Keys.CONTROL + "a");
        input_phone.sendKeys("0336666666");
        Thread.sleep(1000);

        WebElement input_birthday = wait.until(ExpectedConditions.elementToBeClickable(profileBirthday));
        input_birthday.sendKeys(Keys.CONTROL + "a");
        input_birthday.sendKeys("01/01/2001");
        Thread.sleep(1000);

        driver.findElement(profileOtherGender).click();
        Thread.sleep(1000);
        driver.findElement(profileSubmitBtn).click();
        Thread.sleep(1500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Cập nhật thông tin thành công!", message_actual);
    }

    public void editProfileWithFalsePhoneNumber() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Profile");
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement input_phone = wait.until(ExpectedConditions.elementToBeClickable(profilePhoneNumber));
        input_phone.sendKeys(Keys.CONTROL + "a");
        input_phone.sendKeys("0123456");
        Thread.sleep(1000);

        driver.findElement(profileOtherGender).click();
        Thread.sleep(1000);
        String message_actual = driver.findElement(messFailPhoneNumber).getText();
        Assert.assertEquals("Định dạng số điện thoại không đúng", message_actual);
    }

    public void editProfileBlankNameAndPhone() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Profile");
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement input_name = wait.until(ExpectedConditions.elementToBeClickable(profileName));
        input_name.sendKeys(Keys.CONTROL + "a");
        input_name.sendKeys(Keys.DELETE);
        Thread.sleep(1000);

        WebElement input_phone = wait.until(ExpectedConditions.elementToBeClickable(profilePhoneNumber));
        input_phone.sendKeys(Keys.CONTROL + "a");
        input_phone.sendKeys(Keys.DELETE);
        Thread.sleep(1000);

        driver.findElement(profileOtherGender).click();
        Thread.sleep(1000);
        String message_actual_name = driver.findElement(messBlankName).getText();
        Assert.assertEquals("Vui lòng nhập trường này", message_actual_name);

        String message_actual_phone = driver.findElement(messBlankPhoneNumber).getText();
        Assert.assertEquals("Vui lòng nhập trường này", message_actual_phone);
    }

    public void editProfileBlankBirthday() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Profile");
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement input_name = wait.until(ExpectedConditions.elementToBeClickable(profileName));
        input_name.sendKeys(Keys.CONTROL + "a");
        input_name.sendKeys("Trường Thành Đô");
        Thread.sleep(1000);

        WebElement input_phone = wait.until(ExpectedConditions.elementToBeClickable(profilePhoneNumber));
        input_phone.sendKeys(Keys.CONTROL + "a");
        input_phone.sendKeys("0987654321");
        Thread.sleep(1000);

        WebElement input_birthday = wait.until(ExpectedConditions.elementToBeClickable(profileBirthday));
        input_birthday.sendKeys(Keys.CONTROL + "a");
        input_birthday.sendKeys(Keys.DELETE);
        Thread.sleep(1000);

        driver.findElement(profileMaleGender).click();
        Thread.sleep(1000);
        driver.findElement(profileSubmitBtn).click();
        Thread.sleep(1500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Cập nhật thông tin thành công!", message_actual);
    }

}
