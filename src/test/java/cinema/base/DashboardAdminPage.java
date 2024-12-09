package cinema.base;

import cinema.pages.admin.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardAdminPage {
    WebDriver driver;

    public DashboardAdminPage(WebDriver driver) {
        this.driver = driver;
    }

    private By genreMenu = By.xpath("//a[@href='/admin/genre']");
    private By regionMenu = By.xpath("//a[@href='/admin/region']");
    private By directorMenu = By.xpath("//a[@href='/admin/director']");
    private By castMenu = By.xpath("//a[@href='/admin/cast']");
    private By userMenu = By.xpath("//a[@href='/admin/user']");
    private By cinemaMenu = By.xpath("//a[@href='/admin/cinemas']");
    private By movieMenu = By.xpath("//a[@href='/admin/movie']");
    private By comboMenu = By.xpath("//a[@href='/admin/combo']");
    private By newsMenu = By.xpath("//a[@href='/admin/news']");
    private By screenMenu = By.xpath("//a[@href='/admin/screen']");
    private By couponMenu = By.xpath("//a[@href='/admin/coupon']");
    private By showtimeMenu = By.xpath("//a[@href='/admin/showtime']");
    private By ticketPriceMenu = By.xpath("//a[@href='/admin/ticketprice']");
    private By orderMenu = By.xpath("//a[@href='/admin/order']");
    private By salesMenu = By.xpath("//a[@href='/admin/dashboard']");
    private String url ="/admin";

    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }

    public GenrePage openGenrePage(){
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Dashboard");
        driver.findElement(genreMenu).click();
        return new GenrePage(driver);
    }
    public RegionPage openRegionPage(){
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Dashboard");
        driver.findElement(regionMenu).click();
        return new RegionPage(driver);
    }
    public DirectorPage openDirectorPage(){
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Dashboard");
        driver.findElement(directorMenu).click();
        return new DirectorPage(driver);
    }
    public CastPage openCastPage(){
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Dashboard");
        driver.findElement(castMenu).click();
        return new CastPage(driver);
    }

    public UserPage openUserPage(){
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Dashboard");
        driver.findElement(userMenu).click();
        return new UserPage(driver);
    }

    public CinemaPage openCinemaPage(){
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Dashboard");
        driver.findElement(cinemaMenu).click();
        return new CinemaPage(driver);
    }

    public MoviePage openMoviePage(){
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Dashboard");
        driver.findElement(movieMenu).click();
        return new MoviePage(driver);
    }
    public ComboPage openComboPage(){
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Dashboard");
        driver.findElement(comboMenu).click();
        return new ComboPage(driver);
    }

    public NewsPage openNewsPage(){
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Dashboard");
        driver.findElement(newsMenu).click();
        return new NewsPage(driver);
    }

    public ScreenPage openScreenPage(){
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Dashboard");
        driver.findElement(screenMenu).click();
        return new ScreenPage(driver);
    }

    public CouponPage openCouponPage(){
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Dashboard");
        driver.findElement(couponMenu).click();
        return new CouponPage(driver);
    }

    public TicketPricePage openTicketPricePage(){
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Dashboard");
        driver.findElement(ticketPriceMenu).click();
        return new TicketPricePage(driver);
    }

    public ShowTimePage openShowTimePage(){
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Dashboard");
        driver.findElement(showtimeMenu).click();
        return new ShowTimePage(driver);
    }

    public OrderPage openOrderPage(){
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Dashboard");
        driver.findElement(orderMenu).click();
        return new OrderPage(driver);
    }

    public SalesPage openSalesPage(){
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Dashboard");
        driver.findElement(salesMenu).click();
        return new SalesPage(driver);
    }
}
