package Excellsheets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class propertyfile
{
	public static void main(String[] args) throws FileNotFoundException, IOException, Exception 
	{
		Properties obj=new Properties();
		obj.load(new FileInputStream("C:\\swetha\\hrmautomation\\swetha.properties"));
		String strurl=obj.getProperty("url");
		String strun=obj.getProperty("username");
		String strpwd=obj.getProperty("password");
		ChromeDriver Driver=new ChromeDriver();
		Driver.navigate().to(strurl);
		Thread.sleep(1000);
		Driver.findElement(By.name("txtUserName")).clear();
		Driver.findElement(By.name("txtUserName")).sendKeys(strun);
		Driver.findElement(By.name("txtPassword")).clear();
		Driver.findElement(By.name("txtPassword")).sendKeys(strpwd);
		Driver.findElement(By.name("Submit")).click();
		Thread.sleep(1000);
		Driver.findElement(By.linkText("Logout")).click();
		Driver.close();
		Driver.quit();
		

	}
}
