package TestCasesEx;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import orangehrm.nestedif;

public class EditLocation 
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
		Driver.switchTo().frame("rightMenu");
		//create webelemt for searchby and search for
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
		searchfor.sendKeys("LOC026");
		Driver.findElement(By.xpath("//input[@value='Search']")).click();
		Driver.findElement(By.xpath("//tbody/tr/td[2]/a")).click();
		Driver.findElement(By.xpath("//input[@value='Edit']")).click();
		String nameloc="chennai";
		WebElement name=Driver.findElement(By.xpath("//input[@id='txtLocDescription']"));
		name.clear();
		name.sendKeys(nameloc);
		WebElement Country=Driver.findElement(By.xpath("//select[@id='cmbCountry']"));
		Select sele=new Select(Country);
		sele.selectByVisibleText("Australia");
		String add="tnagar chennai";
		WebElement Address=Driver.findElement(By.xpath("//textarea[@id='txtAddress']"));
		Address.clear();
		Address.sendKeys(add);
		String zip="500081";
		WebElement zipcode=Driver.findElement(By.xpath("//input[@id='txtZIP']"));
		zipcode.clear();
		zipcode.sendKeys(zip);
		WebElement save=Driver.findElement(By.xpath("//input[@id='editBtn']"));
		save.click();
		List<WebElement> li=Driver.findElements(By.xpath("//table/tbody/tr/td/a"));
		Iterator<WebElement> itr=li.iterator();
		while(itr.hasNext())
		{
			System.out.println("....................");
			itr.next();
			WebElement e=itr.next();
			/*String a=e.getText();*/
			if (e.getText().equals("chennai")) 
			{
				System.out.println("name changed");
				break;
			}
		}
	}
}
