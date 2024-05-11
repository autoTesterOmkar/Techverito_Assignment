package TechVerito.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TechVerito.abstractcompoenent.Abstractcompoenent;

public class Cartpage extends Abstractcompoenent{
	
	WebDriver driver;
	
	public Cartpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//div[@class='d-flex align-items-center']/button[2]")
	WebElement Cart;
	
	@FindBy (xpath="//tr/td[4]//div[3]/button")
	List<WebElement> Additem;
	
	@FindBy (xpath="//tr/td[2]/a")
	List<WebElement> AddedBookname;
	
	@FindBy (xpath="//span[text()=' CheckOut ']")
	WebElement CheckoutBtn;
	
	@FindBy (xpath="//tr/td[5]")
	List<WebElement> EachPrice; 
	
	@FindBy (xpath="//mat-card-content/td[5]/strong")
	WebElement TotalCartValue;
	
	public int TotalPrice() {
		int Totalprice;
		
		String Tprice = TotalCartValue.getText();
        String ActualPrice=Tprice.replace("₹", "");
        String SP3 = ActualPrice.replace(".", "&");
        String [] SplitName=SP3.split("&");
        String formatPrice=SplitName[0];
        //String formatPrice =i.replace(".", "");
        if (formatPrice.contains(",")) {
        	String T=formatPrice.replace(",", "");
        	 Totalprice = Integer.parseInt(T);
        } else {
		 Totalprice = Integer.parseInt(formatPrice);
        }
        return Totalprice;
	}
	
	public void AddQtyForEach() {
		
		for (int i=1; i<=Additem.size(); i++) {
			driver.findElement(By.xpath("//tr["+i+"]/td[4]//div[3]/button")).click();
		}
	}
	
	public Orderspage Checkout() {
		CheckoutBtn.click();
		Orderspage OP= new Orderspage(driver);
		return OP;
	}
	
	public void VerifyAddedBook(String BookName) throws InterruptedException {
		Cart.click();
		Thread.sleep(1000);
		for (int i=0; i<AddedBookname.size(); i++) {
			String CopyName=AddedBookname.get(i).getText();
			if (CopyName.equalsIgnoreCase(BookName)){
				System.out.println("Books gets added to cart");
			}else {
				System.out.println("");
			}
		}
	}
		
		public int VerifyAddedBookTotalPrice () throws InterruptedException {
        //Cart.click();
        Thread.sleep(2000);
		int j=0;
		int k;
			for (int i=0; i<EachPrice.size(); i++) {
				String SP =EachPrice.get(i).getText();
				String SP2 = SP.replace("₹", "");
				String SP3 = SP2.replace(".", "&");
		        String [] SplitName=SP3.split("&");
		        String SP4=SplitName[0];
		       // String  =.replace(".", "");
		       
		        if (SP4.contains(",")) {
		        	String T=SP4.replace(",", "");
		        	 k = Integer.parseInt(T);
		        } else {
				 k = Integer.parseInt(SP4);
		        }
				 j=j+k;
             }
			return j;
		  
	}
	public void CartClick() {
		Cart.click();
	}
	

}
