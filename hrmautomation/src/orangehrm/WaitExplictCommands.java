package orangehrm;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitExplictCommands
{
	

	public static void main(String[] args) {
		
		// Create a new instance of the chromedriver
		System.setProperty("webdriver.chrome.driver","C:\\web drivers\\chromedriver.exe");
		WebDriver Driver=new ChromeDriver();
				Driver.manage().window().maximize();
				WebDriverWait wait= new WebDriverWait(Driver,20);
			    Driver.get("http://classroom:8888/index.php?action=Login&module=Users");
		
			    // wait for title  
			    wait.until(ExpectedConditions.titleIs("vtiger CRM 5 - Commercial Open Source CRM"));
			    if(Driver.getTitle().equals("vtiger CRM 5 - Commercial Open Source CRM"))
			    {
			    	System.out.println("title displayed");
			    }
			    else
			    {
			    	System.out.println("title not displayed");
			    	return;
			    }
			    //wait contains or not
			    wait.until(ExpectedConditions.titleContains("vtiger CRM 5 - Commercial Open Source CRM"));
			    if(Driver.getTitle().contains("vtiger CRM 5 - Commercial Open Source CRM"))
			    {
			    	System.out.println("title contains");
			    }
			    else
			    {
			    	System.out.println("title not contains");
			    	return;
			    }
			    //wait for element present
			    wait.until(ExpectedConditions.presenceOfElementLocated(By.name("user_name")));
			    WebElement objun=Driver.findElement(By.name("user_name"));
				WebElement objPWD=Driver.findElement(By.name("user_password"));
				WebElement objlogin=Driver.findElement(By.id("submitButton"));
				if(objun.isDisplayed()&&objPWD.isDisplayed()&&objlogin.isDisplayed())
				{
			    	System.out.println("true");
			    }
			    else
			    {
			    	System.out.println("flase");
			    	return;
			    }
				String sUN="qaplanet1";
				objun.clear();
				objun.sendKeys(sUN);
				String sPWD="lab1";
				objPWD.clear();
				objPWD.sendKeys(sPWD);	
			    objlogin.click();
			    //wait of text present
			    wait.until(ExpectedConditions.titleIs("user1 - Home - vtiger CRM 5 - Commercial Open Source CRM"));
			    if(Driver.getTitle().equals("user1 - Home - vtiger CRM 5 - Commercial Open Source CRM"))
			    {
			    	System.out.println("main page title displayed");
			    }
			    else
			    {
			    	System.out.println("main page title not displayed");
			    	return;
			    }
			    boolean b=wait.until(ExpectedConditions.attributeContains(By.xpath("//input[@name='query_string']"), "type", "text"));
			    System.out.println(b);
			    WebElement calender=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Calendar')]")));
			    if(calender.isDisplayed())
			    {
			    	System.out.println("calender displayed");
			    }
			    else
			    {
			    	System.out.println("not displayed");
			    	return;
			    }
			    WebElement img = Driver.findElement(By.xpath("//table[@class='small']/descendant::td[@class='small']/img"));
			    Actions logoutbutton= new Actions(Driver);
			    logoutbutton.moveToElement(img).perform();
			   
			    WebElement objlogout=Driver.findElement(By.linkText("Sign Out"));
			    wait.until(ExpectedConditions.elementToBeClickable(objlogout));
			    if(objlogout.isDisplayed())
			    {
			    	System.out.println("true");
			    }
			    else
			    {
			    	System.out.println("flase");
			    }
			    objlogout.click();
			    		    
	}

}
