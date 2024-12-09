package cinema.testcases.client;

import cinema.base.BaseSetup;
import cinema.base.DashboardAdminPage;
import cinema.base.DashboardClientPage;
import cinema.pages.admin.LogInAdminPage;
import cinema.pages.client.LogInClientPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogInClientTest extends BaseSetup {
    private WebDriver driver;
    private LogInClientPage logInClientPage;

    @BeforeClass
    public void setup() {
        driver = getDriver();
    }

    @Test(priority = 1)
    public void LogInTest() throws InterruptedException {
        logInClientPage = new LogInClientPage(driver);
        logInClientPage.Login("do@gmail.com", "123456");
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void LoginWithInvalidEmailPage() throws InterruptedException {
        logInClientPage.LoginWithInvalidEmail();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void LoginWithInvalidPasswordPage() throws InterruptedException {
        logInClientPage.LoginWithInvalidPassword();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void LoginWithBlankEmailPage() throws InterruptedException {
        logInClientPage.LoginWithBlankEmail();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void LoginWithBlankPasswordPage() throws InterruptedException {
        logInClientPage.LoginWithBlankPassword();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void LoginWithBlankAccountPage() throws InterruptedException {
        logInClientPage.LoginWithBlankAccount();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void TestPasswordVisibilityPage() throws InterruptedException {
        logInClientPage.TestPasswordVisibility();
    }

    @Test(priority = 8)
    public void SaveAccountPage() throws InterruptedException {
        logInClientPage.SaveAccount("do@gmail.com", "123456");
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
