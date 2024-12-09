package cinema.testcases.client;

import cinema.base.BaseSetup;
import cinema.base.DashboardClientPage;
import cinema.pages.client.LogInClientPage;
import cinema.pages.client.MyTicketPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyTicketTest extends BaseSetup {
    private WebDriver driver;
    private DashboardClientPage dashboardClientPage;
    private LogInClientPage logInClientPage;
    private MyTicketPage myTicketPage;

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
    public void openMyTicketPage() throws InterruptedException {
        myTicketPage = dashboardClientPage.openMyTicketPage();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void ViewMyTicketPage() throws InterruptedException {
        myTicketPage.ViewMyTicket();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void ViewListHistoryTicketPage() throws InterruptedException {
        myTicketPage.ViewListHistoryTicket();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void ViewFailPaymentOrderDetailPage() throws InterruptedException {
        myTicketPage.ViewFailPaymentOrderDetail();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void ViewOrderDetailInvalidPage() throws InterruptedException {
        myTicketPage.ViewOrderDetailInvalid();
        Thread.sleep(2000);
    }
    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}

