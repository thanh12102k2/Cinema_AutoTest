package cinema.testcases.admin;

import cinema.base.BaseSetup;
import cinema.base.DashboardAdminPage;
import cinema.pages.admin.LogInAdminPage;
import cinema.pages.admin.ShowTimePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ShowTimeTest extends BaseSetup {
    private WebDriver driver;
    private DashboardAdminPage dashboardAdminPage;
    private LogInAdminPage logInAdminPage;
    private ShowTimePage showtimePage;

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
    public void openShowTimePage() throws InterruptedException {
        showtimePage = dashboardAdminPage.openShowTimePage();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void addShowTimePage() throws InterruptedException{
        showtimePage.addShowTime("00:00:00", "03:00:00", "2025-01-13");
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void searchShowTimePage() throws InterruptedException{
        showtimePage.searchShowTime("2025-01-13");
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void updateShowTimePage() throws InterruptedException{
        showtimePage.updateShowTime("01:00:00", "04:00:00", "2025-01-13");
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void addDuplicateShowtimePage() throws InterruptedException{
        showtimePage.addDuplicateShowtime("01:00:00", "04:00:00", "2025-01-13");
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void deleteShowTimePage() throws InterruptedException{
        showtimePage.deleteShowTime();
        Thread.sleep(2000);
    }

    @Test(priority = 8)
    public void addBlankShowTimePage() throws InterruptedException{
        showtimePage.addBlankShowTime();
        Thread.sleep(2000);
    }

    @Test(priority = 9)
    public void addShowtimeTotalTimeLessDurationPage() throws InterruptedException{
        showtimePage.addShowtimeTotalTimeLessDuration("01:00:00", "02:00:00", "2025-12-12");
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
