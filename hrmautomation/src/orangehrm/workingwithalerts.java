package orangehrm;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class workingwithalerts
{
public static void main(String[] args)
{
	System.setProperty("webdriver.chrome.driver","C:\\web drivers\\chromedriver.exe");
	ChromeDriver Driver=new ChromeDriver();
WebDriverWait Wait=new WebDriverWait(Driver,60);
//open application
Driver.get("http://apps.qaplanet.in/WebApp/AgeProb.html");
//wait for home page
boolean res=Wait.until(ExpectedConditions.titleIs("Age Problem"));
//verify Age Problem
if(res)
{
	System.out.println("Age Problem displayed");
}
//-----------------------------------------------------------
//Enter age
Driver.findElement(By.id("idAge")).sendKeys("10");
//Click on submit
Driver.findElement(By.id("idSubGo")).click();
//--------------------------------------------------------
//wait for alert
Wait.until(ExpectedConditions.alertIsPresent());
//Switch to alert
Alert A=Driver.switchTo().alert();
//Verify Kid message
if(A.getText().equals("Kid"))
{
	System.out.println("Kid alert displayed");
	A.accept();
}
//------------------------------------------------------------
Driver.close();
Driver.quit();


}

}
