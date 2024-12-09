package cinema.testcases.admin;

import cinema.base.BaseSetup;
import cinema.base.DashboardAdminPage;
import cinema.pages.admin.LogInAdminPage;
import cinema.pages.admin.MoviePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class MovieTest extends BaseSetup {
    private WebDriver driver;
    private DashboardAdminPage dashboardAdminPage;
    private LogInAdminPage logInAdminPage;
    private MoviePage moviePage;

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
    public void openMoviePage() throws InterruptedException {
        moviePage = dashboardAdminPage.openMoviePage();
        Thread.sleep(2000);
    }

    @Test(priority = 3, enabled = true)
    public void addMoviePage() throws InterruptedException, IOException {
        moviePage.addMovie();
        Thread.sleep(2000);
    }
    @Test(priority = 4)
    public void updateMoviePage() throws InterruptedException {
        moviePage.updateMovie();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void deleteMoviePage() throws InterruptedException {
        moviePage.deleteMovie();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void sortAndSearchNameMoviePage() throws InterruptedException {
        moviePage.sortAndSearchNameMovie();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void addBlankMoviePage() throws InterruptedException {
        moviePage.addBlankMovie();
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
