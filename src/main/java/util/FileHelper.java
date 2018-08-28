package util;

import java.io.File;

public class FileHelper {

    /**
     * 获得相对于resources目录下的文件索引
     *
     * @param filePath 相对于resources的文件目录
     * 如resources/test.csv, 则filePath="test.csv"
     * @return 文件流
     */
    public File getResourceFile(String filePath){
        return new File(this.getClass().getResource("/").getPath()+filePath);
    }
}
