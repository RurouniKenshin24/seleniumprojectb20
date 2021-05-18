package com.cybertek.tests.day_14_IO_practice;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ReadExcelFile {

    public static void main(String[] args) throws IOException {
        String path = "vytrack_testusers.xlsx";
        File file = new File(path);
        Workbook workbook = WorkbookFactory.create(file);

        int numberOfSheets = workbook.getNumberOfSheets();
        System.out.println("numberOfSheets = " + numberOfSheets);

        System.out.println("=================================");

        workbook.forEach(sh -> System.out.println(sh.getSheetName()));

        Sheet sheet = workbook.getSheet("QA3-short");
        Row row1 = sheet.getRow(0);
        Cell cell1 = row1.getCell(0);

        String value1 = cell1.getStringCellValue();

        System.out.println("=================================");

        System.out.println("value1 = " + value1);

        System.out.println("=================================");

        Iterator<Cell> cellIterator = row1.cellIterator();
        while (cellIterator.hasNext()){
            String cellValue = cellIterator.next().getStringCellValue() + " ";
            System.out.print(cellValue);
        }

        System.out.println();
        System.out.println("=================================");

        //Wrong way of writing hole sheet!!!
        //sheet.forEach(rows -> rows.forEach(cells -> System.out.print(cells.getStringCellValue() + " ")));

        int rowNumbers = sheet.getPhysicalNumberOfRows();

        for (int i = 0;i < rowNumbers;i++){
             Row row = sheet.getRow(i);
             Iterator<Cell> cellIterator1 = row.cellIterator();
             while (cellIterator1.hasNext()){
                 String cellValue = cellIterator1.next().getStringCellValue();
                 System.out.print(cellValue + " | ");
             }
            System.out.println();
        }

        System.out.println("=================================");

        for (Row row: sheet){
            for (Cell cell: row){
                String cellValue = cell.getStringCellValue();
                System.out.print(cellValue + " ");
            }
            System.out.println();
        }
    }
}
