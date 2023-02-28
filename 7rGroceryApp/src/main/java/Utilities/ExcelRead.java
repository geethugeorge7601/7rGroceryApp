package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelRead {

		XSSFSheet sh;
		Row r;
		Cell c;

		public ExcelRead() throws IOException{
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\ExcelFiles\\7rGroceryApp.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(file);
			sh = wb.getSheet("Sheet1");
		}
		public String readdata(int i, int j) {

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
			return null;

		}

		public int rowsize() {
			int rows = sh.getLastRowNum() + 1;
			return rows;
		}

		

	}


