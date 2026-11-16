package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.MyaccountPage;
import testBase.BaseClass;

public class TC002LoginTest extends BaseClass{
	@Test(groups = {"regression","master"})
	public void verifyLoginID()
	{
		
		logger.info(".................TC002 Verify login started..................");
		
		try 
		{
			
		HomePage hp = new HomePage(driver);
		logger.info("clicked myaccount link");
		hp.clickMyaccount();
		
		logger.info("clicked loginpage link");
		hp.clickLoginPage();
		
		logger.info("login page opened");
		LoginPage lp = new LoginPage(driver);
		
		lp.LgmailID(p.getProperty("mail"));
		logger.info("email entered on email filed");
		lp.LpassId(p.getProperty("pass"));
		logger.info("password entered on password filed");
		lp.clickLoginButton();
		logger.info("login button clicked");
		
		
		MyaccountPage ap = new MyaccountPage(driver);	
		
		boolean tPage = ap.isMyaccoundHeading();
		
		Assert.assertEquals(tPage, true);
		
		
		
	   }
	catch(Exception e)
		{
		 
		   Assert.fail();
		
		}
	
		logger.info(".................TC002 Verify login Finished..................");
		
	}
		
	
		
}