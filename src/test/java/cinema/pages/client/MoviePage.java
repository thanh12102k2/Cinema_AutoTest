package cinema.pages.client;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MoviePage {
    WebDriver driver;

    public MoviePage(WebDriver driver) {
        this.driver = driver;
    }

    private String ShowingUrl ="/movie";

    private By movie1 = By.xpath("(//p[contains(@class, 'MoviePreview_name')])[1]");
    private By movie5 = By.xpath("(//p[contains(@class, 'MoviePreview_name')])[5]");
    private By movieDetailName = By.xpath("//h4[@class='InfoDetailMovie_name___t8NC']");

    private By movieUpcomingBtn = By.xpath("//a[@class='PageListMovies_tab__AXBQp']");

    private String invalidMoviewUrl = "http://localhost:3030/movie/bc16f730-ea2f-47a9-9ab1-67cf184f41eeXXX";

    private By TrailerBtn =By.xpath("//div[@class='InfoDetailMovie_icon_play__Aa8zU']//*[name()='svg']");
    private By playVideoBtn = By.xpath("//button[@title='Phát']");
    private By closeTrailerBtn = By.xpath("//div[contains(text(),'Đóng')]");

    private By subtitleDropDown = By.xpath("//p[contains(text(),'Phụ đề')]");
    private By dubbingDropDown = By.xpath("//p[contains(text(),'Lồng tiếng')]");

    private By directorView = By.xpath("//a[contains(@class,'InfoDetailMovie_description')]");
    private By castView = By.xpath("(//a[contains(@class,'InfoDetailMovie_link')])[2]");
    private By nameDrectorOrCast = By.xpath("(//p[@class='MainDetailDirectorCast_code__UnKWL']/span)[1]");

    public boolean verifyShowingUrl(){
        return driver.getCurrentUrl().contains(ShowingUrl);
    }

    public void ViewFirstMovieShowing() throws InterruptedException {
        Thread.sleep(2000);
        org.testng.Assert.assertTrue(verifyShowingUrl(), "Không phải trang Movie");
        String text_title = driver.findElement(movie1).getText();;
        driver.findElement(movie1).click();
        Thread.sleep(5000);
        String message_actual = driver.findElement(movieDetailName).getText();
        Assert.assertEquals(text_title, message_actual);
    }

    public void ViewFifthMovieShowing() throws InterruptedException {
        driver.navigate().back();
        Thread.sleep(2000);
        org.testng.Assert.assertTrue(verifyShowingUrl(), "Không phải trang Movie");
        String text_title = driver.findElement(movie5).getText();;
        driver.findElement(movie5).click();
        Thread.sleep(5000);
        String message_actual = driver.findElement(movieDetailName).getText();
        Assert.assertEquals(text_title, message_actual);
    }

    public void ViewFirstMovieUpComing() throws InterruptedException {
        driver.navigate().back();
        driver.findElement(movieUpcomingBtn).click();
        Thread.sleep(1500);
        org.testng.Assert.assertTrue(verifyShowingUrl(), "Không phải trang Movie");
        String text_title = driver.findElement(movie1).getText();;
        driver.findElement(movie1).click();
        Thread.sleep(5000);
        String message_actual = driver.findElement(movieDetailName).getText();
        Assert.assertEquals(text_title, message_actual);
    }

    public void ViewFifthMovieUpComing() throws InterruptedException {
        driver.navigate().back();
        org.testng.Assert.assertTrue(verifyShowingUrl(), "Không phải trang Movie");
        String text_title = driver.findElement(movie5).getText();;
        driver.findElement(movie5).click();
        Thread.sleep(5000);
        String message_actual = driver.findElement(movieDetailName).getText();
        Assert.assertEquals(text_title, message_actual);
    }

    public void ViewInvalidMovie() throws InterruptedException {
        driver.navigate().back();
        Thread.sleep(2000);
        org.testng.Assert.assertTrue(verifyShowingUrl(), "Không phải trang Movie");
        driver.get(invalidMoviewUrl);
        Thread.sleep(3000);
        String message_actual = driver.findElement(movieDetailName).getText();
        Assert.assertEquals("", message_actual);
    }

    public void ViewTrailerMovie() throws InterruptedException {
        driver.get("http://localhost:3030/movie");
        ViewFirstMovieShowing();
        Thread.sleep(1000);
        driver.findElement(TrailerBtn).click();
//        Thread.sleep(1000);
//        driver.findElement(playVideoBtn).click();
        Thread.sleep(5000);
        driver.findElement(closeTrailerBtn).click();
    }

    public void ViewShowtimeMovieType() throws InterruptedException {
        driver.get("http://localhost:3030/movie");
        ViewFirstMovieShowing();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        driver.findElement(subtitleDropDown).click();
        Thread.sleep(2000);
        driver.findElement(dubbingDropDown).click();
        Thread.sleep(2000);
        driver.findElement(dubbingDropDown).click();
        Thread.sleep(2000);
        driver.findElement(subtitleDropDown).click();
        Thread.sleep(2000);
    }

    public void ViewDirector() throws InterruptedException {
        driver.get("http://localhost:3030/movie");
        ViewFirstMovieShowing();
        Thread.sleep(1000);
        String message_actual_1 = driver.findElement(directorView).getText();
        driver.findElement(directorView).click();
        Thread.sleep(2000);
        String message_actual_2 = driver.findElement(nameDrectorOrCast).getText();
        Thread.sleep(1000);
        Assert.assertEquals(message_actual_1, message_actual_2);
    }

    public void ViewCast() throws InterruptedException {
        driver.get("http://localhost:3030/movie");
        ViewFirstMovieShowing();
        Thread.sleep(1000);
        String message_actual_1 = driver.findElement(castView).getText();
        driver.findElement(castView).click();
        Thread.sleep(2000);
        String message_actual_2 = driver.findElement(nameDrectorOrCast).getText();
        Thread.sleep(1000);
        Assert.assertTrue(message_actual_1.contains(message_actual_2));
    }

    public void ViewDirectorOrCastInvalid() throws InterruptedException {
        driver.get("http://localhost:3030/director-cast/2caa8a0f-d688-4ed3-8cb4-076d7fcea450XXX");
        Thread.sleep(3000);
        String message_actual_2 = driver.findElement(nameDrectorOrCast).getText();
        Thread.sleep(1000);
        Assert.assertEquals("", message_actual_2);
    }
}
