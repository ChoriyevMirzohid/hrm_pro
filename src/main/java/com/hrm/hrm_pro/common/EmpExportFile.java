package com.hrm.hrm_pro.common;

import com.aspose.words.*;
import com.hrm.hrm_pro.model.system_emp.BankEmp;
import com.hrm.hrm_pro.repository.BankEmpRepo;
import com.hrm.hrm_pro.service.BankEmpS;
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

@Service
public class EmpExportFile {
        final BankEmpRepo bankEmpRepo;

        public EmpExportFile(BankEmpRepo bankEmpRepo) {
                this.bankEmpRepo = bankEmpRepo;
        }

        public String pathFile(HttpServletRequest request){
                ServletContext servletContext = request.getServletContext();
                String contextPath = servletContext.getRealPath("/");
                URL file = null; String filePath = null;  String pathFile = null;
                try {
                        file = servletContext.getResource("/static/files/shablon.docx");
                } catch (MalformedURLException ex) {
                        ex.printStackTrace();
                }
                System.out.println(contextPath);
                        filePath = file.getPath();
                        pathFile = contextPath == null ? filePath : contextPath;

                System.out.println(pathFile);
                return pathFile;
        }

        public void getDocFile(Integer emp_id, HttpServletRequest request, HttpServletResponse response){
                String pathFile = "C:\\Users\\user\\Desktop\\Gulasal\\shablon.docx";
                String pathLicense = "D:\\JavaProjects\\hrm_pro\\src\\main\\resources\\Aspose.Total.Java.lic";
                Document document = null;
                License license = null;
                InputStream fileStream = null;
                String filename = "hrm-doc.docx";
                pathFile(request);
                try {
                        license = new License();
                        license.setLicense(pathLicense);
                        fileStream = new FileInputStream(pathFile);
                }catch (Exception e){
                        e.printStackTrace();
                }

                BankEmp bankEmp = bankEmpRepo.getBankEmployeeById(emp_id);

                try {
                        document = new Document(fileStream);
                        document.getRange().replace("/directorate/", bankEmp.getBank_direct(), new FindReplaceOptions(FindReplaceDirection.FORWARD));

                        ByteArrayOutputStream dstStream = new ByteArrayOutputStream();
                        OutputStream output = response.getOutputStream();
                        document.save(dstStream, SaveFormat.DOCX);
                        response.setCharacterEncoding("UTF-8");
                        response.setHeader("Content-Type", "application/pdf; charset=UTF-8");
                        response.setHeader("Content-Disposition", "attachment;filename=\"" + filename);
                        output.write(dstStream.toByteArray());
                        output.flush();
                        fileStream.close();
                        output.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
}
