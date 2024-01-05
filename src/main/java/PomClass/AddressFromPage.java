package PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressFromPage {

	public WebDriver driver;

	public  AddressFromPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

		@FindBy(id="Name")
		private WebElement nameTextField;

		@FindBy(id="House/Office Info")
		private WebElement houseOfficeInformationTextField;
		
		@FindBy(id="Street Info")
		private WebElement streetInformationTextField;
		
		@FindBy(id="Landmark")
		private WebElement landMarkTextField;
		
		@FindBy(id="Country")
		private WebElement countryDropDown;
		
		@FindBy(id="State")
		private WebElement stateDropDown;
		
		@FindBy(id="City")
		private WebElement cityDropDown;
		
		@FindBy(id="Pincode")
		private WebElement pincodeTextField;
		
		@FindBy(id="Phone Number")
		private WebElement phoneNumberTextField;
		
		@FindBy(xpath="//button[text()='Add Address']")
		private WebElement addAddressButton;

		public WebElement getNameTextField() {
			return nameTextField;
		}

		public WebElement getHouseOfficeInformationTextField() {
			return houseOfficeInformationTextField;
		}

		public WebElement getStreetInformationTextField() {
			return streetInformationTextField;
		}

		public WebElement getLandMarkTextField() {
			return landMarkTextField;
		}

		public WebElement getCountryDropDown() {
			return countryDropDown;
		}

		public WebElement getStateDropDown() {
			return stateDropDown;
		}

		public WebElement getCityDropDown() {
			return cityDropDown;
		}

		public WebElement getPincodeTextField() {
			return pincodeTextField;
		}

		public WebElement getPhoneNumberTextField() {
			return phoneNumberTextField;
		}

		public WebElement getAddAddressButton() {
			return addAddressButton;
		}
		
		

}
