package com.testcases;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UsabilityTest extends BaseTest {

	@Test(invocationCount = 3)
	@Parameters({"uname","pwd"})
	public void loginFunctionality(@Optional("aaa") String uname,@Optional("aa@aa") String pwd)
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

}
