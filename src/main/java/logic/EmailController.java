package logic;

import logicservice.EmailService;
import util.resultmessage.SendEmailMessage;

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

    @Override
    public SendEmailMessage sendEmail(double salary, String toAddress) {
        boolean res;
        try {
            res = new EmailSender(salary,toAddress).send();
        }catch (Exception e){
            e.printStackTrace();
            return SendEmailMessage.SEND_FAIL;
        }
        if(res){
            return SendEmailMessage.SEND_SUCCESS;
        }else{
            return SendEmailMessage.SEND_FAIL;
        }
    }
}
