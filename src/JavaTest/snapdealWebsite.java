package JavaTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class snapdealWebsite {
	WebDriver driver;
	@BeforeClass
	public void initialization() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	@Test
	public void WebTablesCount() {
		WebElement signIn = driver.findElement(By.xpath("//span[text()='Sign In']"));
		signIn.click();
		WebElement newUserRegister = driver.findElement(By.xpath("//span[@class='newUserRegister']"));
		newUserRegister.click();
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys("testu4896@gmail.com");
		WebElement continuebutton = driver.findElement(By.xpath("//input[contains(@class,'clickOnceOnly')]"));
		continuebutton.click();
		WebElement accountUserName = driver.findElement(By.xpath("//span[contains(@class,'accountUserName')]"));
		String userName= accountUserName.getText();
		assertEquals(userName,"Test user");
	}

	@AfterClass
	public void driverClose() {
		System.out.println("Browser Terminated succeessfully");
		driver.close();
	}
}
