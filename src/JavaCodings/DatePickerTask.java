package JavaCodings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerTask {
	
	WebDriver driver;
	@BeforeClass
	public void initialization() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	@Test
	public void main() throws InterruptedException {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iframe);
		WebElement datepicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
		datepicker.click();
		WebElement clickNext = driver.findElement(By.xpath("//input[@id='datepicker']"));
		clickNext.click();
		selectDate("22");
		Thread.sleep(3000);
		}
	public void selectDate(String date) {
		WebElement selectDate = driver.findElement(By.xpath("//a[text()='"+date+"']"));
		selectDate.click();
	}
	@AfterClass
	public void driverClose() {
		System.out.println("Browser Terminated successfully");
		driver.close();
	}

}
