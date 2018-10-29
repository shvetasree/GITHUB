package TestCasesEx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditEmployee
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
		Searchfor.sendKeys("8707");
		Driver.findElement(By.xpath("//input[@value='Search']")).click();
		Driver.findElement(By.xpath("//tbody/tr/td[3]/a")).click();
		Driver.findElement(By.xpath("//input[@value='Edit']")).click();
		//--------------------------
		String SFN="swetha Sree";
		String SLN="K";
		
	WebElement lastname=Driver.findElement(By.name("txtEmpLastName"));
	lastname.clear();
	lastname.sendKeys(SLN);
		WebElement firstname=Driver.findElement(By.name("txtEmpFirstName"));
		firstname.clear();
	firstname.sendKeys(SFN);
		Driver.findElement(By.xpath("//input[@class='savebutton']")).click();
		Driver.switchTo().defaultContent();
		Act.moveToElement(ObjPIM).perform();
		Driver.findElement(By.linkText("Employee List")).click();
		Driver.switchTo().frame("rightMenu");
		int rc=Driver.findElements(By.xpath("//table/tbody/tr")).size();
		for(int i=1;i<=rc;i++)
		{
			WebElement id=Driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]"));
			WebElement name=Driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]/a"));
			if(id.getText().equals("8707") && name.getText().equals("swetha Sree K")) 
			{
				System.out.println(id.getText()+" "+name.getText()+" "+i);
				break;
			}
		}
		
		
	
		
	}
}
	

