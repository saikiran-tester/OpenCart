package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class accountRegistrationPage extends BasePage{
	
	
	public accountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstN;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastN;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement mailId;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement PassWord;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkdPolicy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement clicContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void fName(String Firstn)
	{
	      firstN.sendKeys(Firstn);
	}
	
	public void lName(String lastn)
	{
		lastN.sendKeys(lastn);
	}
	
	public void Gmail(String Id)
	{
		mailId.sendKeys(Id);
	}
	
	public void tPhone(String num)
	{
		txtTelephone.sendKeys(num);
	}
	
	public void pass(String pwd)
	{
		PassWord.sendKeys(pwd);
	}
	
	public void conPass(String Cpwd)
	{
		txtConfirmPassword.sendKeys(Cpwd);
	}
	
	public void policy()
	{
		chkdPolicy.click();
	}
	
	public void clickContinue()
	{
		
		clicContinue.click();
	}
	
	public String getConfirmation() {
	try
	{
		return(msgConfirmation.getText());
		
	}
	catch(Exception e)
	{
		return(e.getMessage());
	}
	}

}
