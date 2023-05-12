package dataDrivenTestng;

import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	XSSFWorkbook book;
	XSSFSheet sheet;
	
	public ExcelReader(String path)   {
		
		File fs=new File(path);
		try {
			FileInputStream fis= new FileInputStream(fs);
			   book=new XSSFWorkbook(fis);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}
	
	public int getrowCount(int sheetindex) {
		
		int rows=book.getSheetAt(sheetindex).getLastRowNum();
		rows=rows+1;
	
		return rows;
	}
	
	String getdata(int row,int cell,int sheetindex) {
       	sheet=book.getSheetAt(sheetindex);
		
		String data=sheet.getRow(row).getCell(cell).getStringCellValue();
		return data;
		
		
	}
				
		
	
	

}
