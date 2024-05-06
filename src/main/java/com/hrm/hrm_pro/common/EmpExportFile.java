package com.hrm.hrm_pro.common;

import com.aspose.words.*;
import com.hrm.hrm_pro.dto.ExportIdDto;
import com.hrm.hrm_pro.model.system_emp.BankEmp;
import com.hrm.hrm_pro.repository.BankEmpRepo;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmpExportFile {
        final BankEmpRepo bankEmpRepo;

        public EmpExportFile(BankEmpRepo bankEmpRepo) {
                this.bankEmpRepo = bankEmpRepo;
        }

        public String pathFile(String fileName){
                URL url; String filePath;
                url = EmpExportFile.class.getResource("/static/files/" + fileName);
                assert url != null;
                filePath = url.getPath();
                return filePath;
        }

        public void getDocFile(Integer emp_id, HttpServletRequest request, HttpServletResponse response){
                String pathFile = pathFile("shablon.docx");
                String pathLicense = pathFile("Aspose.Total.Java.lic");

                        BankEmp bankEmp = bankEmpRepo.getBankEmployeeById(emp_id);
                        Document document = null;
                        License license = null;
                        InputStream fileStream = null;

                        try {
                                license = new License();
                                license.setLicense(pathLicense);
                                fileStream = new FileInputStream(pathFile);
                        }catch (Exception e){
                                e.printStackTrace();
                        }

                        try {
                            assert fileStream != null;
                            document = new Document(fileStream);
                                document.getRange().replace("/directorate/", bankEmp.getBank_direct(), new FindReplaceOptions(FindReplaceDirection.FORWARD));

                                ByteArrayOutputStream dstStream = new ByteArrayOutputStream();
                                OutputStream output = response.getOutputStream();
                                document.save(dstStream, SaveFormat.DOCX);
                                response.setCharacterEncoding("UTF-8");
                                response.setHeader("Content-Type", "application/docx; charset=UTF-8");
                                response.setHeader("Content-Disposition", "attachment;filename=\"" + bankEmp.getFirstname()+".docx");
                                output.write(dstStream.toByteArray());
                                output.flush();
                                fileStream.close();
                                output.close();
                                dstStream.close();
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
        }
}
