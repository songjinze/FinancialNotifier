package logic;

import logicservice.SalaryManageService;
import vo.EmployeeVO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SalaryManage implements SalaryManageService {
    private SalaryManage(){}
    private static volatile SalaryManage salaryManage;
    public static SalaryManage getInstance(){
        if(salaryManage==null){
            synchronized (SalaryManage.class){
                salaryManage=new SalaryManage();
            }
        }
        return salaryManage;
    }
    public List<EmployeeVO> getEmployeeList_csv(File file) {
        List<EmployeeVO> res=new ArrayList<EmployeeVO>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String oneItem=bf.readLine();
            while(oneItem!=null){
                String[] information=oneItem.split(",");
                res.add(new EmployeeVO(information[0], Double.parseDouble(information[1]),information[2]));
                oneItem=bf.readLine();
            }
            bf.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return res;
    }
}
