package orangehrm;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class TC2_AddEmployee {
		public static void main(String[] args) throws Exception
		{
			System.setProperty("webdriver.chrome.driver", "C:\\web drivers\\chromedriver.exe");
			ChromeDriver Driver=new ChromeDriver();
			//Maximize browser
			Driver.manage().window().maximize();
			//wait object
			WebDriverWait wait=new WebDriverWait(Driver, 60);
			//Actions class object
			Actions Act=new Actions(Driver);
			//------------------------------------------------
			//Open application
			Driver.get("http://apps.qaplanet.in/qahrm/login.php");
			//Verify home page
			if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
			{
				System.out.println("Home Page Displayed");
			}
			else
			{
				System.out.println("Failed to open home page");
				return;
			}
			//----------------------------------------------------------
			//Create WebElement
			WebElement objUserName=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
			WebElement objPassword=Driver.findElement(By.name("txtPassword"));
			WebElement objLogin=Driver.findElement(By.name("Submit"));
			WebElement objClear=Driver.findElement(By.name("clear"));
			//-------------------------------------------------------------
			//Verify user name
			if(objUserName.isDisplayed())
			{
				System.out.println("User name displayed");
			}
			//Verify password
			if(objPassword.isDisplayed())
			{
				System.out.println("Password displayed");
			}
			//Verify login and clear
			if(objLogin.isDisplayed() && objClear.isDisplayed())
			{
				System.out.println("Llogin and clear displayed");
			}
			//--------------------------------------------------------------
			String sUN="qaplanet1";
			String sPWD="lab1";
			//--------------------------------------------------------------
			//Login to orangeHRM
			objUserName.clear();
			objUserName.sendKeys(sUN);
			objPassword.clear();
			objPassword.sendKeys(sPWD);
			objLogin.click();
			//Verify OrangeHRM page
			if(wait.until(ExpectedConditions.titleIs("OrangeHRM")))
			{
				System.out.println("OrangeHRM Page Displayed");
			}
			else
			{
				System.out.println("Failed to login");
				return;
			}	
			//Get welcome text
			String sWelText=Driver.findElement(By.xpath("//ul[@id='option-menu']/li[1]")).getText();
			//Verify Welcome qaplanet1
			if(sWelText.equals("Welcome "+sUN))
			{
				System.out.println("Welcome "+sUN+" displayed");
			}
			//Way 2: Verify only user name
			String[] Arr=sWelText.split(" ");
			if(Arr[1].equals(sUN))
			{
				System.out.println(sUN+" displayed");
			}
			//---------------------------------------------------------
			WebElement objCP=Driver.findElement(By.linkText("Change Password"));
			WebElement objLogout=Driver.findElement(By.linkText("Logout"));
			//---------------------------------------------------------
			if(objCP.isDisplayed() && objLogout.isDisplayed())
			{
				System.out.println("Change Password and Logout are displayed");
			}
			//----------------------------------------------------------------------
			//Create webElement for PIM
			WebElement objPIM=Driver.findElement(By.linkText("PIM"));
			//Mouse over on PIM
			Act.moveToElement(objPIM).perform();
			//Click on addemployee
			Driver.findElement(By.linkText("Add Employee")).click();
			//wait 2 sec
			Thread.sleep(2000);
			//Switch to frame
			Driver.switchTo().frame("rightMenu");
			//Verify PIM : Add Employee
			if(Driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("PIM : Add Employee"))
			{
				System.out.println("PIM : Add Employee displayed");
			}
			else
			{
				System.out.println("Failed to display PIM : Add Employee text");
			}
			//--------------------------------------------------------------------------
			//Create webelement for Save button
			WebElement objSave=Driver.findElement(By.id("btnEdit"));
			//Get employee id
			String sEmpCode=Driver.findElement(By.name("txtEmployeeId")).getAttribute("value");
			//Click on save
			objSave.click();
			//wait for alert
			Alert A=wait.until(ExpectedConditions.alertIsPresent());
			//Verify alert message
			if(A.getText().equals("Last Name Empty!"))
			{
				System.out.println("Last Name Empty! displayed");
				A.accept();
			}
			//-------------------------------------------------
			String sFN="Sreedhar";
			String sLN="M";
			//--------------------------------------------------
			//Enter last name
			Driver.findElement(By.name("txtEmpLastName")).sendKeys(sLN);
			//Click on save
			objSave.click();
			//wait for alert
			Alert A1=wait.until(ExpectedConditions.alertIsPresent());
			//Verify alert message
			if(A1.getText().equals("First Name Empty!"))
			{
				System.out.println("First Name Empty! displayed");
				A1.accept();
			}		
			//Enter first name
			Driver.findElement(By.name("txtEmpFirstName")).sendKeys(sFN);
			//Click on save
			objSave.click();
			//wait for Personal Details
			if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='mainHeading']/h2"), "Personal Details")))
			{
				System.out.println("Personal Details text displayed");
			}
			else
			{
				System.out.println("Personal Details did not displayed");
			}
			//switch to parent frame
			Driver.switchTo().parentFrame();
			//------------------------------------------------------------------------------
			//Mouse over on PIM
			Act.moveToElement(objPIM).perform();
			//Click on Employee List
			Driver.findElement(By.linkText("Employee List")).click();
			//wait 2 sec
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
				if(sEmpID.equals(sEmpCode) && sEmpName.equals(sFN+" "+sLN))
				{
					System.out.println(sEmpCode+", "+sEmpName+" displayed at: "+i);
					break;
				}
			}
			//switch to top frame
			Driver.switchTo().defaultContent();
			//--------------------------------------------------------------------------
			//Click on logout
			objLogout.click();
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


