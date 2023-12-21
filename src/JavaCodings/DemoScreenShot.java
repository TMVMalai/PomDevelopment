package JavaCodings;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoScreenShot {

	@Test
	public void screenShot() throws InterruptedException, IOException {
WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();

		//maximize window
		driver.manage().window().maximize();
		//delete cookies
		driver.manage().deleteAllCookies();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Thread.sleep(2000);
		//Select the target element
		WebElement usernameField=driver.findElement(By.xpath("//input[@name='username']"));
		
		usernameField.sendKeys("Admin");
		
		WebElement passwordField=driver.findElement(By.xpath("//input[@name='password']"));
		passwordField.sendKeys("admin123");
		
		WebElement buttonField=driver.findElement(By.tagName("button"));
		buttonField.click();
		
		Thread.sleep(5000);
		
		//capture screenshot of the page
		TakesScreenshot tk=(TakesScreenshot) driver;
		File f=tk.getScreenshotAs(OutputType.FILE);
		File f1=new File("* /Users/thirumalaivasanperumal/eclipse-workspace/PomDevelopment\n");
		FileUtils.copyFile(f,f1);
		System.out.println("Screenshot captured successfully....");
		System.out.println("Screenshot captured successfully....");
	}
}
