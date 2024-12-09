package cinema.testcases.client;

import cinema.base.BaseSetup;
import cinema.base.DashboardClientPage;
import cinema.pages.client.ChangePasswordPage;
import cinema.pages.client.LogInClientPage;
import cinema.pages.client.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ChangePasswordTest extends BaseSetup {
    private WebDriver driver;
    private DashboardClientPage dashboardClientPage;
    private LogInClientPage logInClientPage;
    private ChangePasswordPage changePasswordPage;

    @BeforeClass
    public void setup() {
        driver = getDriver();
    }

    @Test(priority = 1)
    public void LogInTest() throws InterruptedException {
        logInClientPage = new LogInClientPage(driver);
        dashboardClientPage = logInClientPage.Login("do@gmail.com", "123456");
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void openChangePasswordPage() throws InterruptedException {
        changePasswordPage = dashboardClientPage.openChangePasswordPage();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void ChangePassWordPage() throws InterruptedException {
        changePasswordPage.ChangePassWord("123456", "do12345");
        changePasswordPage.ChangePassWord("do12345", "123456"); //Back to old password
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void ChangePassWordWithFailOldPassPage() throws InterruptedException {
        changePasswordPage.ChangePassWordWithFailOldPass();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void ChangePassWordWithFailNewPassPage() throws InterruptedException {
        changePasswordPage.ChangePassWordWithFailNewPass();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void ChangeBlankPassWordPage() throws InterruptedException {
        changePasswordPage.ChangeBlankPassWord();
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}
