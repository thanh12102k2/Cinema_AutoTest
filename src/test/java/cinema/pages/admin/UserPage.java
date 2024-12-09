package cinema.pages.admin;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.Faker;

public class UserPage {
    WebDriver driver;

    public UserPage(WebDriver driver) {
        this.driver = driver;
    }

    private String url ="/admin/user";

    private By addUserBtn = By.xpath("//span[contains(text(),'Thêm mới người dùng')]");
    private By addEmailInput = By.id("basic_email");
    private By addPhoneInput = By.id("basic_phoneNumber");
    private By addNameInput = By.id("basic_fullName");
    private By addBirthdayInput = By.id("basic_birthday");
    private By addPassInput = By.id("basic_password");
    private By addPass2Input = By.id("basic_password2");
    private By addMale = By.xpath("//input[@value='0']");
    private By addFemale = By.xpath("//input[@value='1']");
    private By addOtherGender = By.xpath("//input[@value='2']");
    private By submitAddBtn = By.xpath("//button[@type='submit']");

    private By updateUserBtn = By.xpath("(//button[@type='button'])[5]");
    private By updateNameInput = By.id("basic1_fullname");
    private By updatePhoneInput = By.id("basic1_phoneNumber");
    private By updateBirthdayInput = By.id("basic1_birthday");
    private By updateMale = By.xpath("//div[@id='basic1_gender']//span[contains(text(),'Nam')]");
    private By updateFemale = By.xpath("//div[@id='basic1_gender']//span[contains(text(),'Nữ')]");
    private By updateOtherGender = By.xpath("//div[@id='basic1_gender']//span[contains(text(),'Khác')]");
    private By updateStatus = By.xpath("(//div[@class='ant-select-selector'])[2]");
    private By updateLockedStatus = By.xpath("//div[@title='Đã khoá']//div[1]");
    private By submitUpdateBtn = By.xpath("(//span[contains(text(),'Cập nhật')])[1]");

    private By deteleBtn = By.xpath("(//button[@type='button'])[4]");
    private By submitDeleteBtn = By.xpath("//span[normalize-space()='Có']");

    private By searchNameUserBtn = By.xpath("(//span[@role='button'])[1]");
    private By searchNameUserInput = By.xpath("//input[@placeholder='Tìm kiếm tên người dùng']");
    private By searchBtn = By.xpath("//span[contains(text(),'Tìm kiếm')]");
    private By resetBtn = By.xpath("//span[contains(text(),'Đặt lại')]");
    private By sortBtn= By.xpath("//span[contains(text(),'Họ tên')]");

    private By messEmailBlank = By.xpath("//div[contains(text(),'Xin hãy nhập Email của bạn!')]");
    private By messNameBlank = By.xpath("//div[contains(text(),'Xin hãy nhập họ và tên bạn!')]");
    private By messPhoneBlank = By.xpath("//div[contains(text(),'Xin hãy nhập số điện thoại của bạn!')]");
    private By messBirthdayBlank = By.xpath("//div[contains(text(),'Hãy nhập ngày sinh của bạn!')]");
    private By messPassBlank = By.xpath("//div[contains(text(),'Xin hãy nhập password của bạn!')]");
    private By messPass2Blank = By.xpath("//div[contains(text(),'Xin hãy nhập lại password của bạn!')]");
    private By messGenderBlank = By.xpath("//div[contains(text(),'Hãy chọn giới tính của bạn')]");
    private By closeBtn = By.xpath("//button[@aria-label='Close']");

    private By messEmailIvalid = By.xpath("//div[contains(text(),'Vui lòng nhập địa chỉ Email hợp lệ!')]");
    private By messNameIvalid = By.xpath("//div[contains(text(),'Họ tên chỉ được dùng ký tự!')]");
    private By messPhoneIvalid = By.xpath("//div[contains(text(),'Số điện thoại phải bắt đầu bằng số 0 và có đúng 10')]");
    private By notif = By.xpath("//div[@class='ant-message-notice-content']");

    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }

    public void addUser() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang User");
        Thread.sleep(2000);
        driver.findElement(addUserBtn).click();
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        driver.findElement(addEmailInput).sendKeys(email);
        driver.findElement(addPhoneInput).sendKeys("0336700305");
        driver.findElement(addNameInput).sendKeys("Test Add Name");
        driver.findElement(addBirthdayInput).sendKeys("2002-10-12");
        driver.findElement(addPassInput).sendKeys("thanh123");
        driver.findElement(addPass2Input).sendKeys("thanh123");
        driver.findElement(addMale).click();
        Thread.sleep(2000);
        driver.findElement(submitAddBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        org.testng.Assert.assertEquals("Success", message_actual);
    }

    public void updateUser() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang User");
        Thread.sleep(2000);
        driver.findElement(updateUserBtn).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement input_name = wait.until(ExpectedConditions.elementToBeClickable(updateNameInput));
        input_name.sendKeys(Keys.CONTROL + "a");
        input_name.sendKeys(Keys.DELETE);
        input_name.sendKeys("Test Update Name");

        WebElement input_birthday = wait.until(ExpectedConditions.elementToBeClickable(updateBirthdayInput));
        input_birthday.sendKeys(Keys.CONTROL + "a");
        input_birthday.sendKeys(Keys.DELETE);
        input_birthday.sendKeys("2003-12-8");

        WebElement input_phone = wait.until(ExpectedConditions.elementToBeClickable(updatePhoneInput));
        input_phone.sendKeys(Keys.CONTROL + "a");
        input_phone.sendKeys(Keys.DELETE);
        input_phone.sendKeys("0336700444");

        driver.findElement(updateFemale).click();

        WebElement dropdown = driver.findElement(updateStatus);
        dropdown.click();
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(updateLockedStatus));
        option.click();

        Thread.sleep(2000);
        driver.findElement(submitUpdateBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        org.testng.Assert.assertEquals("Success", message_actual);

    }

    public void deleteUser() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang User");
        Thread.sleep(2000);
        driver.findElement(deteleBtn).click();
        Thread.sleep(1000);
        driver.findElement(submitDeleteBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        org.testng.Assert.assertEquals("Đã xoá thành công.", message_actual);
    }

    public void sortAndSearchNameUser() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang User");
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(searchNameUserBtn).click();
        driver.findElement(searchNameUserInput).sendKeys("Trương Thành Đô");
        Thread.sleep(2000);
        driver.findElement(searchBtn).click();
        driver.findElement(searchNameUserBtn).click();
        Thread.sleep(2000);
        driver.findElement(resetBtn).click();
        driver.findElement(searchBtn).click();
    }

    public void addUserBlank() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang User");
        Thread.sleep(2000);
        driver.findElement(addUserBtn).click();
        Thread.sleep(2000);
        driver.findElement(submitAddBtn).click();
        Thread.sleep(2000);

        String message_actual_email = driver.findElement(messEmailBlank).getText();
        Assert.assertEquals("Xin hãy nhập Email của bạn!", message_actual_email);

        String message_actual_name = driver.findElement(messNameBlank).getText();
        Assert.assertEquals("Xin hãy nhập họ và tên bạn!", message_actual_name);

        String message_actual_phone = driver.findElement(messPhoneBlank).getText();
        Assert.assertEquals("Xin hãy nhập số điện thoại của bạn!", message_actual_phone);

        String message_actual_birthday = driver.findElement(messBirthdayBlank).getText();
        Assert.assertEquals("Hãy nhập ngày sinh của bạn!", message_actual_birthday);

        String message_actual_pass = driver.findElement(messPassBlank).getText();
        Assert.assertEquals("Xin hãy nhập password của bạn!", message_actual_pass);

        String message_actual_pass2 = driver.findElement(messPass2Blank).getText();
        Assert.assertEquals("Xin hãy nhập lại password của bạn!", message_actual_pass2);

        String message_actual_gender = driver.findElement(messGenderBlank).getText();
        Assert.assertEquals("Hãy chọn giới tính của bạn", message_actual_gender);

        Thread.sleep(2000);
        driver.findElement(closeBtn).click();
    }

    public void addInvalidUser() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang User");
        Thread.sleep(2000);
        driver.findElement(addUserBtn).click();
        driver.findElement(addEmailInput).sendKeys("nguyentienthanh");
        driver.findElement(addPhoneInput).sendKeys("123456");
        driver.findElement(addNameInput).sendKeys("thanh1210");
        driver.findElement(addBirthdayInput).sendKeys("2002-10-12");
        driver.findElement(addPassInput).sendKeys("thanh123");
        driver.findElement(addPass2Input).sendKeys("thanh123");
        driver.findElement(addMale).click();
        Thread.sleep(2000);
        driver.findElement(submitAddBtn).click();

        String message_actual_email = driver.findElement(messEmailIvalid).getText();
        Assert.assertEquals("Vui lòng nhập địa chỉ Email hợp lệ!", message_actual_email);

        String message_actual_name = driver.findElement(messNameIvalid).getText();
        Assert.assertEquals("Họ tên chỉ được dùng ký tự!", message_actual_name);

        String message_actual_phone = driver.findElement(messPhoneIvalid).getText();
        Assert.assertEquals("Số điện thoại phải bắt đầu bằng số 0 và có đúng 10 chữ số!", message_actual_phone);

        Thread.sleep(2000);
        driver.findElement(closeBtn).click();
    }

    public void addUserInvalidPass() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang User");
        Thread.sleep(2000);
        driver.findElement(addUserBtn).click();
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        driver.findElement(addEmailInput).sendKeys(email);
        driver.findElement(addPhoneInput).sendKeys("0336700305");
        driver.findElement(addNameInput).sendKeys("Nguyễn Tiến Thành");
        driver.findElement(addBirthdayInput).sendKeys("2002-10-12");
        driver.findElement(addPassInput).sendKeys("thanh123");
        driver.findElement(addPass2Input).sendKeys("123456");
        driver.findElement(addMale).click();
        Thread.sleep(2000);
        driver.findElement(submitAddBtn).click();
        String message_actual_pass = driver.findElement(notif).getText();
        System.out.println(message_actual_pass);
        Assert.assertEquals("Tài khoản đã có", message_actual_pass);
        Thread.sleep(2000);
        driver.findElement(closeBtn).click();
    }
}
