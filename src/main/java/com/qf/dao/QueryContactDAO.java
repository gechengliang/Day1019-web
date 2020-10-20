package com.qf.dao;

import com.qf.domain.Contact;

import java.util.List;

public interface QueryContactDAO {
    List<Contact> queryAll();
    List<Contact> queryAll(int pageOffSet, int pageSize);

    int queryCount();


    int deleteById(String contactId);

    Contact queryById(String contactId);

    int addById(Contact contact);

    int update(Contact contact);
}
