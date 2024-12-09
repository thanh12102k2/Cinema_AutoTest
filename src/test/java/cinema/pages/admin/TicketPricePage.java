package cinema.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TicketPricePage {
    WebDriver driver;
    Actions actions;
    public TicketPricePage(WebDriver driver) {
        this.driver = driver;
    }

    private String url ="/admin/ticketprice";
    private By addCTicketPriceBtn = By.xpath("//span[contains(text(),'Thêm mới giá vé')]");
    private By addTypeSeat = By.xpath("(//span[@class='ant-select-selection-item'])[2]");
    private By addTypeDate = By.xpath("//span[@title='Chọn ngày']");
    private By addTypeScreen = By.xpath("(//span[@class='ant-select-selection-item'])[4]");
    private By addPrice = By.id("basic_price");
    private By addSubmitBtn = By.xpath("//button[@type='submit']");
    private By notif = By.xpath("//div[@class='ant-message-notice-content']");

    private By deleteTicketPriceBtn = By.xpath("(//button[@type='button'])[4]");
    private By deteleSubmitBtn = By.xpath("//span[normalize-space()='Có']");

    private By updateCTicketPriceBtn = By.xpath("(//button[@type='button'])[5]");
    private By updateTypeSeat = By.xpath("(//div[@class='ant-select-selector'])[5]");
    private By updateTypeDate = By.xpath("(//div[@class='ant-select-selector'])[6]");
    private By updateTypeScreen = By.xpath("(//div[@class='ant-select-selector'])[7]");
    private By updatePrice = By.id("basic1_price");
    private By updateSubmitBtn = By.xpath("//span[contains(text(),'Cập nhật')]");

    private By searchNameBtn = By.xpath("//span[@role='button']");
    private By getSearchNameInput = By.xpath("//input[@placeholder='Tìm kiếm giá ghế ngồi']");
    private By searchBtn = By.xpath("//span[contains(text(),'Tìm kiếm')]");
    private By resetBtn = By.xpath("//span[contains(text(),'Đặt lại')]");
    private By sortBtn= By.xpath("//span[contains(text(),'Loại ghế')]");

    private By addCloseBtn = By.xpath("//button[@aria-label='Close']");
    private By messAddBlankTypeSeat = By.xpath("//div[contains(text(),'Hãy chọn loại ghế!')]");
    private By messAddBlankTypeDate = By.xpath("//div[contains(text(),'Hãy chọn ngày!')]");
    private By messAddBlankTypeScreen = By.xpath("//div[contains(text(),'Hãy chọn phòng chiếu!')]");
    private By messAddBlankPrice = By.xpath("//div[contains(text(),'Hãy nhập giá tiền')]");

    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }

    public void addTicketPrice() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang TicketPrice");
        Thread.sleep(1000);
        driver.findElement(addCTicketPriceBtn).click();
        Thread.sleep(1000);

        driver.findElement(addTypeSeat).click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addTypeDate).click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addTypeScreen).click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addPrice).sendKeys("269000");
        driver.findElement(addSubmitBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Success", message_actual);

//        driver.findElement(addCloseBtn).click();
    }

    public void updateTicketPrice() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang TicketPrice");
        Thread.sleep(1000);
        driver.findElement(updateCTicketPriceBtn).click();
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 10);

//        driver.findElement(updateTypeSeat).click();
//        actions = new Actions(driver);
//        actions.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).build().perform();
//        Thread.sleep(1000);

//        driver.findElement(updateTypeDate).click();
//        actions = new Actions(driver);
//        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
//        Thread.sleep(1000);

//        driver.findElement(updateTypeScreen).click();
//        actions = new Actions(driver);
//        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
//        Thread.sleep(1000);

        WebElement input_price = wait.until(ExpectedConditions.elementToBeClickable(updatePrice));
        input_price.sendKeys(Keys.CONTROL + "a");
        input_price.sendKeys(Keys.DELETE);
        input_price.sendKeys("299000");

        driver.findElement(updateSubmitBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Success", message_actual);


    }

    public void deleteTicketPrice() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang TicketPrice");
        Thread.sleep(2000);
        driver.findElement(deleteTicketPriceBtn).click();
        Thread.sleep(1000);
        driver.findElement(deteleSubmitBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Đã xoá thành công.", message_actual);
    }

    public void sortAndSearchNameTicketPrice() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang TicketPrice");
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(searchNameBtn).click();
        driver.findElement(getSearchNameInput).sendKeys("Ghế VIP");
        driver.findElement(searchBtn).click();
        Thread.sleep(1000);
        driver.findElement(searchNameBtn).click();
        Thread.sleep(1000);
        driver.findElement(resetBtn).click();
        driver.findElement(searchBtn).click();
    }

    public void addBlackTicketPrice() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang TicketPrice");
        Thread.sleep(2000);
        driver.findElement(addCTicketPriceBtn).click();
        Thread.sleep(1000);
        driver.findElement(addSubmitBtn).click();
        Thread.sleep(2000);

        String message_actual_seat = driver.findElement(messAddBlankTypeSeat).getText();
        Assert.assertEquals("Hãy chọn loại ghế!", message_actual_seat);

        String message_actual_date = driver.findElement(messAddBlankTypeDate).getText();
        Assert.assertEquals("Hãy chọn ngày!", message_actual_date);

        String message_actual_screen = driver.findElement(messAddBlankTypeScreen).getText();
        Assert.assertEquals("Hãy chọn phòng chiếu!", message_actual_screen);

        String message_actual_price = driver.findElement(messAddBlankPrice).getText();
        Assert.assertEquals("Hãy nhập giá tiền", message_actual_price);

        driver.findElement(addCloseBtn).click();
    }

    public void addTicketPriceInvalid() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang TicketPrice");
        Thread.sleep(1000);
        driver.findElement(addCTicketPriceBtn).click();
        Thread.sleep(1000);

        driver.findElement(addTypeSeat).click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addTypeDate).click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addTypeScreen).click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addPrice).sendKeys("55000");
        driver.findElement(addSubmitBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Đã có giá vé này!", message_actual);

        driver.findElement(addCloseBtn).click();
    }
}
