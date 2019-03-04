package testSuite;

//import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Test;



import config.GetPropertiesObj;

public class BaseTest {

	private WebDriver driver; // will be accessed in sub classes using the
								// getDriver() defined in this class
	// protected WebDriver driver; // if we make it protected -- it is directly
	// accessible to all sub classes (Tests)
	GetPropertiesObj props;

	@BeforeSuite
	public void selectBrowser() {

		try {
			props = GetPropertiesObj.getObj();
		} catch (Exception e) {
			System.out
					.println("\n\nUnable to read properties in prop object\n\n");
			e.printStackTrace();
		}
		
		if (props.getBrowser().toLowerCase().equals("firefox")) {
			System.out.println(" Setting Firefox Browser ");
			FirefoxOptions firefoxoptions = new FirefoxOptions();
			firefoxoptions.setHeadless(false);
//			firefoxoptions.setLogLevel(FirefoxDriverLogLevel.TRACE);
			System.setProperty("webdriver.gecko.driver",
					"C:\\PORTABLES\\geckodriver_v0.23.0_win64\\geckodriver.exe");
			driver = new FirefoxDriver(firefoxoptions);
			System.out.println("Firefox Browser Initialized");
		} else if (props.getBrowser().toLowerCase().equals("chrome")) {
			System.out.println(" Setting Chrome Browser ");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setHeadless(false);
			System.setProperty("webdriver.chrome.driver",
					"C:\\PORTABLES\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(chromeOptions);
			System.out.println("chrome Browser Initialized");
		} else {
			System.out.println(" Setting IE Browser ");
			System.setProperty("webdriver.ie.driver",
					"C:\\PORTABLES\\IEDriverServer_Win32_3.141.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			System.out.println("IE Browser Initialized");
		}

		
	}

	@AfterSuite
	public void afterSuite() {
		/*
		 * if(null != driver) { driver.close(); driver.quit(); }
		 */
//		 driver.close();
//		 driver.quit();
		
	}
//	@Test
	public void navigateToDashboardPage() {
		driver.get(props.getUrl());
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(props.getUser());
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(props.getPassword());
		driver.findElement(By.xpath(".//button[@type='submit']")).click();
	}
	public WebDriver getDriver() {
		return driver;
	}
}
