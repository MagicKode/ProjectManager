package com.example.projectmanager.service.excelCreation;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Excel {
    public void excelData() throws IOException {
       /* File file = new File("C:\\DZ\\IT\\Projects\\Apache POI Excel File.xlsx");	//Temporary file path File created in advance Use this as a template
        XSSFWorkbook original = (XSSFWorkbook) WorkbookFactory.create(file);
        XSSFSheet orgSheet = original.getSheetAt(0);
        SXSSFWorkbook workbook = new SXSSFWorkbook(original);
        SXSSFSheet sheet = workbook.getSheetAt(0);
        Row baseRow = orgSheet.getRow(orgSheet.getLastRowNum());
        int rowCnt = 1;
        int rowNum = 6;
        boolean isFirst = true;
        for (1 acquired data: list) {    //list is pre-obtained, source is not specified
            SXSSFRow newRow = sheet.createRow(rowNum++);
            int cellCnt = 0;
            XSSFCell originCell = null;
            SXSSFCell newCell = null;
            CellStyle style = workbook.createCellStyle();
            if (isFirst) {    //Execute only the first line
                sheet.changeRowNum(newRow, 5);
                rowNum = 6;
                baseRow = newRow;
                isFirst = false;
            }
        }
        //Write to the output stream and get a byte array
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipSecureFile.setMinInflateRatio(0.001);	//It seems that it is checking the compression rate and the size of one entry...
        workbook.write(outputStream);
        excelData = outputStream.toByteArray();
        outputStream.close();
        workbook.close();
        original.close();
        //Delete temporary files
        file.delete();
        //Put the byte array in the response and download it*/
    }
}
