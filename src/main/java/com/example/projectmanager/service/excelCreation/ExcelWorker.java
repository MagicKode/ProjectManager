//package com.example.projectmanager.service.excelCreation;
//
//import com.example.projectmanager.model.entity.Product;
//import com.example.projectmanager.model.entity.Retailer;
//import com.example.projectmanager.repository.ProductRepository;
//import com.fasterxml.jackson.databind.exc.InvalidFormatException;
//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.usermodel.HSSFFont;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.streaming.SXSSFRow;
//import org.apache.poi.xssf.streaming.SXSSFSheet;
//import org.apache.poi.xssf.streaming.SXSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//
//public class ExcelWorker {
//
//    private static ProductRepository productRepository;
//
//    public static void main(String[] args) throws FileNotFoundException {
//        //excel dataFile creation
//        XSSFWorkbook workbook = new XSSFWorkbook();
//        XSSFSheet sheet = workbook.createSheet("DataSheet");
//
//        //List<Product> products = fillData(1L);
//        int rowNum = 0;
//        Row row = sheet.createRow(rowNum);
//        row.createCell(0).setCellValue("Retailer");
//        row.createCell(1).setCellValue("Stock_Level");
//        row.createCell(2).setCellValue("StartDate");
//        row.createCell(3).setCellValue("EndDate");
//        for (ProductRepository product : productRepository.findAll()) {
//            createSheetHeader(sheet, ++rowNum, product);
//        }
//
//        try (FileOutputStream out = new FileOutputStream("C:\\DZ\\IT\\Projects\\ProjectManager\\DataFile.xlsx")) {
//            workbook.write(out);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Creation success");
//    }
//
//    private static void createSheetHeader(XSSFSheet sheet, int rowNum, Product product) {
//        Row row = sheet.createRow(rowNum);
//        row.createCell(0).setCellValue(product.getRetailers().add(new Retailer()));
//        row.createCell(1).setCellValue(product.getStockLevel());
//    }
//
//    // в реальных приложениях данные будут из БД или интернета
//    private static List<Product> fillData(Long id) {
//        Product productFromDb = productRepository.findById(id).orElseThrow();
//        List<Product> products = new ArrayList<>();
//        products.add(productFromDb);
//        return products;
//    }
//}
//
//
