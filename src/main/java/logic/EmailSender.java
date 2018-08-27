package logic;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {
    private final Properties prop = new Properties();
    private final Session session;
    private final Message message;
    private final Transport transport;
    private EmailBuilder builder;

    EmailSender(String toAddress) throws Exception {
        builder = new EmailBuilder(toAddress);
        prop.setProperty("mail.debug", builder.getDebug());
        prop.setProperty("mail.smtp.auth", builder.getAuth());
        prop.setProperty("mail.host", builder.getHost());
        prop.setProperty("mail.transport.protocol", builder.getProtocol());

        session = Session.getInstance(prop);
        message = new MimeMessage(session);
        transport = session.getTransport();
        message.setSubject(builder.getSubject());
        message.setFrom(new InternetAddress(builder.getFromAddress(), "通知"));
        transport.connect(builder.getFromCount(), builder.getFromPassword());
        message.setContent(builder.getMailContent(), "text/html;charset=utf-8");
    }

    public void send() {
        try {
            transport.sendMessage(this.message, new Address[]{
                    new InternetAddress(builder.getToAddress()),
                    new InternetAddress(builder.getToAddress())
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}