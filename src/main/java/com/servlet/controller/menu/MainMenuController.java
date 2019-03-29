package com.servlet.controller.menu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/menu/developersMenu/developersMenu",
                            "/menu/skillsMenu/skillsMenu",
                            "/menu/projectsMenu/projectsMenu",
                            "/menu/companiesMenu/companiesMenu",
                            "/menu/customersMenu/customersMenu",
                            "/menu/otherMenu/otherMenu"})

public class MainMenuController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().contains("/menu/developersMenu/developersMenu")) {
            developersMenu(request, response);
        } else if (request.getRequestURI().contains("/menu/skillsMenu/skillsMenu")) {
            skillsMenu(request, response);
        } else if (request.getRequestURI().contains("/menu/projectsMenu/projectsMenu")) {
            projectsMenu(request, response);
        } else if (request.getRequestURI().contains("/menu/companiesMenu/companiesMenu")) {
            companiesMenu(request, response);
        } else if (request.getRequestURI().contains("/menu/customersMenu/customersMenu")) {
            customersMenu(request, response);
        } else if (request.getRequestURI().contains("/menu/otherMenu/otherMenu")) {
            otherMenu(request, response);
        }
    }


    private void developersMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/developersMenu/developersMenu.jsp").forward(request, response);
    }

    private void skillsMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/skillsMenu/skillsMenu.jsp").forward(request, response);
    }

    private void projectsMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/projectsMenu/projectsMenu.jsp").forward(request, response);
    }

    private void companiesMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/companiesMenu/companiesMenu.jsp").forward(request, response);
    }

    private void customersMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/customersMenu/customersMenu.jsp").forward(request, response);
    }

    private void otherMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/otherMenu/otherMenu.jsp").forward(request, response);
    }
}