// Suraweera S.M.H.M. | used xpaths

package testGmail;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class TestGmail {
	
	WebDriver driver = null;
	String geckoDriverPath = "C:/Program Files/geckodriver-v0.29.1-win64/geckodriver.exe";
	String baseUrl = "https:///google.com/";
	String searchFor =  "Gmail";
	String username = "seleniumtesting870@gmail.com";
	String password = "KFJcdU3XEj2hEQj";
	String expectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
	
	//Start the Firefox browser
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", geckoDriverPath);
		driver = new FirefoxDriver();
	}
	
	//Navigate to google.com and search for "Gmail"
	@Test(priority = 0)
	public void searchForEbay() throws InterruptedException {
		driver.navigate().to(baseUrl);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".gLFyf")).sendKeys(searchFor);
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).click();
	}
	
	//Go to Sign In page, set username and passoword and click the  "Sign In" button
	@Test(priority = 1)
	public void tryToSignIn() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".eKjLze > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > h3:nth-child(2)")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".header__aside__nav > li:nth-child(2) > a:nth-child(1)")).click();
		
		
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(username);
		driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf' and  @type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b']")).click();
		
	}
	
	//Compare the actual title of the page with the expected title
	@Test(priority=2)
	public void verifyPageTitle() throws InterruptedException {
		
		Thread.sleep(3000);
		String actualTitle = driver.getTitle();
		assertTrue(actualTitle.contains(username));
		
	}

}
