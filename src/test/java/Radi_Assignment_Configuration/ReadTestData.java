package Radi_Assignment_Configuration;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;
import static Radi_Assignment_TestCase.BaseTest.testDataExcelFileName;

public class ReadTestData {
	public static final String currentDir = System.getProperty("user.dir");
    public static String testDataExcelPath = null;
    private static XSSFWorkbook excelWBook;
    private static XSSFSheet excelWSheet;
    private static XSSFCell cell;
    private static XSSFRow row;
    public static int rowNumber;
    public static int columnNumber;
    
    public static void setRowNumber(int pRowNumber) {
    	rowNumber = pRowNumber;
    }
    public static int getRowNumber() {
        return rowNumber;
    }
    public static void setColumnNumber(int pColumnNumber) {
        columnNumber = pColumnNumber;
    }
    public static int getColumnNumber() {
        return columnNumber;
    }
    //Set up path where Test data can read and write. 
    public static void setExcelFileSheet(String sheetName) throws Exception {

        if (Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
//            testDataExcelPath ="//Users//gopi//Gopi";
            testDataExcelPath ="/Users/gopi/eclipse-workspace1/AssignmentLogin/src/test/Excel";
        }
        try {
            FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
            excelWBook = new XSSFWorkbook(ExcelFile);
            excelWSheet = excelWBook.getSheet(sheetName);
        } catch (Exception e) {
            try {
                throw (e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    
    //Use to read test data from the cell and passing the parameters row and col. 
    public static String getCellData(int RowNum, int ColNum) throws Exception {
        try {
            cell = excelWSheet.getRow(RowNum).getCell(ColNum);
            String cellData = cell.getStringCellValue();
            return cellData;
        } catch (Exception e) {
            throw (e);
        }
    }
 
    //Pass row number as a parameter and returns the data of given row number.
    public static XSSFRow getRowData(int RowNum) throws Exception {
        try {
            row = excelWSheet.getRow(RowNum);
            return row;
        } catch (Exception e) {
            throw (e);
        }
    }
 
    //Its use to set a value to that cell. 
    public static void setCellData(String value, int RowNum, int ColNum) throws Exception {
        try {
            row = excelWSheet.getRow(RowNum);
            cell = row.getCell(ColNum);
            if (cell == null) {
                cell = row.createCell(ColNum);
                cell.setCellValue(value);
            } else {
                cell.setCellValue(value);
            }
            // Constant variables Test Data path and Test Data file name
            FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + testDataExcelFileName);
            excelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            try {
                throw (e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
	

}

