package cinema.pages.admin;

import cinema.base.DashboardAdminPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInAdminPage {
	WebDriver driver;
	
	public LogInAdminPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By emailInput = By.xpath("//input[@id='email']");
	private By passwordInput = By.xpath("//input[@id='password']");
	private By LoginBtn = By.xpath("//button[@type='submit']");
	private By notifMail = By.xpath("//div[@class='ant-form-item-explain-error']");
	private By pop_up = By.xpath("//div[@class='ant-message-notice-content']");
	private By emailHelp = By.xpath("//div[@id='email_help']//div[1]");
	private By passwordHelp = By.xpath("//div[@id='password_help']//div[1]");
	private By eyeIcon1 = By.xpath("//span[@aria-label='eye-invisible']//*[name()='svg']");
	private By eyeIcon2 = By.xpath("//span[@aria-label='eye']//*[name()='svg']");
	private By logOutBtn = By.xpath("//span[contains(text(),'Đăng xuất')]");
	
	public DashboardAdminPage Login(String emailValue, String passwordValue) {
		driver.findElement(emailInput).sendKeys(emailValue);
		driver.findElement(passwordInput).sendKeys(passwordValue);
		driver.findElement(LoginBtn).click();
		return new DashboardAdminPage(driver);
	}

	public void LoginAdminWithInvalidEmail() throws InterruptedException{
		driver.findElement(logOutBtn).click();
		driver.findElement(emailInput).sendKeys("nguyenTienThanh");
		driver.findElement(passwordInput).sendKeys("123456");
		driver.findElement(LoginBtn).click();
		Thread.sleep(1000);
		String message_actual = driver.findElement(notifMail).getText();
		Assert.assertEquals("Vui lòng nhập địa chỉ Email hợp lệ!", message_actual);
	}

	public void LoginAdminWithInvalidPassword() throws InterruptedException{
		driver.navigate().refresh();
		driver.findElement(emailInput).sendKeys("do@gmail.com");
		driver.findElement(passwordInput).sendKeys("123");
		driver.findElement(LoginBtn).click();
		Thread.sleep(1000);
		String message_actual = driver.findElement(pop_up).getText();
		Assert.assertEquals("Email hoặc Mật khẩu sai ! Vui lòng thử lại", message_actual);
	}

	public void LoginAdminWithBlankEmail() throws InterruptedException {
		driver.navigate().refresh();
		driver.findElement(passwordInput).sendKeys("123");
		driver.findElement(LoginBtn).click();
		Thread.sleep(1000);
		String message_actual = driver.findElement(notifMail).getText();
		Assert.assertEquals("Xin hãy nhập Email của bạn!", message_actual);
	}

	public void LoginAdminWithBlankPassword() throws InterruptedException {
		driver.navigate().refresh();
		driver.findElement(emailInput).sendKeys("do@gmail.com");
		driver.findElement(LoginBtn).click();
		Thread.sleep(1000);
		String message_actual = driver.findElement(notifMail).getText();
		Assert.assertEquals("Xin hãy nhập mật khẩu của bạn!", message_actual);
	}

	public void LoginAdminWithBlankPAccount() throws InterruptedException {
		driver.navigate().refresh();
		driver.findElement(LoginBtn).click();
		Thread.sleep(1000);
		String message_actual_1 = driver.findElement(emailHelp).getText();
		String message_actual_2 = driver.findElement(passwordHelp).getText();
		Assert.assertEquals("Xin hãy nhập Email của bạn!", message_actual_1);
		Assert.assertEquals("Xin hãy nhập mật khẩu của bạn!", message_actual_2);
	}

	public void TestPasswordVisibility() throws InterruptedException {
		driver.navigate().refresh();
		driver.findElement(emailInput).sendKeys("nguyenTienThanh");
		driver.findElement(passwordInput).sendKeys("123456");
		driver.findElement(eyeIcon1).click();
		Thread.sleep(1000);
		driver.findElement(eyeIcon2).click();
		Thread.sleep(1000);
		driver.findElement(eyeIcon1).click();
		Thread.sleep(1000);
		String message_actual = driver.findElement(passwordInput).getAttribute("value");
		Assert.assertEquals("123456", message_actual);
	}

}
