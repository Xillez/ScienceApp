package com.example.kent.sciencetestapp;


import android.app.Activity;
import android.util.Log;

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

public class SpreadSheetMgr
{
    private static final String FILE_PATH_XLSX = "./xlsxtest.xlsx";
    private Activity context;
    private File file;
    private FileOutputStream fileOut = null;
    private FileInputStream fileIn = null;

    SpreadSheetMgr(Activity context)
    {
        this.context = context;
    }

    public void test()
    {
        Workbook book = null;
        if (context.getFilesDir().exists() && context.getFilesDir().canRead() && context.getFilesDir().canWrite())
            file = new File(context.getFilesDir(), FILE_PATH_XLSX);

        try
        {
            fileOut = new FileOutputStream(file);
            /*fileOut.close();
            fileIn = new FileInputStream(file);*/

            book = WorkbookFactory.create(file);
            book.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (InvalidFormatException e)
        {
            e.printStackTrace();
        }

        if (book != null)
        {
            Sheet sheet = book.createSheet("TestSheet");

            Row row = sheet.createRow(0);

            Cell cell = row.createCell(0);

            cell.setCellValue("HELLUUUUUU!!!!!");

            // Write the output to a file
            try
            {
                book.write(fileOut);
                fileOut.close();

                // Closing the workbook
                book.close();
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            } catch (IOException e)
            {
                e.printStackTrace();
            }

            Log.i("KENT_", sheet.getSheetName());
        }
        //sheet
    }
}
