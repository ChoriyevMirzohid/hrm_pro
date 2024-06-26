package com.hrm.hrm_pro.service;

import com.hrm.hrm_pro.model.system_emp.BankEmp;
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

    public static List<BankEmp> getDataFromExcel(InputStream inputStream){
        List<BankEmp> bankEmployees = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("emp-sheet");
            int rowIndex = 0;
            for (Row row : sheet){
                if (rowIndex == 0){
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                BankEmp bankEmp = new BankEmp();
                bankEmp.setCondition("1");
                bankEmp.setCreation_type("import");
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();

                    switch (cellIndex){
                        case 0 -> bankEmp.setNumber((int) cell.getNumericCellValue());
                        case 1 -> bankEmp.setCode_unique(cell.getStringCellValue());
                        case 2 -> bankEmp.setBank_block(cell.getStringCellValue());
                        case 3 -> bankEmp.setBank_direct(cell.getStringCellValue());
                        case 4 -> bankEmp.setBank_dep(cell.getStringCellValue());
                        case 5 -> bankEmp.setBank_dep_insade(cell.getStringCellValue());
                        case 6 -> bankEmp.setEmp_position(cell.getStringCellValue());
                        case 7 -> bankEmp.setEmp_level(cell.getStringCellValue());
                        case 8 -> bankEmp.setEmp_manager(cell.getStringCellValue());
                        case 9 -> bankEmp.setSub_employee(cell.getStringCellValue());
                        case 10 -> bankEmp.setLevel_require(cell.getStringCellValue());
                        case 11 -> bankEmp.setEmp_skill(cell.getStringCellValue());
                        case 12 -> bankEmp.setMain_obligation(cell.getStringCellValue());
                        case 13 -> bankEmp.setFunc_desc(cell.getStringCellValue());
                        case 14 -> bankEmp.setResponsibility(cell.getStringCellValue());
                        case 15 -> bankEmp.setEmp_law(cell.getStringCellValue());
                        case 16 -> bankEmp.setConf_direct_man1(cell.getStringCellValue());
                        case 17 -> bankEmp.setConf_direct_level1(cell.getStringCellValue());
                        case 18 -> bankEmp.setConf_direct_man2(cell.getStringCellValue());
                        case 19 -> bankEmp.setConf_direct_man3(cell.getStringCellValue());
                        case 20 -> bankEmp.setConf_direct_level2(cell.getStringCellValue());
                        case 21 -> bankEmp.setConf_direct_man4(cell.getStringCellValue());
                        case 22 -> bankEmp.setFirstname(cell.getStringCellValue());
                        default -> {
                        }
                    }
                    cellIndex++;
                }
                if (bankEmp.getFirstname()!=null){
                    bankEmployees.add(bankEmp);
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return bankEmployees;
    }
}
