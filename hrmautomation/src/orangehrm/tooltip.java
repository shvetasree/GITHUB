package orangehrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class tooltip
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","C:\\web drivers\\chromedriver.exe");
		WebDriver Brow=new ChromeDriver();
		Brow.manage().window().maximize();
		Brow.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		//--------------------------
		Brow.get("https://www.google.com/");
		//Get title attribute of edit box
		String ToolTip=Brow.findElement(By.id("lst-ib")).getAttribute("title");
		System.out.println("ToolTip");
		//close browser
		Brow.close();
		//quit browser
		Brow.quit();
	}
	
}
