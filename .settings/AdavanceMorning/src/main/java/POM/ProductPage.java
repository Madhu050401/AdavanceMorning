package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	WebDriver driver;
	public ProductPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "productId")
	private WebElement productid;
	
	@FindBy(name = "productName")
	private WebElement productName;
	
	@FindBy(name ="productCategory")
	private WebElement productCategory;
	
	@FindBy(name = "quantity")
	private WebElement quantity;
	
	@FindBy(name = "price")
	private WebElement price;
	
	@FindBy(name = "vendorId")
	private WebElement vendorId;
	
	@FindBy(xpath = "//button[text()='Add']")
	private WebElement addprodButton;
	
	@FindBy(className = "material-icons")
	private WebElement createProd;

	
	public WebElement getCreateProd() {
		return createProd;
	}

	public void setCreateProd(WebElement createProd) {
		this.createProd = createProd;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getProductid() {
		return productid;
	}

	public void setProductid(WebElement productid) {
		this.productid = productid;
	}

	public WebElement getProductName() {
		return productName;
	}

	public void setProductName(WebElement productName) {
		this.productName = productName;
	}

	public WebElement getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(WebElement productCategory) {
		this.productCategory = productCategory;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public void setQuantity(WebElement quantity) {
		this.quantity = quantity;
	}

	public WebElement getPrice() {
		return price;
	}

	public void setPrice(WebElement price) {
		this.price = price;
	}

	public WebElement getVendorId() {
		return vendorId;
	}

	public void setVendorId(WebElement vendorId) {
		this.vendorId = vendorId;
	}

	public WebElement getAddprodButton() {
		return addprodButton;
	}

	public void setAddprodButton(WebElement addprodButton) {
		this.addprodButton = addprodButton;
	}

	


}
