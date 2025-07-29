package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	
	WebDriver driver;
	public CampaignPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "campaignName")
	private WebElement campaignName;
	
	@FindBy(name = "campaignStatus")
	private WebElement campaignstatus;
	
	@FindBy(name="targetSize")
	private WebElement targetsizeTF;
	
	@FindBy(name = "expectedCloseDate")
	private WebElement expectedclosedate;
	
	@FindBy(xpath = "//button[text()='Create Campaign']")
	private WebElement createcampaignsubmitBtn;
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(WebElement campaignName) {
		this.campaignName = campaignName;
	}

	public WebElement getCampaignstatus() {
		return campaignstatus;
	}

	public void setCampaignstatus(WebElement campaignstatus) {
		this.campaignstatus = campaignstatus;
	}

	public WebElement getTargetsizeTF() {
		return targetsizeTF;
	}

	public void setTargetsizeTF(WebElement targetsizeTF) {
		this.targetsizeTF = targetsizeTF;
	}

	public WebElement getExpectedclosedate() {
		return expectedclosedate;
	}

	public void setExpectedclosedate(WebElement expectedclosedate) {
		this.expectedclosedate = expectedclosedate;
	}

	public WebElement getCreatecampaignsubmitBtn() {
		return createcampaignsubmitBtn;
	}

	public void setCreatecampaignsubmitBtn(WebElement createcampaignsubmitBtn) {
		this.createcampaignsubmitBtn = createcampaignsubmitBtn;
	}


}
