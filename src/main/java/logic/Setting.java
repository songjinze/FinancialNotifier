package logic;

import logicservice.SettingService;
import util.FileHelper;
import vo.UserVO;

import java.io.*;

public class Setting implements SettingService {
    private static volatile Setting setting;
    private Setting(){
        config= new FileHelper().getResourceFile("config.dat");
    }
    public static Setting getInstance(){
        if(setting==null){
            synchronized (Setting.class){
                setting=new Setting();
            }
        }
        return setting;
    }
    private File config;
    public UserVO getUserInfo(){
        UserVO userVO=new UserVO("sjz",
                "734609160@qq.com",
                "smtp.qq.com",
                "smtp",
                "734609160@qq.com",
                "ftxybikjkzldbfff");
        try {
            if(!config.exists()){
                config.getParentFile().mkdirs();
                config.createNewFile();
                modifyConfig(userVO);
            }
            BufferedReader bf = new BufferedReader(new FileReader(config));
            userVO.setName(bf.readLine());
            userVO.setEmail(bf.readLine());
            userVO.setHost(bf.readLine());
            userVO.setProtocol(bf.readLine());
            userVO.setFromCount(bf.readLine());
            userVO.setFromPassword(bf.readLine());
        }catch(IOException e){
            e.printStackTrace();
        }
        File userFolder=new FileHelper().getResourceFile(userVO.getName());
        userFolder.mkdirs();
        return userVO;
    }
    private boolean modifyConfig(UserVO userVO){
        File userFolder=new File(userVO.getName());
        userFolder.mkdirs();
        try{
            BufferedWriter bw=new BufferedWriter(new FileWriter(config));
            bw.write("");
            bw.append(userVO.getName());
            bw.newLine();
            bw.append(userVO.getEmail());
            bw.newLine();
            bw.append(userVO.getHost());
            bw.newLine();
            bw.append(userVO.getProtocol());
            bw.newLine();
            bw.append(userVO.getFromCount());
            bw.newLine();
            bw.append(userVO.getFromPassword());
            bw.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
        return true;
    }

    public boolean modifyName(String name) {
        UserVO userVO=getUserInfo();
        userVO.setName(name);
        return modifyConfig(userVO);
    }

    public boolean modifyFromEmailAddress(String fromEmailAddress) {
        UserVO userVO=getUserInfo();
        userVO.setEmail(fromEmailAddress);
        return modifyConfig(userVO);
    }

    public boolean modifyHost(String host) {
        UserVO userVO=getUserInfo();
        userVO.setHost(host);
        return modifyConfig(userVO);
    }

    public boolean modifyProtocol(String protocol) {
        UserVO userVO=getUserInfo();
        userVO.setProtocol(protocol);
        return modifyConfig(userVO);
    }

    public boolean modifyFromCount(String fromCount) {
        UserVO userVO=getUserInfo();
        userVO.setFromCount(fromCount);
        return modifyConfig(userVO);
    }

    public boolean modifyFromPassword(String fromPassword) {
        UserVO userVO=getUserInfo();
        userVO.setFromPassword(fromPassword);
        return modifyConfig(userVO);
    }
}
