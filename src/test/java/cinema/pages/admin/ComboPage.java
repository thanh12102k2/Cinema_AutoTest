package cinema.pages.admin;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.UUID;

public class ComboPage {
    WebDriver driver;
    public ComboPage(WebDriver driver) {
        this.driver = driver;
    }

    private String url ="/admin/combo";
    private By addComboBtn = By.xpath("//span[contains(text(),'Thêm mới combo')]");
    private By addNameInput = By.id("basic_comboName");
    private By addPriceInput = By.id("basic_price");
    private By addItemsInput = By.id("basic_comboItems");
    private By addImgInput = By.xpath("//span[@class='ant-upload']");
    private By addSubmitBtn = By.xpath("//button[@type='submit']");
    private By addCloseBtn = By.xpath("//button[@aria-label='Close']");
    private By notif = By.xpath("//div[@class='ant-message-notice-content']");

    private By updateComboBtn = By.xpath("(//button[@type='button'])[5]");
    private By updateNameInput = By.id("basic1_comboName");
    private By updatePriceInput = By.id("basic1_price");
    private By updateItemsInput = By.id("basic1_comboItems");
    private By updateImgInput = By.xpath("(//span[@class='ant-upload'])[2]");
    private By updateDeteleImgInput = By.xpath("//span[@class='ant-btn-icon']//span[@aria-label='delete']//*[name()='svg']");
    private By updateSubmitBtn = By.xpath("//span[contains(text(),'Cập nhật')]");

    private By deleteComboBtn = By.xpath("(//button[@type='button'])[4]");
    private By deteleSubmitBtn = By.xpath("//span[normalize-space()='Có']");

    private By searchNameBtn = By.xpath("//span[@role='button']");
    private By getSearchNameInput = By.xpath("//input[@placeholder='Tìm kiếm combo']");
    private By searchBtn = By.xpath("//span[contains(text(),'Tìm kiếm')]");
    private By resetBtn = By.xpath("//span[contains(text(),'Đặt lại')]");
    private By sortBtn= By.xpath("//span[contains(text(),'Tên combo - nước uống')]");

    private By messAddBlankName = By.xpath("//div[contains(text(),'Hãy nhập tên combo!')]");
    private By messAddBlankPrice = By.xpath("//div[contains(text(),'Hãy nhập giá tiền của combo!')]");
    private By messAddBlankItems = By.xpath("//div[contains(text(),'Hãy nhập loại vật phẩm có trong combo!')]");


    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }

    private String generateRandomName() {
        return UUID.randomUUID().toString().substring(0, 6);
    }

    public void addCombo() throws InterruptedException, IOException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Combo");
        Thread.sleep(2000);
        String random = generateRandomName();
        driver.findElement(addComboBtn).click();
        driver.findElement(addNameInput).sendKeys("Add Combo " + random);
        driver.findElement(addPriceInput).sendKeys("89000");
        driver.findElement(addItemsInput).sendKeys(" 2 nước siêu lớn +1 bắp lớn");
        driver.findElement(addImgInput).click();
        Thread.sleep(2000);
        Runtime.getRuntime().exec("C://Users//Admin//Desktop//CinemaTest//AddImg.exe");
        Thread.sleep(2000);
        driver.findElement(addSubmitBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        org.testng.Assert.assertEquals("Success", message_actual);
    }

    public void updateCombo() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Combo");
        Thread.sleep(2000);
        driver.findElement(updateComboBtn).click();
        String random = generateRandomName();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement input_name = wait.until(ExpectedConditions.elementToBeClickable(updateNameInput));
        input_name.sendKeys(Keys.CONTROL + "a");
        input_name.sendKeys(Keys.DELETE);
        input_name.sendKeys("Update Combo " + random);

        WebElement input_price = wait.until(ExpectedConditions.elementToBeClickable(updatePriceInput));
        input_price.sendKeys(Keys.CONTROL + "a");
        input_price.sendKeys(Keys.DELETE);
        input_price.sendKeys("179000");

        WebElement input_Items = wait.until(ExpectedConditions.elementToBeClickable(updateItemsInput));
        input_Items.sendKeys(Keys.CONTROL + "a");
        input_Items.sendKeys(Keys.DELETE);
        input_Items.sendKeys("Update Test Description");
//        driver.findElement(updateImgInput).click();
        driver.findElement(updateDeteleImgInput).click();

        Thread.sleep(1000);
        driver.findElement(updateSubmitBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        org.testng.Assert.assertEquals("Success", message_actual);
    }

    public void deleteCombo() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Combo");
        Thread.sleep(2000);
        driver.findElement(deleteComboBtn).click();
        Thread.sleep(1000);
        driver.findElement(deteleSubmitBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        org.testng.Assert.assertEquals("Đã xoá thành công.", message_actual);
    }

    public void sortAndSearchNameCombo() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Combo");
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(searchNameBtn).click();
        driver.findElement(getSearchNameInput).sendKeys("My Combo");
        driver.findElement(searchBtn).click();
        Thread.sleep(1000);
        driver.findElement(searchNameBtn).click();
        Thread.sleep(1000);
        driver.findElement(resetBtn).click();
        driver.findElement(searchBtn).click();
    }

    public void addBlankCombo() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Combo");
        Thread.sleep(2000);
        driver.findElement(addComboBtn).click();
        Thread.sleep(1000);
        driver.findElement(addSubmitBtn).click();
        Thread.sleep(2000);

        String message_actual_name = driver.findElement(messAddBlankName).getText();
        Assert.assertEquals("Hãy nhập tên combo!", message_actual_name);

        String message_actual_price = driver.findElement(messAddBlankPrice).getText();
        Assert.assertEquals("Hãy nhập giá tiền của combo!", message_actual_price);

        String message_actual_items = driver.findElement(messAddBlankItems).getText();
        Assert.assertEquals("Hãy nhập loại vật phẩm có trong combo!", message_actual_items);
        driver.findElement(addCloseBtn).click();
    }
}
