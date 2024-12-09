package cinema.testcases.client;

import cinema.base.BaseSetup;
import cinema.base.DashboardClientPage;
import cinema.pages.client.CinemaPage;
import cinema.pages.client.LogInClientPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CinemaTest extends BaseSetup {
    private WebDriver driver;
    private DashboardClientPage dashboardClientPage;
    private LogInClientPage logInClientPage;
    private CinemaPage cinemaPage;

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
    public void openCinemaPage() throws InterruptedException {
        cinemaPage = dashboardClientPage.openCinemaPage();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void SearchCinemaPage() throws InterruptedException {
        cinemaPage.SearchCinema();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void SearchInvalidCinemaPage() throws InterruptedException {
        cinemaPage.SearchInvalidCinema();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void ViewMapCinemaPage() throws InterruptedException {
        cinemaPage.ViewMapCinema();
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}
