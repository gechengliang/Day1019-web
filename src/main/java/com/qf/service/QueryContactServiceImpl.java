package com.qf.service;

import com.qf.dao.QueryContactDAO;
import com.qf.dao.QueryContactDAOImpl;
import com.qf.domain.Contact;

import java.util.List;

public class QueryContactServiceImpl implements QueryContactService{
    QueryContactDAO queryContactDAO=new QueryContactDAOImpl();

    @Override
    public List<Contact> queryAll() {


        return queryContactDAO.queryAll();
    }

    @Override
    public List<Contact> queryAll(int currentPage, int pageSize) {
        int pageOffSet=(currentPage-1)*pageSize;

        return queryContactDAO.queryAll(pageOffSet,pageSize);
    }

    @Override
    public int pageCount(int pageSize) {
        int recordCount = queryContactDAO.queryCount();
        return (int) Math.ceil(recordCount/pageSize);
    }

    @Override
    public boolean deleteById(String contactId) {
        int sum = queryContactDAO.deleteById(contactId);
        return sum==1;
    }

    @Override
    public Contact queryById(String contactId) {
        Contact contact = queryContactDAO.queryById(contactId);
        return contact;
    }

    @Override
    public boolean addById(Contact contact) {
        int i = queryContactDAO.addById(contact);
        return i==1;
    }

    @Override
    public boolean update(Contact contact) {
        int update = queryContactDAO.update(contact);
        return update==1;
    }
}
