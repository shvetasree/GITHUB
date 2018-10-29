package TestCasesEx;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddLoction 
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
		WebElement Add=Driver.findElement(By.xpath("//input[@value='Add']"));
			Add.click();
		WebElement Save=Driver.findElement(By.xpath("//input[@class='savebutton']"));
		Save.click();
		Alert A=wait.until(ExpectedConditions.alertIsPresent());
		if(A.getText().equals("Please correct the following\n\n\t- Location Name has to be specified\n\t- Country should be selected!\n\t- Address should be specified\n\t- Zip Code should be specified\n"))
	    {
			System.out.println("Alert is Displayed");
			A.accept();	
		}
		Timestamp ts=new Timestamp(System.currentTimeMillis());
		String name="Hyderabad "+ts;
		Driver.findElement(By.xpath("//input[@name='txtLocDescription']")).sendKeys(name);
		Save.click();
		if(A.getText().equals("Please correct the following\n\n\t- Country should be selected!\n\t- Address should be specified\n\t- Zip Code should be specified\n"))
	    {
			System.out.println("Alert is Displayed");
			Thread.sleep(2000);
			A.accept();	
			}
		WebElement Country=Driver.findElement(By.xpath("//select[@id='cmbCountry']"));
		Select sel=new Select(Country);
		sel.selectByVisibleText("India");
		Save.click();
		if(A.getText().equals("Please correct the following\n\n\t- Address should be specified\n\t- Zip Code should be specified\n"))
	    {
			System.out.println("Alert is Displayed");
			Thread.sleep(2000);
			A.accept();	
			}
		String Address="h.no:3-2-162,madhapur,hyd";
		Driver.findElement(By.xpath("//textarea[@id='txtAddress']")).sendKeys(Address);
		Save.click();
		if(A.getText().equals("Please correct the following\n\n\t- Zip Code should be specified\n"))
	    {
			System.out.println("Alert is Displayed");
			Thread.sleep(2000);
			A.accept();	
			}
		String Zipcode="500081";
		Driver.findElement(By.xpath("//input[@id='txtZIP']")).sendKeys(Zipcode);
		Thread.sleep(2000);
		Save.click();
		String code=Driver.findElement(By.xpath("//table/descendant::td/a[contains(text(),'"+name+"')]/ancestor::td/preceding-sibling::td[1]/a")).getText();		int rc=Driver.findElements(By.xpath("//table/tbody/tr")).size();
		for(int i=1;i<=rc;i++)
		{
			WebElement locid=Driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]/a"));
			WebElement locname=Driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]/a"));
			if (locid.getText().equals(code) && locname.getText().equals(name))
			{
				System.out.println(locid.getText() +" "+locname.getText() +" "+i);
				break;
			}
			
		}
		
		}
	}

