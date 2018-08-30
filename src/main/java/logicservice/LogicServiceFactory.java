package logicservice;

import logic.EmailController;
import logic.SalaryManage;
import logic.Setting;

public class LogicServiceFactory {
    public static SalaryManageService getSalaryManageService(){
        return SalaryManage.getInstance();
    }
    public static EmailService getEmailService(){
        return EmailController.getInstance();
    }
    public static SettingService getSettingService(){
        return Setting.getInstance();
    }
}
