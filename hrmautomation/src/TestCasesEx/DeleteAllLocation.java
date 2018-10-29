package TestCasesEx;

import java.time.chrono.ThaiBuddhistEra;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteAllLocation
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\web drivers\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		//maximize browser
		Driver.manage().window().maximize();
		//wait object
		WebDriverWait wait=new WebDriverWait(Driver,60);
		//Action class object
		Actions Act=new Actions(Driver);
		//-------------------
		//open application
		Driver.get("http://apps.qaplanet.in/qahrm/login.php");
		//verify home page
		if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
		{
			System.out.println("home page displayed");
		}
		else
		{
			System.out.println("failed to open home page");
			return;
		}
		
		//-------------------------------------------
		//create web element
		WebElement ObjUserName=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
		WebElement ObjPassword=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
		WebElement ObjLogin=Driver.findElement(By.name("Submit"));
		WebElement ObjClear=Driver.findElement(By.name("clear"));
		//---------------------------------------------------
		//verify username
		if(ObjUserName.isDisplayed())
		{
			System.out.println("username is displayed");
		}
		//verify password
		if(ObjPassword.isDisplayed())
		{
			System.out.println("password is displayed");
		}
		//verify login and clear
		if(ObjLogin.isDisplayed()&&ObjClear.isDisplayed())
		{
			System.out.println("Login and clear is displayed");
		}
		//----------------------------------------
		String SUN="qaplanet1";
		String SPWD="lab1";
		//------------------------
		//Login to Orange Hrm
		ObjUserName.clear();
		ObjUserName.sendKeys(SUN);
		ObjPassword.clear();
		ObjPassword.sendKeys(SPWD);
		ObjLogin.click();
		//verify OrangeHrm page
		if(wait.until(ExpectedConditions.titleIs("OrangeHRM")))
				{
					System.out.println("Orange hrm is displayed");
				}
		else
		{
			System.out.println("failed to login");
		}
		//Get welcome text
		String SwelText=Driver.findElement(By.xpath("//ul[@id='option-menu']/li[1]")).getText();
		//verify Welcome Qaplanet
		if(SwelText.equals("Welcome "+ SUN ))
		{
			System.out.println("Welcome"+SUN +"Displayed");
		}
		WebElement ObjCP =Driver.findElement(By.xpath("//ul[@id='option-menu']/li[2]/a"));
		WebElement ObjLogout =Driver.findElement(By.xpath("//ul[@id='option-menu']/li[3]/a"));
		//----------------------------
	//Create WebElement for Admin
		WebElement objAdmin=Driver.findElement(By.xpath("//ul[@id='nav']/li/a/span"));
		Act.moveToElement(objAdmin).perform();
		Act.moveToElement(Driver.findElement(By.linkText("Company Info"))).perform();
		Driver.findElement(By.linkText("Locations")).click();
		Thread.sleep(2000);
		Driver.switchTo().frame("rightMenu");
		/*//way 1
		WebElement searchby=Driver.findElement(By.xpath("//select[@name='loc_code']"));
		WebElement searchfor=Driver.findElement(By.xpath("//input[@name='loc_name']"));
		if (searchby.isDisplayed() && searchfor.isDisplayed()) 
		{
			System.out.println("searchby and searchfor is displayed");
		}
		else
		{
			System.out.println("searchby and searchfor is not displayed");
		}
		Select sel=new Select(searchby);
		sel.selectByValue("0");
		searchfor.sendKeys("LOC28");
		Driver.findElement(By.xpath("//input[@class='plainbtn']")).click(); 
		WebElement check=Driver.findElement(By.xpath("//input[@name='allCheck']"));
		check.click();
		WebElement del=Driver.findElement(By.xpath("//input[@value='Delete']"));
		del.click();
		Alert A=wait.until(ExpectedConditions.alertIsPresent());
	if (A.getText().equals("Deletion might affect Company Hierarchy. If the Location has associations deletion may fail. Do you want to delete ?"))
			{
		System.out.println("Alert is present");
		Thread.sleep(2000);
		A.accept();
		}*/
	
		
	    //way2
	
		int rc=Driver.findElements(By.xpath("//table/tbody/tr")).size();
		for(int i=1;i<=rc;i++)
		{
		String name=Driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]/a")).getText();
		if (name.contains("LOC25"))
		{
			WebElement checkbox=Driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]/input"));
			checkbox.click();
		}
		
		}
		WebElement del=Driver.findElement(By.xpath("//input[@value='Delete']"));
		del.click();
		Alert A=wait.until(ExpectedConditions.alertIsPresent());
	if (A.getText().equals("Deletion might affect Company Hierarchy. If the Location has associations deletion may fail. Do you want to delete ?"))
			{
		System.out.println("Alert is present");
		Thread.sleep(2000);
		A.accept();
		}
	}
}
