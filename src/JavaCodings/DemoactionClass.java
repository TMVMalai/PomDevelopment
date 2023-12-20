package JavaCodings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoactionClass {
	@Test
	public  void main() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();

		//maximize window
		driver.manage().window().maximize();
		//delete cookies
		driver.manage().deleteAllCookies();
		
//		driver.get("https://www.guvi.in/");
		driver.get("https://www.amazon.com/");

	
//		WebElement loginfield=driver.findElement(By.linkText("Login"));
		
		//create an object of Actions class
		
//        Actions actions=new Actions(driver);
//        actions.click(loginfield).build().perform();
//        Thread.sleep(5000);
		
		
		//locate an element
		WebElement hoversignelement=driver.findElement(By.id("nav-link-accountList"));
		Actions actions=new Actions(driver);
		actions.moveToElement(hoversignelement).build().perform();
        Thread.sleep(2000);
//        driver.close();
	}

}
