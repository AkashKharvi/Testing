package com.crm.qa.pages;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExamplePractice {


	public static void main(String[] args) throws InterruptedException, IOException{
		Object[][] a1;
				File src = new File("/home/anupama/Documents/afolder/CreatingPost.xlsx");
				FileInputStream fls = new FileInputStream(src);
			try {
				XSSFWorkbook xb = new XSSFWorkbook(fls);
			XSSFSheet sheet1 = xb.getSheetAt(0);
				//	String data1;
			int i=0,j=0;
					int a=sheet1.getLastRowNum();
			int b=sheet1.getRow(0).getLastCellNum();
			
			System.out.println(b);
			
			System.out.println(a);
			System.out.println("---");
					
			/*for(Row row:sheet1){
				for(Cell cell:row) {
					System.out.println(cell.getStringCellValue());
					XSSFCell cell1= row.getStringCellValue()(cell); // on that row, get the value of each column of each row.
					String value = getStringCellValue(cell1);*/
			
			/*for (int i = 0; i < a; i++) {
				XSSFRow row = sheet1.getRow(i); // select and point to a specific row in my sheet it points according to the iteration
				for (int j = 0; j < b; j++) {
				String cell = row.getCell(j).toString();; // on that row, get the value of each column of each row.
				String value = cell; //convert a specific cell type(int,string/double etc) to a simple string – this I can get from the function HSSFcell
				xData[i][j] = value;
			}*/
			
			

            Iterator rowsit = sheet1.rowIterator();
            while (rowsit.hasNext()) {
            	
            		
            	Row row = (Row) rowsit.next();
                Iterator cells = row.cellIterator();
                while (cells.hasNext()) {
                	XSSFCell cell = (XSSFCell) cells.next();

                    CellType type = cell.getCellType();
                    if (type == CellType.STRING) {
                        System.out.println("[" + ((XSSFCell) cell).getRowIndex() + ", "
                                + cell.getColumnIndex() + "] = STRING; Value = "
                                + cell.getRichStringCellValue().toString());
                       a1[i][j]=cell.getRichStringCellValue().toString();
                        
                        
                    } else if (type == CellType.NUMERIC) {
                        System.out.println("[" + cell.getRowIndex() + ", "
                                + cell.getColumnIndex() + "] = NUMERIC; Value = "
                                + (int)cell.getNumericCellValue());
                        a1[i][j]=(int)cell.getNumericCellValue();
                        
                        
                    } else if (type == CellType.BOOLEAN) {
                        System.out.println("[" + cell.getRowIndex() + ", "
                                + cell.getColumnIndex() + "] = BOOLEAN; Value = "
                                + cell.getBooleanCellValue());
                        a1[i][j]=cell.getBooleanCellValue();
                        
                    } else if (type == CellType.BLANK) {
                        System.out.println("[" + cell.getRowIndex() + ", "
                                + cell.getColumnIndex() + "] = BLANK CELL");
                    }
                }
            }
            System.out.println(a1[i][j]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

					
	

	
 }

	


/*for(int i =0;i<a;i++)
{
	System.out.println(i);
	for(int j =0;j<b;j++)
	{
		
		System.out.println(j);

	}
	
	String data[][]=*/

