package cinema.testcases.admin;

import cinema.base.BaseSetup;
import cinema.base.DashboardAdminPage;
import cinema.pages.admin.LogInAdminPage;
import cinema.pages.admin.TicketPricePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TicketPriceTest extends BaseSetup {
    private WebDriver driver;
    private DashboardAdminPage dashboardAdminPage;
    private LogInAdminPage logInAdminPage;
    private TicketPricePage ticketPricePage;

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
    public void openTicketPricePage() throws InterruptedException {
        ticketPricePage = dashboardAdminPage.openTicketPricePage();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void addTicketPricePage() throws InterruptedException {
        ticketPricePage.addTicketPrice();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void updateTicketPricePage() throws InterruptedException {
        ticketPricePage.updateTicketPrice();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void deleteTicketPricePage() throws InterruptedException {
        ticketPricePage.deleteTicketPrice();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void sortAndSearchNameTicketPricePage() throws InterruptedException {
        ticketPricePage.sortAndSearchNameTicketPrice();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void addBlackTicketPricePage() throws InterruptedException {
        ticketPricePage.addBlackTicketPrice();
        Thread.sleep(2000);
    }

    @Test(priority = 8)
    public void addTicketPriceInvalidPage() throws InterruptedException {
        ticketPricePage.addTicketPriceInvalid();
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
