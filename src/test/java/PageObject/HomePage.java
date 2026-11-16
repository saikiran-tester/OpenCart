package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement linkAccount;
	
	@FindBy(css = "a[href*='route=account/register']")
	WebElement linkRegister;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement loginLinkPage;
	
	
	
	public void clickMyaccount()
	{
		linkAccount.click();
	}
	
	public void clickRegister()
	{
		linkRegister.click();
		
	}
	
	public void clickLoginPage()
	{
		loginLinkPage.click();
	}
	
	
	
	
}
