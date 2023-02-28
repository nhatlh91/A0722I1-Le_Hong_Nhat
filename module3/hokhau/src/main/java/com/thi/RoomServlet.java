package com.thi;
import com.thi.model.Room;
import com.thi.repos.RoomRepository;
import com.thi.ultils.*;
import java.io.*;
import java.sql.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "RoomServlet", value = "/rooms")
public class RoomServlet extends HttpServlet implements Pattern {
    RoomRepository repository = null;
    public void init() {
        repository = new RoomRepository();
        }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
       String action = request.getParameter("action");
       if (action == null) {
           action="";
       }
       switch (action){
           case "bulk_delete":
               bulkDelete(request,response);
               break;
           case "search":
               search(request,response);
               break;
           case "detail":
               detail(request,response);
               break;
           case "edit":
               edit(request,response);
               break;
           default:
               read(request,response);
               break;
       }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Room room = repository.read(id);
        request.setAttribute("room",room);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/room/edit.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Room room = repository.read(id);
        request.setAttribute("room",room);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/room/detail.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String keyword = request.getParameter("keyword");
        System.out.println("keyword: " + keyword);
        List<Room> rooms = repository.search(keyword);
        request.setAttribute("rooms",rooms);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/room/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void bulkDelete(HttpServletRequest request, HttpServletResponse response) {
        String[] list = request.getParameterValues("delete_id");
        for (String id : list) {
            int id_number = Integer.parseInt(id);
            repository.detele(id_number);
        }
        try {
            response.sendRedirect("/rooms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void read(HttpServletRequest request, HttpServletResponse response) {
        List<Room> rooms = repository.read();
        for (Room room : rooms){
            System.out.println(room);
        }
        request.setAttribute("rooms",rooms);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/room/list.jsp");
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
        if (action == null) {
            action="";
        }
        switch (action){
            case "create":
                create(request,response);
                break;
            case "update":
                update(request,response);
                break;
            default:
                read(request,response);
                break;
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        boolean flag = false;
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        if (!name.matches(NAME_PATTERN)||name.length()<5||name.length()>50) {
            flag = true;
        }
        String phone = request.getParameter("phone");
        if (!phone.matches(PHONE_PATTERN)){
            flag = true;
        }
        Date date = Date.valueOf(request.getParameter("date"));
        int payment = Integer.parseInt(request.getParameter("payment"));
        String note = request.getParameter("note");
        if (note.length() > 200) {
            flag = true;
        }
        if (flag) {
            request.setAttribute("flag",flag);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/room/edit.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Room room = new Room(id, name, phone, date, payment, note);
            repository.update(room);
            try {
                response.sendRedirect("/rooms");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        boolean flag = false;
        String name = request.getParameter("name");
        if (!name.matches(NAME_PATTERN)||name.length()<5||name.length()>50) {
            flag = true;
        }
        String phone = request.getParameter("phone");
        if (!phone.matches(PHONE_PATTERN)){
            flag = true;
        }
        Date date = Date.valueOf(request.getParameter("date"));
        int payment = Integer.parseInt(request.getParameter("payment"));
        String note = request.getParameter("note");
        if (note.length() > 200) {
            flag = true;
        }
        if (flag) {
            request.setAttribute("flag",flag);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/room/create.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Room room = new Room(name, phone, date, payment, note);
            repository.create(room);
            try {
                response.sendRedirect("/rooms");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void destroy() {
    }
}