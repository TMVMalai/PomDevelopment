package JavaTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class phpTravels {
	WebDriver driver;

	@BeforeClass
	public void initialization() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://phptravels.com/demo/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	@Test
	public void main() throws InterruptedException {
		WebElement firstname = driver.findElement(By.xpath("//input[@name='first_name']"));
		WebElement lastname = driver.findElement(By.xpath("//input[@name='last_name']"));
		WebElement businessName = driver.findElement(By.xpath("//input[@name='business_name']"));
		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement numb1 = driver.findElement(By.xpath("//span[@id='numb1']"));
		WebElement numb2 = driver.findElement(By.xpath("//span[@id='numb2']"));
		WebElement result = driver.findElement(By.xpath("//input[@id='number']"));
		WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
		String num1Text =numb1.getText();
		String num2Text =numb2.getText();
		int num1 = Integer.parseInt(num1Text);
		int num2 = Integer.parseInt(num2Text);
		int total = num1+num2;
		String strNumber3 = Integer.toString(total);
		firstname.sendKeys("Test");
		lastname.sendKeys("user");
		businessName.sendKeys("TestUser");
		email.sendKeys("testu4896@gmail.com");
		result.sendKeys(strNumber3);
		submit.click();
		Thread.sleep(3000);
	}
	@AfterClass
	public void driverClose() {
		System.out.println("Browser Terminated succeessfully");
		driver.close();
	}
}
