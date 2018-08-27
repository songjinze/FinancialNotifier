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
    private UserVO userVO;
    public UserVO getUserInfo(){
        try {
            if(!config.exists()){
                config.getParentFile().mkdirs();
                config.createNewFile();
                UserVO newUser=new UserVO("","","","","","");
                this.userVO=newUser;
                modifyConfig();
            }else{
                userVO=new UserVO();
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
    private boolean modifyConfig(){
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

    @Override
    public boolean modifyName(String name) {
        userVO.setName(name);
        return modifyConfig();
    }

    @Override
    public boolean modifyFromEmailAddress(String fromEmailAddress) {
        userVO.setEmail(fromEmailAddress);
        return modifyConfig();
    }

    @Override
    public boolean modifyHost(String host) {
        userVO.setHost(host);
        return modifyConfig();
    }

    @Override
    public boolean modifyProtocol(String protocol) {
        userVO.setProtocol(protocol);
        return modifyConfig();
    }

    @Override
    public boolean modifyFromCount(String fromCount) {
        userVO.setFromCount(fromCount);
        return modifyConfig();
    }

    @Override
    public boolean modifyFromPassword(String fromPassword) {
        userVO.setFromPassword(fromPassword);
        return modifyConfig();
    }
}
