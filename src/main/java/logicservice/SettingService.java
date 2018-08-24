package logicservice;

public interface SettingService {
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
