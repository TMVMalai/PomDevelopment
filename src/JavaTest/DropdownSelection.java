package JavaTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownSelection extends commonaction {
	
	@BeforeClass
	public void initialization() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();//launching driver
		driver.get("https://flightnewapp.netlify.app/lavish.com/dropdownspractise/");
		Thread.sleep(2000);
		//maximize window
		driver.manage().window().maximize();
		//delete cookies
		driver.manage().deleteAllCookies();
	}
	
	 @Test
	  public void m1() throws InterruptedException {
		  WebElement selectcurrency=driver.findElement(By.xpath("(//div/select)[3]"));
		  SelectDropdownFromVisibleText(selectcurrency,"INR");
		  SelectDropdownFromVisibleText(selectcurrency,"USD");
		 
		  
	  }

}
