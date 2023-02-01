package com.example.customerlist;

import com.example.customerlist.models.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "customerServlet", value = "/customer")
public class customerList extends HttpServlet {
    private static List<Customer> customers = new ArrayList<Customer>();
    static  {
        customers.add(new Customer("Mai Văn Hoàn","1983-08-20","Hà Nội","img1.jpg"));
        customers.add(new Customer("Nguyễn Văn Nam","1983-08-21","Bắc Giang","img2.jpg"));
        customers.add(new Customer("Nguyễn Thái Hoà","1983-08-22","Nam Định","img3.jpg"));
        customers.add(new Customer("Trần Đăng Khoa","1983-08-17","Hà Tây","img4.jpg"));
        customers.add(new Customer("Nguyễn Đình Thi","1983-08-19","Hà Nội","img5.jpg"));
    }
    public void init() {
        System.out.println("Servlet init()");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("list", customers);
        request.getRequestDispatcher("/customer/list.jsp").forward(request, response);
    }

    public void destroy() {
        System.out.println("Servlet destroy()");;
    }
}