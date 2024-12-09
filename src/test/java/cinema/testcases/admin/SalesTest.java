package cinema.testcases.admin;

import cinema.base.BaseSetup;
import cinema.base.DashboardAdminPage;
import cinema.pages.admin.LogInAdminPage;

import cinema.pages.admin.SalesPage;
import cinema.pages.admin.ScreenPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SalesTest extends BaseSetup {
    private WebDriver driver;
    private DashboardAdminPage dashboardAdminPage;
    private LogInAdminPage logInAdminPage;
    private SalesPage salesPage;

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
    public void openSalesPage() throws InterruptedException {
        salesPage = dashboardAdminPage.openSalesPage();
        Thread.sleep(5000);
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
