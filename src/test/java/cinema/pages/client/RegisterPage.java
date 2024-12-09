package cinema.pages.client;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private String url ="/auth/register";
    private By title = By.xpath("//h4[contains(text(),'ĐĂNG KÝ TÀI KHOẢN')]");
    private By registerName = By.xpath("//input[@placeholder='Họ và tên']");
    private By registerEmail = By.xpath("//input[@placeholder='Email']");
    private By registerPhoneNumber = By.xpath("//input[@placeholder='Nhập số điện thoại']");
    private By registerBirthday = By.xpath("//input[@placeholder='dd/mm/yyyy']");
    private By registerMaleGender = By.id("male");
    private By registerFemaleGender = By.id("female");
    private By registerOtherGender = By.id("other");
    private By registerPass1 = By.xpath("//input[@placeholder='Mật khẩu']");
    private By registerPass2 = By.xpath("//input[@placeholder='Xác nhận mật khẩu']");
    private By registerSubmitBtn = By.xpath("//div[@class='Button_text__FcN3u']");

    private By notif = By.xpath("//div[@role='alert']");

    private By userBtn = By.xpath("//div[@class='MenuLogged_main__Mf4C_']");
    private By logOutBtn = By.xpath("//p[contains(text(),'Đăng xuất')]");
    private By logOutSubmitBtn = By.xpath("//div[contains(text(),'Đăng xuất')]");

    private By messFailEmail = By.xpath("//p[contains(text(),'Định dạng email không chính xác')]");
    private By messFailPhoneNumber = By.xpath("//p[contains(text(),'Định dạng số điện thoại không đúng')]");
    private By messFailPassword = By.xpath("//p[contains(text(),'Mật khẩu không trùng khớp')]");

    private By messBlankName = By.xpath("//body/div[@id='__next']/div[@class='WrapperAuth_container__j4uEJ']/form/div[@class='MainRegister_container__5IQED']/div[@class='MainRegister_form__lQssq']/div[@class='Input_container__PD98V Input_error__wyxcs']/p[1]");
    private By messBlankBirthday = By.xpath("//body/div[@id='__next']/div[@class='WrapperAuth_container__j4uEJ']/form/div[@class='MainRegister_container__5IQED']/div[@class='MainRegister_form__lQssq']/div[2]/div[1]/p[1]");
    private By messBlankPhoneNumber = By.xpath("//div[@class='MainRegister_form__lQssq']//div[2]//div[2]//div[1]//p[1]");
    private By messBlankPass1 = By.xpath("//body/div[@id='__next']/div[@class='WrapperAuth_container__j4uEJ']/form/div[@class='MainRegister_container__5IQED']/div[@class='MainRegister_form__lQssq']/div[4]/div[1]/p[1]");
    private By messBlankPass2 = By.xpath("//div[4]//div[2]//div[1]//p[1]");

    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }

    public void RegisterAccount() throws InterruptedException {
        Thread.sleep(2000);
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Registor");
        Thread.sleep(1000);
        driver.findElement(registerName).sendKeys("Test Register");
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        driver.findElement(registerEmail).sendKeys(email);
        driver.findElement(registerPhoneNumber).sendKeys("0987654321");
        driver.findElement(registerBirthday).sendKeys("12/10/2002");
        driver.findElement(registerMaleGender).click();
        driver.findElement(registerPass1).sendKeys("thanh123");
        driver.findElement(registerPass2).sendKeys("thanh123");
        Thread.sleep(2000);
        driver.findElement(registerSubmitBtn).click();
        Thread.sleep(1500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Đăng ký thành công!", message_actual);
    }

    public void RegisterWithFailEmail() throws InterruptedException {
        driver.navigate().back();
        Thread.sleep(2000);
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Registor");
        driver.findElement(registerName).sendKeys("Test Register With Fail Email");
        driver.findElement(registerEmail).sendKeys("test_register");
        driver.findElement(registerPhoneNumber).sendKeys("0987654321");
        driver.findElement(registerBirthday).sendKeys("12/10/2002");
        driver.findElement(registerMaleGender).click();
        driver.findElement(registerPass1).sendKeys("thanh123");
        driver.findElement(registerPass2).sendKeys("thanh123");
        Thread.sleep(1000);
        String message_actual = driver.findElement(messFailEmail).getText();
        Assert.assertEquals("Định dạng email không chính xác", message_actual);
    }

    public void RegisterWithFailPhoneNumber() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Registor");
        driver.findElement(registerName).sendKeys("Test Register With Fail Phone Number");
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        driver.findElement(registerEmail).sendKeys(email);
        driver.findElement(registerPhoneNumber).sendKeys("12345678");
        driver.findElement(registerBirthday).sendKeys("12/10/2002");
        driver.findElement(registerMaleGender).click();
        driver.findElement(registerPass1).sendKeys("thanh123");
        driver.findElement(registerPass2).sendKeys("thanh123");
        Thread.sleep(1000);
        String message_actual = driver.findElement(messFailPhoneNumber).getText();
        Assert.assertEquals("Định dạng số điện thoại không đúng", message_actual);
    }

    public void RegisterWithFailPassword() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Registor");
        driver.findElement(registerName).sendKeys("Test Register With Fail Password");
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        driver.findElement(registerEmail).sendKeys(email);
        driver.findElement(registerPhoneNumber).sendKeys("0987654321");
        driver.findElement(registerBirthday).sendKeys("12/10/2002");
        driver.findElement(registerMaleGender).click();
        driver.findElement(registerPass1).sendKeys("thanh123");
        driver.findElement(registerPass2).sendKeys("123456");
        driver.findElement(title).click();
        Thread.sleep(1000);
        String message_actual = driver.findElement(messFailPassword).getText();
        Assert.assertEquals("Mật khẩu không trùng khớp", message_actual);
    }

    public void RegisterWithBlankBirthday() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Registor");
        driver.findElement(registerName).sendKeys("Test Register With Fail Password");
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        driver.findElement(registerEmail).sendKeys(email);
        driver.findElement(registerPhoneNumber).sendKeys("0987654321");
        driver.findElement(registerMaleGender).click();
        driver.findElement(registerPass1).sendKeys("thanh123");
        driver.findElement(registerPass2).sendKeys("thanh123");
        Thread.sleep(2000);
        driver.findElement(registerSubmitBtn).click();
        Thread.sleep(1500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Vui lòng nhập ngày sinh!", message_actual);
    }

    public void RegisterWithBlankInfo() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Registor");
        driver.findElement(registerName).click();
        driver.findElement(registerEmail).click();
        driver.findElement(registerPhoneNumber).click();
        driver.findElement(registerBirthday).click();
        driver.findElement(registerOtherGender).click();
        driver.findElement(registerPass1).click();
        driver.findElement(registerPass2).click();
        driver.findElement(title).click();
        Thread.sleep(1000);
        String message_actual_name = driver.findElement(messBlankName).getText();
        Assert.assertEquals("Vui lòng nhập trường này", message_actual_name);

        String message_actual_birthday = driver.findElement(messBlankBirthday).getText();
        Assert.assertEquals("Vui lòng nhập trường này", message_actual_birthday);

        String message_actual_phone = driver.findElement(messBlankPhoneNumber).getText();
        Assert.assertEquals("Vui lòng nhập trường này", message_actual_phone);

        String message_actual_pass1 = driver.findElement(messBlankPass1).getText();
        Assert.assertEquals("Vui lòng nhập trường này", message_actual_pass1);

        String message_actual_pass2 = driver.findElement(messBlankPass2).getText();
        Assert.assertEquals("Vui lòng nhập trường này", message_actual_pass2);
    }

    public void logOut() throws InterruptedException {
        driver.findElement(userBtn).click();
        Thread.sleep(1000);
        driver.findElement(logOutBtn).click();
        Thread.sleep(1000);
        driver.findElement(logOutSubmitBtn).click();
        Thread.sleep(1000);
    }
}
