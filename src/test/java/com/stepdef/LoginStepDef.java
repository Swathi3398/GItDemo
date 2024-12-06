package com.stepdef;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.classes.HomePage;
import com.classes.LoginPage;
import com.parameters.ExcelCredentialReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDef {

	WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;

	//--------------------------------------------------------Scenario 1----------------------------------------//
	/*
	 * Created By: Shivks
	 * Reviewed By: Giri Joshi
	 * Motive: user should enter all the GitHub credentials and click on submit btn
	 */

	@Before(order =1)
	public void init()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Before(order = 2)
	public void init2()
	{
		System.out.println("Before 2");
	}

	@Given("User is on the GitHub login page")
	public void user_is_on_the_git_hub_login_page() throws FileNotFoundException, IOException {
		System.out.println("Given");

		//driver.get("https://github.com");
		homePage=new HomePage(driver);

		Properties properties=new Properties();
		properties.load(new FileInputStream("src/test/resources/git.configuration"));
		String urlVal=properties.getProperty("url");


		homePage.loadUrl(urlVal);
		driver.manage().window().maximize();
		loginPage=homePage.signInObjClickPF();


	}
	/*
	@When("User needs to enter username and password")
	public void user_needs_to_enter_username_and_password() {
	    System.out.println("When -1");
	    driver.findElement(By.id("login_field")).sendKeys("shivks");
	    driver.findElement(By.id("password")).sendKeys("shivks");

	}
	 */

	@When("User needs to enter {string} and {string}")
	public void user_needs_to_enter_and(String uname, String password) {
		System.out.println("When -1");
		//		    driver.findElement(By.id("login_field")).sendKeys(uname);
		//		    driver.findElement(By.id("password")).sendKeys(password);
		loginPage.unameInput(uname);
		loginPage.pwdInput(password);
	}


	@When("User clicks on submit button")
	public void user_clicks_on_submit_button() {
		System.out.println("When -2");
		//		driver.findElement(By.name("commit")).click();
		loginPage.commitClick();
	}
	@Then("User is on their GitHub account page")
	public void user_is_on_their_git_hub_account_page() {
		System.out.println("Then -1");
		System.out.println("User is on their account page");
		//Assert.assertTrue(false);

	}
	@Then("User gets email notification for successful login")
	public void user_gets_email_notification_for_successful_login() throws InterruptedException {
		System.out.println("Then -2");
		System.out.println("User got the email notification");

		Thread.sleep(3000);
		//driver.quit();
	}


	//--------------------------------------------------------Scenario 2----------------------------------------//
	/*
	 * Created By: Shivks
	 * Reviewed By: Giri Joshi
	 * Motive: user should enter all the GitHub credentials and click on submit btn
	 */


	@Then("User is on the same page")
	public void user_is_on_the_same_page() {
		String actual = driver.findElement(By.id("js-flash-container")).getText();
		// String expected = "Incorrect username or password.";
		//  Assert.assertEquals(expected, actual);
	}
	@Then("User gets forgot password link")
	public void user_gets_forgot_password_link() throws InterruptedException {
		//Forgot password?
		System.out.println("Getting forgot password link");
		WebElement element = driver.findElement(By.linkText("Forgot password?"));
		boolean res = element.isDisplayed();
		//Assert.assertTrue(res);

	}
	@When("User needs to get data from  {int} and {int}")
	public void user_needs_to_get_data_from_and(Integer sheetno, Integer rowno) throws IOException {
		ExcelCredentialReader er = new ExcelCredentialReader();
		String data[]=er.getMyCredentials(sheetno, rowno);

		loginPage.unameInput(data[0]);
		loginPage.pwdInput(data[1]);



	}


	@After
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}

}

