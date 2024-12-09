package cinema.pages.client;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BookTicketPage {
    WebDriver driver;
    private String DashboardUrl = "http://localhost:3030/";

    private By cinemaTaskBar = By.xpath("//a[@class='NavItem_nav__GF4M8'][contains(text(),'Rạp chiếu')]");
    private By bookTicketDayWithCinema = By.xpath("//div[contains(@class, 'MainPageCinema_item_time')][2]"); // thay sst bằng ngày có xuất chiếu
    private By bookTicketTimeWithCinema = By.xpath("(//div[contains(@class, 'BookingMovie_time')][1])[1]");

    private By showtimeTaskBar = By.xpath("//p[contains(text(),'Lịch chiếu')]");
    private By movieShowingTaskBar = By.xpath("//a[@class='NavItem_link__Va1_b'][contains(text(),'Phim đang chiếu')]");
    private By movie = By.xpath("(//p[contains(@class, 'MoviePreview_name')])[1]");
    private By movieDetailName = By.xpath("//h4[@class='InfoDetailMovie_name___t8NC']");
    private By bookTicketDayWithMovie = By.xpath("//div[contains(@class, 'BookingMovieTicket_item_time')][2]"); // thay sst bằng ngày có xuất chiếu
    private By bookTicketTimeWithMovie = By.xpath("(//div[@class='BookingCinema_time__tXi7Q'])[1]");

    private By normalSeat = By.xpath("(//div[contains(@class, 'Seats_seat_item')][1])[2]");
    private By vipSeat = By.xpath("(//div[contains(@class, 'Seats_seat_item')][2])[5]");
    private By coupleSeat = By.xpath("(//div[contains(@class, 'Seats_seat_item')][2])[9]");

    private By normalSeat2 = By.xpath("(//div[contains(@class, 'Seats_seat_item')][2])[1]");
    private By normalSeat3 = By.xpath("(//div[contains(@class, 'Seats_seat_item')][3])[1]");
    private By normalSeat4 = By.xpath("(//div[contains(@class, 'Seats_seat_item')][4])[1]");
    private By normalSeat5 = By.xpath("(//div[contains(@class, 'Seats_seat_item')][5])[1]");
    private By normalSeat6 = By.xpath("(//div[contains(@class, 'Seats_seat_item')][6])[1]");
    private By notif = By.xpath("//div[@role='alert']");

    private By buyTicketBtn = By.xpath("//div[@class='Button_text__FcN3u']");
    private By addCombo = By.xpath("(//div[contains(@class, 'ComboPopcornDrink_btn_control')][2])[1]");
    private By BuyCombo = By.xpath("//div[contains(text(),'Tiếp tục')]");
    private By finishBtn = By.xpath("//div[@class='Button_text__FcN3u']");
    private By couponDropdown = By.xpath("//div[@class='MainTicketPreview_select__TJsz9']");
    private By coupon_2 = By.xpath("//p[normalize-space()='VNPAYNEW20']");
    private By paymentBank = By.xpath("//body/div[@class='main main-layout-sm']/div[@class='main-wrap']/div[@class='main-inner main-inner-page']/div[@class='box box-main']/div[@class='box__body ubg-porcelain-light']/form/div[@class='pv32 box-section']/div[@class='list-mb24 list-crop']/div[@id='accordionList']/div[2]/div[1]/div[1]/div[1]");
    private By searchBank = By.xpath("//input[@id='searchPayMethod2']");
    private By bank = By.xpath("//button[@id='NCB']//div[@class='list-bank-item-inner']");
    private By cardNumber = By.id("card_number_mask");
    private By cardHolder = By.id("cardHolder");
    private By cardDate = By.id("cardDate");
    private By continuePayment = By.id("btnContinue");
    private By cancelPayment = By.xpath("//a[@data-bs-target='#modalCancelPayment']");
    private By confirmCancel = By.xpath("//span[contains(text(),'Xác nhận hủy')]");
    private By submitClause = By.xpath("//span[contains(text(),'Đồng ý & Tiếp tục')]");
    private By otpInput = By.id("otpvalue");
    private By submitPayment = By.xpath("//span[normalize-space()='Thanh toán']");
    private By paymentMessAccess = By.xpath("//p[normalize-space()='Thanh toán thành công']");
    private By paymentMessCancel = By.xpath("//p[normalize-space()='Thanh toán không thành công']");
    private By paymentMessErro = By.id("lb_message_error");


    public BookTicketPage(WebDriver driver) {
        this.driver = driver;
    }

    public void bookTicketWithCinema() throws InterruptedException {
        driver.get(DashboardUrl);
        Thread.sleep(3000);
        driver.findElement(cinemaTaskBar).click();
        Thread.sleep(1000);
        driver.findElement(bookTicketDayWithCinema).click();
        Thread.sleep(1000);
        driver.findElement(bookTicketTimeWithCinema).click();
        Thread.sleep(1000);
        payment("9704198526191432198","NGUYEN VAN A","07/15");
        Thread.sleep(1000);
        driver.findElement(otpInput).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(submitPayment).click();
        Thread.sleep(3000);
        String message_actual_payment = driver.findElement(paymentMessAccess).getText();
        Assert.assertEquals("Thanh toán thành công", message_actual_payment);
    }

    public void bookTicketWithMovie() throws InterruptedException {
        driver.get(DashboardUrl);
        Thread.sleep(3000);
        driver.findElement(showtimeTaskBar).click();
        Thread.sleep(1000);
        driver.findElement(movieShowingTaskBar).click();
        Thread.sleep(3000);
        String text_title = driver.findElement(movie).getText();;
        driver.findElement(movie).click();
        Thread.sleep(3000);
        String message_actual = driver.findElement(movieDetailName).getText();
        Assert.assertEquals(text_title, message_actual);
        Thread.sleep(1000);
        driver.findElement(bookTicketDayWithMovie).click();
        Thread.sleep(1000);
        driver.findElement(bookTicketTimeWithMovie).click();
        Thread.sleep(1000);
        payment("9704198526191432198","NGUYEN VAN A","07/15");
        Thread.sleep(1000);
        driver.findElement(otpInput).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(submitPayment).click();
        Thread.sleep(3000);
        String message_actual_payment = driver.findElement(paymentMessAccess).getText();
        Assert.assertEquals("Thanh toán thành công", message_actual_payment);
    }

    public void insufficientBalance() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(cinemaTaskBar).click();
        Thread.sleep(1000);
        driver.findElement(bookTicketDayWithCinema).click();
        Thread.sleep(1000);
        driver.findElement(bookTicketTimeWithCinema).click();
        Thread.sleep(1000);
        payment("9704195798459170488","NGUYEN VAN A","07/15");
        Thread.sleep(2000);
        String message_actual_payment = driver.findElement(paymentMessErro).getText();
        Assert.assertEquals("Tài khoản của khách hàng không đủ số dư để thực hiện giao dịch", message_actual_payment);
        Thread.sleep(1000);
        driver.findElement(cancelPayment).click();
        Thread.sleep(1000);
        driver.findElement(confirmCancel).click();
        Thread.sleep(5000);
        String message_actual = driver.findElement(paymentMessCancel).getText();
        Assert.assertEquals("Thanh toán không thành công", message_actual);
    }

    public void BookTicketMaxSeat() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(cinemaTaskBar).click();
        Thread.sleep(1000);
        driver.findElement(bookTicketDayWithCinema).click();
        Thread.sleep(1000);
        driver.findElement(bookTicketTimeWithCinema).click();
        Thread.sleep(1000);
        driver.findElement(normalSeat).click();
        Thread.sleep(500);
        driver.findElement(vipSeat).click();
        Thread.sleep(500);
        driver.findElement(coupleSeat).click();
        Thread.sleep(500);
        driver.findElement(normalSeat2).click();
        Thread.sleep(500);
        driver.findElement(normalSeat3).click();
        Thread.sleep(500);
        driver.findElement(normalSeat4).click();
        Thread.sleep(500);
        driver.findElement(normalSeat5).click();
        Thread.sleep(500);
        driver.findElement(normalSeat6).click();
        Thread.sleep(500);
        String message_actual = driver.findElement(notif).getText();
        Assert.assertEquals("Bạn chỉ có thể chọn tối đa 8 ghế.", message_actual);
    }

    public void payment(String cardNumberValue, String cardHolderValue, String cardDateValue ) throws InterruptedException {
        driver.findElement(normalSeat).click();
        Thread.sleep(500);
        driver.findElement(vipSeat).click();
        Thread.sleep(500);
        driver.findElement(coupleSeat).click();
        Thread.sleep(500);
        driver.findElement(buyTicketBtn).click();
        Thread.sleep(1000);
        driver.findElement(addCombo).click();
        Thread.sleep(1000);
        driver.findElement(BuyCombo).click();
        Thread.sleep(1000);
        driver.findElement(couponDropdown).click();
        Thread.sleep(1000);
//        driver.findElement(coupon_2).click();
//        Thread.sleep(1000);
//        Mỗi tài khoản chỉ dùng được 1 lần mỗi loại coupon
        driver.findElement(finishBtn).click();
        Thread.sleep(2000);
        driver.findElement(paymentBank).click();
        Thread.sleep(1000);
        driver.findElement(searchBank).sendKeys("NCB");
        Thread.sleep(1000);
        driver.findElement(bank).click();
        Thread.sleep(2000);
        driver.findElement(cardNumber).sendKeys(cardNumberValue);
        Thread.sleep(1000);
        driver.findElement(cardHolder).sendKeys(cardHolderValue);
        Thread.sleep(1000);
        driver.findElement(cardDate).sendKeys(cardDateValue);
        Thread.sleep(1000);
        driver.findElement(continuePayment).click();
        Thread.sleep(1000);
        driver.findElement(submitClause).click();
    }
}
