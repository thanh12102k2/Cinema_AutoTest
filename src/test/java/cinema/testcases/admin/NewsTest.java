package cinema.testcases.admin;

import cinema.base.BaseSetup;
import cinema.base.DashboardAdminPage;
import cinema.pages.admin.ComboPage;
import cinema.pages.admin.LogInAdminPage;
import cinema.pages.admin.NewsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class NewsTest extends BaseSetup {
    private WebDriver driver;
    private DashboardAdminPage dashboardAdminPage;
    private LogInAdminPage logInAdminPage;
    private NewsPage newsPage;

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
    public void openNewsPage() throws InterruptedException {
        newsPage = dashboardAdminPage.openNewsPage();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void addNewsPage() throws InterruptedException, IOException {
        newsPage.addNews();
        Thread.sleep(2000);
    }

    @Test(priority = 4,enabled = true)
    public void updateNewsPage() throws InterruptedException {
        newsPage.updateNews();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void deleteNewsPage() throws InterruptedException {
        newsPage.deleteNews();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void sortAndSearchNameNewsPage() throws InterruptedException {
        newsPage.sortAndSearchNameNews();
        Thread.sleep(2000);
    }
    @Test(priority = 7)
    public void addBlankNewsPage() throws InterruptedException {
        newsPage.addBlankNews();
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
