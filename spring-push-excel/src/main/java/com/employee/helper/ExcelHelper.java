package com.employee.helper;

import com.employee.model.Employee;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {
    /**
     * checks weather the content of the file
     * is in excel format or not
     * @param file
     * @return boolean
     */
    public static boolean hasExcelFormat(MultipartFile file) {  //check that file is of excel type or not

        String contentType = file.getContentType();
        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * this method iterates through each
     * row of the excel sheet and then through the cell of each particular row
     * retrieves the value from cell and sets the value to employee properties
     * @param inputStream
     * @return
     */
    public static List<Employee> excelToEmployee(InputStream inputStream) {
        List<Employee> employees = new ArrayList<>();

        try {
            Workbook workbook = new XSSFWorkbook(inputStream);

            Sheet sheet = workbook.getSheet("Sheet1");   //used to tell which sheet to be uploaded

            int rowNumber = 0;
            Iterator<Row> rows = sheet.iterator();  // iterates through each row in the particular sheet
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.cellIterator();
                int cellID = 0;
                Employee employee = new Employee();
                while (cellsInRow.hasNext()) {        // iterates through each cell in the particular row
                    Cell currentCell = cellsInRow.next();

                    switch (cellID) {  //depending upon each cell id the cell  statement extracts the value from tab assigns it to the
                                        // particular property of the Employee entity
                        case 0:
                            employee.setName(currentCell.getStringCellValue());
                            break;
                        case 1:
                            employee.setDesignation(currentCell.getStringCellValue());
                            break;
                        case 2:
                            employee.setDepartment(currentCell.getStringCellValue());
                            break;
                        case 3:
                            employee.setAddress(currentCell.getStringCellValue());
                            break;
                        case 4:
                            employee.setSalary(currentCell.getNumericCellValue());
                            break;
                        case 5:
                            employee.setExperience((int) currentCell.getNumericCellValue());
                            break;
                        default:
                            break;
                    }
                    cellID++;
                }
                employees.add(employee);
            }
            return employees;

        } catch (Exception e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }

    }
}
