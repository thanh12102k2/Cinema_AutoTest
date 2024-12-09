package cinema.base;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseSetup {
    static String driverPath = "C:\\\\Webdriver\\\\";
    private WebDriver driver;

    public WebDriver getDriver() { return driver; }

    private void setDriver(String browserType, String webURL) {
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver(webURL);
                break;
            case "firefox":
                driver = initFirefoxDriver(webURL);
                break;
            case "edge":
                driver = initEdgeDriver(webURL);
                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid. Launching Chrome as default browser...");
                driver = initChromeDriver(webURL);
        }
    }

    private WebDriver initChromeDriver(String webURL) {
        System.out.println("Launching Chrome browser...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(webURL);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    private WebDriver initFirefoxDriver(String webURL) {
        System.out.println("Launching Firefox browser...");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(webURL);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    private WebDriver initEdgeDriver(String webURL) {
        System.out.println("Launching Edge browser...");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(webURL);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    @Parameters({"browserType" , "webURL"})
    @BeforeClass
    public void initializeTestBaseSetup(String browserType,String webURL) {
        try {
            setDriver(browserType, webURL);
        } catch (Exception e) {
            System.out.println("Error: " + e.getStackTrace());
        }
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
            driver.quit();
    }
}
