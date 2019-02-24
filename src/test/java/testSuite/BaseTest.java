package testSuite;

//import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    private WebDriver driver; // will be accessed in sub classes using the getDriver() defined in this class
//    protected WebDriver driver; // if we make it protected -- it is directly accessible to all sub classes (Tests) 

    @BeforeSuite
    public void beforeSuite() {
    	
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(false);
		options.setLogLevel(FirefoxDriverLogLevel.TRACE);
		System.setProperty("webdriver.gecko.driver",
				"C:\\PORTABLES\\geckodriver_v0.23.0_win64\\geckodriver.exe");
		driver = new FirefoxDriver(options);
		
/*        System.setProperty("headless", "false"); // You can set this property elsewhere
        String headless = System.getProperty("headless");

        ChromeDriverManager.chromedriver();
        if("true".equals(headless)) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        } else {
            driver = new ChromeDriver();
        }*/
    }

    @AfterSuite
    public void afterSuite() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
