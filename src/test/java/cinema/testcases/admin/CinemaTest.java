package cinema.testcases.admin;

import cinema.base.BaseSetup;
import cinema.base.DashboardAdminPage;
import cinema.pages.admin.CinemaPage;
import cinema.pages.admin.LogInAdminPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CinemaTest extends BaseSetup {
    private WebDriver driver;
    private DashboardAdminPage dashboardAdminPage;
    private LogInAdminPage logInAdminPage;
    private CinemaPage cinemaPage;

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
    public void openCinemaPage() throws InterruptedException {
        cinemaPage = dashboardAdminPage.openCinemaPage();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void addCinemaPage() throws InterruptedException {
        cinemaPage.addCinema();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void updateCinemaPage() throws InterruptedException {
        cinemaPage.updateCinema();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void deleteCinemaPage() throws InterruptedException {
        cinemaPage.deleteCinema();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void sortAndSearchNameCinemaPage() throws InterruptedException {
        cinemaPage.sortAndSearchNameCinema();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void addCinemaBlankPage() throws InterruptedException {
        cinemaPage.addCinemaBlank();
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}
