package cinema.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.UUID;

public class CouponPage {
    WebDriver driver;
    Actions actions;
    public CouponPage(WebDriver driver) {
        this.driver = driver;
    }

    private String url ="/admin/coupon";
    private By addCouponBtn = By.xpath("//span[contains(text(),'Thêm mới khuyến mãi')]");
    private By addNameInput = By.id("basic_code");
    private By addPercentInput = By.id("basic_discount");
    private By addQuantityInput = By.id("basic_quantity");
    private By addStatusInput = By.xpath("//span[@title='Chọn trạng thái']");
    private By addStartDateInput = By.id("basic_startDate");
    private By addEndDateInput = By.id("basic_endDate");
    private By addSubmitBtn = By.xpath("//button[@type='submit']//span[contains(text(),'Thêm mới')]");
    private By notif = By.xpath("//div[@class='ant-message-notice-content']");

    private By updateCouponBtn = By.xpath("(//button[@type='button'])[5]");
    private By updateNameInput = By.id("basic1_code");
    private By updatePercentInput = By.id("basic1_discount");
    private By updateQuantityInput = By.id("basic1_quantity");
    private By updateStatusInput = By.xpath("(//div[@class='ant-select-selector'])[3]");
    private By updateStartDateInput = By.id("basic1_startDate");
    private By updateEndDateInput = By.id("basic1_endDate");

    private By deleteCouponBtn = By.xpath("(//button[@type='button'])[4]");
    private By deteleSubmitBtn = By.xpath("//span[normalize-space()='Có']");

    private By searchNameBtn = By.xpath("//span[@role='button']");
    private By getSearchNameInput = By.xpath("//input[@placeholder='Tìm kiếm khuyến mãi']");
    private By searchBtn = By.xpath("//span[contains(text(),'Tìm kiếm')]");
    private By resetBtn = By.xpath("//span[contains(text(),'Đặt lại')]");
    private By sortBtn= By.xpath("//span[contains(text(),'Mã khuyến mãi')]");

    private By addCloseBtn = By.xpath("//button[@aria-label='Close']");
    private By messAddBlankName = By.xpath("//div[contains(text(),'Hãy nhập mã khuyến mãi!')]");
    private By messAddBlankPercent = By.xpath("//div[contains(text(),'Hãy nhập phần trăm')]");
    private By messAddBlankQuantity = By.xpath("//div[contains(text(),'Hãy nhập số lượng')]");
    private By messAddBlankStatus = By.xpath("//div[contains(text(),'Hãy chọn trạng thái')]");
    private By messAddBlankStartDate = By.xpath("//div[contains(text(),'Hãy chọn ngày bắt đầu')]");
    private By messAddBlankEndDate = By.xpath("//div[contains(text(),'Hãy chọn ngày kết thúc')]");

    private By messEndDateLessStartDate = By.xpath("//div[@class='ant-form-item-explain-error']");


    private String generateRandomName() {
        return UUID.randomUUID().toString().substring(0, 6);
    }
    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }

    public void addCoupon() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Coupon");
        Thread.sleep(1000);
        driver.findElement(addCouponBtn).click();
        Thread.sleep(1000);
        String randomTitle = generateRandomName();
        driver.findElement(addNameInput).sendKeys("Coupon Test " + randomTitle);
        driver.findElement(addPercentInput).sendKeys("30");
        driver.findElement(addQuantityInput).sendKeys("1000");

        driver.findElement(addStatusInput).click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addStartDateInput).sendKeys("2025-01-01");
        actions.sendKeys(Keys.SHIFT).build().perform();
        driver.findElement(addEndDateInput).sendKeys("2025-01-31");
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Success", message_actual);
    }

    public void updateCoupon() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Coupon");
        Thread.sleep(2000);
        driver.findElement(updateCouponBtn).click();
        Thread.sleep(3000);
        String randomTitle = generateRandomName();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement input_title = wait.until(ExpectedConditions.elementToBeClickable(updateNameInput));
        input_title.sendKeys(Keys.CONTROL + "a");
        input_title.sendKeys(Keys.DELETE);
        input_title.sendKeys("Coupon Update " + generateRandomName());

        WebElement input_percent = wait.until(ExpectedConditions.elementToBeClickable(updatePercentInput));
        input_percent.sendKeys(Keys.CONTROL + "a");
        input_percent.sendKeys(Keys.DELETE);
        input_percent.sendKeys("25");

        WebElement input_quantity = wait.until(ExpectedConditions.elementToBeClickable(updateQuantityInput));
        input_quantity.sendKeys(Keys.CONTROL + "a");
        input_quantity.sendKeys(Keys.DELETE);
        input_quantity.sendKeys("25");

        driver.findElement(updateStatusInput).click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        WebElement input_start_date = wait.until(ExpectedConditions.elementToBeClickable(updateStartDateInput));
        input_start_date.sendKeys(Keys.CONTROL + "a");
        input_start_date.sendKeys(Keys.DELETE);
        input_start_date.sendKeys("2025-01-15");
        actions.sendKeys(Keys.SHIFT).build().perform();

        WebElement input_end_date = wait.until(ExpectedConditions.elementToBeClickable(updateEndDateInput));
        input_end_date.sendKeys(Keys.CONTROL + "a");
        input_end_date.sendKeys(Keys.DELETE);
        input_end_date.sendKeys("2025-02-28");
        actions.sendKeys(Keys.ENTER).build().perform();

        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Success", message_actual);
    }

    public void deleteCoupon() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Coupon");
        Thread.sleep(2000);
        driver.findElement(deleteCouponBtn).click();
        Thread.sleep(1000);
        driver.findElement(deteleSubmitBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Đã xoá thành công.", message_actual);
    }

    public void sortAndSearchNameCoupon() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Coupon");
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(searchNameBtn).click();
        driver.findElement(getSearchNameInput).sendKeys("VNPAYNEW20");
        driver.findElement(searchBtn).click();
        Thread.sleep(1000);
        driver.findElement(searchNameBtn).click();
        Thread.sleep(1000);
        driver.findElement(resetBtn).click();
        driver.findElement(searchBtn).click();
    }

    public void addBlankCoupon() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Coupon");
        Thread.sleep(2000);
        driver.findElement(addCouponBtn).click();
        Thread.sleep(1000);
        driver.findElement(addSubmitBtn).click();
        Thread.sleep(2000);

        String message_actual_name = driver.findElement(messAddBlankName).getText();
        Assert.assertEquals("Hãy nhập mã khuyến mãi!", message_actual_name);

        String message_actual_percent = driver.findElement(messAddBlankPercent).getText();
        Assert.assertEquals("Hãy nhập phần trăm", message_actual_percent);

        String message_actual_quantity = driver.findElement(messAddBlankQuantity).getText();
        Assert.assertEquals("Hãy nhập số lượng", message_actual_quantity);

        String message_actual_status = driver.findElement(messAddBlankStatus).getText();
        Assert.assertEquals("Hãy chọn trạng thái", message_actual_status);

        String message_actual_start_date = driver.findElement(messAddBlankStartDate).getText();
        Assert.assertEquals("Hãy chọn ngày bắt đầu", message_actual_start_date);

        String message_actual_end_date = driver.findElement(messAddBlankEndDate).getText();
        Assert.assertEquals("Hãy chọn ngày kết thúc", message_actual_end_date);

        driver.findElement(addCloseBtn).click();
    }

    public void addCouponEndDateLessStartDate() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Coupon");
        Thread.sleep(1000);
        driver.findElement(addCouponBtn).click();
        Thread.sleep(1000);
        String randomTitle = generateRandomName();
        driver.findElement(addNameInput).sendKeys("Coupon " + randomTitle);
        driver.findElement(addPercentInput).sendKeys("25");
        driver.findElement(addQuantityInput).sendKeys("1000");

        driver.findElement(addStatusInput).click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addStartDateInput).sendKeys("2025-01-31");
        actions.sendKeys(Keys.SHIFT).build().perform();
        driver.findElement(addEndDateInput).sendKeys("2025-01-01");
        actions.sendKeys(Keys.ENTER).build().perform();

        Thread.sleep(500);
        String message_actual = driver.findElement(messEndDateLessStartDate).getText();
        Assert.assertEquals("Ngày kết thúc phải lớn hơn ngày bắt đầu!", message_actual);

        driver.findElement(addCloseBtn).click();
    }

}
