package com.baizhi.dao;

import com.baizhi.entity.Logs;

import java.util.List;

/**
 * Created with IDEA
 * 类功能描述:
 *
 * @author:Z大 Date:2018/6/11
 * Time:20:04
 */
public interface LogsDao {
    public void insertLogs(Logs logs);
    public List<Logs> queryAllLogs();
}
