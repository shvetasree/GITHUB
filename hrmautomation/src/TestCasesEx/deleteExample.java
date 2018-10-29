package TestCasesEx;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import orangehrm.webdrivercommands;

public class deleteExample 
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
		if(ObjCP.isDisplayed()&&ObjLogout.isDisplayed())
		{
			System.out.println("Change Password andLogout is Displayed");
		}
		//Create Webelement for PIM
		WebElement ObjPIM=Driver.findElement(By.xpath("//ul[@id='nav']/li[2]"));
		//Mouse over on PIM
		Act.moveToElement(ObjPIM).perform();
		Driver.findElement(By.linkText("Employee List")).click();
		Thread.sleep(2000);
		Driver.switchTo().frame("rightMenu");
		//create web element for search 
				WebElement Searchby=Driver.findElement(By.xpath("//div[@class='searchbox']/select"));
				WebElement Searchfor=Driver.findElement(By.xpath("//input[@name='loc_name']"));
				if(Searchby.isDisplayed() && Searchfor.isDisplayed() )
				{
					System.out.println("searchby and searchfor is displayed");
				}
				else
				{
					System.out.println("searchby and searchfor are not displayed");
				}
				Select sel=new Select(Searchby);
				sel.selectByValue("0");
				Searchfor.sendKeys("8713");
				Driver.findElement(By.xpath("//input[@value='Search']")).click();
		WebElement Del=Driver.findElement(By.xpath("//input[@value='Delete']"));
		Del.click();
	     Thread.sleep(2000);
				Alert A1=wait.until(ExpectedConditions.alertIsPresent());
				if(A1.getText().equals("Select at least one record to delete"))
				{
					System.out.println("Select at least one record to delete is Displayed");
					Thread.sleep(2000);
					 A1.accept();
				}
		WebElement check=Driver.findElement(By.xpath("//input[@class='checkbox']"));
		check.click();
		Thread.sleep(2000);
		Del.click();
	}
}
