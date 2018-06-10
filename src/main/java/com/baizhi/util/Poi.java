package com.baizhi.util;


import com.baizhi.entity.User;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.*;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Poi {
    public static void exprot(String names,String value,List<User> users) throws IOException{
        String[] s1=names.split(",");
        String[] s2=value.split(",");
        Workbook workbook = new HSSFWorkbook();
        CellStyle cellStyle = workbook.createCellStyle();
        DataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy年MM月dd日");
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setDataFormat(format);
        Sheet sheet = workbook.createSheet("用户表");
        /*第一个参数是第几列  第二个参数列宽  进制256*/
        //sheet.setColumnWidth(0, 7680);
        //创建行   下标从0开始
        Row row = sheet.createRow(0);
        for (int i=0;i<s1.length;i++){
            //创建单元格
            Cell cell = row.createCell(i);
            cell.setCellValue(s1[i]);
        }
        //创建行
        for (int l=0;l<users.size();l++){
            Row row1 = sheet.createRow(l+1);
            for (int j=0;j<s2.length;j++){
                //创建单元格
                Class<User> userClass = User.class;
                String get="get"+s2[j].substring(0,1).toUpperCase()+s2[j].substring(1);
                Cell cell1 = row1.createCell(j);
                try {
                    //通过反射，用方法名获取类中方法对象              方法名                参数
                    Method declaredMethod = userClass.getDeclaredMethod(get, null);

                    //启动方法，返回执行结果        哪个对象调用方法    参数
                    Object invoke = declaredMethod.invoke(users.get(l), null);
                    System.out.println(invoke.toString());
                    //对invoke做判断，看如何转化他的类型
                    if (invoke instanceof Date) {
                        //设置当前列的宽度（第j行）
                        sheet.setColumnWidth(j, 20 * 256);
                        cell1.setCellValue((Date) invoke);
                    } else {
                        cell1.setCellValue(invoke.toString());
                    }
                }catch (Exception e){
                }
            }

        }
        workbook.write(new FileOutputStream(new File("f:/用户.xls")));
    }
    public static void imports() throws IOException {
        List<User> users=new ArrayList<>();
        Workbook workbook = new HSSFWorkbook(new FileInputStream("f:/用户.xls"));
        Sheet sheet = workbook.createSheet();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            User user = new User();
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0);
            String value = cell.getStringCellValue();
            user.setId(value);
            Cell cell1=row.getCell(1);
            String value1 = cell1.getStringCellValue();
            user.setName(value1);
            Cell cell2=row.getCell(2);
            String value2 = cell2.getStringCellValue();
            user.setPhotoNum(value2);
            Cell cell3=row.getCell(3);
            String value3 = cell3.getStringCellValue();
            user.setFarmington(value3);
            users.add(user);
        }

        for (User user : users) {
            System.out.println(user);
        }

    }
}
