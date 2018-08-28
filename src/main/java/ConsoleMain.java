import logicservice.LogicServiceFactory;
import logicservice.SettingService;
import util.resultmessage.SendEmailMessage;
import vo.EmployeeVO;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class ConsoleMain {
    public static void main(String[] args){
        System.out.print("当前用户为"+LogicServiceFactory.getSettingService().getUserInfo().getName()+",是否修改用户？[y/n]");
        Scanner scanner=new Scanner(System.in);
        String choice=scanner.nextLine();
        if(choice.equals("y")||choice.equals("Y")) {
            System.out.print("请输入用户名：");
            String user = scanner.nextLine();
            System.out.print("请输入密码：");
            String passwd = scanner.nextLine();
            System.out.print("请输入邮箱地址：");
            String email = scanner.nextLine();
            System.out.print("请输入邮箱host：");
            String host = scanner.nextLine();
            System.out.print("请输入邮箱协议：");
            String protocol = scanner.nextLine();
            System.out.print("请输入邮箱账户名：");
            String emailCount = scanner.nextLine();
            System.out.print("请输入邮箱密码：");
            String emailPasswd = scanner.nextLine();
            SettingService settingService = LogicServiceFactory.getSettingService();
            boolean settingRes = settingService.modifyName(user)
                    && settingService.modifyFromEmailAddress(email)
                    && settingService.modifyHost(host)
                    && settingService.modifyProtocol(protocol)
                    && settingService.modifyFromCount(emailCount)
                    && settingService.modifyFromPassword(emailPasswd);
            if (settingRes) {
                System.out.println("修改成功:)");
            }
        }
        System.out.println("请输入导入文件路径：");
        String path=scanner.nextLine();
        File file=new File(path);
        while(!file.exists()){
            System.out.println("文件不存在，请重新输入：");
            path=scanner.nextLine();
            file=new File(path);
        }
        List<EmployeeVO> employeeVOS=LogicServiceFactory.getSalaryManageService().getEmployeeList_csv(new File(path));
        for(EmployeeVO employeeVO:employeeVOS){
            SendEmailMessage message=LogicServiceFactory.getEmailService().sendEmail(employeeVO.getSalary(),
                    employeeVO.getEmail());
            if(message.equals(SendEmailMessage.SEND_SUCCESS)){
                System.out.println("发送至"+employeeVO.getName()+"成功");
            }else{
                System.out.println("发送至"+employeeVO.getName()+"失败");
            }
        }
    }
}
