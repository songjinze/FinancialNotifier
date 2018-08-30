package logicservice;

import org.junit.Test;
import util.resultmessage.SendEmailMessage;

import static org.junit.Assert.*;

public class EmailServiceTest {

    @Test
    public void sendEmail() {
        assertEquals(SendEmailMessage.SEND_SUCCESS,LogicServiceFactory.getEmailService().sendEmail(10000,"734609160@qq.com"));
    }
}