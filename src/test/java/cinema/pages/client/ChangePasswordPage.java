package cinema.pages.client;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ChangePasswordPage {
    WebDriver driver;

    public ChangePasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    private String url ="/change-password";
    private By title = By.xpath("//h4[contains(text(),'Thay đổi mật khẩu')]");
    private By oldPass = By.xpath("//input[@placeholder='Mật khẩu cũ']");
    private By newPass1 = By.xpath("//input[@placeholder='Mật khẩu mới']");
    private By newPass2 = By.xpath("//input[@placeholder='Xác nhận mật khẩu mới']");
    private By changePassSubmitBtn= By.xpath("//div[@class='Button_text__FcN3u']");

    private By viewOldPass = By.xpath("//div[@class='MainPageChangePassword_container__6IA5c']//div[1]//div[1]//div[1]//span[2]//*[name()='svg']");
    private By viewNewPass1 = By.xpath("//div[@class='MainPageChangePassword_container__6IA5c']//div[2]//div[1]//div[1]//span[2]//*[name()='svg']");
    private By viewNewPass2 = By.xpath("//div[3]//div[1]//div[1]//span[2]//*[name()='svg']");
    private By notif = By.xpath("//div[@role='alert']");

    private By messFailNewPass = By.xpath("//p[contains(text(),'Mật khẩu không trùng khớp')]");

    private By messBlankOldPass = By.xpath("//div[@class='MainPageChangePassword_container__6IA5c']//div[1]//p[1]");
    private By messBlankNewPass1 = By.xpath("//div[@class='MainPageChangePassword_container__6IA5c']//div[2]//p[1]");
    private By messBlankNewPass2 = By.xpath("//div[@class='MainPageChangePassword_container__6IA5c']//div[3]//p[1]");

    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }

    public void ChangePassWord(String oldPassValue, String newPassValue) throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Change Password");
        Thread.sleep(2000);
        driver.findElement(oldPass).sendKeys(oldPassValue);
        driver.findElement(viewOldPass).click();
        Thread.sleep(1000);
        driver.findElement(newPass1).sendKeys(newPassValue);
        driver.findElement(viewNewPass1).click();
        driver.findElement(newPass2).sendKeys(newPassValue);
        driver.findElement(viewNewPass2).click();
        Thread.sleep(1000);
        driver.findElement(changePassSubmitBtn).click();
        Thread.sleep(1500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Thay đổi mật khẩu thành công!", message_actual);
    }

    public void ChangePassWordWithFailOldPass() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Change Password");
        Thread.sleep(2000);
        driver.findElement(oldPass).sendKeys("truongthanhdo123");
        driver.findElement(viewOldPass).click();
        Thread.sleep(1000);
        driver.findElement(newPass1).sendKeys("do123456");
        driver.findElement(viewNewPass1).click();
        driver.findElement(newPass2).sendKeys("do123456");
        driver.findElement(viewNewPass2).click();
        Thread.sleep(1000);
        driver.findElement(changePassSubmitBtn).click();
        Thread.sleep(1500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Sai mật khẩu cũ!", message_actual);
    }

    public void ChangePassWordWithFailNewPass() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Change Password");
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement input_old_pass = wait.until(ExpectedConditions.elementToBeClickable(oldPass));
        input_old_pass.sendKeys(Keys.CONTROL + "a");
        input_old_pass.sendKeys("123456");
        Thread.sleep(1000);

        WebElement input_new_pass = wait.until(ExpectedConditions.elementToBeClickable(newPass1));
        input_new_pass.sendKeys(Keys.CONTROL + "a");
        input_new_pass.sendKeys("do123456");

        WebElement input_new_pass2 = wait.until(ExpectedConditions.elementToBeClickable(newPass2));
        input_new_pass2.sendKeys(Keys.CONTROL + "a");
        input_new_pass2.sendKeys("do1234");
        Thread.sleep(1000);

        driver.findElement(oldPass).click();
        Thread.sleep(1500);
        String message_actual = driver.findElement(messFailNewPass).getText();
        Assert.assertEquals("Mật khẩu không trùng khớp", message_actual);
    }

    public void ChangeBlankPassWord() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Change Password");
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement input_old_pass = wait.until(ExpectedConditions.elementToBeClickable(oldPass));
        input_old_pass.sendKeys(Keys.CONTROL + "a");
        input_old_pass.sendKeys(Keys.DELETE);
        Thread.sleep(1000);

        WebElement input_new_pass = wait.until(ExpectedConditions.elementToBeClickable(newPass1));
        input_new_pass.sendKeys(Keys.CONTROL + "a");
        input_new_pass.sendKeys(Keys.DELETE);

        WebElement input_new_pass2 = wait.until(ExpectedConditions.elementToBeClickable(newPass2));
        input_new_pass2.sendKeys(Keys.CONTROL + "a");
        input_new_pass2.sendKeys(Keys.DELETE);
        Thread.sleep(1000);
        driver.findElement(title).click();

        String message_actual_old_pass = driver.findElement(messBlankOldPass).getText();
        Assert.assertEquals("Vui lòng nhập trường này", message_actual_old_pass);

        String message_actual_new_pass1 = driver.findElement(messBlankNewPass1).getText();
        Assert.assertEquals("Vui lòng nhập trường này", message_actual_new_pass1);

        String message_actual_new_pass2 = driver.findElement(messBlankNewPass2).getText();
        Assert.assertEquals("Vui lòng nhập trường này", message_actual_new_pass2);
    }
}
