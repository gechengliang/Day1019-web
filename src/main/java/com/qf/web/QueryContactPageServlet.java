package com.qf.web;

import com.qf.domain.Contact;
import com.qf.service.QueryContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( "/query_contact_page")
public class QueryContactPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QueryContactServiceImpl queryContactService = new QueryContactServiceImpl();
        String strCurrentPage = request.getParameter("currentPage");
        int currentPage=1;
        if (strCurrentPage !=null) {
            currentPage = Integer.parseInt(strCurrentPage);
        }
        int pageSize=10;
        String strPageSize = request.getParameter("pageSize");
        if(strPageSize !=null) {
            pageSize = Integer.parseInt(strPageSize);
        }
        List<Contact> contacts = queryContactService.queryAll(currentPage, pageSize);
        int pageCount = queryContactService.pageCount(pageSize);
        int begin=1;
        int end=pageCount;
        if(currentPage>5)
            begin=currentPage-5;
        if(currentPage<pageCount-4)
            end=currentPage+4;
        if(currentPage<=5)
            end=10;
        if(end>pageCount)
            end=pageCount;
        if(currentPage>pageCount-4)
            begin=end-9;
        if(begin<1)
            begin=1;


        request.setAttribute("contact",contacts);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("pageSize",pageSize);
        request.setAttribute("beginPage",begin);
        request.setAttribute("endPage",end);



        request.getRequestDispatcher("/list.jsp").forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
