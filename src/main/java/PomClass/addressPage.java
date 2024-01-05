package PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addressPage {

	public WebDriver driver;

	public addressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='/addressform']")
	private WebElement addAddressForm;

	@FindBy(xpath = "//strong[text()='LOveBirds']/../../..//input")
	private WebElement lovwebirdAddress;

	@FindBy(xpath = "//button[text()='Proceed']")
	private WebElement procedButton;

	public WebElement getProcedButton() {
		return procedButton;
	}

	public WebElement getLovwebirdAddress() {
		return lovwebirdAddress;
	}

	public WebElement getAddAddressForm() {
		return addAddressForm;
	}

}
