package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public FileInputStream fin;
	public Workbook book;
	public Sheet sh;
	public Row ro;
	public Cell ce;
	public FileOutputStream fout;
	public DataFormatter df;
	String path;
	
	public ExcelUtility(String path)
	{
		this.path=path;
	}
	
	@SuppressWarnings("unused")
	public int getRowCount(String sheetName) throws IOException
	{
		fin = new FileInputStream(path);
		book = WorkbookFactory.create(fin);
		sh = book.getSheet(sheetName);
		int rowcount = sh.getPhysicalNumberOfRows();//getLastRowNum();
		
		/*
		 * int actualRows = 0;
		 * 
		 * for(int i=0; i<=rowcount; i++) { Row row = sh.getRow(i); if(row != null &&
		 * row.getPhysicalNumberOfCells()>0) { actualRows++; } }
		 */
		
				    
		book.close();
		fin.close();
		return rowcount;		
	}
	
	public int getCellCount(String sheetName, int rownum) throws IOException
	{
		fin = new FileInputStream(path);
		book = WorkbookFactory.create(fin);
		sh = book.getSheet(sheetName);
		ro = sh.getRow(rownum);
		int cellcount = ro.getLastCellNum();
		book.close();
		fin.close();
		return cellcount;
	}
	
	public String getCellData(String sheetName, int rownum, int colnum) throws IOException
	{
		try
		{
		fin = new FileInputStream(path);
		book = WorkbookFactory.create(fin);
		sh = book.getSheet(sheetName);
		ro = sh.getRow(rownum);
		ce = ro.getCell(colnum);
		
		df = new DataFormatter();
		String data = df.formatCellValue(ce);
		book.close();
		fin.close();
		return data;
		} 
		catch (Exception e)
		{
			return "";			
		}
	}
	
	public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException
	{
		try {
		fin = new FileInputStream(path);
		book = WorkbookFactory.create(fin);
		
		// If sheet not exist
		
		sh = book.getSheet(sheetName);
		if (sh == null) 
		{
			sh = book.createSheet(sheetName);
		}
		
		// If row and col not exist
		
		ro = sh.getRow(rownum);
		if (ro == null)
		{
			ro = sh.createRow(rownum);
		}
		
		ce = ro.getCell(colnum);
		{
			ce = ro.createCell(colnum);
		}
		
		ce.setCellValue(data);
		
		fin.close();
		
		fout = new FileOutputStream(path);
		fout.close();
		
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}

}
