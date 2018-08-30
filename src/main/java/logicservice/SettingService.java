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

    /**
     * 修改邮箱host
     * @param host 新host
     * @return  true 修改成功 false 修改失败
     */
    boolean modifyHost(String host);

    /**
     * 修改邮箱协议
     * @param protocol 新协议
     * @return true 修改成功 false 修改失败
     */
    boolean modifyProtocol(String protocol);

    /**
     * 修改邮箱账户名
     * @param fromCount 新帐户名
     * @return true 修改成功 false 修改失败
     */
    boolean modifyFromCount(String fromCount);

    /**
     * 修改邮箱密码
     * @param fromPassword 新密码
     * @return true 修改成功 false 修改失败
     */
    boolean modifyFromPassword(String fromPassword);
}
