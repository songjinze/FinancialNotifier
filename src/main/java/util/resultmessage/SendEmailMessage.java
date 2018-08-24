package util.resultmessage;

public enum SendEmailMessage {

    SEND_SUCCESS("发送成功");

    private String message;

    SendEmailMessage(String message) {
        this.message = message;
    }
}
