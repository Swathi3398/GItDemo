package com.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.classes.HomePage;
import com.classes.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected WebDriver driver;
	protected HomePage homePage;
	protected LoginPage loginPage;
	
	@BeforeMethod
	public void initT() throws FileNotFoundException, IOException
	{
		//cross browser -- from properties
		// switch case
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		
		Properties properties=new Properties();
			properties.load(new FileInputStream("src/test/resources/git.configuration"));
			String urlVal=properties.getProperty("url");
			driver.get(urlVal);
			
		driver.manage().window().maximize();
		homePage=new HomePage(driver);
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		try {
			Thread.sleep(3000);
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
