package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hc.client5.http.utils.DateUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	
	public static void loadBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static String loadTitle() {
		String title = driver.getTitle();
		return title;
		

	}
	public static void loadUrl(String url) {
		driver.get(url);

	}
	
	public static void fill(WebElement ele,String text) {
		ele.sendKeys(text);

	}
    
	
	public static void close() {
		driver.close();

	}
	
	public static String excelRead(String path,String sheetName,int rowNo,int colNo) throws IOException {
		
	File file=new File(path);
	FileInputStream fin=new FileInputStream(file);
	Workbook w=new XSSFWorkbook(fin);
	Sheet s=w.getSheet(sheetName);
	Row r=s.getRow(rowNo);
	Cell c=r.getCell(colNo);
	int cellType = c.getCellType();
	String value="";
	if (cellType==1) {
		value=c.getStringCellValue();
	}
	else if (DateUtil.isCellDateFormatted(c)) {
		Date d = c.getDateCellValue();
		SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
		value=sim.format(d);
		
	}
	else {
		double d=c.getNumericCellValue();
		long l=(long)d;
		value=String.valueOf(l);
	}
	return value;
	
}
	public static void excelWrite(String path,String sheetName, String text,int rowNo,int colNo) throws IOException {
		
		File file=new File(path);
		Workbook w=new XSSFWorkbook();
		Sheet s=w.createSheet(sheetName);
		Row r=s.createRow(rowNo);
		Cell c=r.createCell(colNo);
		c.setCellValue(text);
		FileOutputStream fout=new FileOutputStream(file);
		w.write(fout);
        System.out.println("Done successfully");
	}
public static void excelUpdate(String path,String sheetName, String text,String text2,int rowNo,int colNo) throws IOException {
		
		File file=new File(path);
		FileInputStream fin=new FileInputStream(file);
		Workbook w=new XSSFWorkbook();
		Sheet s=w.getSheet(sheetName);
		Row r=s.getRow(rowNo);
		Cell c=r.getCell(colNo);
		String value = c.getStringCellValue();
		if (value.equals(text)) {
			c.setCellValue(text2);
			
		}
		FileOutputStream fout=new FileOutputStream(file);
		w.write(fout);
		System.out.println("Done successfully");
 
	}

    public static void click(WebElement ele) {
		ele.click();

	}
}
