package com.qa.testscripts;

import org.testng.annotations.Test;

public class My_Test extends TestBase
{
	@Test(priority =1)
	public void LaunchBrowser() throws InterruptedException 
	{
		driver.get("https://www.google.com/");
		boolean contains = driver.getCurrentUrl().contains("https://www.google.com/");
		if(contains)
		{
			System.out.println("User is landed on Google Home Page");
		}
		else
		{
			System.out.println("User is not landed on Google Home Page");
		}
		
		Thread.sleep(2000);
		System.out.println("Title of the page : "+driver.getTitle());
		
	}

}
