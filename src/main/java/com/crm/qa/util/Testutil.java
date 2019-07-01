package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.hssf.usermodel.HSSFCell;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class Testutil extends TestBase{
	
	
	public Testutil() throws IOException {
		
		
	}

	public static long implicittime=6000;
	public static long pt=20;
	
	public static long explixittime=30;
	 public static Workbook book;
	  public static Sheet sheet;
	 
	public static String excellocation="/home/anupama/javaeclipse/FreeCRMTest/src/main/java/com/crm/qa/testdata/CreatingPost.xlsx";
	
public static Object[][] getExcelData(String sheetname) throws Exception, IOException {
		
		FileInputStream fls=null;
		fls = new FileInputStream(excellocation);
		
		book=WorkbookFactory.create(fls);
					
			sheet=book.getSheet(sheetname);
		System.out.println("akash11");
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				System.out.println(i+"=="+j);
				
			
                         
			data[i][j]=sheet.getRow(i+1).getCell(j).toString();
             
			 /*FileInputStream fis = new FileInputStream(excellocation);
     		
	            XSSFWorkbook workbook = new XSSFWorkbook(fis);
	            XSSFSheet sheet = workbook.getSheet(sheetname);*/

	            Iterator rows = sheet.rowIterator();
	            
	            while (rows.hasNext()) {
	            	
	            
	                XSSFRow row = (XSSFRow) rows.next();
	                Iterator cells = row.cellIterator();
	                while (cells.hasNext()) 
	                {
	                    XSSFCell cell = (XSSFCell) cells.next();

	                    CellType type = cell.getCellType();
	                    if (type == CellType.STRING)
	                    {
	                        System.out.println("[" + cell.getRowIndex() + ", "
	                                + cell.getColumnIndex() + "] = STRING; Value = "
	                                + cell.getRichStringCellValue().toString());
	                        
	                    } else if (type == CellType.NUMERIC) 
	                    {
	                        System.out.println("[" + cell.getRowIndex() + ", "
	                                + cell.getColumnIndex() + "] = NUMERIC; Value = "
	                                + (int)cell.getNumericCellValue());
	                    } else if (type == CellType.BOOLEAN)
	                    {
	                        System.out.println("[" + cell.getRowIndex() + ", "
	                                + cell.getColumnIndex() + "] = BOOLEAN; Value = "
	                                + cell.getBooleanCellValue());
	                    } else if (type == CellType.BLANK) 
	                    {
	                        System.out.println("[" + cell.getRowIndex() + ", "
	                                + cell.getColumnIndex() + "] = BLANK CELL");
	                    }
	                }
	            }
				
		    }
		
		
	}
		return data;
	
		
		
   }

public static void screenshot(String FileName) throws Exception
{

	try {
		TakesScreenshot ts =  (TakesScreenshot)driver; //Typecast driver to get screenshot
		
		File source= ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(source,new File("./Screenshot/"+FileName +".png"));
	} catch (Exception e1) 
		// TODO Auto-generated catch block
		
	{
	
	System.out.println("Exception while taking screenshot" +e1.getMessage());
    }
 
   }        
 
}
