package com.example.product_discount;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", value = "/discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("Da vao GET");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        float discountRate = Float.parseFloat(request.getParameter("discountRate"));
        float discountAmount = price*discountRate/100;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<br>Product description: "+description);
        writer.println("<br>Listed price: "+price);
        writer.println("<br>Discount percent: "+discountRate);
        writer.println("<br>Discount percent: "+discountAmount);
        writer.println("</html>");
    }
}
