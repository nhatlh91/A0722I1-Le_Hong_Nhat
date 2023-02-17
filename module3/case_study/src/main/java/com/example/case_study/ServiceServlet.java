package com.example.case_study;

import com.example.case_study.models.facility.*;
import com.example.case_study.services.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ServiceServlet", value = "/services")
public class ServiceServlet extends HttpServlet {
    private IFacilityService facilityService = new FacilityService();

    public void init() {
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
            case "display":
                displayServiceById(request, response);
                break;
            case "delete":
                deleteServiceById(request, response);
                break;
            default:
                showAllService(request, response);
                break;
        }
    }

    private void deleteServiceById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int service_id = Integer.parseInt(request.getParameter("id"));
        facilityService.deleteFacility(service_id);
        response.sendRedirect("/services");
    }

    private void displayServiceById(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Facility facility = facilityService.findById(id);
        request.setAttribute("service",facility);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/service/details.jsp");
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
            response.sendRedirect("/service/create.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAllService(HttpServletRequest request, HttpServletResponse response) {
        String service_type_id = request.getParameter("service_type");
        if (service_type_id == null) {
            service_type_id = "";
        }
        List<Facility> villas = new ArrayList<>();
        List<Facility> houses = new ArrayList<>();
        List<Facility> rooms = new ArrayList<>();
        switch (service_type_id) {
            case "1":
                villas = facilityService.listAll(1);
                Collections.sort(villas);
                break;
            case "2":
                houses = facilityService.listAll(2);
                Collections.sort(houses);
                break;
            case "3":
                rooms = facilityService.listAll(3);
                Collections.sort(rooms);
                break;
                default:
                    villas = facilityService.listAll(1);
                    houses = facilityService.listAll(2);
                    rooms = facilityService.listAll(3);
                    Collections.sort(villas);
                    Collections.sort(houses);
                    Collections.sort(rooms);
                    break;
        }
        request.setAttribute("villas", villas);
        request.setAttribute("houses", houses);
        request.setAttribute("rooms", rooms);
        System.out.println("Got the data");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/service/list.jsp");
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
                createService(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "edit":
                editService(request, response);
                break;
            default:
                break;
        }
    }

    private void editService(HttpServletRequest request, HttpServletResponse response) {
        Facility facility = null;
        int service_type_id = Integer.parseInt(request.getParameter("service_type_id"));
        int service_id = Integer.parseInt(request.getParameter("id"));
        String service_name = request.getParameter("service_name");
        int service_area = Integer.parseInt(request.getParameter("service_area"));
        double service_cost = Double.parseDouble(request.getParameter("service_cost"));
        int service_max_people = Integer.parseInt(request.getParameter("service_max_people"));
        int rent_type_id = Integer.parseInt(request.getParameter("rent_type_id"));
        String room_standard = request.getParameter("room_standard");
        String other_convenience = request.getParameter("description_other_convenience");
        int number_of_floors = 0;
        double pool_area = 0;
        if (service_type_id!=3) {
            number_of_floors = Integer.parseInt(request.getParameter("number_of_floors"));
            if (service_type_id == 1) {
                pool_area = Double.parseDouble(request.getParameter("pool_area"));
            }
        }
        switch (service_type_id) {
            case 1:
                facility = new Villa(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id, service_type_id, room_standard,other_convenience,pool_area,number_of_floors);
                facilityService.editService(facility);
                break;
            case 2:
                facility = new House(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,room_standard,other_convenience,number_of_floors);
                facilityService.editService(facility);
                break;
            case 3:
                facility = new Room(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id);
                facilityService.editService(facility);
                break;
        }
        request.setAttribute("service",facility);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/service/details.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        facilityService.findById(id);
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) {
        int service_type_id = Integer.parseInt(request.getParameter("service_type"));
        String service_name = request.getParameter("service_name");
        int service_area = Integer.parseInt(request.getParameter("service_area"));
        double service_cost = Double.parseDouble(request.getParameter("service_cost"));
        int service_max_people = Integer.parseInt(request.getParameter("service_max_people"));
        int rent_type_id = Integer.parseInt(request.getParameter("rent_type_id"));
        String room_standard = request.getParameter("room_standard");
        String other_convenience = request.getParameter("other_convenience");
        int number_of_floors = 0;
        double pool_area = 0;
        if (service_type_id!=3) {
            number_of_floors = Integer.parseInt(request.getParameter("number_of_floors"));
            if (service_type_id == 1) {
                pool_area = Double.parseDouble(request.getParameter("pool_area"));
            }
        }
        switch (service_type_id) {
            case 1:
                Facility villa = new Villa(service_name,service_area,service_cost,service_max_people,rent_type_id, service_type_id, room_standard,other_convenience,pool_area,number_of_floors);
                facilityService.addFacility(villa);
                break;
            case 2:
                Facility house = new House(service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,room_standard,other_convenience,number_of_floors);
                facilityService.addFacility(house);
                break;
            case 3:
                Facility room = new Room(service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id);
                facilityService.addFacility(room);
                break;
        }
        try {
            response.sendRedirect("services");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
    }
}