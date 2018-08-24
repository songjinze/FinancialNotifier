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
        UserVO userVO=new UserVO();
        try {
            if(!config.exists()){
                config.getParentFile().mkdirs();
                config.createNewFile();
                UserVO newUser=new UserVO("","");
                modifyConfig(newUser);
            }
            BufferedReader bf = new BufferedReader(new FileReader(config));
            userVO.setName(bf.readLine());
            userVO.setEmail(bf.readLine());
        }catch(IOException e){
            e.printStackTrace();
        }
        return userVO;
    }
    private boolean modifyConfig(UserVO userVO){
        try{
            BufferedWriter bw=new BufferedWriter(new FileWriter(config));
            bw.write("");
            bw.append(userVO.getName());
            bw.newLine();
            bw.append(userVO.getEmail());
            bw.newLine();
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
}
