package orangehrm;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkart 
{
	public static void main(String[] args) throws Exception
	{
		ChromeDriver Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(Driver, 60);
		
		Driver.get("https://www.flipkart.com/");
		String MB="9515746141";
		String PWD="kilambi162";
		WebElement mobile=Driver.findElement(By.xpath("//input[@class='_2zrpKA']"));
		mobile.clear();
		mobile.sendKeys(MB);
		WebElement pswd=Driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv']"));
		pswd.clear();
		pswd.sendKeys(PWD);
		Driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']")).click();
		Thread.sleep(2000);
		WebElement elect=Driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"));
		Actions Act=new Actions(Driver);
		Act.moveToElement(elect).perform();
		Thread.sleep(1000);
		Driver.findElement(By.linkText("Samsung")).click();
		Thread.sleep(1000);
		Driver.findElement(By.linkText("VIEW ALL")).click();
		Thread.sleep(1000);
		Driver.findElement(By.xpath("//div[contains(text(),'Price -- High to Low')]")).click();
		List<WebElement> li=Driver.findElements(By.xpath("//div[@class='_3wU53n']"));
		System.out.println(li.size());
		Iterator<WebElement> itr=li.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next().getText());
		}
		List<WebElement> lis= Driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
		System.out.println(lis.size());
		Iterator<WebElement> itrs=lis.iterator();
		while(itrs.hasNext())
		{
			System.out.println(itrs.next().getText());
			
		}
		List<WebElement> namelist=Driver.findElements(By.xpath("//div[@class='_3wU53n']"));

		
	}
}
