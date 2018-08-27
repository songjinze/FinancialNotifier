package util.resultmessage;

public enum SendEmailMessage {

    SEND_SUCCESS("发送成功"),
    SEND_FAIL("发送失败");

    private String message;

    SendEmailMessage(String message) {
        this.message = message;
    }
}
