package com.qf.web;

import com.qf.domain.Contact;
import com.qf.service.QueryContactService;
import com.qf.service.QueryContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update_broker")
public class UpdateBrokerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QueryContactService queryContactService= new QueryContactServiceImpl();
        String contactId = request.getParameter("id");
        Contact contact = queryContactService.queryById(contactId);
        request.setAttribute("contact",contact);
        request.getRequestDispatcher("/update.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
