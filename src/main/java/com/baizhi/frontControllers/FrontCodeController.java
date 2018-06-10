package com.baizhi.frontControllers;

import com.aliyuncs.exceptions.ClientException;
import com.baizhi.util.SendMessage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/identify")
public class FrontCodeController {
    @GetMapping(value = "/obtain")
    public void getCode(String phone, ModelMap map) throws ClientException {
        String s = SendMessage.sendMessage(phone);
    }
}
