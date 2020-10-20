package com.qf.web;

import com.qf.domain.Contact;
import com.qf.utils.DataSourceUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( "/JDBC")
public class JDBCServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    testQueryList();
    testQueryOne();
    testQueryNumber();
    testUpdate();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public static void testQueryList() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtils.getDataSource());
        String s = "SELECT * FROM contact_info WHERE del=0";
        List<Contact> query = jdbcTemplate.query(s, new BeanPropertyRowMapper<>(Contact.class));

    }
    public static void testQueryOne() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtils.getDataSource());
        String s = "SELECT * FROM contact_info WHERE del=0 LIMIT 0,1";
        Contact contact = jdbcTemplate.queryForObject(s, new BeanPropertyRowMapper<>(Contact.class));
        System.out.println(contact);
    }
     public static void testQueryNumber() {
         JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtils.getDataSource());
         String s = "SELECT COUNT(*) FROM contact_info WHERE del=0";
         Integer integer = jdbcTemplate.queryForObject(s, Integer.class);
         System.out.println(integer);
     }
     public static  void testUpdate(){
             JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtils.getDataSource());
         String s = "INSERT INTO contact_info('name','gender','birthday','birthplace','mobile','email')VALUE(?,?,?,?,?,?)";
         int update = jdbcTemplate.update(s, "zhangsan", "男", "女", "1111", "大连", "12345678", "@qq.com");
         System.out.println(update);

     }


     }




