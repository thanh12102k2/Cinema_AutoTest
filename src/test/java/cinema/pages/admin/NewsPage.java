package cinema.pages.admin;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.UUID;

public class NewsPage {
    WebDriver driver;
    Actions actions;
    public NewsPage(WebDriver driver) {
        this.driver = driver;
    }

    private String url ="/admin/news";
    private By addNewsBtn = By.xpath("//span[contains(text(),'Thêm mới tin tức')]");
    private By addTile = By.id("basic_title");
    private By addDescrip = By.id("basic_shortTitle");
    private By addImg = By.xpath("//span[@class='ant-upload']");
    private By addSubmitBtn = By.xpath("//button[@type='submit']");

    private By updateNewsBtn = By.xpath("(//button[@type='button'])[5]");
    private By updateTitle = By.id("basic1_title");
    private By updateStatus = By.xpath("(//div[@class='ant-select-selector'])[2]");
    private By updateDescrip = By.id("basic1_shortTitle");
    private By updateSubmitBtn = By.xpath("//span[contains(text(),'Cập nhật')]");
    private By updateDeteleImgInput = By.xpath("//span[@class='ant-btn-icon']//span[@aria-label='delete']//*[name()='svg']");

    private By deleteNewsBtn = By.xpath("(//button[@type='button'])[4]");
    private By deteleSubmitBtn = By.xpath("//span[normalize-space()='Có']");

    private By searchNameBtn = By.xpath("//span[@role='button']");
    private By getSearchNameInput = By.xpath("//input[@placeholder='Tìm kiếm tin tức']");
    private By searchBtn = By.xpath("//span[contains(text(),'Tìm kiếm')]");
    private By resetBtn = By.xpath("//span[contains(text(),'Đặt lại')]");
    private By sortBtn= By.xpath("//span[contains(text(),'Tiêu đề')]");

    private By addCloseBtn = By.xpath("//button[@aria-label='Close']");
    private By notif = By.xpath("//div[@class='ant-message-notice-content']");
    private By messAddBlankTitle = By.xpath("//div[contains(text(),'Hãy nhập tiêu đề cho tin tức!')]");
    private By messAddBlankContent = By.xpath("//div[contains(text(),'Hãy nhập nội dung tin tức!')]");
    private By messAddBlankDescrip = By.xpath("//div[contains(text(),'Hãy nhập tiêu đề ngắn cho tin tức!')]");

    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }

    private String generateRandomName() {
        return UUID.randomUUID().toString().substring(0, 6);
    }

    public void addNews() throws InterruptedException, IOException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang News");
        Thread.sleep(2000);
        String randomTitle = generateRandomName();
        driver.findElement(addNewsBtn).click();
        Thread.sleep(8000);
        driver.findElement(addTile).sendKeys("Title Add News " + randomTitle);

        Actions actions = new Actions(driver);
        actions.moveByOffset(680,350).click().sendKeys("Đây là nội dung test add news").build().perform();

        driver.findElement(addDescrip).sendKeys("Test Add Description News");
        driver.findElement(addImg).click();
        Thread.sleep(2000);
        Runtime.getRuntime().exec("C://Users//Admin//Desktop//CinemaTest//AddImg.exe");
        Thread.sleep(2000);
        driver.findElement(addSubmitBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Success", message_actual);
    }

    public void updateNews() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang News");
        Thread.sleep(2000);
        driver.findElement(updateNewsBtn).click();
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement input_title = wait.until(ExpectedConditions.elementToBeClickable(updateTitle));
        input_title.sendKeys(Keys.CONTROL + "a");
        input_title.sendKeys(Keys.DELETE);
        input_title.sendKeys("Title Update News");

        driver.findElement(updateStatus).click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        WebElement input_descrip = wait.until(ExpectedConditions.elementToBeClickable(updateDescrip));
        input_descrip.sendKeys(Keys.CONTROL + "a");
        input_descrip.sendKeys(Keys.DELETE);
        input_descrip.sendKeys("Title Update Description News");

        driver.findElement(updateDeteleImgInput).click();

//        Actions actions = new Actions(driver);
//        actions.moveByOffset(680, 350)
//                .click()
//                .sendKeys(Keys.CONTROL+"a")
//                .sendKeys(Keys.DELETE)
//                .build()
//                .perform();

        Thread.sleep(2000);
        driver.findElement(updateSubmitBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Success", message_actual);
    }

    public void deleteNews() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang News");
        Thread.sleep(2000);
        driver.findElement(deleteNewsBtn).click();
        Thread.sleep(1000);
        driver.findElement(deteleSubmitBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Đã xoá thành công.", message_actual);
    }

    public void sortAndSearchNameNews() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang News");
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(searchNameBtn).click();
        driver.findElement(getSearchNameInput).sendKeys("JUJUTSU KAISEN");
        driver.findElement(searchBtn).click();
        Thread.sleep(1000);
        driver.findElement(searchNameBtn).click();
        Thread.sleep(1000);
        driver.findElement(resetBtn).click();
        driver.findElement(searchBtn).click();
    }

    public void addBlankNews() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang News");
        Thread.sleep(2000);
        driver.findElement(addNewsBtn).click();
        Thread.sleep(1000);
        driver.findElement(addSubmitBtn).click();
        Thread.sleep(2000);

        String message_actual_title = driver.findElement(messAddBlankTitle).getText();
        Assert.assertEquals("Hãy nhập tiêu đề cho tin tức!", message_actual_title);

        String message_actual_content = driver.findElement(messAddBlankContent).getText();
        Assert.assertEquals("Hãy nhập nội dung tin tức!", message_actual_content);

        String message_actual_descrip = driver.findElement(messAddBlankDescrip).getText();
        Assert.assertEquals("Hãy nhập tiêu đề ngắn cho tin tức!", message_actual_descrip);
        driver.findElement(addCloseBtn).click();
    }
}
