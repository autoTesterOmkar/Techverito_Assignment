package TechVerito.StepDefination2;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TechVerito.Tests.BaseTest;
import TechVerito.pages.Cartpage;
import TechVerito.pages.Loginpage;
import TechVerito.pages.Orderspage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinitionImpl2 extends BaseTest{

	public Loginpage landingPage;
	public TechVerito.pages.ProductCatalouge productCatalogue;
	public TechVerito.pages.Cartpage CP;
	public Orderspage orderpage; 
	public int EstimatedPrice;
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landingPage = launchURL();
		//code
	}

	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password)
	{
		productCatalogue = landingPage.Login(username,password);
	}
	
	
	@When("^I add product (.+) to Cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException
	{
		productCatalogue.searchAndSelect(productName);
		CP=productCatalogue.AddToCart();
	}
	
	@When("^Checkout (.+) and submit the order$")
	public void checkout_submit_order(String productName)
	{
		CP.TotalPrice();
		
		CP.AddQtyForEach();
		orderpage=CP.Checkout();
	}
	

    @Then("{string} message is displayed on ConfirmationPage")
    public void message_displayed_confirmationPage(String string)
    {
    	orderpage.Title();
		//driver.close();
    }
    
    @Then ("^Verify product (.+) added to cart$")
    public void verify_product_added_to_cart(String Bookname) throws InterruptedException {
    	
    	CP.VerifyAddedBook(Bookname);
    	
    }
    
    @When ("Calculate total price of added products")
    public void calculate_total_price_added_products() throws InterruptedException {
    	Thread.sleep(2000);
    	Cartpage cartpage = new Cartpage(driver);
    	cartpage.CartClick();
    	EstimatedPrice=cartpage.VerifyAddedBookTotalPrice();
    	System.out.println(EstimatedPrice);
    	
    	
    }
    
    @Then ("Compare calculated and Total value in cart")
    public void compare_calculated_and_total_value_cart() throws InterruptedException {
    	Thread.sleep(1000);
    	Cartpage cartpage = new Cartpage(driver);
    	int ActualPrice = cartpage.TotalPrice();
    	System.out.println(ActualPrice);
    	Assert.assertEquals(ActualPrice, EstimatedPrice);    }
    
    @When ("Increase the quantity by one of added product")
    public void increase_the_quantity_one_added_product() throws InterruptedException {
    	Thread.sleep(1000);
    	Cartpage cartpage = new Cartpage(driver);
    	cartpage.CartClick();
    	Thread.sleep(2000);
    	cartpage.AddQtyForEach();
    }
    

    
    
}
