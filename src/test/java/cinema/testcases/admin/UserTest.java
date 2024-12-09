package cinema.testcases.admin;

import cinema.base.BaseSetup;
import cinema.base.DashboardAdminPage;
import cinema.pages.admin.LogInAdminPage;
import cinema.pages.admin.UserPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTest extends BaseSetup {
    private WebDriver driver;
    private DashboardAdminPage dashboardAdminPage;
    private LogInAdminPage logInAdminPage;
    private UserPage userPage;

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
    public void openUserPage() throws InterruptedException {
        userPage = dashboardAdminPage.openUserPage();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void addUserPage() throws InterruptedException {
        userPage.addUser();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void updateUserPage() throws InterruptedException {
        userPage.updateUser();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void deleteUserPage() throws InterruptedException {
        userPage.deleteUser();
        Thread.sleep(2000);
    }

    @Test(priority = 6, enabled = true)
    public void sortAndSearchNameUserPage() throws InterruptedException {
        userPage.sortAndSearchNameUser();
        Thread.sleep(2000);
    }

    @Test(priority = 7, enabled = true)
    public void addUserBlankPage() throws InterruptedException {
        userPage.addUserBlank();
        Thread.sleep(2000);
    }

    @Test(priority = 8, enabled = true)
    public void addInvalidUserPage() throws InterruptedException {
        userPage.addInvalidUser();
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}
