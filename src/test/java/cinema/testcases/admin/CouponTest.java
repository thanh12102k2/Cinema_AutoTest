package cinema.testcases.admin;

import cinema.base.BaseSetup;
import cinema.base.DashboardAdminPage;
import cinema.pages.admin.CouponPage;
import cinema.pages.admin.LogInAdminPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CouponTest extends BaseSetup {
    private WebDriver driver;
    private DashboardAdminPage dashboardAdminPage;
    private LogInAdminPage logInAdminPage;
    private CouponPage couponPage;

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
    public void openCouponPage() throws InterruptedException {
        couponPage = dashboardAdminPage.openCouponPage();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void addCouponPage() throws InterruptedException{
        couponPage.addCoupon();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void updateCouponPage() throws InterruptedException{
        couponPage.updateCoupon();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void deleteCouponPage() throws InterruptedException{
        couponPage.deleteCoupon();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void sortAndSearchNameCouponPage() throws InterruptedException{
        couponPage.sortAndSearchNameCoupon();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void addBlankCouponPage() throws InterruptedException{
        couponPage.addBlankCoupon();
        Thread.sleep(2000);
    }

    @Test(priority = 8)
    public void addCouponEndDateLessStartDatePage() throws InterruptedException{
        couponPage.addCouponEndDateLessStartDate();
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
