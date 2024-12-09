package cinema.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import junit.framework.Assert;

public class ValidBase {
	private WebDriver driver;
	private WebDriverWait wait;
	private final int timeoutWaitForPageLoaded = 20;
	
	public ValidBase(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,5);
	} 
	
	public void setText(By element, String value) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		driver.findElement(element).clear();
		driver.findElement(element).sendKeys(value);
	}
	
	public void clickElement(By element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		driver.findElement(element).click();
	}
	
	public void selectOptionByText(By element, String text) {
		Select select = new Select(driver.findElement(element));
		select.selectByVisibleText(text);
	}
	
	public void selectOptionByValue(By element, String value) {
		Select select = new Select(driver.findElement(element));
		select.selectByValue(value); 
	}
	
	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("compelete");
			}
		} ;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeoutWaitForPageLoaded);
			wait.until(expectation);
		} catch (Throwable error) {
			org.testng.Assert.fail("Timeout waiting for Page Load request.");
		}
	}
}
