package cinema.testcases.admin;

import cinema.base.BaseSetup;
import cinema.base.DashboardAdminPage;
import cinema.pages.admin.LogInAdminPage;
import cinema.pages.admin.ScreenPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScreenTest extends BaseSetup {
    private WebDriver driver;
    private DashboardAdminPage dashboardAdminPage;
    private LogInAdminPage logInAdminPage;
    private ScreenPage screenPage;

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
    public void openScreenPage() throws InterruptedException {
        screenPage = dashboardAdminPage.openScreenPage();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void addScreenPage() throws InterruptedException {
        screenPage.addScreen();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void updateScreenPage() throws InterruptedException {
        screenPage.updateScreen();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void viewScreenPage() throws InterruptedException {
        screenPage.viewScreen();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void deleteScreenPage() throws InterruptedException {
        screenPage.deleteScreen();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void sortAndSearchNameScreenPage() throws InterruptedException {
        screenPage.sortAndSearchNameScreen();
        Thread.sleep(2000);
    }

    @Test(priority = 8)
    public void addBlankScreenPage() throws InterruptedException {
        screenPage.addBlankScreen();
        Thread.sleep(2000);
    }

    @Test(priority = 9)
    public void addMaxSizeScreenPage() throws InterruptedException {
        screenPage.addMaxSizeScreen();
        screenPage.deleteScreen();
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}
