package com.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.classes.LoginPage;

public class FunctionalityTest  extends BaseTest{
	LoginPage loginPage;

	/*------------------------------------- TestCase 1------------------------------------------------------
	 * Created By: Shivks
	 * Reviewed By: Giri Joshi
	 * Motive : Load GitHub HomePage and navigate to loginPage
-----------------------------------------------------------------------------------------*/	
	
	@Test
	public void homePageFunctionality()
	{
		loginPage=homePage.signInObjClickPF();
		try {
			loginPage.tearDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	/*------------------------------------- Testcase 2------------------------------------------------------
	 * Created By: Medha Joshi
	 * Reviewed By: Giri Joshi
	 * Motive : Load GitHub HomePage and navigate to loginPage and test login functionality
-----------------------------------------------------------------------------------------*/	
	
	@Test
	@Parameters({"uname","pwd"})
	public void loginFunctionality(String uname,String pwd)
	{
		loginPage=homePage.signInObjClickPF();
		loginPage.unameInput(uname);
		loginPage.pwdInput(pwd);
		loginPage.commitClick();
		try {
			loginPage.tearDown();
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		
	}
	
	
	@Test(dataProvider = "credDP")
	public void loginFunctionalityDP(String uname,String pwd)
	{
		loginPage=homePage.signInObjClickPF();
		loginPage.unameInput(uname);
		loginPage.pwdInput(pwd);
		loginPage.commitClick();
		try {
			loginPage.tearDown();
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		
	}
	
	@DataProvider(name="credDP")
	public Object[][] dataProviderLogin()
	{
		Object[][] data= {{"raj","raj@123"},{"giri","giri@123"},{"hari","hari@123"}};
		return data;
	}
	
	@DataProvider(name="credDP")
	public Object[][] dataProviderLogin1()
	{
		Object[][] data= {{"raj","raj@123"},{"giri","giri@123"},{"hari","hari@123"}};
		return data;
	}
}
