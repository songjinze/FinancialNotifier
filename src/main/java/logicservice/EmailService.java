package logicservice;

import util.resultmessage.SendEmailMessage;

import java.io.File;

public interface EmailService {

    /**
     * 给一个邮箱地址发送邮件
     * 其他需要的参数在用户设置文件中
     * @param file 发送的邮件内容
     * @param toAddress 发送目的地址
     * @return 发送结果信息
     */
    SendEmailMessage sendEmail(File file,String toAddress);
}
