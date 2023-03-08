package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	XSSFSheet sh;
	Row r;
	Cell c;

	public String[][] getExcelData(String fileName, String sheetName) {

		String[][] arrayExcelData = null;
		try {
			File excelfile = new File(fileName);
			FileInputStream file = new FileInputStream(excelfile);
			XSSFWorkbook wb = new XSSFWorkbook(file);
			sh = wb.getSheet(sheetName);
			int noOfRows = sh.getPhysicalNumberOfRows();
			int noOfColumns = sh.getRow(0).getLastCellNum();
			arrayExcelData = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					c = sh.getRow(i + 1).getCell(j);
					DataFormatter df = new DataFormatter();
					arrayExcelData[i][j] = df.formatCellValue(c);
				}
			}
			wb.close();
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		}
		return arrayExcelData;
	}

	public String readdata(int i, int j) {
		FileInputStream file;
		try {
			file = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resources\\ExcelFiles\\7rGroceryApp.xlsx");

			XSSFWorkbook wb = new XSSFWorkbook(file);
			sh = wb.getSheet("sheet1");
			r = sh.getRow(i);
			c = r.getCell(j);
			CellType type = c.getCellType();
			switch (type) {
			case NUMERIC:
				double data = c.getNumericCellValue();
				return String.valueOf(data);

			case STRING:
				return c.getStringCellValue();
			default:
				break;

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
