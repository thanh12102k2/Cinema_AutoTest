package cinema.pages.admin;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CinemaPage {
    WebDriver driver;
    public CinemaPage(WebDriver driver) {
        this.driver = driver;
    }

    private String url ="/admin/cinemas";
    private By addCinemaBtn = By.xpath("//span[contains(text(),'Thêm mới rạp phim')]");
    private By addNameCinemaInput = By.id("basic_cinemaName");
    private By addAddressCinemaInput = By.id("basic_address");
    private By addLocationCinemaInput = By.id("basic_location");
    private By addSaveBtn = By.xpath("//button[@type='submit']");

    private By updateCinemaBtn = By.xpath("(//button[@type='button'])[5]");
    private By updateNameCinemaInput = By.xpath("//input[@id='basic1_cinemaName']");
    private By updateAddressCinemaInput = By.xpath("//textarea[@id='basic1_address']");
    private By updateLocationCinemaInput = By.xpath("//textarea[@id='basic1_location']");
    private By updateSaveBtn = By.xpath("(//button[@type='submit'])[2]");

    private By deleteCinemaBtn = By.xpath("(//button[@type='button'])[4]");
    private By yesDeteleBtn = By.xpath("//span[normalize-space()='Có']");

    private By searchNameBtn = By.xpath("//span[@role='button']");
    private By getSearchNameInput = By.xpath("//input[@placeholder='Tìm kiếm rạp phim']");
    private By searchBtn = By.xpath("//span[contains(text(),'Tìm kiếm')]");
    private By resetBtn = By.xpath("//span[contains(text(),'Đặt lại')]");
    private By sortBtn= By.xpath("//span[contains(text(),'Tên rạp phim')]");

    private  By messNameCinema = By.xpath("//div[contains(text(),'Hãy nhập tên rạp phim!')]");
    private  By messAddressCinema = By.xpath("//div[contains(text(),'Hãy nhập địa chỉ rạp phim!')]");
    private  By messLocationCinema = By.xpath("//div[contains(text(),'Hãy nhập địa chỉ map!')]");

    private By notif = By.xpath("//div[@class='ant-message-notice-content']");
    private By closeBtn = By.xpath("(//button[@aria-label='Close'])[1]");

    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }

    public void addCinema() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Cinema");
        Thread.sleep(2000);
        driver.findElement(addCinemaBtn).click();
        driver.findElement(addNameCinemaInput).sendKeys("Popcorn H02");
        driver.findElement(addAddressCinemaInput).sendKeys("Vincom Mega Mall, 72A Đ. Nguyễn Trãi, Khu đô thị Royal City, Thanh Xuân, Hà Nội 11414, Việt Nam");
        driver.findElement(addLocationCinemaInput).sendKeys("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.6659033661034!2d105.81506727629218!3d21.003125680638822!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135abc68ef444df%3A0x5427926a2a50655d!2zVmluY29tIFJveWFsIENpdHksIDcyQSBOZ3V54buFbiBUcsOjaSwgVGjGsOG7o25nIMSQw6xuaCwgVGhhbmggWHXDom4sIEjDoCBO4buZaQ!5e0!3m2!1svi!2s!4v1699708730243!5m2!1svi!2s");
        Thread.sleep(2000);
        driver.findElement(addSaveBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        org.testng.Assert.assertEquals("Success", message_actual);
    }

    public void updateCinema() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Cinema");
        Thread.sleep(2000);
        driver.findElement(updateCinemaBtn).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement input_name = wait.until(ExpectedConditions.elementToBeClickable(updateNameCinemaInput));
        input_name.sendKeys(Keys.CONTROL + "a");
        input_name.sendKeys(Keys.DELETE);
        input_name.sendKeys("Popcorn H03");

        WebElement input_address = wait.until(ExpectedConditions.elementToBeClickable(updateAddressCinemaInput));
        input_address.sendKeys(Keys.CONTROL + "a");
        input_address.sendKeys(Keys.DELETE);
        input_address.sendKeys("Toà nhà Sun Plaza Thụy Khuê, Sun Grand City Thuy Khue Residence, đối diện 119, Đ. Hoàng Hoa Thám, Tây Hồ, Hà Nội, Việt Nam");

        WebElement input_location = wait.until(ExpectedConditions.elementToBeClickable(updateLocationCinemaInput));
        input_location.sendKeys(Keys.CONTROL + "a");
        input_location.sendKeys(Keys.DELETE);
        input_location.sendKeys("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3723.798481373734!2d105.82361217597!3d21.040747787365415!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135abe580abb089%3A0x2c2698cc6cc37d04!2zQ0dWIFN1biBHcmFuZCBUaOG7pXkgS2h1w6o!5e0!3m2!1svi!2sus!4v1731343483902!5m2!1svi!2sus\"");

        Thread.sleep(3000);
        driver.findElement(updateSaveBtn).click();

        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        org.testng.Assert.assertEquals("Success", message_actual);

    }

    public void deleteCinema() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Cinema");
        Thread.sleep(2000);
        driver.findElement(deleteCinemaBtn).click();
        Thread.sleep(1000);
        driver.findElement(yesDeteleBtn).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        org.testng.Assert.assertEquals("Đã xoá thành công.", message_actual);
    }

    public void sortAndSearchNameCinema() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Cinema");
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(sortBtn).click();
        Thread.sleep(1000);
        driver.findElement(searchNameBtn).click();
        driver.findElement(getSearchNameInput).sendKeys("Popcorn H01");
        driver.findElement(searchBtn).click();
        Thread.sleep(1000);
        driver.findElement(searchNameBtn).click();
        Thread.sleep(1000);
        driver.findElement(resetBtn).click();
        driver.findElement(searchBtn).click();
    }

    public void addCinemaBlank() throws InterruptedException{
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang Cinema");
        Thread.sleep(2000);
        driver.findElement(addCinemaBtn).click();
        Thread.sleep(2000);
        driver.findElement(addSaveBtn).click();
        Thread.sleep(2000);
        String message_actual_1 = driver.findElement(messNameCinema).getText();
        Assert.assertEquals("Hãy nhập tên rạp phim!", message_actual_1);

        String message_actual_2 = driver.findElement(messAddressCinema).getText();
        Assert.assertEquals("Hãy nhập địa chỉ rạp phim!", message_actual_2);

        String message_actual_3 = driver.findElement(messLocationCinema).getText();
        Assert.assertEquals("Hãy nhập địa chỉ map!", message_actual_3);
        driver.findElement(closeBtn).click();
    }


}
