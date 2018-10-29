package orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webdrivercommands
{
public static void main(String[] args)throws Exception
{
	System.setProperty("webdriver.chrome.driver","C:\\web drivers\\chromedriver.exe");
	WebDriver Driver=new ChromeDriver();
	//to maximize browser
	Driver.manage().window().maximize();
//open application
	Driver.get("http://apps.qaplanet.in/qahrm/login.php");
	//wait 2 sec
	Thread.sleep(2000);
	//enter username
	Driver.findElement(By.name("txtUserName")).clear();
	Driver.findElement(By.name("txtUserName")).sendKeys("qaplanet1");
	//enter password
	Driver.findElement(By.name("txtPassword")).clear();
	Driver.findElement(By.name("txtPassword")).sendKeys("lab1");
	//click on login
	Driver.findElement(By.name("Submit")).click();
	//wait 2 sec
	Thread.sleep(2000);
	//----------------
	//click on logout
	Driver.findElement(By.linkText("Logout")).click();
	//wait 2 sec
	Thread.sleep(2000);
	//------------------
	Driver.close();
	Driver.quit();
}
}
