// Suraweera S.M.H.M.

package testLinkedin;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class TestLinkedin {
	
	WebDriver driver = null;
	String geckoDriverPath = "C:/Program Files/geckodriver-v0.29.1-win64/geckodriver.exe";
	String baseUrl = "https:///google.com/";
	String searchFor =  "Linkedin";
	String username = "testgmaill6523@gmail.com";
	String password = "4576hdhdhfdQAty";
	String expectedTitle = "Feed | LinkedIn";
	
	//Start the Firefox browser
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", geckoDriverPath);
		driver = new FirefoxDriver();
	}
	
	//Navigate to google.com and search for "LinkedIn"
	@Test(priority = 0)
	public void tryToSignIn() throws InterruptedException {
		driver.navigate().to(baseUrl);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".gLFyf")).sendKeys(searchFor);
		driver.findElement(By.cssSelector(".FPdoLc > center:nth-child(1) > input:nth-child(1)")).click();
	}
	
	//Go to Sign In page, set username and passoword and click the  "Sign In" button
	@Test(priority = 1)
	public void signInToEbay() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".eKjLze > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > h3:nth-child(2)")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".nav__button-secondary")).click();
		
		
		driver.findElement(By.cssSelector("#username")).sendKeys(username);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		driver.findElement(By.cssSelector(".btn__primary--large")).click();
		
	}
	
	//Compare the actual title of the page with the expected title
	@Test(priority=2)
	public void verifyPageTitle() throws InterruptedException {
		
		Thread.sleep(3000);
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
		
	}

}
