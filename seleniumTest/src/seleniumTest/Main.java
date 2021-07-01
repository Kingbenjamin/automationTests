package seleniumTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select; 
import org.openqa.selenium.firefox.FirefoxDriver;
public class Main {
 
  	public static void main(String[] args) throws InterruptedException {
 
System.setProperty("webdriver.gecko.driver","geckodriver.exe");        	
WebDriver driver = new FirefoxDriver();
        	setup(driver);
        	addRemoveElementTest(driver);
        	dropdownTest(driver);
        	redirectLinkTest(driver);
        	
        	
        	Thread.sleep(1000);
        	driver.quit();
  	}
  	
  	public static void setup(WebDriver driver){
  		driver.get("http://the-internet.herokuapp.com/");
    	driver.manage().window().maximize();
  	}
  	
  	public static void addRemoveElementTest(WebDriver driver){
  		//navigating to add_remove_elements/ page
  		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a")).click();
  		Assert.assertEquals(driver.getCurrentUrl(),"http://the-internet.herokuapp.com/add_remove_elements/");
  		
  		//adding an element
  		driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
  		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"elements\"]/button")).getText(), "Delete");
  		
  		//removing an element
  		driver.findElement(By.xpath("//*[@id=\"elements\"]/button")).click();
  		
  		driver.navigate().back();
  	}
  	
  	public static void dropdownTest(WebDriver driver) {
  		//navigating to the /dropdown page
  		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[11]/a")).click();
  		Assert.assertEquals(driver.getCurrentUrl(),"http://the-internet.herokuapp.com/dropdown");
  		
  		Select dropdown = new Select(driver.findElement(By.id("dropdown")));
  		//select option 1, and asserts if it is true
  		dropdown.selectByVisibleText("Option 1");
  		Assert.assertTrue(driver.findElement(By.id("dropdown")).isDisplayed());
  		//select option 2, and asserts if it is true
  		dropdown.selectByVisibleText("Option 2");
  		Assert.assertTrue(driver.findElement(By.id("dropdown")).isDisplayed());
  		
  		driver.navigate().back();
  	}
  	
  	public static void redirectLinkTest(WebDriver driver){
  		//navigating to the /redirector page
  		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[36]/a")).click();
  		Assert.assertEquals(driver.getCurrentUrl(),"http://the-internet.herokuapp.com/redirector");
  		
  		//navigate to the status codes page
  		driver.findElement(By.xpath("//*[@id=\"redirect\"]")).click();
  		Assert.assertEquals(driver.getCurrentUrl(),"http://the-internet.herokuapp.com/status_codes");
  		
  		driver.get("http://the-internet.herokuapp.com/");
  		
  	}
}