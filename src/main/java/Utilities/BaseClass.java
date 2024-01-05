package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import PomClass.AccountSettingPage;
import PomClass.HomePage;
import PomClass.LoginPage;
import PomClass.WelcomePage;

public class BaseClass {
	public static WebDriver driver;
	public DataUtility data = new DataUtility();
	public WebDriverUtility wu = new WebDriverUtility();
	public DropDownUtility drpu = new DropDownUtility();

	@BeforeClass
	public void launchingBrowser() throws Throwable {
		System.out.println("-----------launchingBrowser----------");
		String BROWSER = data.dataFromPropertiesFile("browser");

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		String URL = data.dataFromPropertiesFile("url");
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}

	@BeforeMethod
	public void loginToApplication() throws Throwable {
		System.out.println("-----------loginToApplication----------");

		Thread.sleep(3000);
		WelcomePage WLpage = new WelcomePage(driver);
		WLpage.getMainLoginButton().click();

		LoginPage Lpage = new LoginPage(driver);

		String emailId = data.dataFromPropertiesFile("email");
		Lpage.getEmailTextField().sendKeys(emailId);

		String Password = data.dataFromPropertiesFile("Password");
		Lpage.getPasswordTextField().sendKeys(Password);

		Lpage.getLoginButton().click();

	}

	@AfterMethod
	public void logoutFromApplication() throws Throwable {
		System.out.println("-----------logoutFromApplication----------");
		Thread.sleep(3000);
		HomePage Hpage = new HomePage(driver);
		Hpage.javaScriptClick(driver);

		AccountSettingPage ASpage = new AccountSettingPage(driver);
		ASpage.getLogOutIcon().click();

	}

	@AfterClass
	public void quitBrowser() {
		System.out.println("-----------quitBrowser----------");
		driver.quit();
	}
}