package TestCasesEx;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddJobTitle 
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
				Act.moveToElement(Driver.findElement(By.linkText("Job"))).perform();
				Driver.findElement(By.linkText("Job Titles")).click();
				Driver.switchTo().frame("rightMenu");
				WebElement add=Driver.findElement(By.xpath("//input[@value='Add']"));
				add.click();
				WebElement Save=Driver.findElement(By.xpath("//input[@value='Save']"));
				Save.click();		
				Alert A=wait.until(ExpectedConditions.alertIsPresent());
				if (A.getText().equals("Job Title Name should be specified"))
				{
					System.out.println("Alert is present");
					Thread.sleep(2000);
					A.accept();
				}
				String titlename="Senior testengineer";
				WebElement name=Driver.findElement(By.xpath("//input[@type='text']"));
				name.sendKeys(titlename);
				Save.click();
				if (A.getText().equals("Job Description should be specified"))
				{
					System.out.println("Alert is present");
					Thread.sleep(2000);
					A.accept();
				}
				String des="XYZ";
				WebElement Desc=Driver.findElement(By.xpath("//textarea[@name='txtJobTitleDesc']"));
				Desc.sendKeys(des);
				Save.click();	
				Thread.sleep(2000);
				WebElement edit=Driver.findElement(By.xpath("//input[@value='Edit']"));
				edit.click();
				WebElement addstatus=Driver.findElement(By.xpath("//input[@value='Add Employment Status']"));
				addstatus.click();
				String Status="swetha";
				WebElement empstatus=Driver.findElement(By.xpath("//input[@id='txtEmpStatDesc']"));
				empstatus.sendKeys(Status);
				Thread.sleep(2000);
				Save.click();
				/*WebElement back=Driver.findElement(By.xpath("//input[@value='Back']"));
				back.click();
				List<WebElement> li=Driver.findElements(By.xpath("//table/tbody/tr/td/a"));
				Iterator<WebElement> itr=li.iterator();
				while(itr.hasNext())
				{
					itr.next();
					WebElement e=itr.next();
					if (e.getText().equals("Senior testengineer"))
					{
						System.out.println("Title is present");
					}
				
				}*/
	}
}
			

