package excelUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import frameworkUtils.resusableComponent;

public class readDataFromExcel {

	
	public static String fetchdatafromExcel(int rownum, int colnum) throws InvalidFormatException, IOException {
		
		File file = new File(resusableComponent.Excelpath);
		FileInputStream stream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("FleetManagement");
		String data = sheet.getRow(1).getCell(1).getStringCellValue();	
		return data;
	}
}
