package logic;

import logicservice.SettingService;

public class Setting implements SettingService {
    public boolean modifyName(String name) {
        return false;
    }

    public boolean modifyFromEmailAddress(String fromEmailAddress) {
        return false;
    }
}
