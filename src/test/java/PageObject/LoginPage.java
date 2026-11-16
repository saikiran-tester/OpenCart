package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage  {

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement GmailID;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement passID;
	@FindBy(xpath="//input[@value='Login']")
	WebElement lButton;
	
	
	public void LgmailID(String Mid)
	{
		GmailID.sendKeys(Mid);
	}
	
	public void LpassId(String pID)
	{
		passID.sendKeys(pID);
	}
	
	public void clickLoginButton()
	{
		lButton.click();
	}
	
	
}
