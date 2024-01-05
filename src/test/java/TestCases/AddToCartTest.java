package TestCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PomClass.AccountSettingPage;
import PomClass.AddressFromPage;
import PomClass.HomePage;
import PomClass.MyAddress;
import PomClass.MyProfilePage;
import PomClass.NetBankingPage;
import PomClass.OrderConfirm;
import PomClass.PaymentMethod;
import PomClass.TshirtPage;
import PomClass.addToCartPage;
import PomClass.addressPage;
import Utilities.BaseClass;

@Listeners(Utilities.ListenersUtility.class)

public class AddToCartTest extends BaseClass {

	@Test(priority=2,dataProvider = "dataProviderAddress")
	public void Tc_AddAddress_001_Test(String home, String house_office, String street, String landmark, String country,
			String state, String city, String Dpin, String mobN) throws Throwable {
		System.out.println("add address");
		
		Thread.sleep(5000);

		HomePage hp = new HomePage(driver);
		hp.javaScriptClick(driver);
		// WebElement accountSetting=hp.getAccountSettingIcon();
		// accountSetting.click();

		AccountSettingPage as = new AccountSettingPage(driver);
		as.getMyProfileLink().click();

		Assert.assertEquals(driver.getCurrentUrl(), "https://www.shoppersstack.com/my-profile/my-profile-info");

		System.out.println(" The my profile page is opened");

		MyProfilePage mp = new MyProfilePage(driver);
		mp.getAddAddressLink().click();

		MyAddress ma = new MyAddress(driver);
		ma.getAddAddressformbutton().click();

		AddressFromPage afp = new AddressFromPage(driver);
		afp.getNameTextField().sendKeys(home);
		afp.getHouseOfficeInformationTextField().sendKeys(house_office);
		afp.getStreetInformationTextField().sendKeys(street);
		afp.getLandMarkTextField().sendKeys(landmark);
		WebElement countryDropDown = afp.getCountryDropDown();
		drpu.selectDropDownByVisibleText(country, countryDropDown);
		WebElement StateDropDown = afp.getStateDropDown();
		drpu.selectDropDownByVisibleText(state, StateDropDown);
		WebElement CityDropDown = afp.getCityDropDown();
		drpu.selectDropDownByVisibleText(city, CityDropDown);
		afp.getPincodeTextField().sendKeys(Dpin);
		afp.getPhoneNumberTextField().sendKeys(mobN);
		afp.getAddAddressButton().click();

		
	}

	@DataProvider
	public Object[][]dataProviderAddress() throws Throwable {
		return data.aceessAllAddress();
	}

	@Test(dependsOnMethods = "Tc_AddAddress_001_Test")

	public void Tc_EndToEndCashOnDelivery_Test() throws Throwable {
		Thread.sleep(5000);

		System.out.println("First test case");
		String titleHomePage = driver.getTitle();
		Assert.assertEquals(titleHomePage, "ShoppersStack | Home");

		HomePage hp = new HomePage(driver);
		Thread.sleep(5000);
		WebElement menLink = hp.getmenManuLink();

		wu.mouseOverAction(driver, menLink);

		hp.getTshirtPopUpLink().click();

		TshirtPage tsp = new TshirtPage(driver);
		String currentUrl = driver.getCurrentUrl();

		Assert.assertEquals(currentUrl, "https://www.shoppersstack.com/sub-category/men-tshirt");
		wu.mouseOverAction(driver, tsp.gettshirtTopLink());

		tsp.getlevisMenRegularfitproduct_AddToCartButton().click();
		hp.getaddToCartLink().click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.shoppersstack.com/cart");
		System.out.println("The cart page is opened");

		addToCartPage ac = new addToCartPage(driver);
		String leviseProductTest = ac.getLevisProduct().getText();
		Assert.assertEquals(leviseProductTest, "Levis Mens Regular Fit Tee");
		System.out.println("the product is added to cart");

		ac.getBuyNowButtonInAddToCartPage().click();
		String addresPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(addresPageUrl, "https://www.shoppersstack.com/selectaddress");
		System.out.println("the product is address page is displayed");

		addressPage ap = new addressPage(driver);
		ap.getLovwebirdAddress().click();
		ap.getProcedButton().click();
		
		PaymentMethod pm=new PaymentMethod(driver);
		pm.getcashOnDeliveryRadioButton().click();
		pm.getproceedButton().click();
		
		OrderConfirm oc= new OrderConfirm(driver);
		Assert.assertEquals(oc.getOrderConfirmedText().getText(),"Order Confirmed");
		System.out.println("The order got confirmed in cash on delivery");
	}
	
	@Test(priority=2,dependsOnMethods="Tc_AddAddress_001_Test")
	public void EndToEnd_NetBanking() throws Throwable {
		

		System.out.println("First test case");
		String titleHomePage = driver.getTitle();
		Assert.assertEquals(titleHomePage, "ShoppersStack | Login");

		HomePage hp = new HomePage(driver);
		Thread.sleep(5000);
		WebElement menLink = hp.getmenManuLink();

		wu.mouseOverAction(driver, menLink);

		hp.getTshirtPopUpLink().click();

		TshirtPage tsp = new TshirtPage(driver);
		String currentUrl = driver.getCurrentUrl();

		Assert.assertEquals(currentUrl, "https://www.shoppersstack.com/sub-category/men-tshirt");
		wu.mouseOverAction(driver, tsp.gettshirtTopLink());

		tsp.getlevisMenRegularfitproduct_AddToCartButton().click();
		hp.getaddToCartLink().click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.shoppersstack.com/cart");
		System.out.println("The cart page is opened");

		addToCartPage ac = new addToCartPage(driver);
		String leviseProductTest = ac.getLevisProduct().getText();
		Assert.assertEquals(leviseProductTest, "Levis Mens Regular Fit Tee");
		System.out.println("the product is added to cart");

		ac.getBuyNowButtonInAddToCartPage().click();
		String addresPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(addresPageUrl, "https://www.shoppersstack.com/selectaddress");
		System.out.println("the product is address page is displayed");

		addressPage ap = new addressPage(driver);
		ap.getLovwebirdAddress().click();
		ap.getProcedButton().click();
		
		PaymentMethod pm=new PaymentMethod(driver);
		pm.getNetBankingButton().click();
		pm.getproceedButton().click();
		
		NetBankingPage np= new NetBankingPage(driver);
		driver.switchTo().frame(np.getnetBankingFrameTag());  
		
		np.getIDHC_radioButton().click();
		np.getSubmitButton().click();
		
	}
	

//	@Test
//	public void Tc_AddToCart_003_Test() throws Throwable {
//		Thread.sleep(5000);
//
//		System.out.println("Third test case");
//
//	}

	
}
