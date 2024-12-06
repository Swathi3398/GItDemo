package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",glue = "com.stepdef",
plugin = {"pretty:target/pretty.txt",
		"json:target/cucumber.json",
		"junit:target/cucumber.xml",
		"usage:target/usage.json",
		"html:target/index.html",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
dryRun = false,
monochrome = true)
public class TestRunner {
	//	WebDriver driver;	
	//	HomePage homePage;
	//	LoginPage loginPage;
	//	
	//	public TestRunner()
	//	{
	//		WebDriverManager.chromedriver().setup();
	//		driver = new ChromeDriver();
	//	}

	//	public void LoginTest() throws InterruptedException
	//	{
	//		homePage=new HomePage(driver);
	//		homePage.loadUrl("https://github.com/");
	//		loginPage=homePage.signInObjClick();
	//		loginPage.unameInput("MedhaJoshi15");
	//		loginPage.pwdInput("Medha@123");
	//		loginPage.commitClick();
	//		loginPage.tearDown();
	//		
	//	}
	/*
	@Test
	public void test() throws InterruptedException, FileNotFoundException, IOException
	{
		WebDriver driver;	
		HomePage homePage;
		LoginPage loginPage;

		Properties properties=new Properties();
		properties.load(new FileInputStream("src/test/resources/git.configuration"));
		String urlVal=properties.getProperty("url");
		String uname=properties.getProperty("uname");
		String pwd=properties.getProperty("pwd");
		String broswerName=properties.getProperty("browser");
		switch(broswerName.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
		}

		homePage=new HomePage(driver);
		//homePage.loadUrl("https://github.com/");
		homePage.loadUrl(urlVal);
		loginPage=homePage.signInObjClick();
//		loginPage.unameInput("MedhaJoshi15");
//		loginPage.pwdInput("Medha@123");
		loginPage.unameInput(uname);
		loginPage.pwdInput(pwd);
		loginPage.commitClick();
		loginPage.tearDown();

//		TestRunner runner = new TestRunner();
//		runner.LoginTest();

	}

//	public static void main(String[] args) throws InterruptedException {
//		
//		WebDriver driver;	
//	HomePage homePage;
//	LoginPage loginPage;
//	WebDriverManager.chromedriver().setup();
//	driver = new ChromeDriver();
//	homePage=new HomePage(driver);
//	homePage.loadUrl("https://github.com/");
//	loginPage=homePage.signInObjClick();
//	loginPage.unameInput("MedhaJoshi15");
//	loginPage.pwdInput("Medha@123");
//	loginPage.commitClick();
//	loginPage.tearDown();
//		
//	}
	 */
}
