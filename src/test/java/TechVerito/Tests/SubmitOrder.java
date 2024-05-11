package TechVerito.Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TechVerito.pages.Cartpage;
import TechVerito.pages.Loginpage;
import TechVerito.pages.ProductCatalouge;

public class SubmitOrder extends BaseTest {
    public ProductCatalouge PC;
	String BookName= "Roomies";
	@Test
	public void Demo() throws InterruptedException  {

       
       PC=LP.Login("OmkarAutoTester", "OmkarAutoTester@1");
	   PC.searchAndSelect(BookName);
	   String Book =PC.VerifyContent();
	   Assert.assertEquals(Book, BookName);
	   PC.AddToCart();
	   Cartpage CP=PC.selectFromHomepage();
	   int CalculatedPrice=CP.TotalPrice();
	   System.out.println("Calculated Price "+CalculatedPrice);
	   Thread.sleep(2000);
	   CP.AddQtyForEach();
	   Thread.sleep(2000);
	   int FinalPrice = CP.TotalPrice();
	   System.out.println("Price after adding one to QTY each product "+FinalPrice);
	   int BeforechangeQtyPrice = (2 * CalculatedPrice);
	   Assert.assertEquals(FinalPrice, BeforechangeQtyPrice);
	   CP.Checkout();
	   
	}
	 
	  
	  
}
