package com.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class HomePage extends BasePage{
	//Object Repository
By signInObj = By.linkText("Sign in");
By gitLogoObj= By.xpath("//a[@class='mr-lg-3 color-fg-inherit flex-order-2 js-prevent-focus-on-mobile-nav']");
By textObj=By.xpath("//h1[@class='h0-mktg mb-3 position-relative z-2']");

//==============================================
	
@FindBy(linkText="Sign in")
WebElement signInELe;


//==================================
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	public LoginPage signInObjClick()
	{
		LoginPage loginPage=new LoginPage(driver);
		driver.findElement(signInObj).click();
		return loginPage;
	}
	
	public LoginPage signInObjClickPF()
	{
		LoginPage loginPage=new LoginPage(driver);
		signInELe.click();
		return loginPage;
	}
	
	public void validateLogo()
	{
		WebElement element = driver.findElement(gitLogoObj);
		if(element.isDisplayed())
		{
			System.out.println("Logo displayed");
		}
		else
		{
			System.out.println("Logo not displayed");
		}
	}
}
