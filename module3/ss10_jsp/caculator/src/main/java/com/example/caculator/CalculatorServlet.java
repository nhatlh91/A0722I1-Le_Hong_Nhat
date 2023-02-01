package com.example.caculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet ", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float first = Float.parseFloat(request.getParameter("first"));
        float second = Float.parseFloat(request.getParameter("second"));
        char operand = request.getParameter("operand").charAt(0);
        Calculator calculator = new Calculator(first,second,operand);
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Result:</h1>");
        writer.println(calculator.calculate());
        writer.println("</html>");
    }
}
