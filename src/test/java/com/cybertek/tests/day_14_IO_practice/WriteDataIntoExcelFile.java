package com.cybertek.tests.day_14_IO_practice;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteDataIntoExcelFile {

    public static void main(String[] args) throws IOException {

        String path = "vytrack_testusers.xlsx";
        FileInputStream file = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet("QA2-short");
        Row row1 = sheet.getRow(2);
        Cell cell5 = row1.getCell(4);

        System.out.println("cell5 = " + cell5);

        cell5.setCellValue("PASSED");

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        System.out.println("cell5 = " + cell5);

        workbook.close();
        fileOutputStream.close();
        file.close();
    }
}
