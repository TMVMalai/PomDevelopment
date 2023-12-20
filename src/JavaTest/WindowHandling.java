package JavaTest;

import static org.testng.Assert.assertEquals;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {
	WebDriver driver;

	@BeforeClass
	public void initialization() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		WebElement text = driver.findElement(By.xpath("//a[text()='Multiple Windows']"));
		text.click();
	}

	@Test
	public void main() throws InterruptedException {
		String mainWindowHandle = driver.getWindowHandle();
		WebElement text = driver.findElement(By.xpath("//a[text()='Click Here']"));
		text.click();
		for (String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);
			String Url = driver.getCurrentUrl();
			System.out.println(Url);
		}
		WebElement newWindow = driver.findElement(By.xpath("//h3"));
		String windowText = newWindow.getText();
		assertEquals(windowText, "New Window");
		// driver.close();// close the instance of the current Tab
		// Switch back to the main window
		driver.switchTo().window(mainWindowHandle);
		Thread.sleep(3000);
	}

	@AfterClass
	public void driverClose() {
		System.out.println("Browser Terminated successfully");
		driver.close();
	}

}
