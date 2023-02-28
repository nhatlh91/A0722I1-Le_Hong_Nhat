package com.example.baithi;

import com.example.baithi.models.Product;
import com.example.baithi.services.IService;
import com.example.baithi.services.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "productServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private IService service = null;

    public void init() {
        service = new Service();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                delete(request, response);
                break;
            case "search":
                search(request, response);
                break;
            case "detail":
                detail(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            default:
                listAll(request, response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = service.detail(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = service.detail(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/detail.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String keyword = request.getParameter("keyword");
        List<Product> products = service.search(keyword);
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        service.delete(id);
        boolean deleteNoti = true;
        List<Product> products = service.read();
        request.setAttribute("products", products);
        request.setAttribute("deleteNoti", deleteNoti);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listAll(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = service.read();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "update":
                update(request, response);
                break;
            default:
                listAll(request, response);
                break;
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String desc = request.getParameter("desc");
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        Product product = new Product(id, name, price, quantity, color, desc, category_id);
        service.update(product);
        boolean updateNoti = true;
        List<Product> products = service.read();
        request.setAttribute("products", products);
        request.setAttribute("updateNoti", updateNoti);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        boolean flag = false;
        String name = request.getParameter("name");
        if (name.length() > 50) {
            flag = true;
        }
        int price = Integer.parseInt(request.getParameter("price"));
        if (price < 10000000) {
            flag = true;
        }
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        if (quantity < 1) {
            flag = true;
        }
        String color = request.getParameter("color");
        String desc = request.getParameter("desc");
        if (desc.length() > 200) {
            flag = true;
        }
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        RequestDispatcher dispatcher = null;
        if (flag) {
            request.setAttribute("fail", flag);
            dispatcher = request.getRequestDispatcher("/product/create.jsp");
        } else {
            Product product = new Product(name, price, quantity, color, desc, category_id);
            service.create(product);
            boolean createNoti = true;
            List<Product> products = service.read();
            request.setAttribute("products", products);
            request.setAttribute("createNoti", createNoti);
            dispatcher = request.getRequestDispatcher("/product/list.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
    }
}