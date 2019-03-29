package com.servlet.controller.menu;

import fromHibernate.dao.CompanyDAO;
import fromHibernate.dao.DeveloperDAO;
import fromHibernate.dao.SkillDAO;
import fromHibernate.entity.Developer;
import fromHibernate.entity.Skill;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Scanner;

@WebServlet(urlPatterns = { "/menu/developersMenu/createDeveloper",
                            "/menu/developersMenu/createDeveloperAnswer",
                            "/menu/developersMenu/getDeveloperById",
                            "/menu/developersMenu/getDeveloperByIdAnswer",
                            "/menu/developersMenu/getAllDevelopers",
                            "/menu/developersMenu/updateDeveloperById",
                            "/menu/developersMenu/updateDeveloperByIdAnswer",
                            "/menu/developersMenu/updateDeveloperByIdAnswer2",
                            "/menu/developersMenu/deleteDeveloperById",
                            "/menu/developersMenu/deleteDeveloperByIdAnswer",
                            "/menu/developersMenu/getSkillsByDeveloperId",
                            "/menu/developersMenu/getSkillsByDeveloperIdAnswer",
                            "/menu/developersMenu/assignSkillToDeveloper",
                            "/menu/developersMenu/assignSkillToDeveloperAnswer",
                            "/menu/developersMenu/assignSkillToDeveloperAnswer2"})

public class DevelopersMenuController extends HttpServlet {
    private Developer developer = new Developer();
    private DeveloperDAO developerDAO = new DeveloperDAO();
    private CompanyDAO companyDAO = new CompanyDAO();
    private SkillDAO skillDAO = new SkillDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().equals("/menu/developersMenu/createDeveloper")) {
            createDeveloper(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/createDeveloperAnswer")) {
            createDeveloperAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/getDeveloperById")) {
            getDeveloperById(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/getDeveloperByIdAnswer")) {
            getDeveloperByIdAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/getAllDevelopers")) {
            getAllDevelopers(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/updateDeveloperById")) {
            updateDeveloperById(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/updateDeveloperByIdAnswer")) {
            updateDeveloperByIdAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/updateDeveloperByIdAnswer2")) {
            updateDeveloperByIdAnswer2(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/deleteDeveloperById")) {
            deleteDeveloperById(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/deleteDeveloperByIdAnswer")) {
            deleteDeveloperByIdAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/getSkillsByDeveloperId")) {
            getSkillsByDeveloperId(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/getSkillsByDeveloperIdAnswer")) {
            getSkillsByDeveloperIdAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/assignSkillToDeveloper")) {
            assignSkillToDeveloper(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/assignSkillToDeveloperAnswer")) {
            assignSkillToDeveloperAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/assignSkillToDeveloperAnswer2")) {
            assignSkillToDeveloperAnswer2(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().equals("/menu/developersMenu/createDeveloper")) {
            createDeveloper(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/createDeveloperAnswer")) {
            createDeveloperAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/getDeveloperById")) {
            getDeveloperById(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/getDeveloperByIdAnswer")) {
            getDeveloperByIdAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/getAllDevelopers")) {
            getAllDevelopers(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/updateDeveloperById")) {
            updateDeveloperById(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/updateDeveloperByIdAnswer")) {
            updateDeveloperByIdAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/updateDeveloperByIdAnswer2")) {
            updateDeveloperByIdAnswer2(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/deleteDeveloperById")) {
            deleteDeveloperById(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/deleteDeveloperByIdAnswer")) {
            deleteDeveloperByIdAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/getSkillsByDeveloperId")) {
            getSkillsByDeveloperId(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/assignSkillToDeveloper")) {
            assignSkillToDeveloper(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/assignSkillToDeveloperAnswer")) {
            assignSkillToDeveloperAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/developersMenu/assignSkillToDeveloperAnswer2")) {
            assignSkillToDeveloperAnswer2(request, response);
        }
    }


    private void createDeveloper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("private void createDeveloper");
        request.getRequestDispatcher("/jsp/menu/developersMenu/createDeveloper.jsp").forward(request, response);
    }

    private void createDeveloperAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Scanner scanner = new Scanner(request.getParameter("idCompany"));
        long idCompany = scanner.nextLong();
        developer.setFirstName(request.getParameter("firstName"));
        developer.setAge(Integer.parseInt(request.getParameter("age")));
        developer.setCompany(companyDAO.getCompanyById(idCompany));
        developer.setSalary(Integer.parseInt(request.getParameter("salary")));
        developerDAO.createDeveloper(developer);

        request.setAttribute("developerList", developerDAO.getAllDevelopers());
        request.getRequestDispatcher("/jsp/menu/developersMenu/createDeveloperAnswer.jsp").forward(request, response);
    }


    private void getDeveloperById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/developersMenu/getDeveloperById.jsp").forward(request, response);
    }

    private void getDeveloperByIdAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameterMap().containsKey("idDeveloper")) {
            Scanner scanner = new Scanner(request.getParameter("idDeveloper"));
            long idDeveloper = scanner.nextLong();
            Developer developer = developerDAO.getDeveloperById(idDeveloper);
            request.setAttribute("developerById", developer);
            request.getRequestDispatcher("/jsp/menu/developersMenu/getDeveloperByIdAnswer.jsp").forward(request, response);
        }
    }


    private void getAllDevelopers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("developerList", developerDAO.getAllDevelopers());
        request.getRequestDispatcher("/jsp/menu/developersMenu/getAllDevelopers.jsp").forward(request, response);
    }


    private void updateDeveloperById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/developersMenu/updateDeveloperById.jsp").forward(request, response);
    }

    private void updateDeveloperByIdAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameterMap().containsKey("idDeveloper")) {
            Scanner scanner = new Scanner(request.getParameter("idDeveloper"));
            long idDeveloper = scanner.nextLong();
            developer = developerDAO.getDeveloperById(idDeveloper);

            request.setAttribute("developerById", developer);
            request.getRequestDispatcher("/jsp/menu/developersMenu/updateDeveloperByIdAnswer.jsp").forward(request, response);
        }
    }

    private void updateDeveloperByIdAnswer2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Scanner scanner = new Scanner(request.getParameter("idCompany"));
        long idCompany = scanner.nextLong();
        developer.setFirstName(request.getParameter("firstName"));
        developer.setAge(Integer.parseInt(request.getParameter("age")));
        developer.setCompany(companyDAO.getCompanyById(idCompany));
        developer.setSalary(Integer.parseInt(request.getParameter("salary")));
        developerDAO.updateDeveloper(developer);

        request.setAttribute("developerById", developer);
        request.getRequestDispatcher("/jsp/menu/developersMenu/updateDeveloperByIdAnswer.jsp").forward(request, response);
    }


    private void deleteDeveloperById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/developersMenu/deleteDeveloperById.jsp").forward(request, response);
    }

    private void deleteDeveloperByIdAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameterMap().containsKey("idDeveloper")) {
            Scanner scanner = new Scanner(request.getParameter("idDeveloper"));
            long idDeveloper = scanner.nextLong();
            Developer developer = developerDAO.getDeveloperById(idDeveloper);
            developerDAO.deleteDeveloper(developer);
        }

        request.setAttribute("developerList", developerDAO.getAllDevelopers());
        request.getRequestDispatcher("/jsp/menu/developersMenu/deleteDeveloperByIdAnswer.jsp").forward(request, response);
    }


    private void getSkillsByDeveloperId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/developersMenu/getSkillsByDeveloperId.jsp").forward(request, response);
    }

    private void getSkillsByDeveloperIdAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameterMap().containsKey("idDeveloper")) {
            Scanner scanner = new Scanner(request.getParameter("idDeveloper"));
            long idDeveloper = scanner.nextLong();
            Developer developer = developerDAO.getDeveloperById(idDeveloper);
            request.setAttribute("developerById", developer);
            request.getRequestDispatcher("/jsp/menu/developersMenu/getSkillsByDeveloperIdAnswer.jsp").forward(request, response);
        }
    }


    private void assignSkillToDeveloper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/developersMenu/assignSkillToDeveloper.jsp").forward(request, response);
    }

    private void assignSkillToDeveloperAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameterMap().containsKey("idDeveloper")) {
            Scanner scanner = new Scanner(request.getParameter("idDeveloper"));
            long idDeveloper = scanner.nextLong();
            developer = developerDAO.getDeveloperById(idDeveloper);
            request.setAttribute("developerById", developer);
            request.getRequestDispatcher("/jsp/menu/developersMenu/assignSkillToDeveloperAnswer.jsp").forward(request, response);
        }
    }

    private void assignSkillToDeveloperAnswer2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameterMap().containsKey("idSkill")) {
            Scanner scanner = new Scanner(request.getParameter("idSkill"));
            long idSkill = scanner.nextLong();
            Skill skill = skillDAO.getSkillById(idSkill);
            SkillDAO.assignSkillToDeveloper(developer, skill);
            request.setAttribute("developerById", developer);
            request.getRequestDispatcher("/jsp/menu/developersMenu/assignSkillToDeveloperAnswer.jsp").forward(request, response);
        }
    }

}