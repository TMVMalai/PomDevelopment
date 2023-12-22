package JavaTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class commonaction {
	WebDriver driver;

	public String SelectDropdownFromVisibleText(WebElement Dropdown,String name) {
		//driver = TLDriverfactory.getTLDriver();
		Dropdown.click();
		driver.findElement(By.xpath("//span[text()='"+name+"']")).click();
		return name;
		
	}
	public String SelectDropdownFromVisibleTextSearch(WebElement Dropdown,String name) {
		Dropdown.click();
		Dropdown.sendKeys(name);
		driver.findElement(By.xpath("//span[text()='"+name+"']")).click();
		return name;
		
	}
	public void ScrollHorizontallyLeft(WebElement element) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView",element);
	}

}
