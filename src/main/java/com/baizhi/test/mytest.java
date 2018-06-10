package com.baizhi.test;

import com.aliyuncs.exceptions.ClientException;
import com.baizhi.contorllers.UserController;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Menu;
import com.baizhi.entity.TitlePic;
import com.baizhi.service.AdminService;
import com.baizhi.service.MenuService;

import com.baizhi.service.TitlePicService;
import com.baizhi.service.UserService;
import com.baizhi.util.Poi;
import com.baizhi.util.SendMessage;
import com.baizhi.util.chapterutil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import java.io.File;
import java.io.IOException;
import java.util.List;

public class mytest {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        MenuService service = (MenuService)applicationContext.getBean("menuService");
        List<Menu> menus = service.queryMenu();
        for (Menu menu:menus) {
            System.out.println(menu);
        }
    }
    @Test
    public void test2(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AdminService service = (AdminService)applicationContext.getBean("adminService");
        Admin admin = service.queryAdmin("zhangs", "121233");
        System.out.println(admin);
    }
    @Test
    public void test3(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        TitlePicService service = (TitlePicService) applicationContext.getBean("titlePicService");
        List<TitlePic> titlePics = service.queryAllTitlePic();
        System.out.println(titlePics);
    }
    @Test
    public void test4(){
        ServletRequestAttributes requestAttributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String realPath = requestAttributes.getRequest().getSession().getServletContext().getRealPath("");
        File file=new File(realPath);
        File parentFile = file.getParentFile();
        System.out.println(parentFile);
    }
    @Test
    public void test5(){
        Workbook workbook = new HSSFWorkbook();
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        Sheet sheet = workbook.createSheet("用户");
        Row row = sheet.createRow(0);
    }
    @Test
        public void test6() throws IOException {
           Poi.imports();
    }
}
