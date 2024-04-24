package com.hrm.hrm_pro.service;

import com.hrm.hrm_pro.model.system_emp.BankEmployeeOld;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ExcelUploadService {
    public static boolean isValidExcelFile(MultipartFile file){
        return Objects.equals(file.getContentType(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" );
    }

    public static List<BankEmployeeOld> getDataFromExcel(InputStream inputStream){
        List<BankEmployeeOld> bankEmployees = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("employees");
            int rowIndex =0;
            for (Row row : sheet){
                if (rowIndex ==0){
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                BankEmployeeOld bankEmployeeOld = new BankEmployeeOld();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cellIndex){
                        case 0 -> bankEmployeeOld.setCustomerId((int) cell.getNumericCellValue());
                        case 1 -> bankEmployeeOld.setFirstName(cell.getStringCellValue());
                        case 2 -> bankEmployeeOld.setLastName(cell.getStringCellValue());
                        case 3 -> bankEmployeeOld.setCountry(cell.getStringCellValue());
                        case 4 -> bankEmployeeOld.setTelephone(cell.getStringCellValue());
                        default -> {
                        }
                    }
                    cellIndex++;
                }
                bankEmployees.add(bankEmployeeOld);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return bankEmployees;
    }
}
