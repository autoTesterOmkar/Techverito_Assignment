package TechVerito.Tests;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import TechVerito.pages.Loginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public Loginpage LP;
	
	public WebDriver intializeDriver() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		/*Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\RSA\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser");
		System.out.println(browserName);
		
		if (browserName.startsWith("chrome")) {
			ChromeOptions option = new ChromeOptions(); 
			WebDriverManager.chromedriver().setup();
			if (browserName.contains("headless")) {
				option.addArguments("headless");
			}
		    driver = new ChromeDriver(option);
		    driver.manage().window().setSize(new Dimension(1440, 900));
		    
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\Automation_Backup\\Browser Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod
	public Loginpage launchURL() throws IOException {
		driver=intializeDriver();
		LP=new Loginpage(driver);
		LP.gotoURL();
		return LP;
	}

}
