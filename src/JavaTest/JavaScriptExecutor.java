package JavaTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor extends commonaction {
	
	//WebDriver driver;
	@BeforeClass
	public void initialization() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
//	@Test
//	public void main() throws InterruptedException {
//		//WebElement google = driver.findElement(By.xpath("//textarea[@role='combobox']"));
//		//SelectDropdownFromVisibleTextSearch(google,"GUVI");
//	    driver.findElement(By.xpath("//span[contains(text(),'GUVI Zen Class Courses - Get')]")).click();
//		Thread.sleep(3000);
//		try {
//		JavascriptExecutor js =(JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,500)");
//		Thread.sleep(3000);
//	    js.executeScript("window.scrollBy(0,-500)");
//		js.executeScript("window.scrollTo(0,document.body.scrollHeight");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//	@Test
//	public void m2() {
//		RemoteWebDriver r = (RemoteWebDriver)driver; 
//		String objscroll = "window.scrollTo(0,document.body.scrollHeight)";
//		r.executeScript(objscroll);
//	}
	@Test
	public void javaScriptScroll() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		for(int i=0;i<5;i++) {
			js.executeScript("window.scrollBy(0,80)");
			//Thread.sleep(500);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10) );
		}
		Thread.sleep(3000);
		for(int i=0;i<5;i++) {
			js.executeScript("window.scrollBy(0,-80)");
			Thread.sleep(500);
		}
	}


}
