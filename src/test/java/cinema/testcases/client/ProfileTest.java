package cinema.testcases.client;

import cinema.base.BaseSetup;
import cinema.base.DashboardClientPage;
import cinema.pages.client.LogInClientPage;
import cinema.pages.client.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProfileTest extends BaseSetup {
    private WebDriver driver;
    private DashboardClientPage dashboardClientPage;
    private LogInClientPage logInClientPage;
    private ProfilePage profilePage;

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
    public void openProfilePage() throws InterruptedException {
        profilePage = dashboardClientPage.openProfilePage();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void editProfilePage() throws InterruptedException, IOException {
        profilePage.editProfile();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void editProfileWithFalsePhoneNumberPage() throws InterruptedException {
        profilePage.editProfileWithFalsePhoneNumber();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void editProfileBlankNameAndPhonePage() throws InterruptedException {
        profilePage.editProfileBlankNameAndPhone();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void editProfileBlankBirthdayPage() throws InterruptedException {
        profilePage.editProfileBlankBirthday();
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}
