package vo;

public class UserVO {
    private String name;
    private String email;
    private String host;
    private String protocol;
    private String fromCount;
    private String fromPassword;

    public UserVO() {
    }

    public UserVO(String name, String email, String host, String protocol, String fromCount, String fromPassword) {
        this.name = name;
        this.email = email;
        this.host = host;
        this.protocol = protocol;
        this.fromCount = fromCount;
        this.fromPassword = fromPassword;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getFromCount() {
        return fromCount;
    }

    public void setFromCount(String fromCount) {
        this.fromCount = fromCount;
    }

    public String getFromPassword() {
        return fromPassword;
    }

    public void setFromPassword(String fromPassword) {
        this.fromPassword = fromPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
