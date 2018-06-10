package com.baizhi.service;


import java.util.Map;

public interface FrontFirstPageService {
    Map<String,Object> queryFirstPage(String id,String type,String sub_type);
}
