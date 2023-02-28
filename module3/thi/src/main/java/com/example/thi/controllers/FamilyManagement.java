package com.example.thi.controllers;

import com.example.thi.models.Family;
import com.example.thi.models.Person;
import com.example.thi.services.FamilyService;
import com.example.thi.services.IFamilyService;
import com.example.thi.services.IPersonService;
import com.example.thi.services.PersonService;

import java.io.*;
import java.sql.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "FamilyServlet", value = "/families")
public class FamilyManagement extends HttpServlet {
    private IFamilyService familyService;
    private IPersonService personService;

    public void init() {
        familyService = new FamilyService();
        personService = new PersonService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "edit":
                showEditForm(request,response);
                break;
            case "detail":
                listOfMember(request,response);
                break;
            default:
                showList(request, response);
                break;

        }
    }

    private void listOfMember(HttpServletRequest request, HttpServletResponse response) {
        int fid = Integer.parseInt(request.getParameter("fid"));
        List<Person> people = personService.read(fid);
        request.setAttribute("people",people);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/person/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int fid = Integer.parseInt(request.getParameter("fid"));
        Family family = familyService.read(fid);
        request.setAttribute("family",family);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/family/edit.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Family> families = familyService.read();
        request.setAttribute("families",families);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/family/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "update":
                update(request,response);
                break;
            default:
                showList(request, response);
                break;

        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int fid = Integer.parseInt(request.getParameter("fid"));
        String host = request.getParameter("host");
        int members = Integer.parseInt(request.getParameter("members"));
        Date date = Date.valueOf(request.getParameter("date"));
        String address = request.getParameter("address");
        Family family = new Family(fid, host, members, date, address);
        familyService.update(family);
        response.setContentType("text/html");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + "Da cap nhat thanh cong" + "</h1>");
            out.println("<a href=\"/families\">" + "Quay ve danh sach" + "</a>");
            out.println("</body></html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
    }
}