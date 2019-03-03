package pageAction;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private static final int TIMEOUT = 5; //seconds
    private static final int POLLING = 100; //milliseconds

//    protected WebDriver driver;
    public WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
        
/*		try {
			props = GetPropertiesObj.getObj();
		} catch (Exception e) {
			System.out
					.println("\n\nUnable to read properties in prop object\n\n");
			e.printStackTrace();
		}*/
        
/*		//set the implicit time out to find WebElements
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//set the page load time out
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		//maximize the browser window
		driver.manage().window().maximize();
		//get the web site URL
		driver.get(prop.getProperty("url"));*/
        
    }

    protected void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForTextToDisappear(By locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }
}