package cinema.testcases.admin;

import cinema.base.BaseSetup;
import cinema.base.DashboardAdminPage;
import cinema.pages.admin.DirectorPage;
import cinema.pages.admin.LogInAdminPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class DirectorTest extends BaseSetup {
    private WebDriver driver;
    private DashboardAdminPage dashboardAdminPage;
    private LogInAdminPage logInAdminPage;
    private DirectorPage directorPage;

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
    public void openDirectorPage() throws InterruptedException {
        directorPage = dashboardAdminPage.openDirectorPage();
        Thread.sleep(2000);
    }

    @Test(priority = 3, enabled = true)
    public void addDirectorPage() throws InterruptedException, IOException {
        directorPage.addDirector();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void updateDirectorPage() throws InterruptedException {
        directorPage.updateDirector();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void deleteDirectorPage() throws InterruptedException {
        directorPage.deleteDirector();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void sortAndSearchNameDirectorPage() throws InterruptedException {
        directorPage.sortAndSearchNameDirector();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void addDirectorBlankNamePage() throws InterruptedException, IOException {
        directorPage.addDirectorBlankName();
        Thread.sleep(2000);
    }

    @Test(priority = 8,enabled = false)
    public void addDirectorBlankBirthdayPage() throws InterruptedException, IOException {
        directorPage.addDirectorBlankBirthday();
        Thread.sleep(2000);
    }

    @Test(priority = 9,enabled = false)
    public void addDirectorBlankNameAndBirthdayPage() throws InterruptedException, IOException {
        directorPage.addDirectorBlankNameAndBirthday();
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}
