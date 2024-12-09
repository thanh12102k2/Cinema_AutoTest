package cinema.pages.client;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ForgetPasswordPage {
    WebDriver driver;
    Actions actions;

    public ForgetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private String url ="/auth/forgot-password";
    private By titleForgetPass = By.xpath("//h4[contains(text(),'QUÊN MẬT KHẨU')]");
    private By titleSetPass = By.xpath("//h4[contains(text(),'THIẾT LẬP MẬT KHẨU')]");
    private By emailInput = By.xpath("//input[@placeholder='Nhập email']");
    private By otpInput = By.xpath("//input[1]");
    private By submitBtn = By.xpath("//div[@class='Button_text__FcN3u']");
    private By password1Input = By.xpath("//input[@placeholder='Nhập mật khẩu mới']");
    private By password2Input = By.xpath("//input[@placeholder='Nhập lại mật khẩu']");
    private By loginBtn = By.xpath("//div[@class='Button_primaryLinear__P9T1k Button_bold__oPRj9 Button_rounded_8__qPlL4 Button_p_12_32__2yt8W Button_btn__z_3IU']");
    private By forgetPassBtn = By.xpath("//a[contains(text(),'Quên mật khẩu?')]");
    private By loginNowBtn = By.xpath("//a[contains(text(),'Đăng nhập ngay.')]");

    private By notif = By.xpath("//div[@role='alert']");
    private By mess = By.xpath("//p[@class='Input_errorText__Py9Rk']");
    private By messPass2 = By.xpath("(//p[@class='Input_errorText__Py9Rk'])[2]");


    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }

    public void forgotPasswordSuccess() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Forget Password");
        Actions actions = new Actions(driver);
        driver.findElement(emailInput).sendKeys("thanh@gmail.com");
        Thread.sleep(1000);
        driver.findElement(submitBtn).click();
        Thread.sleep(1000);
        String message_actual_sendOTP = driver.findElement(notif).getText();
        Assert.assertEquals("OTP đã được gửi về email của bạn!", message_actual_sendOTP);
        driver.findElement(otpInput).sendKeys("1");
        actions.sendKeys("2").sendKeys("3").sendKeys("4").sendKeys("5").sendKeys("6").build().perform();
        Thread.sleep(3000);
        driver.findElement(submitBtn).click();
        Thread.sleep(1000);
        String message_actual_OTP_success = driver.findElement(notif).getText();
        Assert.assertEquals("Xác thực OTP thành công!", message_actual_OTP_success);
        Thread.sleep(1000);
        driver.findElement(password1Input).sendKeys("thanh123");
        Thread.sleep(1000);
        driver.findElement(password2Input).sendKeys("thanh123");
        Thread.sleep(1000);
        driver.findElement(submitBtn).click();
        Thread.sleep(1000);
        String message_actual_change_success = driver.findElement(notif).getText();
        Assert.assertEquals("Lấy lại mật khẩu thành công!", message_actual_change_success);
        driver.findElement(loginBtn).click();
    }

    public void forgotPasswordWithFailEmailFormat() throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(forgetPassBtn).click();
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Forget Password");
        driver.findElement(emailInput).sendKeys("nguyentienthanh");
        Thread.sleep(1000);
        driver.findElement(titleForgetPass).click();
        Thread.sleep(1000);
        String message_actual = driver.findElement(mess).getText();
        Assert.assertEquals("Định dạng email không chính xác", message_actual);
    }

    public void forgetPasswordWithNonExistentEmail() throws InterruptedException{
        driver.findElement(loginNowBtn).click();
        Thread.sleep(1000);
        driver.findElement(forgetPassBtn).click();
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Forget Password");
        driver.findElement(emailInput).sendKeys("nguyentienthanh12102k2@gmail.com");
        Thread.sleep(1000);
        driver.findElement(submitBtn).click();
        Thread.sleep(1000);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Tài khoản không tồn tại. Vui lòng kiểm tra lại", message_actual);
    }

    public void forgetPasswordWithBlankEmail() throws InterruptedException{
        driver.findElement(loginNowBtn).click();
        Thread.sleep(1000);
        driver.findElement(forgetPassBtn).click();
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Forget Password");
        driver.findElement(emailInput).click();
        Thread.sleep(1000);
        driver.findElement(titleForgetPass).click();
        Thread.sleep(1000);
        String message_actual = driver.findElement(mess).getText();
        Assert.assertEquals("Vui lòng nhập trường này", message_actual);
    }

    public void forgetPasswordWithFailOtp() throws InterruptedException{
        driver.findElement(loginNowBtn).click();
        Thread.sleep(1000);
        driver.findElement(forgetPassBtn).click();
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Forget Password");
        Actions actions = new Actions(driver);
        driver.findElement(emailInput).sendKeys("thanh@gmail.com");
        Thread.sleep(1000);
        driver.findElement(submitBtn).click();
        Thread.sleep(1000);
        String message_actual_sendOTP = driver.findElement(notif).getText();
        Assert.assertEquals("OTP đã được gửi về email của bạn!", message_actual_sendOTP);
        driver.findElement(otpInput).sendKeys("1");
        actions.sendKeys("1").sendKeys("1").sendKeys("1").sendKeys("1").sendKeys("1").build().perform();
        Thread.sleep(3000);
        driver.findElement(submitBtn).click();
        Thread.sleep(1000);
        String message_actual_OTP_success = driver.findElement(notif).getText();
        Assert.assertEquals("Otp invalid", message_actual_OTP_success);
    }

    public void forgetPasswordWithFailPassword() throws InterruptedException {
        driver.get("http://localhost:3030"+url);
        Thread.sleep(3000);
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Forget Password");
        Actions actions = new Actions(driver);
        driver.findElement(emailInput).sendKeys("thanh@gmail.com");
        Thread.sleep(1000);
        driver.findElement(submitBtn).click();
        Thread.sleep(1000);
        String message_actual_sendOTP = driver.findElement(notif).getText();
        Assert.assertEquals("OTP đã được gửi về email của bạn!", message_actual_sendOTP);
        driver.findElement(otpInput).sendKeys("1");
        actions.sendKeys("2").sendKeys("3").sendKeys("4").sendKeys("5").sendKeys("6").build().perform();
        Thread.sleep(3000);
        driver.findElement(submitBtn).click();
        Thread.sleep(1000);
        String message_actual_OTP_success = driver.findElement(notif).getText();
        Assert.assertEquals("Xác thực OTP thành công!", message_actual_OTP_success);
        Thread.sleep(1000);
        driver.findElement(password1Input).sendKeys("thanh123");
        Thread.sleep(1000);
        driver.findElement(password2Input).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(titleSetPass).click();
        Thread.sleep(1000);
        String message_actual = driver.findElement(messPass2).getText();
        Assert.assertEquals("Mật khẩu không trùng khớp", message_actual);
    }

    public void forgetPasswordWithBlankPassword() throws InterruptedException {
        driver.get("http://localhost:3030"+url);
        Thread.sleep(3000);
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Forget Password");
        Actions actions = new Actions(driver);
        driver.findElement(emailInput).sendKeys("thanh@gmail.com");
        Thread.sleep(1000);
        driver.findElement(submitBtn).click();
        Thread.sleep(1000);
        String message_actual_sendOTP = driver.findElement(notif).getText();
        Assert.assertEquals("OTP đã được gửi về email của bạn!", message_actual_sendOTP);
        driver.findElement(otpInput).sendKeys("1");
        actions.sendKeys("2").sendKeys("3").sendKeys("4").sendKeys("5").sendKeys("6").build().perform();
        Thread.sleep(3000);
        driver.findElement(submitBtn).click();
        Thread.sleep(1000);
        String message_actual_OTP_success = driver.findElement(notif).getText();
        Assert.assertEquals("Xác thực OTP thành công!", message_actual_OTP_success);
        Thread.sleep(1000);
        driver.findElement(password1Input).click();
        Thread.sleep(1000);
        driver.findElement(password2Input).click();
        Thread.sleep(1000);
        driver.findElement(titleSetPass).click();
        Thread.sleep(1000);
        String message_actual_pass1 = driver.findElement(mess).getText();
        Assert.assertEquals("Vui lòng nhập trường này", message_actual_pass1);
        String message_actual_pass2 = driver.findElement(messPass2).getText();
        Assert.assertEquals("Vui lòng nhập trường này", message_actual_pass2);
    }
}
