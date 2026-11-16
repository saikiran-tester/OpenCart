package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.MyaccountPage;
import Utilities.DataProviders;
import testBase.BaseClass;

/*
Data is valid - login success - test pass - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail - logout
Data is invalid -- login failed - test pass */


public class TC003Datadriven_LoginPage extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass = DataProviders.class, groups = {"dataDriven"})
	public void verifyDatadrivenLogintest(String email, String pass, String exp)
	{
	
	try
	{
	
	logger.info(".................TC003 datadriven loginPage started..................");
	
	
		
	HomePage hp = new HomePage(driver);
	logger.info("clicked myaccount link");
	hp.clickMyaccount();
	
	logger.info("clicked loginpage link");
	hp.clickLoginPage();
	
	logger.info("login page opened");
	LoginPage lp = new LoginPage(driver);
	
	lp.LgmailID(email);
	logger.info("email entered on email filed");
	lp.LpassId(pass);
	logger.info("password entered on password filed");
	lp.clickLoginButton();
	logger.info("login button clicked");
	
	MyaccountPage ap = new MyaccountPage(driver);	
	
	boolean tPage = ap.isMyaccoundHeading();
	
	
	
	if(exp.equalsIgnoreCase("valid"))
	{
		if(tPage==true)
		{
			logger.info("my account page visible");
			Assert.assertTrue(true);
			ap.clickLogoutButton();
			logger.info("my account page logout");
	
		}
		
		else
		{
			logger.info("my account page not visible");
			Assert.assertTrue(false);
			logger.info("login page not login");
		}
	}
	
	if(exp.equalsIgnoreCase("invalid"))
	{
		
		if(tPage==true)
		{
			logger.info("my account page visible");
			ap.clickLogoutButton();
			logger.info("my account page logout");
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("login page not login due to invalid cred");
		}
	}
	
	}
	catch(Exception e)
	{
	 Assert.fail();
	}
	
	logger.info(".................TC003 datadriven loginPage finished..................");
}
}
