package com.actitime.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
/**
 * This Class contains all generic methods
 */
public class FileLib {
	/**
	 * This is a generic method For reading property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyData( String key) throws IOException {
		FileInputStream fis=new FileInputStream("./data/actiTime.property");
		Properties p=new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
	}
	/**
	 * This is a generic method For reading excel file
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String getExcelData(String sheetName,int row,int cell) throws EncryptedDocumentException,IOException 
	{
		Reporter.log("Sheet: " + sheetName + " | Row: " + row +  " | Cell: " + cell , true);
		FileInputStream fis=new FileInputStream("./data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	
	/**
	 * This is a generic method For writing excel file
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public void setExcelData(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 wb.getSheet(sheetName).getRow(row).getCell(cell).setCellValue("Passed");
		//convert java readable format to external resource file.;
		FileOutputStream fos = new FileOutputStream("./data/testscript.xlsx");
		wb.write(fos);

	}
}
