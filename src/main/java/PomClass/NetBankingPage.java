package PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NetBankingPage {

	public NetBankingPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//iframe[@title='Netbanking']")
	private WebElement netBankingFrameTag;

	public WebElement getnetBankingFrameTag() {
		return netBankingFrameTag;
	}
	
	@FindBy(xpath = "//input[@value='IDHC'] ")
	private WebElement IDHC_radioButton;

	public WebElement getIDHC_radioButton() {
		return IDHC_radioButton;
	}

	@FindBy(xpath = "//button[text()='Submit'] ")
	private WebElement submitButton;

	public WebElement getSubmitButton() {
		return submitButton;
	}

}

