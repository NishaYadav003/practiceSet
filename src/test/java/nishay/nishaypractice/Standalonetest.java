package nishay.nishaypractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Standalonetest {

	@Test
    public void testShoppingFlow() throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		String email = "nisamisa@xyz.com";
		String pass = "Nisa123!@";

		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.id("userPassword")).sendKeys(pass);
		driver.findElement(By.id("login")).click();

		List<WebElement> element = driver.findElements(By.cssSelector(".mb-3"));

		WebElement names = element.stream().filter(
				elements -> elements.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("Adidas original"))
				.findFirst().orElse(null);

		names.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		Assert.assertTrue(true);

		String number = "02";

		List<WebElement> el2 = driver.findElements(By.xpath("//ul//label"));

		System.out.println(el2.stream().count());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#ng-animating")));

		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

		driver.findElement(By.xpath("//ul//button[@type='button']")).click();

		Thread.sleep(2000);
		
	WebElement dates=	driver.findElement(By.cssSelector(".input.ddl"));

	Select data= new Select(dates);
	
	data.selectByIndex(2);
	
	WebElement month= driver.findElement(By.cssSelector("select:nth-child(3)"));
	
	Select mon= new Select(month);
	
	mon.selectByIndex(0+17);
	
	String cvv="123";
	String name="Nisa Misa";
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[contains(text(),'CVV Code')]/following-sibling::input")).sendKeys(cvv);
	
	
	driver.findElement(By.xpath("//div[contains(text(),'Name on Card')]/following-sibling::input")).sendKeys(name);
	
		Actions date = new Actions(driver);
		
		date.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "Australia").build().perform();
		
		driver.findElement(By.cssSelector(".ta-results")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
		
		System.out.println(driver.findElement(By.id("toast-container")).getText());
		driver.quit();

	}

}
