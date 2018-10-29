package Excellsheets;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class apachepoi 
{
	public static void main(String[] args) throws Exception
	{
		File f1=new File("‪G:\\seleniumQAPLANET\\5678.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f1);
		XSSFSheet sheet=wb.getSheet("QAPlanet");
		XSSFRow row;
		XSSFCell cell;
		Iterator<Row> rows=sheet.iterator();
		for(Row sr:sheet)
		{
			row=(XSSFRow)rows.next();
			Iterator<Cell> cells=row.cellIterator();
			cell=(XSSFCell)cells.next();
			System.out.println(cell.getStringCellValue()+"\t");
		}		
	
	}
		}

