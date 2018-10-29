package TestCasesEx;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class openapp 
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
		//click on add Employee
		WebElement addemp= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='nav']/li[2]/ul/li[2]/a/span")));
				addemp.click();
				//switch to frame
				Driver.switchTo().frame("rightMenu");
				//verify PIM:Add Employee
				if(Driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("PIM : Add Employee"))
					
						{
						System.out.println("PIM : Add Employee");
						}
				else
				{
					System.out.println("failed to display PIM : Add Employee text ");
				}
				
				//create Webelement for save button
				WebElement ObjSave=Driver.findElement(By.xpath("//input[@class='savebutton']"));
				//get Emp id
				String SEmpCode=Driver.findElement(By.name("txtEmployeeId")).getAttribute("value");
				//click on save
				ObjSave.click();
				//wait for alert
				Alert A=wait.until(ExpectedConditions.alertIsPresent());
				//verify alert message
				if(A.getText().equals("Last Name Empty!"))
				{
					System.out.println("Last Name Empty!Displayed");
				Thread.sleep(2000);
					A.accept();
				}
				//----------------------------------
				String SFN="swetha";
				String SLN="k";
				//--------------------
				//Enter last name
				Driver.findElement(By.name("txtEmpLastName")).sendKeys(SLN);
				Driver.findElement(By.name("txtEmpFirstName")).sendKeys(SFN);
				ObjSave.click();
				//Wait for personal details
				if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='mainHeading']/h2"), "Personal Details")))
				{
					System.out.println("Personal Details text displayed");
				}
				else	
				{
					System.out.println("Personal Details did not displayed");
				}
				//Switch to frame
					Driver.switchTo().defaultContent();
					//Mouse on PIM
					Act.moveToElement(ObjPIM).perform();
					//-----------------------
					//click on employee list
					Driver.findElement(By.linkText("Employee List")).click();
					Thread.sleep(2000);
					//Switch to frame
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));	
					//Verify Employee Information
					if(Driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Employee Information"))
					{
						System.out.println("Employee Information displayed");
					}
					else
					{
						System.out.println("Failed to display Employee Information text");
					}		
					//--------------------------------------------------------------------------
					//Get row count
					int rc=Driver.findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
					int i;
					for(i=1;i<=rc;i++)
					{
						//Get second column data
						String sEmpID=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
						//Get third column data
						String sEmpName=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
						if(sEmpID.equals(SEmpCode) && sEmpName.equals(SFN+" "+SLN))
						{
							System.out.println(SEmpCode+", "+sEmpName+" displayed at: "+i);
							break;
						}
					}
				
					//switch to top frame
					Driver.switchTo().defaultContent();
					//--------------------------------------------------------------------------
					//Click on logout
					ObjLogout.click();
					//wait 2 sec
					Thread.sleep(2000);
					//Verify home page
					if(Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
					{
						System.out.println("Signoff sucessfull & Home Page Displayed");
					}
					else
					{
						System.out.println("Failed to Signoff");
						return;
					}		
					//-----------------------------------------------------
					Driver.close();
					Driver.quit();
	}
}


					
				
		
			
		
	


