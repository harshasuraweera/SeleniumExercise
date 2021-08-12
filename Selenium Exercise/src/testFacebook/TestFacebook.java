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
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(searchFor);
		driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[@class='gNO89b']")).click();
	}
	
	//Set username and passoword and click the  "Sign In" button
	@Test(priority=1)
	public void tryToSignIn() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h3[@class='LC20lb DKV0Md' and contains(text(),'Facebook - Log In or Sign Up')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
		driver.findElement(By.xpath("//div[@class='_6ltg']/button")).click();
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
