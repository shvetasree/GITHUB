package orangehrm;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestion 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","C:\\web drivers\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
	    Driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    Driver.get("https://www.google.com/");
	    WebElement E=Driver.findElement(By.id("lst-ib"));
	    E.sendKeys("Selenium");
	    //Find ul with class property
	    WebElement ul=Driver.findElement(By.className("sbib_b"));
	    List<WebElement>lic=ul.findElements(By.tagName("li"));
	    
}
	}
