package cinema.testcases.client;

import cinema.base.BaseSetup;
import cinema.base.DashboardClientPage;
import cinema.pages.client.LogInClientPage;
import cinema.pages.client.NewsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewsTest extends BaseSetup {
    private WebDriver driver;
    private DashboardClientPage dashboardClientPage;
    private LogInClientPage logInClientPage;
    private NewsPage newsPage;

    @BeforeClass
    public void setup() {
        driver = getDriver();
    }

    @Test(priority = 1)
    public void LogInTest() throws InterruptedException {
        logInClientPage = new LogInClientPage(driver);
        dashboardClientPage = logInClientPage.Login("do@gmail.com", "123456");
        dashboardClientPage = logInClientPage.logOut();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void openNewsPage() throws InterruptedException {
        newsPage = dashboardClientPage.openNewsPage();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void ViewValidFirstNewsPage() throws InterruptedException {
        newsPage.ViewValidFirstNews();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void ViewValidSecondNewsPage() throws InterruptedException {
        newsPage.ViewValidSecondNews();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void ViewValidSeventhNewsPage() throws InterruptedException {
        newsPage.ViewValidSeventhNews();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void ViewInvalidNewsPage() throws InterruptedException {
        newsPage.ViewInvalidNews();
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}
