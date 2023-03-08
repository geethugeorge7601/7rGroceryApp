package DataProvider;

import org.testng.annotations.DataProvider;

import Utilities.ExcelRead;


public class DataProviderClass {
	@DataProvider (name= "create_data")
	public static Object[][] DataSet() throws Exception {

		ExcelRead excel = new ExcelRead();
		Object[][] arrayObject = excel.getExcelData(
				System.getProperty("user.dir") + "\\src\\main\\resources\\ExcelFiles\\7rGroceryApp.xlsx", "Sheet2");
		return arrayObject;
	}

}
