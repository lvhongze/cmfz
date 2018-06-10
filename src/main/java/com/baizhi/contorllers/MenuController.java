package com.baizhi.contorllers;


import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RequestMapping(value = "/menu")
@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;
    @RequestMapping(value = "/show")
    public List<Menu> showAll(){
        List<Menu> menus = menuService.queryMenu();
        return menus;

    }

}
