package MyFramework.Hybrid;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;
//--
import org.openqa.selenium.By;
//--
import org.openqa.selenium.WebDriver;
//--
import org.openqa.selenium.WebElement;
//--
import org.openqa.selenium.firefox.FirefoxDriver;
//--
import org.testng.Assert;
//--
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
//--
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
//--
import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class GoogleHomePage {

	private WebDriver driver;		
	@Test				
	public void testEasy() {	
		driver.get("http://www.google.com");  
		String title = driver.getTitle();
		System.out.printf("This is Failed testing - checking wrong title -Google", title);
		AssertJUnit.assertTrue(title.contains("Google")); 		
	}
	
	@BeforeTest
	public void beforeTest() {	
	    driver = new FirefoxDriver();  
	}		
	@AfterTest
	public void afterTest() {
		//driver.close();
		driver.quit();			
	}		
	
	
	  
	}


