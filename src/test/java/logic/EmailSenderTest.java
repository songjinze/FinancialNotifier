package logic;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmailSenderTest {

    @Test
    public void send() throws Exception{
        new EmailSender("734609160@qq.com").send();
    }


}