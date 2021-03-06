package com.example.kent.sciencetestapp.project;


import android.app.Activity;
import android.util.Log;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

public class SpreadSheetMgr
{
    private static final String FILE_PATH_XLSX = "./xlsxtest.xls";
    private Activity context;
    private File file;
    private FileOutputStream fileOut = null;
    private FileInputStream fileIn = null;

    public SpreadSheetMgr(Activity context)
    {
        this.context = context;
    }

    public void test()
    {
        Workbook book = new HSSFWorkbook();
        Sheet sheet1 = book.createSheet("Test");
        Row row1 = sheet1.createRow(0);
        Cell cell1 = row1.createCell(0);
        cell1.setCellValue("PEEKABOO!");
    }

    public void loadWorkbook(String name)
    {
        //
    }

    public void writeToFile(String name)
    {
        file = new File(context.getExternalFilesDir(null), FILE_PATH_XLSX);

        // Write the output to a file
        try
        {
            fileOut = new FileOutputStream(file);
            //book.write(fileOut);
            fileOut.close();
            //book.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
