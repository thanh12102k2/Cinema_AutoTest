package cinema.testcases.admin;

import cinema.base.BaseSetup;
import cinema.base.DashboardAdminPage;
import cinema.pages.admin.LogInAdminPage;
import cinema.pages.admin.RegionPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegionTest extends BaseSetup {
    private WebDriver driver;
    private DashboardAdminPage dashboardAdminPage;
    private LogInAdminPage logInAdminPage;
    private RegionPage regionPage;

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
    public void openRegionPage() throws InterruptedException {
        regionPage = dashboardAdminPage.openRegionPage();
        Thread.sleep(2000);
    }

    @Test(priority = 3, enabled = true)
    public void addRegionPage() throws InterruptedException {
        regionPage.addRegion();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void updateRegionPage() throws InterruptedException {
        regionPage.updateRegion();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void deleteRegionPage() throws InterruptedException {
        regionPage.deleteRegion();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void sortAndSearchRegionPage() throws InterruptedException {
        regionPage.sortAndSearchTypeRegion();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void addRegionAvailPage() throws InterruptedException {
        regionPage.addRegionAvail();
        Thread.sleep(2000);
    }

    @Test(priority = 8)
    public void addRegionBlankPage() throws InterruptedException {
        regionPage.addRegionBlank();
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}
