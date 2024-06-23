package com.hrm.hrm_pro.common;

import com.aspose.words.*;
import com.hrm.hrm_pro.model.system_emp.BankEmp;
import com.hrm.hrm_pro.repository.BankEmpRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
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

        public void getDocFile(List<Integer> arrayList, HttpServletRequest request, HttpServletResponse response){
            String pathFile = pathFile("shablon.docx");
            String pathLicense = pathFile("Aspose.Total.Java.lic");

            for (Integer emp_id : arrayList) {
                BankEmp bankEmp = bankEmpRepo.getBankEmpById(emp_id);
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
                    document.getRange().replace("/emp-fullname/", bankEmp.getFirstname() + " " + bankEmp.getLastname() + " " + bankEmp.getPatronymic(), new FindReplaceOptions(FindReplaceDirection.FORWARD));
                    document.getRange().replace("/emp-position/", bankEmp.getEmp_position(), new FindReplaceOptions(FindReplaceDirection.FORWARD));
                    document.getRange().replace("/bank-directorate/", bankEmp.getBank_direct(), new FindReplaceOptions(FindReplaceDirection.FORWARD));
                    document.getRange().replace("/conf-direct-level1/", bankEmp.getConf_direct_level1(), new FindReplaceOptions(FindReplaceDirection.FORWARD));
                    document.getRange().replace("/level-require/", bankEmp.getLevel_require(), new FindReplaceOptions(FindReplaceDirection.FORWARD));
                    document.getRange().replace("/emp-skill/", bankEmp.getEmp_skill(), new FindReplaceOptions(FindReplaceDirection.FORWARD));
                    document.getRange().replace("/main-obligation/", bankEmp.getMain_obligation(), new FindReplaceOptions(FindReplaceDirection.FORWARD));
                    document.getRange().replace("/func-desc/", bankEmp.getFunc_desc(), new FindReplaceOptions(FindReplaceDirection.FORWARD));
                    document.getRange().replace("/responsibility/", bankEmp.getResponsibility(), new FindReplaceOptions(FindReplaceDirection.FORWARD));
                    document.getRange().replace("/emp-law/", bankEmp.getEmp_law(), new FindReplaceOptions(FindReplaceDirection.FORWARD));
                    document.getRange().replace("/conf-direct-man1/", bankEmp.getConf_direct_man1(), new FindReplaceOptions(FindReplaceDirection.FORWARD));
                    document.getRange().replace("/conf-direct-level2/", bankEmp.getConf_direct_level2(), new FindReplaceOptions(FindReplaceDirection.FORWARD));
                    document.getRange().replace("/conf-direct-man3/", bankEmp.getConf_direct_man3(), new FindReplaceOptions(FindReplaceDirection.FORWARD));
                    document.getRange().replace("/now-date/", new SimpleDateFormat("dd.MM.yyyy").format(new Date()), new FindReplaceOptions(FindReplaceDirection.FORWARD));

                    ByteArrayOutputStream dstStream = new ByteArrayOutputStream();
                    OutputStream output = response.getOutputStream();
                    document.save(dstStream, SaveFormat.DOCX);
                    response.setCharacterEncoding("UTF-8");
                    response.setHeader("Content-Type", "application/docx; charset=UTF-8");
                    response.setHeader("Content-Disposition", "attachment;filename=\""+"Employee" + bankEmp.getEmp_id() + ".docx");
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
}
