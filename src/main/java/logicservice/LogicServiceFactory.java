package logicservice;

import logic.SalaryManage;

public class LogicServiceFactory {
    public static SalaryManageService getSalaryManageService(){
        return SalaryManage.getInstance();
    }
    public static EmailService getEmailService(){
        // TODO 实现方法
        return null;
    }
    public static SettingService getSettingService(){
        // TODO 实现方法
        return null;
    }
}
