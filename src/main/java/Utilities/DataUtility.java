package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtility {

	public String dataFromPropertiesFile(String key) throws Throwable {
		File file = new File(IPathConstant.propertiesPath);
		FileInputStream fis = new FileInputStream(file);
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}

	public String dataFromExcelFile(String SheetName, int RowNum, int colNum) throws Throwable {
		File file = new File(IPathConstant.ExcelPath);
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);

		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(RowNum);

		DataFormatter formatter = new DataFormatter();
		String value = formatter.formatCellValue(row.getCell(colNum));
		return value;
	}
	
	public Object[][] aceessAllAddress() throws Throwable {

		
		System.out.println("second test case");
		File file = new File(IPathConstant.ExcelPath);
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");

		Object[][] ref = new Object[sheet.getLastRowNum()][9];
		DataFormatter form=new DataFormatter();
		int count=0;
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {			
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				ref[count][j]=form.formatCellValue(sheet.getRow(i).getCell(j)).toString();
			}
			count++;
		}
		return ref;
	}
}
