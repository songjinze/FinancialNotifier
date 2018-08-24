package logicservice;

import vo.EmployeeVO;

import java.io.File;
import java.util.List;

public interface SalaryManageService {

    /**
     * 获得所有员工的信息
     * @param file 存放员工信息的原始文件
     * @return 员工信息列表
     */
    List<EmployeeVO> getEmployeeList_csv(File file);
}
