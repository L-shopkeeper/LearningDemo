package com.example.jingyidemo.javaio;

import org.junit.Test;

import java.io.File;
import java.sql.SQLOutput;

public class JavaIOTest {

    @Test
    public void main() {
        //File对象既可以表示文件，又可以表示目录
        File file = new File("C:\\Windows\\notepad.exe");
        System.out.println(file);
        //判断filed对象是否是一个已存在的文件
        System.out.println(file.isFile());
        //判断filed对象是否是一个已存在的目录
        System.out.println(file.isDirectory());
    }


}
