package cinema.testcases.admin;

import cinema.base.BaseSetup;
import cinema.base.DashboardAdminPage;
import cinema.pages.admin.CastPage;
import cinema.pages.admin.LogInAdminPage;
import cinema.pages.admin.OrderPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class OrderTest extends BaseSetup {
    private WebDriver driver;
    private DashboardAdminPage dashboardAdminPage;
    private LogInAdminPage logInAdminPage;
    private OrderPage oderPage;

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
    public void openOrderPage() throws InterruptedException {
        oderPage = dashboardAdminPage.openOrderPage();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void viewOrderDetailPage() throws InterruptedException {
        oderPage.viewOrderDetail();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void sortAndSearchNameMoviePage() throws InterruptedException {
        oderPage.sortAndSearchNameMovie();
        Thread.sleep(2000);
    }


    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}
