package com.servlet.controller.menu;

import fromHibernate.dao.CustomerDAO;
import fromHibernate.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Scanner;

@WebServlet(urlPatterns = { "/menu/customersMenu/createCustomer",
                            "/menu/customersMenu/createCustomerAnswer",
                            "/menu/customersMenu/getAllCustomers",
                            "/menu/customersMenu/updateCustomerById",
                            "/menu/customersMenu/updateCustomerByIdAnswer",
                            "/menu/customersMenu/updateCustomerByIdAnswer2",
                            "/menu/customersMenu/deleteCustomerById",
                            "/menu/customersMenu/deleteCustomerByIdAnswer"})

public class CustomersMenuController extends HttpServlet {
    private Customer customer = new Customer();
    private CustomerDAO customerDAO = new CustomerDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().equals("/menu/customersMenu/createCustomer")) {
            createCustomer(request, response);
        } else if (request.getRequestURI().equals("/menu/customersMenu/createCustomerAnswer")) {
            createCustomerAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/customersMenu/getAllCustomers")) {
            getAllCustomers(request, response);
        } else if (request.getRequestURI().equals("/menu/customersMenu/updateCustomerById")) {
            updateCustomerById(request, response);
        } else if (request.getRequestURI().equals("/menu/customersMenu/updateCustomerByIdAnswer")) {
            updateCustomerByIdAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/customersMenu/updateCustomerByIdAnswer2")) {
            updateCustomerByIdAnswer2(request, response);
        } else if (request.getRequestURI().equals("/menu/customersMenu/deleteCustomerById")) {
            deleteCustomerById(request, response);
        } else if (request.getRequestURI().equals("/menu/customersMenu/deleteCustomerByIdAnswer")) {
            deleteCustomerByIdAnswer(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().equals("/menu/customersMenu/createCustomer")) {
            createCustomer(request, response);
        } else if (request.getRequestURI().equals("/menu/customersMenu/createCustomerAnswer")) {
            createCustomerAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/customersMenu/getAllCustomers")) {
            getAllCustomers(request, response);
        } else if (request.getRequestURI().equals("/menu/customersMenu/updateCustomerById")) {
            updateCustomerById(request, response);
        } else if (request.getRequestURI().equals("/menu/customersMenu/updateCustomerByIdAnswer")) {
            updateCustomerByIdAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/customersMenu/updateCustomerByIdAnswer2")) {
            updateCustomerByIdAnswer2(request, response);
        } else if (request.getRequestURI().equals("/menu/customersMenu/deleteCustomerById")) {
            deleteCustomerById(request, response);
        } else if (request.getRequestURI().equals("/menu/customersMenu/deleteCustomerByIdAnswer")) {
            deleteCustomerByIdAnswer(request, response);
        }
    }


    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/customersMenu/createCustomer.jsp").forward(request, response);
    }

    private void createCustomerAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        customer.setName(request.getParameter("name"));
        customer.setAddress(request.getParameter("address"));
        customerDAO.createCustomer(customer);

        request.setAttribute("customerList", customerDAO.getAllCustomers());
        request.getRequestDispatcher("/jsp/menu/customersMenu/createCustomerAnswer.jsp").forward(request, response);
    }


    private void getAllCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList", customerDAO.getAllCustomers());
        request.getRequestDispatcher("/jsp/menu/customersMenu/getAllCustomers.jsp").forward(request, response);
    }


    private void updateCustomerById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/customersMenu/updateCustomerById.jsp").forward(request, response);
    }

    private void updateCustomerByIdAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameterMap().containsKey("idCustomer")) {
            Scanner scanner = new Scanner(request.getParameter("idCustomer"));
            long idCustomer = scanner.nextLong();
            customer = customerDAO.getCustomerById(idCustomer);
            request.setAttribute("customerById", customer);
            request.getRequestDispatcher("/jsp/menu/customersMenu/updateCustomerByIdAnswer.jsp").forward(request, response);
        }
    }

    private void updateCustomerByIdAnswer2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        customer.setName(request.getParameter("name"));
        customer.setAddress(request.getParameter("address"));
        customerDAO.updateCustomer(customer);

        request.setAttribute("customerById", customer);
        request.getRequestDispatcher("/jsp/menu/customersMenu/updateCustomerByIdAnswer.jsp").forward(request, response);
    }


    private void deleteCustomerById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/customersMenu/deleteCustomerById.jsp").forward(request, response);
    }

    private void deleteCustomerByIdAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameterMap().containsKey("idCustomer")) {
            Scanner scanner = new Scanner(request.getParameter("idCustomer"));
            long idCustomer = scanner.nextLong();
            Customer customer = customerDAO.getCustomerById(idCustomer);
            customerDAO.deleteCustomer(customer);
        }

        request.setAttribute("customerList", customerDAO.getAllCustomers());
        request.getRequestDispatcher("/jsp/menu/customersMenu/deleteCustomerByIdAnswer.jsp").forward(request, response);
    }

}