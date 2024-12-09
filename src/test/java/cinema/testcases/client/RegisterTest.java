package cinema.testcases.client;

import cinema.base.BaseSetup;
import cinema.base.DashboardClientPage;
import cinema.pages.client.ChangePasswordPage;
import cinema.pages.client.LogInClientPage;
import cinema.pages.client.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterTest extends BaseSetup {
    private WebDriver driver;
    private DashboardClientPage dashboardClientPage;
    private LogInClientPage logInClientPage;
    private RegisterPage registerPage;

    @BeforeClass
    public void setup() {
        driver = getDriver();
    }

    @Test(priority = 1)
    public void LogInTest() throws InterruptedException {
        logInClientPage = new LogInClientPage(driver);
        dashboardClientPage = logInClientPage.Login("do@gmail.com", "123456");
        dashboardClientPage = logInClientPage.logOut();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void openRegisterPage() throws InterruptedException {
        registerPage = dashboardClientPage.openRegisterPage();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void RegisterAccountPage() throws InterruptedException {
        registerPage.RegisterAccount();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void RegisterWithFailEmailPage() throws InterruptedException {
        registerPage.RegisterWithFailEmail();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void RegisterWithFailPhoneNumberPage() throws InterruptedException {
        registerPage.RegisterWithFailPhoneNumber();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void RegisterWithFailPasswordPage() throws InterruptedException {
        registerPage.RegisterWithFailPassword();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void RegisterWithBlankBirthdayPage() throws InterruptedException {
        registerPage.RegisterWithBlankBirthday();
        Thread.sleep(2000);
    }

    @Test(priority = 8)
    public void RegisterWithBlankInfoPage() throws InterruptedException {
        registerPage.RegisterWithBlankInfo();
        Thread.sleep(2000);
    }


    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}

