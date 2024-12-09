package cinema.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ShowTimePage {
    WebDriver driver;
    Actions actions;
    public ShowTimePage(WebDriver driver) {
        this.driver = driver;
    }

    private String url ="/admin/showtime";
    private By notif = By.xpath("//div[@class='ant-message-notice-content']");

    private By addShowTimeBtn = By.xpath("//span[contains(text(),'Thêm mới suất chiếu')]");
    private By addCinema = By.xpath("(//span[@class='ant-select-selection-item'])[4]");
    private By addScreen = By.xpath("(//span[@class='ant-select-selection-item'])[5]");
    private By addMovieName = By.xpath("(//span[@class='ant-select-selection-item'])[6]");
    private By addDate = By.id("basic_showDate");
    private By addType = By.xpath("(//span[@class='ant-select-selection-item'])[7]");
    private By addStartTime = By.id("basic_startTime");
    private By addEndTime = By.id("basic_endTime");
    private By addSubmitBtn = By.xpath("//button[@type='submit']//span[contains(text(),'Thêm mới')]");

    private By searchCinema = By.xpath("(//span[@class='ant-select-selection-item'])[1]");
    private By searchScreen = By.xpath("(//div[@class='ant-select-selector'])[2]");
    private By searchDate = By.id("basic1_showDate");
    private By searchSubmitBtn = By.xpath("//span[contains(text(),'Tìm kiếm')]");

    private By updateShowTimeBtn = By.xpath("(//button[@type='button'])[5]");
    private By updateCinema = By.xpath("(//div[@class='ant-select-selector'])[8]");
    private By updateScreen = By.xpath("(//div[@class='ant-select-selector'])[9]");
    private By updateMovieName = By.xpath("(//div[@class='ant-select-selector'])[10]");
    private By updateDate = By.id("basic2_showDate");
    private By updateType = By.xpath("(//div[@class='ant-select-selector'])[11]");
    private By updateStartTime = By.id("basic2_startTime");
    private By updateEndTime = By.id("basic2_endTime");

    private By deleteShowTimeBtn = By.xpath("(//button[@type='button'])[4]");
    private By deteleSubmitBtn = By.xpath("//span[normalize-space()='Có']");

    private By messBlankCinema = By.xpath("//div[contains(text(),'Hãy chọn rạp phim!')]");
    private By messBlankScreen = By.xpath("//div[contains(text(),'Hãy chọn phòng chiếu!')]");
    private By messBlankMovie = By.xpath("//div[contains(text(),'Hãy chọn phim chiếu!')]");
    private By messBlankDate = By.xpath("//div[contains(text(),'Hãy nhập ngày chiếu phim!')]");
    private By messBlankType = By.xpath("//div[contains(text(),'Hãy chọn hình thức dịch')]");
    private By messBlankStartTime = By.xpath("//div[contains(text(),'Hãy nhập thời gian bắt đầu')]");
    private By messBlankEndTime = By.xpath("//div[contains(text(),'Hãy nhập thời gian kết thúc')]");
    private By addCloseBtn = By.xpath("//button[@aria-label='Close']");

    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }

    public void addShowTime(String startTimeValue, String endTimeValue, String date) throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang ShowTime");
        Thread.sleep(1000);
        driver.findElement(addShowTimeBtn).click();
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.findElement(addCinema).click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addScreen).click();
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addMovieName).click();
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addType).click();
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addStartTime).sendKeys(startTimeValue);
        Thread.sleep(1000);

        WebElement input_end_time = wait.until(ExpectedConditions.elementToBeClickable(addEndTime));
        input_end_time.sendKeys(Keys.CONTROL + "a");
        input_end_time.sendKeys(endTimeValue);
        Thread.sleep(1000);

        driver.findElement(addDate).click();
        actions.sendKeys(date).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Success", message_actual);
    }

    public void searchShowTime(String date) throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang ShowTime");
        Thread.sleep(1000);
        driver.findElement(searchCinema).click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(searchScreen).click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(searchDate));
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(date);
        input.sendKeys(Keys.ENTER);
    }

    public void updateShowTime(String startTimeValue, String endTimeValue, String date) throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang ShowTime");
        Thread.sleep(1000);
        driver.findElement(updateShowTimeBtn).click();
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
//        driver.findElement(updateCinema).click();
        actions = new Actions(driver);
//        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
//        Thread.sleep(1000);
//
//        driver.findElement(updateScreen).click();
//        actions.sendKeys(Keys.ENTER).build().perform();
//        Thread.sleep(1000);

        driver.findElement(updateMovieName).click();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(updateType).click();
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        WebElement input_start_time = wait.until(ExpectedConditions.elementToBeClickable(updateStartTime));
        input_start_time.sendKeys(Keys.CONTROL + "a");
        input_start_time.sendKeys(startTimeValue);
        Thread.sleep(1000);

        WebElement input_end_time = wait.until(ExpectedConditions.elementToBeClickable(updateEndTime));
        input_end_time.sendKeys(Keys.CONTROL + "a");
        input_end_time.sendKeys(endTimeValue);
        Thread.sleep(1000);

        WebElement input_date = wait.until(ExpectedConditions.elementToBeClickable(updateDate));
        input_date.sendKeys(Keys.CONTROL + "a");
        input_date.sendKeys(date);
        input_date.sendKeys(Keys.ENTER);
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Cập nhật suất chiếu thành công", message_actual);
    }

    public void deleteShowTime() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang ShowTime");
        Thread.sleep(2000);
        driver.findElement(deleteShowTimeBtn).click();
        Thread.sleep(1000);
        driver.findElement(deteleSubmitBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Đã xoá thành công.", message_actual);
    }

    public void addBlankShowTime() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang ShowTime");
        Thread.sleep(1000);
        driver.findElement(addShowTimeBtn).click();
        Thread.sleep(1000);
        driver.findElement(addSubmitBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);


        String message_actual_cinema = driver.findElement(messBlankCinema).getText();
        Assert.assertEquals("Hãy chọn rạp phim!", message_actual_cinema);

        String message_actual_screen = driver.findElement(messBlankScreen).getText();
        Assert.assertEquals("Hãy chọn phòng chiếu!", message_actual_screen);

        String message_actual_movie = driver.findElement(messBlankMovie).getText();
        Assert.assertEquals("Hãy chọn phim chiếu!", message_actual_movie);

        String message_actual_date = driver.findElement(messBlankDate).getText();
        Assert.assertEquals("Hãy nhập ngày chiếu phim!", message_actual_date);

        String message_actual_type = driver.findElement(messBlankType).getText();
        Assert.assertEquals("Hãy chọn hình thức dịch", message_actual_type);

        String message_actual_start_time = driver.findElement(messBlankStartTime).getText();
        Assert.assertEquals("Hãy nhập thời gian bắt đầu", message_actual_start_time);

        String message_actual_end_time = driver.findElement(messBlankEndTime).getText();
        Assert.assertEquals("Hãy nhập thời gian kết thúc", message_actual_end_time);

        driver.findElement(addCloseBtn).click();
    }

    public void addDuplicateShowtime(String startTimeValue, String endTimeValue, String date) throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang ShowTime");
        Thread.sleep(1000);
        driver.findElement(addShowTimeBtn).click();
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.findElement(addCinema).click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addScreen).click();
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addMovieName).click();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addType).click();
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addStartTime).sendKeys(startTimeValue);
        Thread.sleep(1000);

        WebElement input_end_time = wait.until(ExpectedConditions.elementToBeClickable(addEndTime));
        input_end_time.sendKeys(Keys.CONTROL + "a");
        input_end_time.sendKeys(endTimeValue);
        Thread.sleep(1000);

        driver.findElement(addDate).click();
        actions.sendKeys(date).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Suất chiếu bị trùng lịch!", message_actual);

        driver.findElement(addCloseBtn).click();
    }

    public void addShowtimeTotalTimeLessDuration(String startTimeValue, String endTimeValue, String date) throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang ShowTime");
        Thread.sleep(1000);
        driver.findElement(addShowTimeBtn).click();
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.findElement(addCinema).click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addScreen).click();
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addMovieName).click();
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addType).click();
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addStartTime).sendKeys(startTimeValue);
        Thread.sleep(1000);

        WebElement input_end_time = wait.until(ExpectedConditions.elementToBeClickable(addEndTime));
        input_end_time.sendKeys(Keys.CONTROL + "a");
        input_end_time.sendKeys(endTimeValue);
        Thread.sleep(1000);

        driver.findElement(addDate).click();
        actions.sendKeys(date).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Tổng thời gian chiếu ít hơn thời lượng phim!", message_actual);

        driver.findElement(addCloseBtn).click();
    }
}
