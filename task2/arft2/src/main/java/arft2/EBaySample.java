package arft2;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

public class EBaySample {

	private static AndroidDriver driver;
	public static void main(String[] args) {

		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/Apps/EBay/");
		File app = new File(appDir, "ebay.com.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "9b4dcc3f");
		//capabilities.setCapability("deviceName", "U8QC7SONOVM7CM9H");
		capabilities.setCapability("platformVersion", "");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());

		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//a) Launch app with Appium on emulator. Search for a product by keyword.
		driver.findElement(By.id("com.ebay.mobile:id/search_box")).click(); 
		driver.findElement(By.id("com.ebay.mobile:id/search_src_text")).click(); 		
		driver.findElement(By.id("com.ebay.mobile:id/search_src_text")).sendKeys("Mango\\n"); 
		
		
		//b) From search results, sort by the given option on price..
		driver.findElement(By.id("com.ebay.mobile:id/button_sort")).click();
		
		WebElement searchView = driver.findElement(By.id("com.ebay.mobile:id/search_refine_list"));
		List<WebElement> searchView1 = searchView.findElements(By.className("android.widget.LinearLayout"));
		searchView1.get(1).click();
		
		
		//c)  Write a utility method that will return the first ‘N’
		HashMap<String,String> ProductNamePrice = new HashMap<String,String>();
		int N = 10;
		ProductNamePrice = getNamePrice(driver,N);
				
		//d) Click on the product link for the first product in search result.
		driver.findElement(By.id("com.ebay.mobile:id/cell_collection_item")).click();
		
		//e) click on 'Watch'.
		driver.findElement(By.id("com.ebay.mobile:id/button_watch")).click();	    	
		
		//f) Now, verify if the SignIn page is showing up.
		driver.findElement(By.id("com.ebay.mobile:id/login_src_text")).sendKeys("test_username1");
		driver.findElement(By.id("com.ebay.mobile:id/button_close")).click();
		
		driver.quit();
		
	}
	private static HashMap<String, String> getNamePrice(AndroidDriver driver2,int num) {
		
		Dimension size = driver.manage().window().getSize();
	    int anchor = (int) (size.width * 0.5);
	    int startPoint = (int) (size.height * 0.9);
	    int endPoint = (int) (size.height * 0.1);
	    
	    	    	   
	    int ctr = num;
	    HashMap<String,String> products = new HashMap<String,String>();	   
	    String firstProduct = "";
			    	    	   
	    for(int i = 0; i < ctr; ctr++){	    	
	    	List<WebElement> items = driver.findElement(By.id("com.ebay.mobile:id/search_result_fragment")).findElements(By.id("com.ebay.mobile:id/cell_collection_item"));	
	    	
	    	for(WebElement item : items)
		    {
	    		String productName = item.findElement(By.id("com.ebay.mobile:id/textview_item_title")).getText();
		    	
	    		if(ctr == 0)
		    		firstProduct = productName;
		    	
	    		String productPrice = item.findElement(By.id("com.ebay.mobile:id/textview_item_price")).getText();	    		
				products.put(productName, productPrice);
				System.out.println(productName + " - " + productPrice);				
				ctr++;
		    }
	    	
	    	//SCROLL DOWN
	    	new TouchAction(driver).press(anchor, startPoint).waitAction(Duration.ofSeconds(3)).moveTo(anchor, endPoint).release().perform();
	    	items = null;
	    }
	    
	    startPoint = (int) (size.height * 0.4);
	    endPoint = (int) (size.height * 0.6);
		
	    for(int i = 0; i < 5000; ctr++)
	    {
	    	List<WebElement> items = driver.findElement(By.id("com.ebay.mobile:id/search_result_fragment")).findElements(By.id("com.ebay.mobile:id/cell_collection_item"));	
	    	for(WebElement item : items)
		    {
	    	String productName = item.findElement(By.id("com.ebay.mobile:id/textview_item_title")).getText();
			if(productName == firstProduct)			
				break;		    
		    }
	    	
	    	//SCROLL UP
			new TouchAction(driver).press(anchor, startPoint).waitAction(Duration.ofSeconds(3)).moveTo(anchor, endPoint).release().perform();
	    }
		
	   	return products;
	}
}
