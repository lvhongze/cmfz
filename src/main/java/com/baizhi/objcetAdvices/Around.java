package com.baizhi.objcetAdvices;

import com.baizhi.dao.LogsDao;
import com.baizhi.entity.Logs;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * Created with IDEA
 * 类功能描述:
 *
 * @author:Z大 Date:2018/6/11
 * Time:19:38
 */
public class Around implements MethodInterceptor {
    @Autowired
    private LogsDao logsDao;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        /*日志  什么人 什么时间  什么事   管理员*/
        //什么人
        Logs logs = new Logs();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = requestAttributes.getRequest().getSession();
        Object user = session.getAttribute("user");
        System.out.println(String.valueOf(user));

        //save  中文 管理员添加  什么事
        Method method = invocation.getMethod();
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
        String name = annotation.name();


        //什么时间
        Date date = new Date();


        //执行结果
        boolean flag = false;
        Object proceed = null;
        //  原始方法执行之后的结果  返回值
        try {
            proceed = invocation.proceed();
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        String uuid = UUID.randomUUID().toString();
        logs.setId(uuid);
        logs.setName(name);
        logs.setMethod(method.getName());
        logs.setDate(date);
        if (flag){
            logs.setStatus(1);
        }else{
            logs.setStatus(0);
        }
        logsDao.insertLogs(logs);
        /*记录数据库*/
        return proceed;
    }
}
