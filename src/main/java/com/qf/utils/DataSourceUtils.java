package com.qf.utils;



import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class DataSourceUtils implements ServletContextListener {
private static DataSource ds;
public static DataSource getDataSource(){
    return ds;
}
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            ServletContext servletContext = servletContextEvent.getServletContext();
            InputStream is = servletContext.getResourceAsStream("WEB-INF/db.properties");
            Properties properties = new Properties();
            properties.load(is);
            ds= DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
