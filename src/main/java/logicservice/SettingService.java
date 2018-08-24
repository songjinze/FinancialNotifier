package logicservice;

import vo.UserVO;

public interface SettingService {
    /**
     * 获得当前设置的信息
     * @return 用户信息值对象
     */
    UserVO getUserInfo();
    /**
     * 修改财务管理人
     * @param name 财务管理人名
     * @return true 修改成功 false 修改失败
     */
    boolean modifyName(String name);

    /**
     * 修改财务管理人邮箱地址
     * @param fromEmailAddress 财务管理者邮箱地址
     * @return true 修改成功 false 修改失败
     */
    boolean modifyFromEmailAddress(String fromEmailAddress);
}
