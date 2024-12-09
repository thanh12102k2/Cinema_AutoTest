package cinema.testcases.client;

import cinema.base.BaseSetup;
import cinema.base.DashboardClientPage;
import cinema.pages.client.BookTicketPage;
import cinema.pages.client.LogInClientPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookTicketTest extends BaseSetup {
    private WebDriver driver;
    private DashboardClientPage dashboardClientPage;
    private LogInClientPage logInClientPage;
    private BookTicketPage bookTicketPage;

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
    public void openBookTicketPage() throws InterruptedException {
        bookTicketPage = dashboardClientPage.openBookTicketPage();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void insufficientBalancePage() throws InterruptedException {
        bookTicketPage.insufficientBalance();
        Thread.sleep(2000);
    }

    @Test(priority = 4,enabled = false)
    public void bookTicketWithCinemaPage() throws InterruptedException {
        bookTicketPage.bookTicketWithCinema();
        Thread.sleep(2000);
    }

    @Test(priority = 5,enabled = false)
    public void bookTicketWithMoviePage() throws InterruptedException {
        bookTicketPage.bookTicketWithMovie();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void BookTicketMaxSeatPage() throws InterruptedException {
        bookTicketPage.BookTicketMaxSeat();
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}
