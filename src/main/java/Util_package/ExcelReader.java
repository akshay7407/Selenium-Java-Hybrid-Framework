package Util_package;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Base_Layer.baseClass;

public class ExcelReader extends baseClass {
	
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
   
    
	public ExcelReader(String excelFilePath) throws Exception {
		
		    File  file=new File(excelFilePath);
			FileInputStream fis=new FileInputStream(file);
			book=new XSSFWorkbook(fis);
		

	}
	
	public int lastRowCount(int sheetIndex) {
		sheet=book.getSheetAt(sheetIndex);
		int rows=sheet.getLastRowNum();
		rows=rows+1;
		return rows;
	}

	public String getData(int row , int cell ,int sheetIndex) {	
		
		String data=sheet.getRow(row).getCell(cell).getStringCellValue();
		
		return data;
	}

}
