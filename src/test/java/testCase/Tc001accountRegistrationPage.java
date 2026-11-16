package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.accountRegistrationPage;
import testBase.BaseClass;

public class Tc001accountRegistrationPage extends BaseClass{
	


	
	@Test(groups = {"sanity","master"})
	public void VerifyAccountRegistration()
	{
	
		try {
		logger.info("......................starting tc001 acountRegistrationPage.............");
		HomePage hp = new HomePage(driver);
		
		
		hp.clickMyaccount();
		logger.info("we clicked on my account link");
		
		hp.clickRegister();
		
		logger.info("we clicked on my register link");
	
		
		accountRegistrationPage rp = new accountRegistrationPage(driver);
		
		logger.info("providing customer details");
		rp.fName(radomString().toUpperCase());
		rp.lName(radomString().toUpperCase());
		rp.Gmail(radomString()+"@gmail.com");
		rp.tPhone(randomNumber());
		String PS = randomAlphaNumeric();
		rp.pass(PS);
		rp.conPass(PS);
		rp.policy();
		logger.info("user click continue button");
		rp.clickContinue();
		
		
		logger.info("Validating expected message");
		String confirmMsg = rp.getConfirmation();
		if(confirmMsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Test Failed");
			logger.debug("debug logs...");
			Assert.assertTrue(false);
		}
			
			
		//Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");
		
		}
		
		catch(Exception e)
		{
			
			
			Assert.fail();
		}
		
		logger.info("...............Finished Tc001 accountRegistrationPage.............");
	
	}
	
	

	

}
