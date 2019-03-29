package com.servlet.controller.menu;

import fromHibernate.dao.ProjectDAO;
import fromHibernate.entity.Project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Scanner;

@WebServlet(urlPatterns = { "/menu/otherMenu/sumDevelopersSalaryInProject",
                            "/menu/otherMenu/sumDevelopersSalaryInProjectAnswer",
                            "/menu/otherMenu/getDevelopersInProject",
                            "/menu/otherMenu/getDevelopersInProjectAnswer",})

public class OtherMenuController extends HttpServlet {
    private Project project = new Project();
    private ProjectDAO projectDAO = new ProjectDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().equals("/menu/otherMenu/sumDevelopersSalaryInProject")) {
            sumDevelopersSalaryInProject(request, response);
        } else if (request.getRequestURI().equals("/menu/otherMenu/sumDevelopersSalaryInProjectAnswer")) {
            sumDevelopersSalaryInProjectAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/otherMenu/getDevelopersInProject")) {
            getDevelopersInProject(request, response);
        } else if (request.getRequestURI().equals("/menu/otherMenu/getDevelopersInProjectAnswer")) {
            getDevelopersInProjectAnswer(request, response);
        }
    }


    private void sumDevelopersSalaryInProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/otherMenu/sumDevelopersSalaryInProject.jsp").forward(request, response);
    }

    private void sumDevelopersSalaryInProjectAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Scanner scanner = new Scanner(request.getParameter("idProject"));
        long idProject = scanner.nextLong();
        project = projectDAO.getProjectById(idProject);
        int sumSalary = project.showSumDevelopersSalary();

        request.setAttribute("projectById", project);
        request.setAttribute("sumSalary", sumSalary);
        request.getRequestDispatcher("/jsp/menu/otherMenu/sumDevelopersSalaryInProjectAnswer.jsp").forward(request, response);
    }


    private void getDevelopersInProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/otherMenu/getDevelopersInProject.jsp").forward(request, response);
    }

    private void getDevelopersInProjectAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Scanner scanner = new Scanner(request.getParameter("idProject"));
        long idProject = scanner.nextLong();
        project = projectDAO.getProjectById(idProject);

        request.setAttribute("projectById", project);
        request.getRequestDispatcher("/jsp/menu/otherMenu/getDevelopersInProjectAnswer.jsp").forward(request, response);
    }

}