package com.baizhi.contorllers;

import com.baizhi.entity.Logs;
import com.baizhi.service.LogsService;
import org.apache.commons.collections4.iterators.ListIteratorWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created with IDEA
 * 类功能描述:
 *
 * @author:Z大 Date:2018/6/11
 * Time:20:33
 */
@Controller
@RequestMapping("/logs")
public class LogsController {
    @Autowired
    private LogsService logsService;
    @PostMapping(value = "queryLogs",produces={MediaType.APPLICATION_JSON_UTF8_VALUE} )
    public List<Logs> queryAllLogs(){
        List<Logs> logs = logsService.queryAllLogs();
        return logs;
    }
}
