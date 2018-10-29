package Excellsheets;

import java.io.File;
import java.io.IOException;

import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;

public class readsinglerowdata
{
	public static void main(String[] args)throws JXLException, IOException
	{
		//to take files as input take file
		File f1=new File("‪‪‪C:\\Excel\\12.xls");
		//load work book
		Workbook WB=Workbook.getWorkbook(f1);
		//Get specific sheet
		Sheet s1=WB.getSheet(1);
		int i=1;
		//sheet.getcell(coloumn index,rowindex)
		String a=s1.getCell(0,i).getContents();
		String b=s1.getCell(1,i).getContents();
		String c=s1.getCell(2,i).getContents();
		String d=s1.getCell(3,i).getContents();
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(a);
		
	}
	

}

