package JavaCodings;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownClass {
	WebDriver driver;
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
		  //create an object of Select Class
		  Select dropdown=new Select(selectcurrency);
		  dropdown.selectByIndex(3);
		  System.out.println(dropdown.getFirstSelectedOption().getText());//USD
		  System.out.println(dropdown.isMultiple());
		  Thread.sleep(2000);
	  }
	  
	  @Test
	  public void m2() throws InterruptedException {
		  WebElement selectcurrency=driver.findElement(By.xpath("(//div/select)[3]"));
		//create an object of Select Class
		  Select dropdown=new Select(selectcurrency);
		  dropdown.selectByValue("INR");
		  System.out.println(dropdown.getFirstSelectedOption().getText());//INR
		  Thread.sleep(2000);


	  }
	  
	  
	  @Test 
	  public void m3() throws InterruptedException {
		  WebElement selectcurrency=driver.findElement(By.xpath("(//div/select)[3]"));
		//create an object of Select Class
		  Select dropdown=new Select(selectcurrency);
		  dropdown.selectByVisibleText("AED");
		  System.out.println(dropdown.getFirstSelectedOption().getText());//AED
		  Thread.sleep(2000);
	  }
	  
	  
	  @Test
	  public void m4() throws InterruptedException {
		  WebElement selectcurrency=driver.findElement(By.xpath("(//div/select)[3]"));
			//create an object of Select Class
			  Select dropdown=new Select(selectcurrency);
			  dropdown.selectByIndex(2);
//			  dropdown.deselectByIndex(2);
			  dropdown.selectByVisibleText("INR");
			  System.out.println(dropdown.getFirstSelectedOption().getText());//AED
			  Thread.sleep(2000);
	  }
	  
	  
	  @Test
	  public void m5_1adult() {
		  WebElement elementpassengerid=driver.findElement(By.id("divpaxinfo"));
//		  System.out.println(elementpassengerid.getText());
		  String result=elementpassengerid.getText();
		  assertEquals(result, "1 Adult");
		  
	  }
	  
	  @Test
	  public void m6_not_1adult() {
		  WebElement elementpassengerid=driver.findElement(By.id("divpaxinfo"));
//		  System.out.println(elementpassengerid.getText());
		  String result=elementpassengerid.getText();
		  assertNotEquals(result, "2 Adult");
		  
	  }
	  
	  @Test 
	  public void m7_passenger_Selection() throws InterruptedException {
		  WebElement elementpassengerid=driver.findElement(By.id("divpaxinfo"));
		  elementpassengerid.click();  
		  //code reduction using looping mechanism
		  //will select 5 passenger and display that passenger
		  Thread.sleep(2000);
		  int counter=1;
		  while(counter<=4) {
			  WebElement elementplusbtn=driver.findElement(By.id("hrefIncAdt"));
			  elementplusbtn.click();
			  counter++;
		  }
		  Thread.sleep(3000);
		  String result=elementpassengerid.getText();//5 Adult
		  assertEquals(result, "5 Adult");  
	  }
	  
	  
	  @AfterClass
		public void terminatebrowser() {
	       System.out.println("Browser terminated successfully");
	       driver.close();
		}
}
