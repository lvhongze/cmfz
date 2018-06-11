package com.baizhi.service;

import com.baizhi.dao.LogsDao;
import com.baizhi.entity.Logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 * 类功能描述:
 *
 * @author:Z大 Date:2018/6/11
 * Time:20:30
 */
@Service
public class LogsServiceImpl implements LogsService{
    @Autowired
    private LogsDao logsDao;
    @Override
    public List<Logs> queryAllLogs() {
        List<Logs> logs = logsDao.queryAllLogs();
        return logs;
    }
}
