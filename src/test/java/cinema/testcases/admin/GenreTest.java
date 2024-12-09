package cinema.testcases.admin;

import cinema.base.BaseSetup;
import cinema.base.DashboardAdminPage;
import cinema.pages.admin.GenrePage;
import cinema.pages.admin.LogInAdminPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GenreTest extends BaseSetup {
    private WebDriver driver;
    private DashboardAdminPage dashboardAdminPage;
    private LogInAdminPage logInAdminPage;
    private GenrePage genrePage;

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
    public void openGenrePage() throws InterruptedException {
//        dashboardAdminPage = new DashboardAdminPage(driver);
        genrePage = dashboardAdminPage.openGenrePage();
        Thread.sleep(2000);
    }

    @Test(priority = 3, enabled = true)
    public void addGenrePage() throws InterruptedException {
        genrePage.addGenre();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void updateGenrePage() throws InterruptedException {
        genrePage.updateGenre();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void deleteGenrePage() throws InterruptedException {
        genrePage.deleteGenre();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void sortAndSearchGenrePage() throws InterruptedException {
        genrePage.sortAndSearchTypeGenre();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void addGenreAvailPage() throws InterruptedException {
        genrePage.addGenreAvail();
        Thread.sleep(2000);
    }

    @Test(priority = 8)
    public void addGenreBlankPage() throws InterruptedException {
        genrePage.addGenreBlank();
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}
