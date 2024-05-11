package TechVerito.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TechVerito.abstractcompoenent.Abstractcompoenent;

public class Loginpage extends Abstractcompoenent {
	
	WebDriver driver;

	public Loginpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this );
	}
	
	@FindBy (id="mat-input-0")
	WebElement Username;
	
	@FindBy (id ="mat-input-1")
	WebElement Password;
	
	@FindBy (xpath="//span[text()='Login']")
	WebElement LoginBtn;
	
	
	public void gotoURL() {
		driver.get("https://bookcart.azurewebsites.net/login");
	}
	
	public ProductCatalouge Login(String username, String password) {
		ProductCatalouge PC= new ProductCatalouge(driver);
		Username.sendKeys(username);
		Password.sendKeys(password);
		LoginBtn.click();
		return PC;
	
	
	
	}
	

}
