package cinema.pages.client;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class NewsPage {
    WebDriver driver;

    public NewsPage(WebDriver driver) {
        this.driver = driver;
    }

    private String url ="/news-promotions";
    private By firstTitle = By.xpath("(//p[contains(@class, 'NewsPromotionPreview_name__n7z2y')])[1]");
    private By secondTitle = By.xpath("(//p[contains(@class, 'NewsPromotionPreview_name__n7z2y')])[2]");
    private By seventhTitle = By.xpath("(//p[contains(@class, 'NewsPromotionPreview_name__n7z2y')])[7]");
    private By detailTitle = By.xpath("//h4[contains(@class, 'PageDetailNewsPromotions_title__oV_sD')]");

    private By firstNew = By.xpath("//main[@class='BaseLayout_main__M2Bmt']//a[1]");
    private By secondNew = By.xpath("//main[@class='BaseLayout_main__M2Bmt']//a[2]");
    private By seventhNew = By.xpath("//main[@class='BaseLayout_main__M2Bmt']//a[7]");

    private String invalidNewsUrl = "http://localhost:3030/news-promotions/f376ffaf-94d6-42d7-8c03-86f5dad3434dXXXX";

    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }

    public void ViewValidFirstNews() throws InterruptedException {
        Thread.sleep(2000);
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang News-Promotion");
        String text_title = driver.findElement(firstTitle).getText();;
        driver.findElement(firstNew).click();
        Thread.sleep(3000);
        String message_actual = driver.findElement(detailTitle).getText();
        Assert.assertEquals(text_title, message_actual);
    }

    public void ViewValidSecondNews() throws InterruptedException {
        driver.navigate().back();
        Thread.sleep(2000);
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang News-Promotion");
        String text_title = driver.findElement(secondTitle).getText();;
        driver.findElement(secondNew).click();
        Thread.sleep(3000);
        String message_actual = driver.findElement(detailTitle).getText();
        Assert.assertEquals(text_title, message_actual);
    }

    public void ViewValidSeventhNews() throws InterruptedException {
        driver.navigate().back();
        Thread.sleep(2000);
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang News-Promotion");
        String text_title = driver.findElement(seventhTitle).getText();;
        driver.findElement(seventhNew).click();
        Thread.sleep(3000);
        String message_actual = driver.findElement(detailTitle).getText();
        Assert.assertEquals(text_title, message_actual);
    }

    public void ViewInvalidNews() throws InterruptedException {
        driver.navigate().back();
        Thread.sleep(2000);
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang News-Promotion");
        driver.get(invalidNewsUrl);
        Thread.sleep(3000);
        String message_actual = driver.findElement(detailTitle).getText();
        Assert.assertEquals("", message_actual);
    }


}
