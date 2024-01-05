package PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethod {
	
	public PaymentMethod(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Cash On Delivery (COD)']/preceding-sibling::span/input ")
	private WebElement cashOnDeliveryRadioButton;

	public WebElement getcashOnDeliveryRadioButton() { // getter
		return cashOnDeliveryRadioButton;

	}

	@FindBy(xpath = "//button[text()='Proceed']")
	private WebElement proceedButton;

	public WebElement getproceedButton() { // getter
		return proceedButton;

	}

	@FindBy(xpath = "//input[@value='Net Banking']")
	private WebElement netBankingButton;

	public WebElement getNetBankingButton() {
		return netBankingButton;
	}


	
}
