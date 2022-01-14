package com.atguigu.easyexcel;

import com.alibaba.excel.EasyExcel;

public class TestRead {
    public static void main(String[] args) {
        //读取文件路径
        String fileName ="E:\\LearnPython\\code\\yishangtong\\excel\\01.xlsx";


        EasyExcel.read(fileName,UserData.class,new ExcelListener()).sheet().doRead();
    }
}
