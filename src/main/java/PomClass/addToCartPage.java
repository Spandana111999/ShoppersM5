package PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addToCartPage {
	public WebDriver driver;

	public addToCartPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
		
		@FindBy(xpath="//p[text()='Levis Mens Regular Fit Tee']")
		
	private WebElement levisProduct;

		public WebElement getLevisProduct() {
			return levisProduct;
		}
	@FindBy(id="buynow_fl")
	private WebElement buyNowButtonInAddToCartPage;

	public WebElement getBuyNowButtonInAddToCartPage() {
		return buyNowButtonInAddToCartPage;
	}

	}
