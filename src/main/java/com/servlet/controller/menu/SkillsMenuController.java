package com.servlet.controller.menu;

import fromHibernate.dao.SkillDAO;
import fromHibernate.entity.Skill;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Scanner;

@WebServlet(urlPatterns = { "/menu/skillsMenu/createSkill",
                            "/menu/skillsMenu/createSkillAnswer",
                            "/menu/skillsMenu/getAllSkills",
                            "/menu/skillsMenu/updateSkillById",
                            "/menu/skillsMenu/updateSkillByIdAnswer",
                            "/menu/skillsMenu/updateSkillByIdAnswer2",
                            "/menu/skillsMenu/deleteSkillById",
                            "/menu/skillsMenu/deleteSkillByIdAnswer"})

public class SkillsMenuController extends HttpServlet {
    private Skill skill = new Skill();
    private SkillDAO skillDAO = new SkillDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().equals("/menu/skillsMenu/createSkill")) {
            createSkill(request, response);
        } else if (request.getRequestURI().equals("/menu/skillsMenu/createSkillAnswer")) {
            createSkillAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/skillsMenu/getAllSkills")) {
            getAllSkills(request, response);
        } else if (request.getRequestURI().equals("/menu/skillsMenu/updateSkillById")) {
            updateSkillById(request, response);
        } else if (request.getRequestURI().equals("/menu/skillsMenu/updateSkillByIdAnswer")) {
            updateSkillByIdAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/skillsMenu/updateSkillByIdAnswer2")) {
            updateSkillByIdAnswer2(request, response);
        } else if (request.getRequestURI().equals("/menu/skillsMenu/deleteSkillById")) {
            deleteSkillById(request, response);
        } else if (request.getRequestURI().equals("/menu/skillsMenu/deleteSkillByIdAnswer")) {
            deleteSkillByIdAnswer(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().equals("/menu/skillsMenu/createSkill")) {
            createSkill(request, response);
        } else if (request.getRequestURI().equals("/menu/skillsMenu/createSkillAnswer")) {
            createSkillAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/skillsMenu/getAllSkills")) {
            getAllSkills(request, response);
        } else if (request.getRequestURI().equals("/menu/skillsMenu/updateSkillById")) {
            updateSkillById(request, response);
        } else if (request.getRequestURI().equals("/menu/skillsMenu/updateSkillByIdAnswer")) {
            updateSkillByIdAnswer(request, response);
        } else if (request.getRequestURI().equals("/menu/skillsMenu/updateSkillByIdAnswer2")) {
            updateSkillByIdAnswer2(request, response);
        } else if (request.getRequestURI().equals("/menu/skillsMenu/deleteSkillById")) {
            deleteSkillById(request, response);
        } else if (request.getRequestURI().equals("/menu/skillsMenu/deleteSkillByIdAnswer")) {
            deleteSkillByIdAnswer(request, response);
        }
    }


    private void createSkill(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/skillsMenu/createSkill.jsp").forward(request, response);
    }

    private void createSkillAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        skill.setArea(request.getParameter("area"));
        skill.setLevel(request.getParameter("level"));
        skillDAO.createSkill(skill);

        request.setAttribute("skillList", skillDAO.getAllSkills());
        request.getRequestDispatcher("/jsp/menu/skillsMenu/createSkillAnswer.jsp").forward(request, response);
    }


    private void getAllSkills(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("skillList", skillDAO.getAllSkills());
        request.getRequestDispatcher("/jsp/menu/skillsMenu/getAllSkills.jsp").forward(request, response);
    }


    private void updateSkillById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/skillsMenu/updateSkillById.jsp").forward(request, response);
    }

    private void updateSkillByIdAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameterMap().containsKey("idSkill")) {
            Scanner scanner = new Scanner(request.getParameter("idSkill"));
            long idSkill = scanner.nextLong();
            skill = skillDAO.getSkillById(idSkill);
            request.setAttribute("skillById", skill);
            request.getRequestDispatcher("/jsp/menu/skillsMenu/updateSkillByIdAnswer.jsp").forward(request, response);
        }
    }

    private void updateSkillByIdAnswer2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        skill.setArea(request.getParameter("area"));
        skill.setLevel(request.getParameter("level"));
        skillDAO.updateSkill(skill);

        request.setAttribute("skillById", skill);
        request.getRequestDispatcher("/jsp/menu/skillsMenu/updateSkillByIdAnswer.jsp").forward(request, response);
    }


    private void deleteSkillById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/menu/skillsMenu/deleteSkillById.jsp").forward(request, response);
    }

    private void deleteSkillByIdAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameterMap().containsKey("idSkill")) {
            Scanner scanner = new Scanner(request.getParameter("idSkill"));
            long idSkill = scanner.nextLong();
            Skill skill = skillDAO.getSkillById(idSkill);
            skillDAO.deleteSkill(skill);
        }

        request.setAttribute("skillList", skillDAO.getAllSkills());
        request.getRequestDispatcher("/jsp/menu/skillsMenu/deleteSkillByIdAnswer.jsp").forward(request, response);
    }

}