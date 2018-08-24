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
        String testName="testName";
        LogicServiceFactory.getSettingService().modifyName(testName);
        assertEquals(testName,LogicServiceFactory.getSettingService().getUserInfo().getName());
    }

    @Test
    public void modifyFromEmailAddress() {
        String testEmail="test@123.com";
        LogicServiceFactory.getSettingService().modifyFromEmailAddress(testEmail);
        assertEquals(testEmail,LogicServiceFactory.getSettingService().getUserInfo().getEmail());
    }
}