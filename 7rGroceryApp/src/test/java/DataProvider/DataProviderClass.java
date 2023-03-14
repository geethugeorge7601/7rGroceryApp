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

	@DataProvider (name= "create_page")
	public static Object[][] DataSet2() throws Exception {

		ExcelRead excel = new ExcelRead();
		Object[][] arrayObject = excel.getExcelData(
				System.getProperty("user.dir") + "\\src\\main\\resources\\ExcelFiles\\PageDetails.xlsx", "Sheet1");
		return arrayObject;
	}
	@DataProvider (name= "add_deliveryboy")
	public static Object[][] DataSet3() throws Exception {

		ExcelRead excel = new ExcelRead();
		Object[][] arrayObject = excel.getExcelData(
				System.getProperty("user.dir") + "\\src\\main\\resources\\ExcelFiles\\PageDetails.xlsx", "Sheet2");
		return arrayObject;
	}
}
