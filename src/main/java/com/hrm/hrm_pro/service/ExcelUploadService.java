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
                        case 0 -> bankEmployeeOld.setNumber((int) cell.getNumericCellValue());
                        case 1 -> bankEmployeeOld.setCode_unique(cell.getStringCellValue());
                        case 2 -> bankEmployeeOld.setBank_block(cell.getStringCellValue());
                        case 3 -> bankEmployeeOld.setBank_direct(cell.getStringCellValue());
                        case 4 -> bankEmployeeOld.setBank_dep(cell.getStringCellValue());
                        case 5 -> bankEmployeeOld.setBank_dep_insade(cell.getStringCellValue());
                        case 6 -> bankEmployeeOld.setEmp_position(cell.getStringCellValue());
                        case 7 -> bankEmployeeOld.setEmp_level(cell.getStringCellValue());
                        case 8 -> bankEmployeeOld.setEmp_manager(cell.getStringCellValue());
                        case 9 -> bankEmployeeOld.setSub_employee(cell.getStringCellValue());
                        case 10 -> bankEmployeeOld.setLevel_require(cell.getStringCellValue());
                        case 11 -> bankEmployeeOld.setEmp_skill(cell.getStringCellValue());
                        case 12 -> bankEmployeeOld.setMain_obligation(cell.getStringCellValue());
                        case 13 -> bankEmployeeOld.setFunc_desc(cell.getStringCellValue());
                        case 14 -> bankEmployeeOld.setResponsibility(cell.getStringCellValue());
                        case 15 -> bankEmployeeOld.setEmp_law(cell.getStringCellValue());
                        case 16 -> bankEmployeeOld.setConf_direct_man1(cell.getStringCellValue());
                        case 17 -> bankEmployeeOld.setConf_direct_man2(cell.getStringCellValue());
                        case 18 -> bankEmployeeOld.setConf_direct_man3(cell.getStringCellValue());
                        case 19 -> bankEmployeeOld.setConf_direct_man4(cell.getStringCellValue());
                        case 20 -> bankEmployeeOld.setFullname(cell.getStringCellValue());
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
