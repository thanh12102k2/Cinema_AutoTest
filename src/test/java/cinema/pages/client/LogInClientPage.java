package cinema.pages.client;

import cinema.base.DashboardAdminPage;
import cinema.base.DashboardClientPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LogInClientPage {
    WebDriver driver;
    private Actions actions;

    public LogInClientPage(WebDriver driver) {
        this.driver = driver;
    }

    private String url ="/auth/login";
    private By LoginBtn = By.xpath("//div[contains(text(),'Đăng nhập')]");
    private By emailInput = By.xpath("//input[@placeholder='Email']");
    private By passwordInput = By.xpath("//input[@placeholder='Mật khẩu']");
    private By loginSubmitBtn = By.xpath("//div[@class='Button_text__FcN3u']");
    private By loginTitle = By.xpath("//h4[contains(text(),'ĐĂNG NHẬP TÀI KHOẢN')]");
    private By notifMail = By.xpath("(//p[contains(@class,'Input_errorText__Py9Rk')])[1]");
    private By notifPass = By.xpath("(//p[contains(@class,'Input_errorText__Py9Rk')])[2]");
    private By eyeIcon = By.xpath("//div[@class='MainLogin_form__NW3NA']//div[2]//div[1]//div[1]//span[2]//*[name()='svg']");
    private By notif = By.xpath("//div[@role='alert']");

    private By userBtn = By.xpath("//div[@class='MenuLogged_main__Mf4C_']");
    private By logOutBtn = By.xpath("//p[contains(text(),'Đăng xuất')]");
    private By logOutSubmitBtn = By.xpath("//div[contains(text(),'Đăng xuất')]");

    private By saveAccount = By.xpath("//div[@class='SwitchButton_container__qnTar click']");

    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }

    public DashboardClientPage Login(String emailValue, String passwordValue) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(LoginBtn).click();
        Thread.sleep(2000);
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Đăng nhập");
        driver.findElement(emailInput).sendKeys(emailValue);
        driver.findElement(passwordInput).sendKeys(passwordValue);
        driver.findElement(loginSubmitBtn).click();
        return new DashboardClientPage(driver);
    }

    public void LoginWithInvalidEmail() throws InterruptedException{
        logOut();
        Thread.sleep(2000);
        driver.findElement(LoginBtn).click();
        Thread.sleep(2000);
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Đăng nhập");
        driver.findElement(emailInput).sendKeys("testInvalidEmail");
        driver.findElement(passwordInput).sendKeys("123456");
        String message_actual = driver.findElement(notifMail).getText();
        Assert.assertEquals("Định dạng email không chính xác", message_actual);
    }

    public void LoginWithInvalidPassword() throws InterruptedException{
        driver.navigate().refresh();
        Thread.sleep(3000);
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Đăng nhập");
        driver.findElement(emailInput).sendKeys("do@gmail.com");
        driver.findElement(passwordInput).sendKeys("123456789");
        driver.findElement(loginSubmitBtn).click();
        Thread.sleep(1000);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Email hoặc Mật khẩu sai ! Vui lòng thử lại", message_actual);
    }

    public void LoginWithBlankEmail() throws InterruptedException{
        driver.navigate().refresh();
        Thread.sleep(3000);
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Đăng nhập");
        driver.findElement(emailInput).click();
        driver.findElement(passwordInput).sendKeys("123456789");
        String message_actual = driver.findElement(notifMail).getText();
        Assert.assertEquals("Vui lòng nhập trường này", message_actual);
    }

    public void LoginWithBlankPassword() throws InterruptedException{
        driver.navigate().refresh();
        Thread.sleep(3000);
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Đăng nhập");
        driver.findElement(passwordInput).click();
        driver.findElement(emailInput).sendKeys("do@gmail.com");
        String message_actual = driver.findElement(notifPass).getText();
        Assert.assertEquals("Vui lòng nhập trường này", message_actual);
    }

    public void LoginWithBlankAccount() throws InterruptedException{
        driver.navigate().refresh();
        Thread.sleep(3000);
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Đăng nhập");
        driver.findElement(emailInput).click();
        driver.findElement(passwordInput).click();
        driver.findElement(loginTitle).click();

        String message_actual_email = driver.findElement(notifMail).getText();
        Assert.assertEquals("Vui lòng nhập trường này", message_actual_email);
        String message_actual_pass = driver.findElement(notifPass).getText();
        Assert.assertEquals("Vui lòng nhập trường này", message_actual_pass);
    }

    public void TestPasswordVisibility() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(3000);
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Đăng nhập");
        driver.findElement(emailInput).sendKeys("do@gmail.com");
        driver.findElement(passwordInput).sendKeys("123456");
        driver.findElement(eyeIcon).click();
        Thread.sleep(1000);
        driver.findElement(eyeIcon).click();
        Thread.sleep(1000);
        driver.findElement(eyeIcon).click();
        Thread.sleep(1000);
        String message_actual = driver.findElement(passwordInput).getAttribute("value");
        Assert.assertEquals("123456", message_actual);
    }

    public void SaveAccount(String emailValue, String passwordValue) throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(3000);
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Đăng nhập");
        driver.findElement(emailInput).sendKeys(emailValue);
        driver.findElement(passwordInput).sendKeys(passwordValue);
        driver.findElement(saveAccount).click();
        Thread.sleep(1000);
        driver.findElement(loginSubmitBtn).click();
        Thread.sleep(1000);
        logOut();
        Thread.sleep(1000);
        driver.findElement(LoginBtn).click();
        Thread.sleep(1000);
        driver.findElement(eyeIcon).click();
        String message_actual_email = driver.findElement(emailInput).getAttribute("value");
        Assert.assertEquals(emailValue, message_actual_email);

        String message_actual_password = driver.findElement(passwordInput).getAttribute("value");
        Assert.assertEquals(passwordValue, message_actual_password);
    }

    public DashboardClientPage logOut() throws InterruptedException {
        driver.findElement(userBtn).click();
        Thread.sleep(1000);
        driver.findElement(logOutBtn).click();
        Thread.sleep(1000);
        driver.findElement(logOutSubmitBtn).click();
        Thread.sleep(1000);
        return new DashboardClientPage(driver);
    }
}
