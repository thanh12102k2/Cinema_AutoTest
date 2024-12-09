package cinema.base;
import cinema.pages.client.*;
import org.openqa.selenium.WebDriver;

public class DashboardClientPage {
    WebDriver driver;

    public DashboardClientPage(WebDriver driver) {
        this.driver = driver;
    }

    private String registerUrl = "http://localhost:3030/auth/register";
    private String profileUrl = "http://localhost:3030/profile";
    private String changePasswordUrl = "http://localhost:3030/change-password";
    private String newsUrl = "http://localhost:3030/news-promotions";
    private String movieUrl = "http://localhost:3030/movie";
    private String cinemaUrl = "http://localhost:3030/cinema";
    private String bookTicketUrl = "http://localhost:3030/";
    private String forgetPasswordUrl = "http://localhost:3030/auth/forgot-password";
    private String myTicketUrl = "http://localhost:3030/my-ticket";
    private String url ="/";

    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }

    public RegisterPage openRegisterPage() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Dashboard");
        driver.get(registerUrl);
        return new RegisterPage(driver);
    }

    public ProfilePage openProfilePage() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Dashboard");
        driver.get(profileUrl);
        return new ProfilePage(driver);
    }

    public ChangePasswordPage openChangePasswordPage() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Dashboard");
        driver.get(changePasswordUrl);
        return new ChangePasswordPage(driver);
    }

    public NewsPage openNewsPage() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Dashboard");
        driver.get(newsUrl);
        return new NewsPage(driver);
    }

    public MoviePage openMoviePage() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Dashboard");
        driver.get(movieUrl);
        return new MoviePage(driver);
    }

    public CinemaPage openCinemaPage() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Dashboard");
        driver.get(cinemaUrl);
        return new CinemaPage(driver);
    }

    public BookTicketPage openBookTicketPage() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Dashboard");
        driver.get(bookTicketUrl);
        return new BookTicketPage(driver);
    }

    public ForgetPasswordPage openForgetPasswordPage() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Dashboard");
        driver.get(forgetPasswordUrl);
        return new ForgetPasswordPage(driver);
    }

    public MyTicketPage openMyTicketPage() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Dashboard");
        driver.get(myTicketUrl);
        return new MyTicketPage(driver);
    }

}
