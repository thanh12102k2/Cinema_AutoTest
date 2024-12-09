package cinema.testcases.client;

import cinema.base.BaseSetup;
import cinema.base.DashboardClientPage;
import cinema.pages.client.ForgetPasswordPage;
import cinema.pages.client.LogInClientPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ForgetPasswordTest extends BaseSetup {
    private WebDriver driver;
    private DashboardClientPage dashboardClientPage;
    private LogInClientPage logInClientPage;
    private ForgetPasswordPage forgetPasswordPage;

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
    public void openForgetPasswordPage() throws InterruptedException {
        forgetPasswordPage = dashboardClientPage.openForgetPasswordPage();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void forgotPasswordSuccessPage() throws InterruptedException {
        forgetPasswordPage.forgotPasswordSuccess();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void forgotPasswordWithFailEmailFormatPage() throws InterruptedException {
        forgetPasswordPage.forgotPasswordWithFailEmailFormat();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void forgetPasswordWithNonExistentEmailPage() throws InterruptedException {
        forgetPasswordPage.forgetPasswordWithNonExistentEmail();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void forgetPasswordWithBlankEmailPage() throws InterruptedException {
        forgetPasswordPage.forgetPasswordWithBlankEmail();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void forgetPasswordWithFailOtpPage() throws InterruptedException {
        forgetPasswordPage.forgetPasswordWithFailOtp();
        Thread.sleep(2000);
    }

    @Test(priority = 8)
    public void forgetPasswordWithFailPasswordPage() throws InterruptedException {
        forgetPasswordPage.forgetPasswordWithFailPassword();
        Thread.sleep(2000);
    }

    @Test(priority = 9)
    public void forgetPasswordWithBlankPasswordPage() throws InterruptedException {
        forgetPasswordPage.forgetPasswordWithBlankPassword();
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}

