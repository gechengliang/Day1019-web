package com.qf.dao;

import com.qf.domain.Contact;
import com.qf.utils.DataSourceUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class QueryContactDAOImpl implements QueryContactDAO {
    //QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
    JdbcTemplate jdbcTemplate=new JdbcTemplate(DataSourceUtils.getDataSource());
    @Override
    public List<Contact> queryAll() {
        List<Contact> result=null;
        try {
            String s = "SELECT *FROM contact_info WHERE del=0";
            result = jdbcTemplate.query(s, new BeanPropertyRowMapper<>(Contact.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Contact> queryAll(int pageOffSet, int pageSize) {
        List<Contact> result=null;
        try {
            String s = "SELECT * FROM contact_info WHERE del=0 LIMIT ?,?";
            result = jdbcTemplate.query(s, new BeanPropertyRowMapper<>(Contact.class),pageOffSet,pageSize);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }




    @Override
    public int queryCount() {
        int result=0;
        try {
            String s = "SELECT COUNT(*)FROM contact_info WHERE del=0";
            result = jdbcTemplate.queryForObject(s, Integer.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  result;
    }

    @Override
    public int deleteById(String contactId) {
        int result=0;
        try{
            String s = "UPDATE contact_info SET del=1 WHERE id=?";
           result = jdbcTemplate.update(s, contactId);
        }catch(Exception e){
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Contact queryById(String contactId) {
        String s = "SELECT * FROM contact_info WHERE id=? AND del=0 ";
        List<Contact> query = jdbcTemplate.query(s, new BeanPropertyRowMapper<>(Contact.class), contactId);
        if(query.size()==1) {
            return query.get(0);
        }else {
            return null;
        }
    }

    @Override
    public int addById(Contact contact) {
        String s = "INSERT INTO contact_info(name,gender,birthday,birthplace,mobile,email)VALUES(?,?,?,?,?,?)";
        int update = jdbcTemplate.update(s, contact.getName(), contact.getGender(), contact.getBirthday(), contact.getBirthplace(), contact.getMobile(), contact.getEmail());
        return update;
    }

    @Override
    public int update(Contact contact) {
        String s = "UPDATE contact_info SET name=?,gender=?,birthday=?,birthplace=? ,mobile=? ,email=? WHERE id=?";
        int update = jdbcTemplate.update(s, contact.getName(), contact.getGender(), contact.getBirthday(), contact.getBirthplace(), contact.getMobile(), contact.getEmail(), contact.getId());

        return update;
    }


}
