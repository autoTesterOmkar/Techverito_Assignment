package TechVerito.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import TechVerito.abstractcompoenent.Abstractcompoenent;

public class ProductCatalouge extends Abstractcompoenent{
	
	WebDriver driver;
	
	public ProductCatalouge(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css="input[class*=mat-mdc]")
	WebElement Searchtextbox;
	
	@FindBy (css="app-addtocart")
	List<WebElement>  AddtoCart;
	
	@FindBy(css="mat-card[class*=mat-elevation] strong")
	List<WebElement> BookInfo;
	
	@FindBy (css="mat-option span")
	WebElement SelectBookDropdown;
	
	@FindBy (css="a strong")
	WebElement BookContent;
	
	
	
	@FindBy (xpath="//span[text()=' Book Cart ']")
	WebElement BookCart;
	
	
	public void searchAndSelect (String Bookname) throws InterruptedException {
		Thread.sleep(2000);
		Searchtextbox.sendKeys(Bookname);
		SelectBookDropdown.click();
	}
	
	public Cartpage selectFromHomepage() throws InterruptedException {
		BookCart.click();
		Thread.sleep(3000);
		for(int i=0; i<BookInfo.size(); i++) {
			String Name = BookInfo.get(i).getText();
			if (Name.equalsIgnoreCase("harry potter and the prisoner of azkaban")) {
			AddtoCart.get(i).click();	
			} else if (Name.equalsIgnoreCase("harry potter and the chamber of secrets")) {
				AddtoCart.get(i).click();	
				}
		}
		Cartpage CP=new Cartpage(driver);
		return CP;
	}
	
	public String VerifyContent() {
		String BookTitle= BookContent.getText();
		return BookTitle;
	}
	
	public Cartpage AddToCart() throws InterruptedException {
		driver.findElement(By.cssSelector("app-addtocart")).click();
		Thread.sleep(2000);
		Cartpage CP=new Cartpage(driver);
		return CP;
		
	}
	

}
