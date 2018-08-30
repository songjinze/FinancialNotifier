package logicservice;

import org.junit.Test;
import util.FileHelper;
import vo.EmployeeVO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class SalaryManageServiceTest {

    @Test
    public void getEmployeeList_csv() {
        File temp= new FileHelper().getResourceFile("testFile.csv");
        try {
            if(!temp.exists()) {
                temp.createNewFile();
            }
            BufferedWriter bf=new BufferedWriter(new FileWriter(temp));
            bf.append("lihua,123.99,734609170@qq.com");
            bf.newLine();
            bf.append("xiaoming,55.11,734609160@qq.com");
            bf.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
        List<EmployeeVO> employeeVOS=LogicServiceFactory.getSalaryManageService().getEmployeeList_csv(temp);
        assertEquals(2,employeeVOS.size());
    }
}