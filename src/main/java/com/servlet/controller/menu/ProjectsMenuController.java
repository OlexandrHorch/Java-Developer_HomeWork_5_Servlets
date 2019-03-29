package com.servlet.controller.menu;

import fromHibernate.dao.CompanyDAO;
import fromHibernate.dao.CustomerDAO;
import fromHibernate.dao.DeveloperDAO;
import fromHibernate.dao.ProjectDAO;
import fromHibernate.entity.Project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Scanner;

@WebServlet(urlPatterns = { "/menu/projectsMenu/createProject",
                            "/menu/projectsMenu/createProjectAnswer",
                            "/menu/projectsMenu/getAllProjects",
                            "/menu/projectsMenu/updateProjectById",
                            "/menu/projectsMenu/updateProjectByIdAnswer",
                            "/menu/projectsMenu/updateProjectByIdAnswer2",
                            "/menu/projectsMenu/deleteProjectById",
                            "/menu/projectsMenu/deleteProjectByIdAnswer"})

public class ProjectsMenuController extends HttpServlet {
    private Scanner scanner;
    private Project project = new Project();
    private ProjectDAO projectDAO = new ProjectDAO();
    private CompanyDAO companyDAO = new CompanyDAO();
    private CustomerDAO customerDAO = new CustomerDAO();
    private DeveloperDAO developerDAO = new DeveloperDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().equals("/menu/projectsMenu/createProject")) {
            createProject(request, response);
        } else if (request.getRequestURI().equals("/menu/projectsMenu/createProjectAnswer")) {
            createProjectAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/projectsMenu/getAllProjects")) {
            getAllProjects(request, response);
        } else if (request.getRequestURI().equals("/menu/projectsMenu/updateProjectById")) {
            updateProjectById(request, response);
        } else if (request.getRequestURI().equals("/menu/projectsMenu/updateProjectByIdAnswer")) {
            updateProjectByIdAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/projectsMenu/updateProjectByIdAnswer2")) {
            updateProjectByIdAnswer2(request, response);
        } else if (request.getRequestURI().equals("/menu/projectsMenu/deleteProjectById")) {
            deleteProjectById(request, response);
        } else if (request.getRequestURI().equals("/menu/projectsMenu/deleteProjectByIdAnswer")) {
            deleteProjectByIdAnswer(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().equals("/menu/projectsMenu/createProject")) {
            createProject(request, response);
        } else if (request.getRequestURI().equals("/menu/projectsMenu/createProjectAnswer")) {
            createProjectAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/projectsMenu/getAllProjects")) {
            getAllProjects(request, response);
        } else if (request.getRequestURI().equals("/menu/projectsMenu/updateProjectById")) {
            updateProjectById(request, response);
        } else if (request.getRequestURI().equals("/menu/projectsMenu/updateProjectByIdAnswer")) {
            updateProjectByIdAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/projectsMenu/updateProjectByIdAnswer2")) {
            updateProjectByIdAnswer2(request, response);
        } else if (request.getRequestURI().equals("/menu/projectsMenu/deleteProjectById")) {
            deleteProjectById(request, response);
        } else if (request.getRequestURI().equals("/menu/projectsMenu/deleteProjectByIdAnswer")) {
            deleteProjectByIdAnswer(request, response);
        }
    }


    private void createProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/projectsMenu/createProject.jsp").forward(request, response);
    }

    private void createProjectAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        scanner = new Scanner(request.getParameter("idCompany"));
        long idCompany = scanner.nextLong();
        scanner = new Scanner(request.getParameter("idCustomer"));
        long idCustomer = scanner.nextLong();

        project.setName(request.getParameter("name"));
        project.setCompany(companyDAO.getCompanyById(idCompany));
        project.setCustomer(customerDAO.getCustomerById(idCustomer));
        project.setCost(Integer.parseInt(request.getParameter("cost")));
        projectDAO.createProject(project);

        request.setAttribute("projectList", projectDAO.getAllProjects());
        request.getRequestDispatcher("/jsp/menu/projectsMenu/createProjectAnswer.jsp").forward(request, response);
    }


    private void getAllProjects(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("projectList", projectDAO.getAllProjects());
        request.getRequestDispatcher("/jsp/menu/projectsMenu/getAllProjects.jsp").forward(request, response);
    }


    private void updateProjectById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/projectsMenu/updateProjectById.jsp").forward(request, response);
    }

    private void updateProjectByIdAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameterMap().containsKey("idProject")) {
            Scanner scanner = new Scanner(request.getParameter("idProject"));
            long idProject = scanner.nextLong();
            project = projectDAO.getProjectById(idProject);
            request.setAttribute("projectById", project);
            request.getRequestDispatcher("/jsp/menu/projectsMenu/updateProjectByIdAnswer.jsp").forward(request, response);
        }
    }

    private void updateProjectByIdAnswer2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        scanner = new Scanner(request.getParameter("idCompany"));
        long idCompany = scanner.nextLong();
        scanner = new Scanner(request.getParameter("idCustomer"));
        long idCustomer = scanner.nextLong();

        project.setName(request.getParameter("name"));
        project.setCompany(companyDAO.getCompanyById(idCompany));
        project.setCustomer(customerDAO.getCustomerById(idCustomer));
        project.setCost(Integer.parseInt(request.getParameter("cost")));
        projectDAO.updateProjectById(project);

        request.setAttribute("projectById", project);
        request.getRequestDispatcher("/jsp/menu/projectsMenu/updateProjectByIdAnswer.jsp").forward(request, response);
    }


    private void deleteProjectById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/projectsMenu/deleteProjectById.jsp").forward(request, response);
    }

    private void deleteProjectByIdAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameterMap().containsKey("idProject")) {
            Scanner scanner = new Scanner(request.getParameter("idProject"));
            long idProject = scanner.nextLong();
            Project project = projectDAO.getProjectById(idProject);
            projectDAO.deleteProject(project);
        }

        request.setAttribute("projectList", projectDAO.getAllProjects());
        request.getRequestDispatcher("/jsp/menu/projectsMenu/deleteProjectByIdAnswer.jsp").forward(request, response);
    }

}