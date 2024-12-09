package cinema.testcases.admin;

import cinema.base.BaseSetup;
import cinema.base.DashboardAdminPage;
import cinema.pages.admin.CastPage;
import cinema.pages.admin.LogInAdminPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CastTest extends BaseSetup {
    private WebDriver driver;
    private DashboardAdminPage dashboardAdminPage;
    private LogInAdminPage logInAdminPage;
    private CastPage castPage;

    @BeforeClass
    public void setup() {
        driver = getDriver();
    }

    @Test(priority = 1)
    public void LogInTest() throws InterruptedException {
        logInAdminPage = new LogInAdminPage(driver);
        dashboardAdminPage = logInAdminPage.Login("do@gmail.com", "123456");
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void openCastPage() throws InterruptedException {
        castPage = dashboardAdminPage.openCastPage();
        Thread.sleep(2000);
    }

    @Test(priority = 3, enabled = true)
    public void addCastPage() throws InterruptedException, IOException {
        castPage.addCast();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void updateCastPage() throws InterruptedException {
        castPage.updateCast();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void deleteCastPage() throws InterruptedException {
        castPage.deleteCast();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void sortAndSearchTypeGenre() throws InterruptedException {
        castPage.sortAndSearchTypeGenre();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void addCastBlankNamePage() throws InterruptedException, IOException {
        castPage.addCastBlankName();
        Thread.sleep(2000);
    }

    @Test(priority = 8, enabled = false)
    public void addCastBlankBirthdayPage() throws InterruptedException, IOException {
        castPage.addCastBlankBirthday();
        Thread.sleep(2000);
    }

    @Test(priority = 9,enabled = false)
    public void addCastBlankNameAndBirthdayPage() throws InterruptedException, IOException {
        castPage.addCastBlankNameAndBirthday();
        Thread.sleep(2000);
    }


    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}
