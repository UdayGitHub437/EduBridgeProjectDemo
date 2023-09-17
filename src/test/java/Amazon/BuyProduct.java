package Amazon;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BuyProduct {
	WebDriver driver;
	@BeforeSuite
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8000));
	}
	@Test(priority=1)
	public void openApp() throws Exception
	{
		driver.get("https://www.amazon.in/?&ext_vrnc=hi&tag=googhydrabk1-21&ref=pd_sl_7hz2t19t5c_e&adgrpid=58355126069&hvpone=&hvptwo=&hvadid=610644601173&hvpos=&hvnetw=g&hvrand=201308671182816415&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9302561&hvtargid=kwd-10573980&hydadcr=14453_2316415");
	    
	}
	@Test(priority=2)
	public void buyProduct()
	{
		WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("Puma sneakers for men",Keys.ENTER);
		String parentWindow=driver.getWindowHandle();
		WebElement shoes=driver.findElement(By.xpath("(//a[@class=\"a-link-normal s-no-outline\"])[1]"));
		shoes.click();
		Set<String> handles=driver.getWindowHandles();
		for(String handle:handles)
			{
			if(!(handle==parentWindow))
			{
				driver.switchTo().window(handle);
			}
			}
		WebElement buyNow=driver.findElement(By.id("buy-now-button"));
		buyNow.click();
		WebElement username=driver.findElement(By.id("ap_email"));	
		username.sendKeys("jagabattulaudaykumar@gmail.com");
		WebElement continurBtn=driver.findElement(By.id("continue"));
		continurBtn.click();
		WebElement password=driver.findElement(By.id("ap_password"));
		password.sendKeys("$$$$4444$$$$amazon");
		WebElement signInBtn=driver.findElement(By.id("signInSubmit"));
		signInBtn.click();
		WebElement cvv=driver.findElement(By.id("pp-ocqN0N-142"));
		cvv.sendKeys("356");
//		WebElement modeOfPayment=driver.findElement(By.id("pp-cCkoig-154"));
//		modeOfPayment.click();
//		WebElement enterTheDetails=driver.findElement(By.id("pp-cCkoig-157"));
//		enterTheDetails.click();
//		WebElement cardNum=driver.findElement(By.id("pp-kRlKR4-16"));
//		cardNum.sendKeys("1234567812345678");
		}
	@AfterSuite
	public void teardown()
	{
//		driver.close();
	}


}
