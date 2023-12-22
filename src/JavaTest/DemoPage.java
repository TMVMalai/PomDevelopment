package JavaTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoPage {
	WebDriver driver;
	public DemoPage() {
		PageFactory.initElements(driver, getClass());
	}
	@FindBy(xpath ="(//ul//li//button)[1]")
	public WebElement username;

}
