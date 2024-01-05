package PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSettingPage {

	public WebDriver driver;

	// Initialization
	public AccountSettingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[name()='svg' and @data-testid='LogoutIcon']")
	private WebElement logoutIcon;

	public WebElement getLogOutIcon() { // getter
		return logoutIcon;
	}

	@FindBy(xpath = "//li[text()='My Profile']")
	private WebElement myProfileLink;

	public WebElement getMyProfileLink() {
		return myProfileLink;
	
	
	}
}	
	
	
	
	
	