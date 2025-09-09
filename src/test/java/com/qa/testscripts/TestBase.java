package com.qa.testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;



public class TestBase 
{
	static WebDriver driver;
	JavascriptExecutor js;
	
	
	@BeforeTest
	 public void driverSet() 
	{
	Scanner sc = new Scanner(System.in);

	System.out.println(" Enter the driver name");

	String input = sc.nextLine();

	if(input.equalsIgnoreCase("chrome")) {

		driver = new ChromeDriver();

		}

	else {

		 driver = new FirefoxDriver();


		}
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
//	CitiBankPages CitiBankOR= CitiBankPage(driver);
//	TOR = new Tiffino_Register_Page(driver);
	
	js = (JavascriptExecutor) driver;
	
	
	}
	
	@AfterTest
	public void tearDown() 
	{
		//driver.quit();
		driver.close();
	}
	
	
	public void captureScreenShot(WebDriver driver,String tName) throws IOException {
	 TakesScreenshot ts = (TakesScreenshot)driver;
	 File src =ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/ScreenShots/"+tName+".png");
		FileUtils.copyFile(src, target);
	}
	
	

}
