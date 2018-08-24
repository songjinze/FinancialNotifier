package logic;

import logicservice.EmailService;
import util.resultmessage.SendEmailMessage;

import java.io.File;

public class EmailController implements EmailService {
    private EmailController(){}
    private static volatile EmailController emailController;
    public static EmailController getInstance(){
        if(emailController==null){
            synchronized (EmailController.class){
                emailController=new EmailController();
            }
        }
        return emailController;
    }
    public SendEmailMessage sendEmail(File file, String toAddress) {
        // TODO 实现方法
        return null;
    }
}
