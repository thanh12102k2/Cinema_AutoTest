package cinema.pages.client;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class MyTicketPage {
    WebDriver driver;

    public MyTicketPage(WebDriver driver) {
        this.driver = driver;
    }

    private final String url = "/my-ticket";
    private final By ticketMovieName = By.xpath("(//p[contains(@class,'Ticket_name')])[1]");
    private final By ticketCinemaName = By.xpath("//body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[2]/p[2]/span[1]");
    private final By ticketScreenName = By.xpath("//body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[2]/p[3]/span[1]");
    private final By ticketDateName = By.xpath("//body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[2]/p[4]/span[1]/time[1]");
    private final By ticketTimeName = By.xpath("//body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[2]/p[5]/span[1]");
    private final By viewHistoryPayBtn = By.xpath("(//div[contains(text(),'Xem lịch sử thanh toán')])[1]");
    private final By movieNameDetail = By.xpath("//p[contains(@class,'MainDetailHistoryTicket_name')]");
    private final By cinemaNameDetail = By.xpath("//body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[4]//p");
    private final By screenNameDetail = By.xpath("//body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[5]/div[1]/p");
    private final By dateDetail = By.xpath("//div[@class='MainDetailHistoryTicket_col_2__mCU_t']//div[2]//p[1]");
    private final By timeDetail = By.xpath("//div[@class='MainDetailHistoryTicket_col_2__mCU_t']//div[1]//p[1]");

    private final By historyTicketTaskBar = By.xpath("//p[@class='SideBarProfile_text__j7Tl2'][contains(text(),'Lịch sử mua vé')]");
    private final By titleHistoryTicket = By.xpath("//span[@class='Breadcrumb_item__J6iQM Breadcrumb_last__Z2dvW']");

    private By statusList = By.xpath("//table/tbody/tr");
    private By status = By.xpath("./td[5]");
    private By detailOrder = By.xpath("./td[6]//a");


    public boolean verifyUrl() {
        return driver.getCurrentUrl().contains(url);
    }

    public void ViewMyTicket() throws InterruptedException {
        org.testng.Assert.assertTrue(verifyUrl(), "Không phải trang My Ticket");
        Thread.sleep(3000);
        String message_actual_movie1 = driver.findElement(ticketMovieName).getText();
        String message_actual_cinema1 = driver.findElement(ticketCinemaName).getText();
        String message_actual_screen1 = driver.findElement(ticketScreenName).getText();
        String message_actual_date1 = driver.findElement(ticketDateName).getText();
        String message_actual_time1 = driver.findElement(ticketTimeName).getText();
        driver.findElement(viewHistoryPayBtn).click();
        Thread.sleep(2000);
        String message_actual_movie2 = driver.findElement(movieNameDetail).getText();
        Assert.assertEquals(message_actual_movie1, message_actual_movie2);

        String message_actual_cinema2 = driver.findElement(cinemaNameDetail).getText();
        Assert.assertEquals(message_actual_cinema1, message_actual_cinema2);

        String message_actual_screen2 = driver.findElement(screenNameDetail).getText();
        Assert.assertEquals(message_actual_screen1, message_actual_screen2);

        String message_actual_date2 = driver.findElement(dateDetail).getText();
        Assert.assertEquals(message_actual_date1, message_actual_date2);

        String message_actual_time2 = driver.findElement(timeDetail).getText();
        Assert.assertEquals(message_actual_time1, message_actual_time2);
    }

    public void ViewListHistoryTicket() throws InterruptedException {
        driver.findElement(historyTicketTaskBar).click();
        Thread.sleep(1000);
        String message_actual = driver.findElement(titleHistoryTicket).getText();
        Assert.assertEquals("Lịch sử mua vé", message_actual);
    }

    public void ViewFailPaymentOrderDetail() throws InterruptedException {
        List<WebElement> rows = driver.findElements(statusList);
        for (int i = 0; i < rows.size(); i++) {
            // Lấy lại danh sách hàng tại mỗi vòng lặp để đảm bảo cập nhật nếu DOM thay đổi
            rows = driver.findElements(statusList);
            WebElement row = rows.get(i);

            WebElement statusCell = row.findElement(status);
            String status = statusCell.getText().trim();

            if (status.equals("Thanh toán thất bại")) {
                WebElement detailButton = row.findElement(detailOrder);
                detailButton.click();
                Thread.sleep(5000);
                break;
            }
        }
    }

    public void ViewOrderDetailInvalid() throws InterruptedException {
        driver.findElement(historyTicketTaskBar).click();
        Thread.sleep(1000);
        driver.get("http://localhost:3030/history-ticket/9d97ada1-5f0a-4f0e-bc25-759812897b11XXX");
        Thread.sleep(3000);
        String message_actual = driver.findElement(movieNameDetail).getText();
        Assert.assertEquals("", message_actual);
    }


}
