package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
	this.driver= driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaign;
	
	@FindBy(linkText = "Contacts")
	private WebElement contacts;
	
	@FindBy(linkText = "Products")
	private WebElement products;
	
	@FindBy(xpath = "//span[text()='Create Campaign']")
	private WebElement createcampaign;
	
	@FindBy(className = "user-icon")
	private WebElement userIcon;
	
	@FindBy(xpath = "//div[text()='Logout ']")
	private WebElement LogoutBtn;
	
	@FindBy(xpath = "//div[@role='alert']")
	private WebElement toastmsg;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCampaign() {
		return campaign;
	}

	public void setCampaign(WebElement campaign) {
		this.campaign = campaign;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public void setContacts(WebElement contacts) {
		this.contacts = contacts;
	}

	public WebElement getProducts() {
		return products;
	}

	public void setProducts(WebElement products) {
		this.products = products;
	}

	public WebElement getCreatecampaign() {
		return createcampaign;
	}

	public void setCreatecampaign(WebElement createcampaign) {
		this.createcampaign = createcampaign;
	}

	public WebElement getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(WebElement userIcon) {
		this.userIcon = userIcon;
	}

	public WebElement getLogoutBtn() {
		return LogoutBtn;
	}

	public void setLogoutBtn(WebElement logoutBtn) {
		LogoutBtn = logoutBtn;
	}

	public WebElement getToastmsg() {
		return toastmsg;
	}

	public void setToastmsg(WebElement toastmsg) {
		this.toastmsg = toastmsg;
	}

	public WebElement getClosemsg() {
		return closemsg;
	}

	public void setClosemsg(WebElement closemsg) {
		this.closemsg = closemsg;
	}

	@FindBy(xpath = "//button[@aria-label='close']")
	private WebElement closemsg;



}
