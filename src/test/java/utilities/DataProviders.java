package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "Login")
	public String [][] getData() throws IOException
	{
		String path = ".\\testData\\Opencart_LoginDetails.xlsx";
		
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int rowCount = xlutil.getRowCount("Sheet1");
		System.out.println("Row Count " + rowCount);
		
		
		int colCount = xlutil.getCellCount("Sheet1", 1);
		System.out.println("Col Cocunt " + colCount);
		
		
		String loginData[][] = new String[rowCount-1][colCount];
		
		for(int i=1; i<rowCount; i++)
		{
			for(int j=0; j<colCount; j++)
			{
				loginData[i-1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		return loginData;
	}

}
