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

public class ScreenPage {
    WebDriver driver;
    Actions actions;
    public ScreenPage(WebDriver driver) {
        this.driver = driver;
    }

    private String url ="/admin/screen";
    private By addScreenBtn = By.xpath("//span[contains(text(),'Thêm mới phòng chiếu')]");
    private By addNameScreen = By.id("basic_screenName");
    private By addCinemaScreen = By.xpath("(//span[@class='ant-select-selection-item'])[2]");
    private By addTypeScreen = By.xpath("(//div[@class='ant-select-selector'])[3]");
    private By add2DTypeScreen = By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='2D']");
    private By addRowScreen = By.id("basic_rows");
    private By addColumnScreen = By.id("basic_columns");
    private By addSumbitBtn = By.xpath("//button[@type='submit']");
    private By addEditSeatBtn = By.xpath("//div[8]//div[9]//button[1]");
    private By addEditSeatDropdown = By.xpath("//span[@title='Ghế thường']");
    private By addEditSeatCouple = By.xpath("//div[@title='Ghế couple']//div[1]");
    private By addSubmitSeatBtn = By.xpath("//div[@class='ant-modal-footer']//button[2]");
    private By addCloseBtn = By.xpath("//button[@aria-label='Close']");

    private By updateBtn = By.xpath("(//button[@type='button'])[6]");
    private By updateNameInput = By.id("basic1_screenName");
    private By updateCinemaScreen = By.xpath("(//div[@class='ant-select-selector'])[5]");
    private By updateTypeScreen = By.xpath("(//div[@class='ant-select-selector'])[6]");
    private By update3DTypeScreen = By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='3D']");
    private By updateRowScreen = By.id("basic1_row");
    private By updateColumnScreen = By.id("basic1_collumn");
    private By updateEditSeatBtn = By.xpath("//form[@id='basic1']//div[8]//div[7]//button[1]");
    private By updateEditSeatDropdown = By.xpath("(//div[@class='ant-select-selector'])[7]");
    private By updateSubmitSeatBtn = By.xpath("(//span[contains(text(),'OK')])[2]");
    private By updateSubmitBtn = By.xpath("//span[contains(text(),'Cập nhật')]");
    private By notif = By.xpath("//div[@class='ant-message-notice-content']");

    private By viewScreenBtn = By.xpath("(//button[@type='button'])[4]");
    private By clostViewScreenBtn = By.xpath("//div[@class='flex justify-center mt-10 mr-2']//button[@type='button']");

    private By deleteScreenBtn = By.xpath("(//button[@type='button'])[5]");
    private By deteleSubmitBtn = By.xpath("//span[normalize-space()='Có']");

    private By searchNameBtn = By.xpath("//span[@role='button']");
    private By getSearchNameInput = By.xpath("//input[@placeholder='Tìm kiếm phòng chiếu']");
    private By searchBtn = By.xpath("//span[contains(text(),'Tìm kiếm')]");
    private By resetBtn = By.xpath("//span[contains(text(),'Đặt lại')]");
    private By sortBtn= By.xpath("//span[contains(text(),'Tên phòng chiếu')]");

    private By messBlankName = By.xpath("//div[contains(text(),'Hãy nhập tên phòng chiếu!')]");
    private By messBlankCinema = By.xpath("//div[contains(text(),'Hãy chọn rạp phim!')]");
    private By messBlankType = By.xpath("//div[contains(text(),'Hãy chọn loại phòng chiếu!')]");
    private By messBlankRow = By.xpath("//div[contains(text(),'Nhập số hàng')]");
    private By messBlankColumn = By.xpath("//div[contains(text(),'Nhập số cột')]");


    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }

    private String generateRandomName() {
        return UUID.randomUUID().toString().substring(0, 6);
    }

    public void addScreen() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Screen");
        driver.findElement(addScreenBtn).click();
        String randomName = generateRandomName();
        driver.findElement(addNameScreen).sendKeys("Phòng chiếu " + randomName);
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.findElement(addCinemaScreen).click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addTypeScreen).click();
        driver.findElement(add2DTypeScreen).click();

        driver.findElement(addRowScreen).sendKeys("8");
        driver.findElement(addColumnScreen).sendKeys("8");
        Thread.sleep(2000);

        driver.findElement(addEditSeatBtn).click();
        Thread.sleep(2000);
        driver.findElement(addEditSeatDropdown).click();
        Thread.sleep(2000);
        driver.findElement(addEditSeatCouple).click();
        driver.findElement(addSubmitSeatBtn).click();

        driver.findElement(addSumbitBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Success", message_actual);
    }

    public void updateScreen() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Screen");
        driver.findElement(updateBtn).click();
        String randomName = generateRandomName();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement input_name = wait.until(ExpectedConditions.elementToBeClickable(updateNameInput));
        input_name.sendKeys(Keys.CONTROL + "a");
        input_name.sendKeys(Keys.DELETE);
        input_name.sendKeys("Phòng chiếu " + randomName);

        driver.findElement(updateCinemaScreen).click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(updateTypeScreen).click();
        driver.findElement(update3DTypeScreen).click();

        WebElement input_row = wait.until(ExpectedConditions.elementToBeClickable(updateRowScreen));
        input_row.sendKeys(Keys.CONTROL + "a");
        input_row.sendKeys(Keys.DELETE);
        input_row.sendKeys("10");

        WebElement input_column = wait.until(ExpectedConditions.elementToBeClickable(updateColumnScreen));
        input_column.sendKeys(Keys.CONTROL + "a");
        input_column.sendKeys(Keys.DELETE);
        input_column.sendKeys("10");
        Thread.sleep(2000);

        driver.findElement(updateEditSeatBtn).click();
        Thread.sleep(2000);
        driver.findElement(updateEditSeatDropdown).click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
        driver.findElement(updateSubmitSeatBtn).click();

        driver.findElement(updateSubmitBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Cập nhật thành công!", message_actual);
    }

    public void viewScreen() throws InterruptedException {
        driver.findElement(viewScreenBtn).click();
        Thread.sleep(2000);
//        String message_actual = driver.findElement(viewTitlte).getText();
//        Assert.assertEquals("Ghế ngồi trong rạp phim", message_actual);
//        Thread.sleep(2000);
        driver.findElement(clostViewScreenBtn).click();
    }

    public void deleteScreen() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Screen");
        Thread.sleep(2000);
        driver.findElement(deleteScreenBtn).click();
        Thread.sleep(1000);
        driver.findElement(deteleSubmitBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Đã xoá thành công.", message_actual);
    }

    public void sortAndSearchNameScreen() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Screen");
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(searchNameBtn).click();
        driver.findElement(getSearchNameInput).sendKeys("Cinema 1");
        driver.findElement(searchBtn).click();
        Thread.sleep(1000);
        driver.findElement(searchNameBtn).click();
        Thread.sleep(1000);
        driver.findElement(resetBtn).click();
        driver.findElement(searchBtn).click();
    }

    public void addBlankScreen() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Screen");
        Thread.sleep(2000);
        driver.findElement(addScreenBtn).click();
        Thread.sleep(1000);
        driver.findElement(addSumbitBtn).click();
        Thread.sleep(2000);

        String message_actual_Name = driver.findElement(messBlankName).getText();
        Assert.assertEquals("Hãy nhập tên phòng chiếu!", message_actual_Name);

        String message_actual_cinema = driver.findElement(messBlankCinema).getText();
        Assert.assertEquals("Hãy chọn rạp phim!", message_actual_cinema);

        String message_actual_type = driver.findElement(messBlankType).getText();
        Assert.assertEquals("Hãy chọn loại phòng chiếu!", message_actual_type);

        String message_actual_row = driver.findElement(messBlankRow).getText();
        Assert.assertEquals("Nhập số hàng", message_actual_row);

        String message_actual_column = driver.findElement(messBlankColumn).getText();
        Assert.assertEquals("Nhập số cột", message_actual_column);

        driver.findElement(addCloseBtn).click();
    }

    public void addMaxSizeScreen() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Screen");
        driver.findElement(addScreenBtn).click();
        String randomName = generateRandomName();
        driver.findElement(addNameScreen).sendKeys("Phòng chiếu " + randomName);
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.findElement(addCinemaScreen).click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        driver.findElement(addTypeScreen).click();
        driver.findElement(add2DTypeScreen).click();

        driver.findElement(addRowScreen).sendKeys("100");
        driver.findElement(addColumnScreen).sendKeys("100");
        Thread.sleep(2000);

        driver.findElement(addSumbitBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Success", message_actual);
    }
}
