// Suraweera S.M.H.M.

package testEbay;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestEbay {
	
	WebDriver driver = null;
	String geckoDriverPath = "C:/Program Files/geckodriver-v0.29.1-win64/geckodriver.exe";
	String baseUrl = "https:///google.com/";
	String searchFor =  "Ebay";
	String username = "seleniumtesting870@gmail.com";
	String password = "KFJcdU3XEj2hEQj";
	String expectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
	
	//Start the Firefox browser
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", geckoDriverPath);
		driver = new FirefoxDriver();
	}
	
	//Navigate to google.com and search for "Ebay"
	@Test(priority = 0)
	public void tryToSignIn() throws InterruptedException {
		driver.navigate().to(baseUrl);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".gLFyf")).sendKeys(searchFor);
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).click();
	}
	
	//Go to Sign In page, set username and passoword and click the  "Sign In" button
	@Test(priority = 1)
	public void signInToEbay() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".eKjLze > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > h3:nth-child(2)")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#gh-ug > a:nth-child(1)")).click();
		
		//Thread sleep is set to 20 seconds because there is a chance to solve a captcha
		Thread.sleep(20000);
		
		driver.findElement(By.cssSelector("#userid")).sendKeys(username);
		driver.findElement(By.cssSelector("#signin-continue-btn")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("#pass")).sendKeys(password);
		driver.findElement(By.cssSelector("#sgnBt")).click();
		
	}
	
	//Compare the actual title of the page with the expected title
	@Test(priority=2)
	public void verifyPageTitle() throws InterruptedException {
		Thread.sleep(3000);
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
		
	}

}
