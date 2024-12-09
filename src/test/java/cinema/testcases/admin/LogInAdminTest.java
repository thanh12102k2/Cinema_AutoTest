package cinema.testcases.admin;

import cinema.base.BaseSetup;
import cinema.pages.admin.LogInAdminPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogInAdminTest extends BaseSetup {
    private WebDriver driver;
    private LogInAdminPage logInAdminPage;

    @BeforeClass
    public void setup() {
        driver = getDriver();
    }

    @Test(priority = 1)
    public void LogInTest() throws InterruptedException {
        logInAdminPage = new LogInAdminPage(driver);
        logInAdminPage.Login("do@gmail.com", "123456");
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void LoginAdminWithInvalidEmail() throws InterruptedException {
        logInAdminPage.LoginAdminWithInvalidEmail();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void LoginAdminWithInvalidPassword() throws InterruptedException {
        logInAdminPage.LoginAdminWithInvalidPassword();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void LoginAdminWithBlankEmail() throws InterruptedException {
        logInAdminPage.LoginAdminWithBlankEmail();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void LoginAdminWithBlankPassword() throws InterruptedException {
        logInAdminPage.LoginAdminWithBlankPassword();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void LoginAdminWithBlankPAccount() throws InterruptedException {
        logInAdminPage.LoginAdminWithBlankPAccount();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void TestPasswordVisibility() throws InterruptedException {
        logInAdminPage.TestPasswordVisibility();
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}


