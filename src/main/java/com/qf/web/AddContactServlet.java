package com.qf.web;

import com.qf.domain.Contact;
import com.qf.service.QueryContactService;
import com.qf.service.QueryContactServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/add_contact")
public class AddContactServlet extends HttpServlet {
   private QueryContactService queryContactService=new QueryContactServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Contact contact=new Contact();

        try{
            BeanUtils.populate(contact,parameterMap);
        }catch(Exception e){
          e.printStackTrace();
        }
        queryContactService.addById(contact);
        response.sendRedirect("query_contact_page");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
