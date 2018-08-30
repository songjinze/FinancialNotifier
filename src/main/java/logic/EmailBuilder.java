package logic;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import util.FileHelper;
import vo.UserVO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.List;

class EmailBuilder {
    private String mailContent;
    private final String toAddress;

    private String debug = "true";
    private String auth = "true";
    private String host;
    private String protocol = "smtp";
    private String subject = "通知";
    private String fromAddress;
    private String fromCount;
    private String fromPassword;

    EmailBuilder(double salary,String toAddress) {
        this.toAddress = toAddress;
        init(salary);
    }

    private void init(double salary) {
        UserVO userVO=Setting.getInstance().getUserInfo();
        this.host=userVO.getHost();
        this.protocol=userVO.getProtocol();
        this.fromAddress=userVO.getEmail();
        this.fromCount=userVO.getFromCount();
        this.fromPassword= userVO.getFromPassword();
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(getClass().getClassLoader().getResourceAsStream("pageTemplate.html"));
            Element root = document.getRootElement();
            Element name = getNodes(root, "id", "name");
            Element message = getNodes(root, "id", "message");
            Element time = getNodes(root, "id", "time");

            Calendar calendar = Calendar.getInstance();
            time.setText(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(calendar.DATE));
            message.setText(salary+"");

            File tempFile = new FileHelper().getResourceFile(Setting.getInstance().getUserInfo().getName()
                    + "/"
                    + "temp.html");
            FileWriter fileWriter = new FileWriter(tempFile.getPath());
            XMLWriter writer = new XMLWriter(fileWriter);
            writer.write(document);
            writer.flush();
            FileReader fileReader = new FileReader(tempFile.getPath());
            BufferedReader br = new BufferedReader(fileReader);
            String str = "";
            String temp = br.readLine();
            while (temp != null) {
                str += temp;
                temp = br.readLine();
            }
            br.close();
            this.mailContent = str;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 递归遍历子节点，根据属性值和属性名找到对应的节点
     *
     * @param node      要进行遍历的根节点
     * @param attrName  属性名
     * @param attrValue 属性值
     * @return 对应的节点或者null（没有符合条件的）
     */
    private Element getNodes(Element node, String attrName, String attrValue) {
        final List<Attribute> listAttr = node.attributes();
        for (final Attribute attr : listAttr) {
            final String name = attr.getName();
            final String value = attr.getValue();
            if (attrName.equals(name) && attrValue.equals(value)) {
                return node;
            }
        }
        final List<Element> listElemnet = node.elements();
        for (Element e : listElemnet) {
            Element temp = getNodes(e, attrName, attrValue);
            if (temp != null) {
                return temp;
            }
        }
        return null;
    }

    String getMailContent() {
        return mailContent;
    }

    String getToAddress() {
        return toAddress;
    }

    String getDebug() {
        return debug;
    }
    String getAuth() {
        return auth;
    }

    String getHost() {
        return host;
    }
    String getProtocol() {
        return protocol;
    }

    String getSubject() {
        return subject;
    }

    String getFromAddress() {
        return fromAddress;
    }
    String getFromCount() {
        return fromCount;
    }

    String getFromPassword() {
        return fromPassword;
    }
}
