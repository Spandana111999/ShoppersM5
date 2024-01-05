package PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	private WebElement emailTextField;

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	@FindBy(id = "Password")
	private WebElement PasswordTextField;

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	@FindBy(id = "Login")
	private WebElement LoginButton;

	public WebElement getLoginButton() {
		return LoginButton;
	}
}
