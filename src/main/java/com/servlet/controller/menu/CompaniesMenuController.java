package com.servlet.controller.menu;

import fromHibernate.dao.CompanyDAO;
import fromHibernate.entity.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Scanner;

@WebServlet(urlPatterns = { "/menu/companiesMenu/createCompany",
                            "/menu/companiesMenu/createCompanyAnswer",
                            "/menu/companiesMenu/getAllCompanies",
                            "/menu/companiesMenu/updateCompanyById",
                            "/menu/companiesMenu/updateCompanyByIdAnswer",
                            "/menu/companiesMenu/updateCompanyByIdAnswer2",
                            "/menu/companiesMenu/deleteCompanyById",
                            "/menu/companiesMenu/deleteCompanyByIdAnswer"})

public class CompaniesMenuController extends HttpServlet {
    private Company company = new Company();
    private CompanyDAO companyDAO = new CompanyDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().equals("/menu/companiesMenu/createCompany")) {
            createCompany(request, response);
        } else if (request.getRequestURI().equals("/menu/companiesMenu/createCompanyAnswer")) {
            createCompanyAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/companiesMenu/getAllCompanies")) {
            getAllCompanies(request, response);
        } else if (request.getRequestURI().equals("/menu/companiesMenu/updateCompanyById")) {
            updateCompanyById(request, response);
        } else if (request.getRequestURI().equals("/menu/companiesMenu/updateCompanyByIdAnswer")) {
            updateCompanyByIdAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/companiesMenu/updateCompanyByIdAnswer2")) {
            updateCompanyByIdAnswer2(request, response);
        } else if (request.getRequestURI().equals("/menu/companiesMenu/deleteCompanyById")) {
            deleteCompanyById(request, response);
        } else if (request.getRequestURI().equals("/menu/companiesMenu/deleteCompanyByIdAnswer")) {
            deleteCompanyByIdAnswer(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().equals("/menu/companiesMenu/createCompany")) {
            createCompany(request, response);
        } else if (request.getRequestURI().equals("/menu/companiesMenu/createCompanyAnswer")) {
            createCompanyAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/companiesMenu/getAllCompanies")) {
            getAllCompanies(request, response);
        } else if (request.getRequestURI().equals("/menu/companiesMenu/updateCompanyById")) {
            updateCompanyById(request, response);
        } else if (request.getRequestURI().equals("/menu/companiesMenu/updateCompanyByIdAnswer")) {
            updateCompanyByIdAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/companiesMenu/updateCompanyByIdAnswer2")) {
            updateCompanyByIdAnswer2(request, response);
        } else if (request.getRequestURI().equals("/menu/companiesMenu/deleteCompanyById")) {
            deleteCompanyById(request, response);
        } else if (request.getRequestURI().equals("/menu/companiesMenu/deleteCompanyByIdAnswer")) {
            deleteCompanyByIdAnswer(request, response);
        }
    }


    private void createCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/companiesMenu/createCompany.jsp").forward(request, response);
    }

    private void createCompanyAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        company.setName(request.getParameter("name"));
        company.setAddress(request.getParameter("address"));
        companyDAO.createCompany(company);

        request.setAttribute("companyList", companyDAO.getAllCompanies());
        request.getRequestDispatcher("/jsp/menu/companiesMenu/createCompanyAnswer.jsp").forward(request, response);
    }


    private void getAllCompanies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("companyList", companyDAO.getAllCompanies());
        request.getRequestDispatcher("/jsp/menu/companiesMenu/getAllCompanies.jsp").forward(request, response);
    }


    private void updateCompanyById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/companiesMenu/updateCompanyById.jsp").forward(request, response);
    }

    private void updateCompanyByIdAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameterMap().containsKey("idCompany")) {
            Scanner scanner = new Scanner(request.getParameter("idCompany"));
            long idCompany = scanner.nextLong();
            company = companyDAO.getCompanyById(idCompany);
            request.setAttribute("companyById", company);
            request.getRequestDispatcher("/jsp/menu/companiesMenu/updateCompanyByIdAnswer.jsp").forward(request, response);
        }
    }

    private void updateCompanyByIdAnswer2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        company.setName(request.getParameter("name"));
        company.setAddress(request.getParameter("address"));
        companyDAO.updateCompany(company);

        request.setAttribute("companyById", company);
        request.getRequestDispatcher("/jsp/menu/companiesMenu/updateCompanyByIdAnswer.jsp").forward(request, response);
    }


    private void deleteCompanyById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/companiesMenu/deleteCompanyById.jsp").forward(request, response);
    }

    private void deleteCompanyByIdAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameterMap().containsKey("idCompany")) {
            Scanner scanner = new Scanner(request.getParameter("idCompany"));
            long idCompany = scanner.nextLong();
            Company company = companyDAO.getCompanyById(idCompany);
            companyDAO.deleteCompany(company);
        }

        request.setAttribute("companyList", companyDAO.getAllCompanies());
        request.getRequestDispatcher("/jsp/menu/companiesMenu/deleteCompanyByIdAnswer.jsp").forward(request, response);
    }

}