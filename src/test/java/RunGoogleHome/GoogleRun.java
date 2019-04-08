package RunGoogleHome;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.*;

public class GoogleRun {  
	
	private WebDriver driver;
	public  String  result;

@BeforeClass
public void beforeClass() {
    driver = new ChromeDriver();
}

@AfterClass
public void afterClass() {
    driver.quit();
}
	@Test
	void Testcase1() {

    driver.get("http://www.floraindia.com");

    driver.findElement(By.id("search")).sendKeys("Red");

    driver.findElement(By.xpath("//input[@src='images/go.gif']")).click();

    String result = driver.findElement(By.xpath("//font[text()='Total Items  :']//following::td[1]")).getText();



Assert.assertEquals(result, "115");

    }

   

    @Test

void Testcase2() {

    driver.get("http://www.floraindia.com");

    driver.findElement(By.id("kwsch")).sendKeys("Blue");

    driver.findElement(By.xpath("//input[@src='images/go.gif']")).click();

    String   result = driver.findElement(By.xpath("//font[text()='Total Items  :']//following::td[1]")).getText();

    Assert.assertEquals(result, "13");

     }

    @Test

void Testcase3() {

    driver.get("http://www.floraindia.com");

    driver.findElement(By.id("kwsch")).sendKeys("Yellow");

    driver.findElement(By.xpath("//input[@src='images/go.gif']")).click();

    String  result = driver.findElement(By.xpath("//font[text()='Total Items  :']//following::td[1]")).getText();

    Assert.assertEquals(result, "27");

     }

    @Test

void Testcase4() {

    driver.get("http://www.floraindia.com");

    driver.findElement(By.id("kwsch")).sendKeys("Purple");

    driver.findElement(By.xpath("//input[@src='images/go.gif']")).click();

    result = driver.findElement(By.xpath("//font[text()='Total Items  :']//following::td[1]")).getText();

    Assert.assertEquals(result, "10");

     }
}
