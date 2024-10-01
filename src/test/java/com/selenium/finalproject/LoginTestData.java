package com.selenium.finalproject;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.selenium.finalproject.BaseClass;

public class LoginTestData {
	@Test
	public Object[][] getData() throws IOException {

		DataFormatter df = new DataFormatter();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\AJINKYA\\eclipse-workspace\\SeleniumFinalProject\\ExcelSheets\\SeleniumProjectData.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(file);

		// Sheet
		XSSFSheet sheet = book.getSheet("Sheet1");

		// row
		int row = sheet.getLastRowNum();
		System.out.println(row);

		// column
		int column = sheet.getRow(0).getLastCellNum();
		System.out.println(column);

		Object logindata[][] = new Object[row + 1][column];

		for (int i = 0; i <= row; i++) {
			XSSFRow rows = sheet.getRow(i);

			for (int j = 0; j < column; j++) {
				XSSFCell cell = rows.getCell(j);

				CellType type = sheet.getRow(i).getCell(j).getCellType();
				switch (type) {
				case STRING:
					logindata[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
					break;
				case NUMERIC:
					logindata[i][j] = (int) sheet.getRow(i).getCell(j).getNumericCellValue();
					break;
				default:
					System.out.println("Other type: " + cell);
				}
			}
		}
		return logindata;

	}

}
