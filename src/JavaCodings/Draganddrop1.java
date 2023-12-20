package JavaCodings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Draganddrop1 {
	WebDriver driver;
	@BeforeClass
	public void initialization() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();//launching driver
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		Thread.sleep(2000);
		//maximize window
		driver.manage().window().maximize();
		//delete cookies
		driver.manage().deleteAllCookies();
	}
	
	
	@Test
	public void draganddrop() throws InterruptedException {
      WebElement drag=driver.findElement(By.id("draggable"));
      WebElement drop=driver.findElement(By.id("droppable"));
      //create an instance of Actions class
      Actions action=new Actions(driver);
//      action.dragAndDrop(drag, drop).build().perform();
      action.clickAndHold(drag).moveToElement(drop).release().perform();
      Thread.sleep(1000);
	}
	
	
	
	
	
	@AfterClass
	public void terminatebrowser() {
       System.out.println("Browser terminated successfully");
       driver.close();
	}

}
