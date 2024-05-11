package TechVerito.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TechVerito.abstractcompoenent.Abstractcompoenent;

public class Orderspage extends Abstractcompoenent{
	
	WebDriver driver;

	public Orderspage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//div[text()=' Order placed successfully!!! ']")
	WebElement SucessMessage;
	
	@FindBy (xpath="//mat-card-title[text()='Check Out ']")
	WebElement Pagename;
	
	//@FindBy (css="input[id='mat-input-31']");
	//WebElement 
	
	public void Title() {
		System.out.println(driver.getTitle());
	}
	
	public String PageName() {
		String TitleName=Pagename.getText();
		return TitleName;
	}

}
