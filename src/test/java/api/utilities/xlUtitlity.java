package api.utilities;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;

public class xlUtitlity {

    public FileInputStream fi;
    public FileOutputStream fo;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    public XSSFCellStyle style;


    String path;

    public xlUtitlity(String path){
        this.path = path;
    }

    public int getRowCount(String sheetName) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        workbook.close();
        fi.close();
        return rowCount;
    }

    public int getCellCount(String sheetName,int rownum) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rownum);
        int cellCount = row.getLastCellNum();
        workbook.close();
        fi.close();

        return cellCount;
    }

    public String getCellData(String sheetName,int rownum, int colnum) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rownum);
        cell = row.getCell(colnum);

        DataFormatter formatter = new DataFormatter();
        String data;

        data = formatter.formatCellValue(cell);
        workbook.close();
        fi.close();

        return data;
    }

    public void SetCellData(String sheetName, int rownum, int colnum,String data) throws IOException {
        File xlFile = new File(path);
        if(!xlFile.exists()){
            workbook = new XSSFWorkbook();
            fo = new FileOutputStream(path);
            workbook.write(fo);
        }

        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);

        if(workbook.getSheetIndex(sheetName) == -1){
            workbook.createSheet();
        }
        else{
            sheet = workbook.getSheet(sheetName);
        }

        if(sheet.getRow(rownum) == null){
            sheet.createRow(rownum);
        }
        else{
            row = sheet.getRow(rownum);
        }

        cell = row.createCell(colnum);
        cell.setCellValue(data);
        fo = new FileOutputStream(path);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }
}
