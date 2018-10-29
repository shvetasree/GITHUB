package orangehrm;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class workwitmulbrowser
{

public static void main(String[] args) throws Exception

{
	System.setProperty("webdriver.chrome.driver","C:\\web drivers\\chromedriver.exe");
	ChromeDriver Driver=new ChromeDriver();
    Driver.manage().window().maximize();
    //------------------------------------
    Driver.get("http://qaplanet.in");
    Thread.sleep(2000);
    //clicked on linked icon
    Driver.findElement(By.xpath("//*[@id='section-tophat']/div/div/div/ul/li[4]/a/img")).click();
    Thread.sleep(4000);
    Set<String> IDS=Driver.getWindowHandles();
    //way 1
    for(String ID:IDS)
    {
    	System.out.println(ID);
    }
    System.out.println("-----------------------");
    //way 2
    Iterator<String> ITR=IDS.iterator();
    String First_ID=ITR.next();
    String Second_ID=ITR.next();
    // switch to second browser
    Driver.switchTo().window(Second_ID);
    Thread.sleep(2000);
    //click on sign in
    Driver.findElement(By.linkText("Sign in")).click();
    Thread.sleep(2000);
    //enter email
    Driver.findElement(By.name("session_key")).sendKeys("qaplanet@gmail.com");
    Thread.sleep(2000);
    //---------------------------------
    //Switch to parent browser
    Driver.switchTo().window(First_ID);
    Thread.sleep(2000);
    //click on just dail icon
    Driver.findElement(By.xpath("//*[@id='section-tophat']/div[1]/div/div[2]/ul/li[5]/a/img")).click();
    //execute code
    Thread.sleep(3000);
    //--------------------
    Driver.close();
    Driver.quit();
}
}

