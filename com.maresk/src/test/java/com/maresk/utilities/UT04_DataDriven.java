package com.maresk.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UT04_DataDriven {

	public String DataFile;
	public UT02_ReadConfig rc;
	public String Filename;
	
	public UT04_DataDriven() throws IOException
	{
		rc = new UT02_ReadConfig() ;
		Filename = "../com.maresk/testdata/Testdata.xlsx";
	}
	
	public int getRowCount(String sheetname) throws IOException {
		FileInputStream file = new FileInputStream(Filename);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		return sheet.getLastRowNum();

	}

	public int getColCount(String sheetname) throws IOException {
		FileInputStream file = new FileInputStream(Filename);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		XSSFRow row = sheet.getRow(0);
		return row.getLastCellNum();
	}
	
	public String getValue(String sheetname, int rownum, int celnum) throws IOException
	{
		FileInputStream file = new FileInputStream(Filename);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		return sheet.getRow(rownum).getCell(celnum).getStringCellValue();
		
	}
	

	
}


