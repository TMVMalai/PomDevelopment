package JavaTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {
	WebDriver driver;

	@BeforeClass
	public void initialization() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		WebElement text = driver.findElement(By.xpath("//a[text()='Sortable Data Tables']"));
		text.click();
	}

	@Test
	public void WebTablesCount() {
		List<WebElement> listHeader = driver.findElements(By.xpath("//table[@id='table1']//tr//th"));
		System.out.println(listHeader.size());
		int headers = listHeader.size();
		assertEquals(headers, 6);
	}

	@Test
	public void WebTable() {
		List<WebElement> listHeader = driver.findElements(By.xpath("//table[@id='table1']//tr//th"));
		for (WebElement element : listHeader) {
			System.out.println(element.getText());
		}
		assertTrue(true);
	}

	@Test
	public void WebRows() {
		List<WebElement> listRows = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
		System.out.println(listRows.size());
		int rows = listRows.size();
		assertEquals(rows, 4);
	}

	@Test
	public void TotalRows() {
		List<WebElement> listRows = driver.findElements(By.xpath("//tbody//tr"));
		System.out.println(listRows.size());
		int rows = listRows.size();
		assertEquals(rows, 8);
	}

	@Test
	public void RowsText() {
		List<WebElement> listRows = driver.findElements(By.xpath("//tr"));
		for (WebElement element : listRows) {
			List<WebElement> listText = driver.findElements(By.xpath("//td"));
			//WebScrapping
			for (WebElement data : listText) {
				System.out.println(data.getText());
			}
		}
	}
	@Test
	public void johnExsitornot() {
		WebElement john = driver.findElement(By.xpath("(//table[@id='table1']//tbody/tr)[1]"));
		String words = john.getText();
		System.out.println(words);
		for(String texts : words.split(" ")) {
			if(texts.contains("John")) {
				System.out.println(texts.contains("John"));
				assertEquals(texts,"John");
				System.out.println(texts);
				break;
			}
		}
	}

	@AfterClass
	public void driverClose() {
		System.out.println("Browser Terminated successfully");
		driver.close();
	}
}
