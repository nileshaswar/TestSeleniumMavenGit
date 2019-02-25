package pageAction;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

	// WebDriver driver;

	public DashboardPage(WebDriver driver) {
		// this.driver = driver;
		super(driver);
	}

	@FindBy(xpath = ".//*[@class='sidebar-menu']")
	WebElement getSidebarMenu;

	@FindBy(tagName = "a")
	List<WebElement> getSidebarLinks;

	@FindBy(partialLinkText = "dashboard")
	WebElement getSidebarDashboardLink;

	@FindBy(partialLinkText = "users")
	WebElement getSidebarUsersLink;

	@FindBy(partialLinkText = "operators")
	WebElement getSidebarOperatorsLink;

	@FindBy(partialLinkText = "logout")
	WebElement getSidebarLogoutLink;

	public WebElement getSidebarMenu() {
		return getSidebarMenu;
	}

	public List<WebElement> getSidebarLinks() {
		return getSidebarLinks;
	}

	public WebElement getSidebarDashboardLink() {
		return getSidebarDashboardLink;
	}

	public WebElement getSidebarUsersLink() {
		return getSidebarUsersLink;
	}

	public WebElement getSidebarOperatorsLink() {
		return getSidebarOperatorsLink;
	}

	public WebElement getSidebarLogoutLink() {
		return getSidebarLogoutLink;
	}

	public String getCurrentPageTitle() {
		return driver.getTitle();
	}

}
