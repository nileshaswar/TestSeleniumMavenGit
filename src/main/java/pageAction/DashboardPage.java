package pageAction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import config.GetPropertiesObj;

public class DashboardPage extends BasePage {

//	WebDriver driver;
//	GetPropertiesObj props;
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

	@FindBy(xpath = "html/body/div[1]/aside[1]/section/ul/li[5]/a/span")
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
	public void browsercleanup() {
		driver.close();
	}


/*	public void navigateToDashboardPage() {
		try {
			props = GetPropertiesObj.getObj();
		} catch (Exception e) {
			System.out
					.println("\n\nUnable to read properties in prop object\n\n");
			e.printStackTrace();
		}
		driver.get(props.getUrl());
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(props.getUser());
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(props.getPassword());
		driver.findElement(By.xpath(".//button[@type='submit']")).click();
	}*/
}
