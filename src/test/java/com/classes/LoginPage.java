package com.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage  extends BasePage{
	//Object repository
	By unameObj = By.cssSelector("input[name='login']");
	By pwdObj = By.xpath("//input[@name='password']");
	By commitButton = By.name("commit");
	By forgotPasswordLink = By.linkText("Forgot password?");
	By invalidCredentialText=By.id("js-flash-container");
	
	//-----------------------------------------------------------------
	//Methods performing operation on the By objects(WebElement)
	public LoginPage(WebDriver driver) {
		super(driver);
	}
		
	public void unameInput(String uname)
	{
		 waitUntilWebElementIsVisibleByObj(unameObj);
		driver.findElement(unameObj).sendKeys(uname);
	}
	
	public void pwdInput(String pwd)
	{
		driver.findElement(pwdObj).sendKeys(pwd);
	}
	
	public void commitClick()
	{
		driver.findElement(commitButton).click();
	}

}
