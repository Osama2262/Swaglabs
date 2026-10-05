package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;


public class ExcelFileManager {
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public  ExcelFileManager(String filePath, String sheetName ) {
        try {
            FileInputStream file = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheet(sheetName);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public  ExcelFileManager(String filePath, int sheetIndex) {
        try {
            FileInputStream file = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheetAt(sheetIndex);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public int getRowCount()
    {
        return sheet.getPhysicalNumberOfRows();
    }
    public int getColumnCount()
    {
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

    public String getFormula(int rowIndex,int colIndex)
    {
        Cell cell = sheet.getRow(rowIndex).getCell(colIndex);
        return cell.getCellFormula();
    }
    public String getCellValue(int rowIndex,int colIndex)
    {
        Cell cell = sheet.getRow(rowIndex).getCell(colIndex);
        DataFormatter dataFormatter = new DataFormatter();
        return dataFormatter.formatCellValue(cell);
    }
}
