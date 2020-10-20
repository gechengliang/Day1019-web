package com.qf.service;

import com.qf.domain.Contact;

import java.util.List;

public interface QueryContactService {
List<Contact> queryAll();
List<Contact> queryAll(int currentPage, int pageSize);
int pageCount(int pageSize);
boolean deleteById(String contactId);
Contact queryById(String contactId);

boolean addById(Contact contact);
boolean update(Contact contact);
}
