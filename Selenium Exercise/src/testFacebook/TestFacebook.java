// Suraweera S.M.H.M.

package testFacebook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestFacebook {
	
	
	WebDriver driver = null;
	String geckoDriverPath = "C:/Program Files/geckodriver-v0.29.1-win64/geckodriver.exe";
	String baseUrl = "https:///google.com/";
	String searchFor =  "Facebook";
	String username = "testtttt986@gmail.com";
	String password = "12345";
	String expectedTitle = "Facebook";
	
	//Start the Firefox browser
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", geckoDriverPath);
		driver = new FirefoxDriver();
	}
	
	//Navigate to google.com and search for "Facebook"
	@Test(priority=0)
	public void searchForFacebook() throws InterruptedException {
		
		driver.navigate().to(baseUrl);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".gLFyf")).sendKeys(searchFor);
		driver.findElement(By.cssSelector(".FPdoLc > center:nth-child(1) > input:nth-child(1)")).click();
	}
	
	//Set username and passoword and click the  "Sign In" button
	@Test(priority=1)
	public void tryToSignIn() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".eKjLze > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > h3:nth-child(2)")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#email")).sendKeys(username);
		driver.findElement(By.cssSelector("#pass")).sendKeys(password);
		driver.findElement(By.cssSelector("div._6ltg:nth-child(6)")).click();
	}
	
	//Compare the actual title of the page with the expected title
	@Test(priority=2)
	public void verifyPageTitle() throws InterruptedException {
		Thread.sleep(2000);
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
		
	}
	
	//close the browser
	@AfterTest
	public void terminateBrowser(){
		driver.close();
	}
	

}
