package cinema.testcases.client;

import cinema.base.BaseSetup;
import cinema.base.DashboardClientPage;
import cinema.pages.client.LogInClientPage;
import cinema.pages.client.MoviePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MovieTest extends BaseSetup {
    private WebDriver driver;
    private DashboardClientPage dashboardClientPage;
    private LogInClientPage logInClientPage;
    private MoviePage moviePage;

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
    public void openMoviePage() throws InterruptedException {
        moviePage = dashboardClientPage.openMoviePage();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void ViewFirstMovieShowingPage() throws InterruptedException {
        moviePage.ViewFirstMovieShowing();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void ViewFifthMovieShowingPage() throws InterruptedException {
        moviePage.ViewFifthMovieShowing();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void ViewFirstMovieUpComingPage() throws InterruptedException {
        moviePage.ViewFirstMovieUpComing();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void ViewFifthMovieUpComingPage() throws InterruptedException {
        moviePage.ViewFifthMovieUpComing();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void ViewInvalidMoviePage() throws InterruptedException {
        moviePage.ViewInvalidMovie();
        Thread.sleep(2000);
    }

    @Test(priority = 8)
    public void ViewTrailerMoviePage() throws InterruptedException {
        moviePage.ViewTrailerMovie();
        Thread.sleep(2000);
    }

    @Test(priority = 9)
    public void ViewShowtimeMovieTypePage() throws InterruptedException {
        moviePage.ViewShowtimeMovieType();
        Thread.sleep(2000);
    }

    @Test(priority = 10)
    public void ViewDirectorPage() throws InterruptedException {
        moviePage.ViewDirector();
        Thread.sleep(2000);
    }

    @Test(priority = 11)
    public void ViewCastPage() throws InterruptedException {
        moviePage.ViewCast();
        Thread.sleep(2000);
    }

    @Test(priority = 12)
    public void ViewDirectorOrCastInvalidPage() throws InterruptedException {
        moviePage.ViewDirectorOrCastInvalid();
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}
