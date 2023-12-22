package WindowsAndFrames;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrames {
	WebDriver driver;

	@BeforeClass
	public void initialization() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	@Test
	public void handlingiframe() {
		WebElement Frames = driver.findElement(By.xpath("//a[text()='Nested Frames']"));
		Frames.click();
		WebElement element = driver.findElement(By.xpath("//frame[@name='frame-top']"));
		driver.switchTo().frame(element);
		switchingFrames("LEFT");
		switchingFrames("MIDDLE");
		switchingFrames("RIGHT");
		switchingFrames("BOTTOM");
	}

	public void switchingFrames(String name) {
		WebElement switchframe = driver.findElement(By.xpath("//*[contains(text(),'" + name + "')]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(switchframe));
		String frameText = switchframe.getText();
		assertEquals(frameText, name);
	}

	@AfterClass
	public void driverclose() {
		System.out.println("Browser Terminated Successfully");
		driver.close();
	}

}
