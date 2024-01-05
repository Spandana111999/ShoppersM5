package PomClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	// Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@aria-label='Account settings']")

	private WebElement accountSettingIcon;

	public WebElement getAccountSettingIcon() { // Setter
		return accountSettingIcon;
	
	}
	
	@FindBy(xpath="//a[@href='/men' and @id='men']")
	private WebElement menMenuLink;
	
	public WebElement getmenManuLink() {
		return menMenuLink;
	}


	@FindBy(xpath="//a[text()='T-shirts']")

	private WebElement TshirtPopUpLink;
	
	public WebElement getTshirtPopUpLink() { // Setter
		return TshirtPopUpLink;
		
		}
	@FindBy(xpath="//a[@id='cart']")

	private WebElement addToCartLink;
	
	public WebElement getaddToCartLink() { // Setter
		return addToCartLink;
}
	public void javaScriptClick(WebDriver driver) {
		WebElement ele=driver.findElement(By.xpath("//button[@aria-label='Account settings']"));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ele);
	}
}