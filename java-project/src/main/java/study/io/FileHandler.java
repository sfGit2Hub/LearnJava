package study.io;

import java.io.File;
import java.io.IOException;

/**
 * File 类处理测试
 */
public class FileHandler {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Project\\workspace\\LearnJava\\..\\project.log");
        System.out.println(file.getName());
//        D:\Project\workspace\project.log
        System.out.println(file.getCanonicalPath());
    }
}
