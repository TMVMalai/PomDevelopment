package JavaCodings;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import JavaTest.SeleniumLogger;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingAlerts extends SeleniumLogger{
	WebDriver driver;

	@BeforeClass
	public void initialization() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	@Test
	public void acceptAler() {
		WebElement clickAlert = driver.findElement(By.xpath("(//ul//li//button)[1]"));
		clickAlert.click();
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		alert.accept();
		if(message.equals("I am a JS Alert")) {
			logPassed(message);
		}
	}

	@Test
	public void dismissAler() {
		WebElement clickAlert = driver.findElement(By.xpath("(//ul//li//button)[1]"));
		clickAlert.click();
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		alert.dismiss();
		assertEquals(message, "I am a JS Alert");
	}

	@Test
	public void acceptConfirm() {
		WebElement clickAlert = driver.findElement(By.xpath("(//ul//li//button)[2]"));
		clickAlert.click();
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		alert.accept();
		assertEquals(message, "I am a JS Confirm");
	}

	@Test
	public void dismissConfirm() {
		WebElement clickAlert = driver.findElement(By.xpath("(//ul//li//button)[2]"));
		clickAlert.click();
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		alert.dismiss();
		assertEquals(message, "I am a JS Confirm");
	}

	@Test
	public void acceptPrompt() {
		WebElement clickAlert = driver.findElement(By.xpath("(//ul//li//button)[3]"));
		clickAlert.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("AcceptPrompt");
		String message = alert.getText();
		alert.accept();
		assertEquals(message, "I am a JS prompt");
	}

	@Test
	public void DismissPrompt() {
		WebElement clickAlert = driver.findElement(By.xpath("(//ul//li//button)[3]"));
		clickAlert.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("DismmisPrompt");
		String message = alert.getText();
		alert.dismiss();
		assertEquals(message, "I am a JS prompt");
	}

	@AfterClass
	public void driverClose() {
		System.out.println("Browser Terminated successfully");
		driver.close();
	}
}
