package CrossBrowserTesting;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.html5.Utils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Cross_Browser_Testing
{
  WebDriver driver;
  
  @BeforeSuite
  @Parameters({"browser"})
  
  @BeforeTest
  public void openbrowser(String brow)
	  {
		  //System.out.println("Open Browser");
		  if(brow.equalsIgnoreCase("Chrome"))
		  {
			  System.setProperty("webdiver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
			  driver=new ChromeDriver();
		  }
		  else if(brow.equalsIgnoreCase("Firefox"))
		  {
			  System.setProperty("webdriver.gecko.driver", "C:\\Firefox Gecko driver\\geckodriver.exe");
			  driver=new FirefoxDriver();
		  }
	  System.out.println("Enter URL");
	  
   }
  
  @BeforeClass
  public void MaxBrowser()
  {
	  System.out.println("Maximize Browser");
	  driver.manage().window().maximize();
  }
  
  @BeforeMethod
  public void Getcookies()
  {
	  System.out.println("Get Cookies");
	  System.out.println("Get Cookies Updated");
  }
  
  @Test
  
  public void Ryde_Book() throws InterruptedException
  {
	  driver.get("https://www.redbus.in/");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//a[@id='Ryde']")).click();
	  Thread.sleep(2000);
  }
  
  @AfterMethod
  public void GetScreenshot() throws IOException
  {
	  System.out.println("Takes Screenshot");
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFileToDirectory(src,new File("C:\\Users\\sh\\eclipse-workspace\\Cross_Browser_Testing\\Screenshot"));
  }
  
  @AfterClass
  public void DeleteCookies()
  {
	  System.out.println("Delete Cookies");
  }
	
  @AfterTest
  public void DBConnectionClose()
  {
	  System.out.println("Database Connection close");
	  
  }
  
  @AfterSuite
  public void Close() 
  {
	  System.out.println("Close Test case execution");
  }
}
