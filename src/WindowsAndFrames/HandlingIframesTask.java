package WindowsAndFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingIframesTask {
	WebDriver driver;
	@BeforeClass
	public void initialization() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://the-internet.herokuapp.com/iframe");
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
	}
	
	@Test
	public void handlingiframe() {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
		driver.switchTo().frame(iframe);
		WebElement textarea = driver.findElement(By.tagName("p"));
		textarea.clear();
		textarea.sendKeys("Hello People");
	}
	@AfterClass
	public void driverclose() {
		System.out.println("Browser Terminated Successfully");
		driver.close();
	}

}
