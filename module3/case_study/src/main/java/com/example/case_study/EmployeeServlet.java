package com.example.case_study;

import com.example.case_study.models.person.Employee;
import com.example.case_study.services.*;
import com.example.case_study.utils.DateUtil;

import java.io.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "EmployeeServlet", value = "/employees")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService;

    public void init() {
        employeeService = new EmployeeService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        System.out.println("get action = " + action);
        switch (action){
            case "create":
                showCreateForm(request, response);
                break;
            case "detail":
                readEmployeeById(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            case "search":
                search(request,response);
                break;
            default:
                showAllEmployee(request, response);
                break;
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String keyword = request.getParameter("keyword");
        List<Employee> employees = employeeService.findByName(keyword);
        request.setAttribute("employees",employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        employeeService.delete(id);
        try {
            response.sendRedirect("/employees");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readEmployeeById(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.readById(id);
        request.setAttribute("employee",employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/details.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("/employee/create.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAllEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employees = employeeService.read();
        Collections.sort(employees);
        request.setAttribute("employees", employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/list.jsp");
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
            action = "";
        }
        System.out.println("post action = " + action);
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "delete":
                break;
            case "edit":
                update(request,response);
                break;
            default:
                doGet(request, response);
                break;
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        String name = request.getParameter("name");
        Date birthday = DateUtil.parseDate(request.getParameter("birthday"));
        String id_card = request.getParameter("id_card");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        double salary = Double.parseDouble(request.getParameter("salary"));
        int position_id = Integer.parseInt(request.getParameter("position"));
        int education_degree_id = Integer.parseInt(request.getParameter("education"));
        int division_id = Integer.parseInt(request.getParameter("division"));
        String username = request.getParameter("username");
        Employee employee = new Employee(employee_id, name, birthday, id_card, phone, email, address, salary, position_id, education_degree_id, division_id, username);
        employeeService.update(employee);
        request.setAttribute("employee",employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/details.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Date birthday = DateUtil.parseDate(request.getParameter("birthday"));
        System.out.println(birthday);
        String id_card = request.getParameter("id_card");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        double salary = Double.parseDouble(request.getParameter("salary"));
        int position_id = Integer.parseInt(request.getParameter("position"));
        int education_degree_id = Integer.parseInt(request.getParameter("education"));
        int division_id = Integer.parseInt(request.getParameter("division"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Employee employee = new Employee(name, birthday, id_card, phone, email, address, salary, position_id, education_degree_id, division_id, username);
        employeeService.createUsername(username,password);
        employeeService.create(employee);
        try {
            response.sendRedirect("/employees");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        employeeService = null;
    }
}