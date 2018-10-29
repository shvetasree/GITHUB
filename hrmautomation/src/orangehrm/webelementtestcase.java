package orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webelementtestcase 
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
		//verify home page
		if(Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
		{
			System.out.println("Home page displayed");
		}
		else
		{
			System.out.println("failed to open home page");
		}
		//-------------
		//create webelement
		WebElement ObjUserName=Driver.findElement(By.name("txtUserName"));
		WebElement ObjPassword=Driver.findElement(By.name("txtPassword"));
		WebElement ObjLogin=Driver.findElement(By.name("Submit"));
		WebElement ObjClear=Driver.findElement(By.name("clear"));
//----------------
		//Verify username
		if(ObjUserName.isDisplayed())
		{
			System.out.println("Username is Displayed");
		}
		//verify password
		if(ObjPassword.isDisplayed())
		{
			System.out.println("Password displayed");
			
		}
		// verify login and clear
		if(ObjLogin.isDisplayed() && ObjClear.isDisplayed())
		{
			System.out.println("login and clear displayed");
		}
	//------------------------------------------------------------------
	String sUN="qaplanet1";
	String sPWD="lab1";
	//-----------------------------------
	//login to orange hrm
	ObjUserName.clear();
	ObjUserName.sendKeys(sUN);
	ObjPassword.clear();
	ObjPassword.sendKeys(sPWD);
	ObjLogin.click();
	//wait 2 sec
	Thread.sleep(2000);
	//verify orange hrm page
	if(Driver.getTitle().equals("OrangeHRM"))
	{
		System.out.println("Home page displayed");
	}
	else
	{
		System.out.println("failed to open home page");
		return;
	}
	//verify welcome qaplanet1
	if(Driver.findElement(By.xpath("//ul[@id='option-menu']/li[1]")).getText().equals("Welcome "+sUN))
	{
		System.out.println("Welcome "+sUN+" displayed");
	}
	//------------------------------------------------------------
	WebElement objCP=Driver.findElement(By.linkText("Change Password"));
	WebElement objlogout=Driver.findElement(By.linkText("Logout"));
	//-----------------------------------------------
	if(objCP.isDisplayed() && objlogout.isDisplayed())
	{
		System.out.println("change password and logout are displayed");
	}
	//-------------------------------------------------
	//click on logout
	objlogout.click();
	//wait 2 sec
	Thread.sleep(2000);
//verify home page
	if(Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
	{
		System.out.println("signoff sucessful and home page displayed");
	}
	else
	{
		System.out.println("failed to signoff");
	}
//----------
	Driver.close();
	Driver.quit();
}
}
