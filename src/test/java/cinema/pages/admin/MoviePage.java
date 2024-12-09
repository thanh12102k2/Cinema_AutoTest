package cinema.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.UUID;

public class MoviePage {
    WebDriver driver;
    private Actions actions;
    public MoviePage(WebDriver driver) {
        this.driver = driver;
    }

    private String url ="/admin/movie";
    private By addMovieBtn = By.xpath("//span[contains(text(),'Thêm mới phim')]");
    private By addTitleInput = By.id("basic_title");
    private By addEngTitleInput = By.id("basic_engTitle");
    private By addTrailerInput = By.id("basic_trailer");
    private By addDurationInput = By.id("basic_duration");
    private By addAgeInput = By.id("basic_rated");
    private By addAvgReviewInput = By.id("basic_averageReview");
    private By addTypeInput = By.xpath("(//div[@class='ant-select-selector'])[3]");
    private By addStatusInput = By.xpath("(//div[@class='ant-select-selector'])[4]");
    private By addRegionInput = By.xpath("(//div[@class='ant-select-selector'])[5]");
    private By addCastInput = By.xpath("(//div[@class='ant-select-selector'])[6]");
    private By addDateInput = By.id("basic_realeaseDate");
    private By addDirectorInput = By.xpath("(//div[@class='ant-select-selector'])[7]");
    private By addDescripInput = By.id("basic_description");
    private By addImgInput = By.xpath("//span[@class='ant-upload']");
    private By addSubmitBtn = By.xpath("//button[@type='submit']");

    private By updateMovieBtn = By.xpath("(//button[@type='button'])[5]");
    private By updateTitleInput = By.id("basic1_title");
    private By updateEngTitleInput = By.id("basic1_engTitle");
    private By updateTrailerInput = By.id("basic1_trailer");
    private By updateDurationInput = By.id("basic1_duration");
    private By updateAgeInput = By.xpath("(//div[@class='ant-select-selector'])[8]");
    private By updateOptionAgeInput = By.xpath("//div[contains(text(),'T16')]");
    private By updateAvgReviewInput = By.id("basic1_averageReview");
    private By updateTypeInput = By.xpath("(//div[@class='ant-select-selector'])[9]");
    private By updateStatusInput = By.xpath("(//div[@class='ant-select-selector'])[10]");
    private By updateRegionInput = By.xpath("(//div[@class='ant-select-selector'])[11]");
    private By updateCastInput = By.xpath("(//div[@class='ant-select-selector'])[12]");
    private By updateDateInput = By.id("basic1_realeaseDate");
    private By updateDirectorInput = By.xpath("(//div[@class='ant-select-selector'])[13]");
    private By updateDescripInput = By.id("basic1_description");
    private By updateSubmitBtn = By.xpath("(//button[@type='submit'])[2]");

    private By deleteMovieBtn = By.xpath("(//button[@type='button'])[4]");
    private By deteleSubmitBtn = By.xpath("//span[normalize-space()='Có']");

    private By searchNameBtn = By.xpath("//span[@role='button']");
    private By getSearchNameInput = By.xpath("//input[@placeholder='Tìm kiếm phim']");
    private By searchBtn = By.xpath("//span[contains(text(),'Tìm kiếm')]");
    private By resetBtn = By.xpath("//span[contains(text(),'Đặt lại')]");
    private By sortBtn= By.xpath("//span[contains(text(),'Tên phim')]");

    private By messTitleBlank = By.xpath("//div[contains(text(),'Hãy nhập tên phim!')]");
    private By messEngTitleBlank = By.xpath("//div[contains(text(),'Hãy nhập tên phim của bạn!')]");
    private By messTrailerBlank = By.xpath("//div[contains(text(),'Hãy nhập tên Trailer!')]");
    private By messDurationBlank = By.xpath("//div[contains(text(),'Hãy nhập thời lượng phim của bạn!')]");
    private By messAgeBlank = By.xpath("//div[contains(text(),'Hãy chọn độ tuổi!')]");
    private By messAvgReviewBlank = By.xpath("//div[contains(text(),'Hãy nhập đánh giá trung bình!')]");
    private By messTypeBlank = By.xpath("//div[contains(text(),'Hãy chọn thể loại phim!')]");
    private By messStatusBlank = By.xpath("//div[contains(text(),'Hãy nhập trạng thái phim của bạn!')]");
    private By messRegionBlank = By.xpath("//div[contains(text(),'Hãy chọn quốc gia!')]");
    private By messCastBlank = By.xpath("//div[contains(text(),'Hãy chọn các diễn viên tham gia bộ phim!')]");
    private By messDateBlank = By.xpath("//div[contains(text(),'Hãy nhập ngày phát hành của phim!')]");
    private By messDirectorBlank = By.xpath("//div[contains(text(),'Hãy chọn đạo diễn phim của bạn!')]");
    private By messDescripBlank = By.xpath("//div[contains(text(),'Hãy nhập mô tả phim của bạn!')]");

    private By closeBtn = By.xpath("(//button[@aria-label='Close'])[1]");
    private By notif = By.xpath("//div[@class='ant-message-notice-content']");

    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }

    private String generateRandomTitle() {
        return UUID.randomUUID().toString().substring(0, 6);
    }

    public void addMovie() throws InterruptedException, IOException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Movie");
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(addMovieBtn).click();
        String randomTitle = generateRandomTitle();
        driver.findElement(addTitleInput).sendKeys("Phim " + randomTitle);
        Thread.sleep(1000);
        driver.findElement(addEngTitleInput).sendKeys("Movie " + randomTitle);
        driver.findElement(addTrailerInput).sendKeys("https://www.youtube.com/watch?v=9qJmCOXk028");
        Thread.sleep(1000);
        driver.findElement(addDurationInput).sendKeys("123");

        driver.findElement(addAgeInput).click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addAvgReviewInput).sendKeys("9");

        driver.findElement(addTypeInput).click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addStatusInput).click();
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addRegionInput).click();
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addCastInput).click();
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addDateInput).sendKeys("2024-12-12");

        driver.findElement(addDirectorInput).click();
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addDescripInput).sendKeys("Test add description movie.");
        driver.findElement(addImgInput).click();
        Thread.sleep(2000);
        Runtime.getRuntime().exec("C://Users//Admin//Desktop//CinemaTest//AddImg.exe");
        Thread.sleep(2000);
        driver.findElement(addSubmitBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Success", message_actual);
    }

    public void updateMovie() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Movie");
        Thread.sleep(2000);
        driver.findElement(updateMovieBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement input_title = wait.until(ExpectedConditions.elementToBeClickable(updateTitleInput));
        input_title.sendKeys(Keys.CONTROL + "a");
        input_title.sendKeys(Keys.DELETE);
        input_title.sendKeys("Cập nhật phim");

        WebElement input_Engtitle = wait.until(ExpectedConditions.elementToBeClickable(updateEngTitleInput));
        input_Engtitle.sendKeys(Keys.CONTROL + "a");
        input_Engtitle.sendKeys(Keys.DELETE);
        input_Engtitle.sendKeys("Update movie");

        WebElement input_Trailer = wait.until(ExpectedConditions.elementToBeClickable(updateTrailerInput));
        input_Trailer.sendKeys(Keys.CONTROL + "a");
        input_Trailer.sendKeys(Keys.DELETE);
        input_Trailer.sendKeys("https://www.youtube.com/watch?v=KmOVNVZEP9o");

        WebElement input_Duration = wait.until(ExpectedConditions.elementToBeClickable(updateDurationInput));
        input_Duration.sendKeys(Keys.CONTROL + "a");
        input_Duration.sendKeys(Keys.DELETE);
        input_Duration.sendKeys("124");

        driver.findElement(updateAgeInput).click();
        driver.findElement(updateOptionAgeInput).click();

        WebElement input_AvgReview = wait.until(ExpectedConditions.elementToBeClickable(updateAvgReviewInput));
        input_AvgReview.sendKeys(Keys.CONTROL + "a");
        input_AvgReview.sendKeys(Keys.DELETE);
        input_AvgReview.sendKeys("7");

        driver.findElement(updateTypeInput).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(updateStatusInput).click();
        actions.sendKeys(Keys.ENTER).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(updateRegionInput).click();
        actions.sendKeys(Keys.ENTER).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(updateCastInput).click();
        actions.sendKeys(Keys.ENTER).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(updateDateInput).sendKeys("2025-01-01");

        driver.findElement(updateDirectorInput).click();
        actions.sendKeys(Keys.ENTER).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        WebElement input_Descrip = wait.until(ExpectedConditions.elementToBeClickable(updateDescripInput));
        input_Descrip.sendKeys(Keys.CONTROL + "a");
        input_Descrip.sendKeys(Keys.DELETE);
        input_Descrip.sendKeys("Test update description movie.");

        Thread.sleep(2000);
        driver.findElement(updateSubmitBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Success", message_actual);
    }

    public void deleteMovie() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Movie");
        Thread.sleep(2000);
        driver.findElement(deleteMovieBtn).click();
        Thread.sleep(1000);
        driver.findElement(deteleSubmitBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Đã xoá thành công.", message_actual);
    }

    public void sortAndSearchNameMovie() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Movie");
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(searchNameBtn).click();
        driver.findElement(getSearchNameInput).sendKeys("Nhím Sonic 3");
        driver.findElement(searchBtn).click();
        Thread.sleep(1000);
        driver.findElement(searchNameBtn).click();
        Thread.sleep(1000);
        driver.findElement(resetBtn).click();
        driver.findElement(searchBtn).click();
    }

    public void addBlankMovie() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Movie");
        Thread.sleep(2000);
        driver.findElement(addMovieBtn).click();
        Thread.sleep(1000);
        driver.findElement(addSubmitBtn).click();
        String message_actual_title = driver.findElement(messTitleBlank).getText();
        Assert.assertEquals("Hãy nhập tên phim!", message_actual_title);

        String message_actual_Engtitle = driver.findElement(messEngTitleBlank).getText();
        Assert.assertEquals("Hãy nhập tên phim của bạn!", message_actual_Engtitle);

        String message_actual_trailer = driver.findElement(messTrailerBlank).getText();
        Assert.assertEquals("Hãy nhập tên Trailer!", message_actual_trailer);

        String message_actual_duration = driver.findElement(messDurationBlank).getText();
        Assert.assertEquals("Hãy nhập thời lượng phim của bạn!", message_actual_duration);

        String message_actual_age = driver.findElement(messAgeBlank).getText();
        Assert.assertEquals("Hãy chọn độ tuổi!", message_actual_age);

        String message_actual_avgReview = driver.findElement(messAvgReviewBlank).getText();
        Assert.assertEquals("Hãy nhập đánh giá trung bình!", message_actual_avgReview);

        String message_actual_type = driver.findElement(messTypeBlank).getText();
        Assert.assertEquals("Hãy chọn thể loại phim!", message_actual_type);

        String message_actual_status = driver.findElement(messStatusBlank).getText();
        Assert.assertEquals("Hãy nhập trạng thái phim của bạn!", message_actual_status);

        String message_actual_region = driver.findElement(messRegionBlank).getText();
        Assert.assertEquals("Hãy chọn quốc gia!", message_actual_region);

        String message_actual_cast = driver.findElement(messCastBlank).getText();
        Assert.assertEquals("Hãy chọn các diễn viên tham gia bộ phim!", message_actual_cast);

        String message_actual_date = driver.findElement(messDateBlank).getText();
        Assert.assertEquals("Hãy nhập ngày phát hành của phim!", message_actual_date);

        String message_actual_director = driver.findElement(messDirectorBlank).getText();
        Assert.assertEquals("Hãy chọn đạo diễn phim của bạn!", message_actual_director);

        String message_actual_descrip = driver.findElement(messDescripBlank).getText();
        Assert.assertEquals("Hãy nhập mô tả phim của bạn!", message_actual_descrip);

        driver.findElement(closeBtn).click();
    }
}
