package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCredentialReader {
public String[]  getMyCredentials(int sheetno,int rowno) throws IOException
{
	FileInputStream fis = new FileInputStream("C:\\Users\\nakswath\\Desktop\\mycredentials.xlsx");
    XSSFWorkbook wb=new XSSFWorkbook(fis);
    
    XSSFSheet sheet=wb.getSheetAt(sheetno);
    int rowno1 = sheet.getLastRowNum();
    XSSFRow row =sheet.getRow(rowno1);
    
    XSSFCell cell1=row.getCell(0);
    XSSFCell cell2=row.getCell(1);
    
    String uname=cell1.getStringCellValue();
    String password=cell2.getStringCellValue();
    
    String data[]=new String[2];
    data[0]=uname;
    data[1]=password;
    wb.close();
    return data;
	
    
}
}
