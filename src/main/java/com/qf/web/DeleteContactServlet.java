package com.qf.web;

import com.qf.service.QueryContactService;
import com.qf.service.QueryContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/delete_contact")
public class DeleteContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QueryContactService contactService=new QueryContactServiceImpl();
        String id = request.getParameter("id");
        contactService.deleteById(id);
        response.sendRedirect("query_contact_page");



    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
