package logicservice;

import org.junit.Test;
import vo.UserVO;

import static org.junit.Assert.*;

public class SettingServiceTest {

    @Test
    public void getUserInfo() {
        UserVO userVO=LogicServiceFactory.getSettingService().getUserInfo();
        assertNotNull(userVO);
        assertNotNull(userVO.getName());
        assertNotNull(userVO.getEmail());
    }

    @Test
    public void modifyName() {
        String oldName=LogicServiceFactory.getSettingService().getUserInfo().getName();
        String testName="testName";
        LogicServiceFactory.getSettingService().modifyName(testName);
        assertEquals(testName,LogicServiceFactory.getSettingService().getUserInfo().getName());
        LogicServiceFactory.getSettingService().modifyName(oldName);
    }

    @Test
    public void modifyFromEmailAddress() {
        String oldFromEmailAddress=LogicServiceFactory.getSettingService().getUserInfo().getEmail();
        String testEmail="123@test.com";
        LogicServiceFactory.getSettingService().modifyFromEmailAddress(testEmail);
        assertEquals(testEmail,LogicServiceFactory.getSettingService().getUserInfo().getEmail());
        LogicServiceFactory.getSettingService().modifyFromEmailAddress(oldFromEmailAddress);
    }

    @Test
    public void modifyHost() {
        String oldHost=LogicServiceFactory.getSettingService().getUserInfo().getHost();
        String testHost="smtp.test.com";
        LogicServiceFactory.getSettingService().modifyHost(testHost);
        assertEquals(testHost,LogicServiceFactory.getSettingService().getUserInfo().getHost());
        LogicServiceFactory.getSettingService().modifyHost(oldHost);
    }

    @Test
    public void modifyProtocol() {
        String oldProtocol=LogicServiceFactory.getSettingService().getUserInfo().getProtocol();
        String testProtocol="testSMTP";
        LogicServiceFactory.getSettingService().modifyProtocol(testProtocol);
        assertEquals(testProtocol,LogicServiceFactory.getSettingService().getUserInfo().getProtocol());
        LogicServiceFactory.getSettingService().modifyProtocol(oldProtocol);
    }

    @Test
    public void modifyFromCount() {
        String oldCount=LogicServiceFactory.getSettingService().getUserInfo().getFromCount();
        String testCount="testCount";
        LogicServiceFactory.getSettingService().modifyFromCount(testCount);
        assertEquals(testCount,LogicServiceFactory.getSettingService().getUserInfo().getFromCount());
        LogicServiceFactory.getSettingService().modifyFromCount(oldCount);
    }

    @Test
    public void modifyFromPassword() {
        String oldPassword=LogicServiceFactory.getSettingService().getUserInfo().getFromPassword();
        String testPassword="testPassword";
        LogicServiceFactory.getSettingService().modifyFromPassword(testPassword);
        assertEquals(testPassword,LogicServiceFactory.getSettingService().getUserInfo().getFromPassword());
        LogicServiceFactory.getSettingService().modifyFromPassword(oldPassword);
    }
}