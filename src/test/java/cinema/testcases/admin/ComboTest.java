package cinema.testcases.admin;

import cinema.base.BaseSetup;
import cinema.base.DashboardAdminPage;
import cinema.pages.admin.ComboPage;
import cinema.pages.admin.LogInAdminPage;
import cinema.pages.admin.MoviePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ComboTest extends BaseSetup {
    private WebDriver driver;
    private DashboardAdminPage dashboardAdminPage;
    private LogInAdminPage logInAdminPage;
    private ComboPage comboPage;

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
    public void openComboPage() throws InterruptedException {
        comboPage = dashboardAdminPage.openComboPage();
        Thread.sleep(2000);
    }

    @Test(priority = 3, enabled = true)
    public void addComboPage() throws InterruptedException, IOException {
        comboPage.addCombo();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void updateComboPage() throws InterruptedException {
        comboPage.updateCombo();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void deleteComboPage() throws InterruptedException {
        comboPage.deleteCombo();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void sortAndSearchNameComboPage() throws InterruptedException {
        comboPage.sortAndSearchNameCombo();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void addBlankComboPage() throws InterruptedException {
        comboPage.addBlankCombo();
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
