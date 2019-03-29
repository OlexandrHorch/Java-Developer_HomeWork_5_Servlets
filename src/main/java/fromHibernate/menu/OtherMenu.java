package fromHibernate.menu;

import fromHibernate.dao.ProjectDAO;
import fromHibernate.dao.SkillDAO;
import fromHibernate.entity.Project;
import fromHibernate.entity.Skill;

import java.util.List;
import java.util.Scanner;

public class OtherMenu {
    private SkillDAO skillDAO = new SkillDAO();
    private Project project;
    private ProjectDAO projectDAO = new ProjectDAO();
    private Scanner input = new Scanner(System.in);

    public OtherMenu() {
        show();
    }

    private void show() {
        System.out.println("\n * Меню інших запитів * ");
        System.out.println("Виберіть, яку інформацію відобразити:" +
                "\n 1 - зарплату (суму) всіх розробників окремого проекта" +
                "\n 2 - список розробників окремого проекта" +
                "\n 3 - список всіх JAVA розробників" +
                "\n 4 - список всіх middle розробників" +
                "\n s - повернутися до головного меню" +
                "\n x - завершити роботу програми"
        );

        System.out.print("\nВведіть символ вибраної дії: ");
        String numberObj = input.next();
        switch (numberObj) {
            case "1":
                showSumDevelopersSalaryInProjectByProjectId();
                show();
                break;
            case "2":
                showAllDevelopersByProjectId();
                show();
                break;
            case "3":
                showAllDevelopersBySkillsArea();
                show();
                break;
            case "4":
                showAllDevelopersBySkillsLevel();
                show();
                break;
            case "s":
                new StartMenu();
                break;
            case "x":
                System.out.print("\nПрограму завершено");
                break;
            default:
                System.out.println("* * * * * * * * * * * * * * * * * * * *\n" +
                        "* Невідома команда! Спробуйте ще раз. *\n" +
                        "* * * * * * * * * * * * * * * * * * * *");
                show();
        }
    }


    private void showSumDevelopersSalaryInProjectByProjectId() {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.print("Введіть id проекта: ");
        long projectId = input.nextLong();

        project = projectDAO.getProjectById(projectId);

        if (project != null) {
            System.out.println("Сума зарплат всіх розробників, що працюють над проєктом '" + project.getName() + "' = " +
                    project.showSumDevelopersSalary());
        } else {
            System.out.println("Проект з id " + projectId + " відсутній в базі даних!");
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }


    private void showAllDevelopersByProjectId() {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.print("Введіть id проекта: ");
        long projectId = input.nextLong();

        project = projectDAO.getProjectById(projectId);

        if (project != null) {
            System.out.println(project.showDevelopers());
        } else {
            System.out.println("Проект з id " + projectId + " відсутній в базі даних!");
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }


    private void showAllDevelopersBySkillsArea() {
        System.out.println("--------------------------------------------------------------------------------------");
        String skillArea = "java";
        List<Skill> skills = skillDAO.getAllSkillsByArea(skillArea);

        if (skills != null) {
            for (Skill skill : skills) {
                System.out.println(skill.showDevelopersBySkillArea());
            }
        } else {
            System.out.println("Розробники відсутні в базі даних!");
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }


    private void showAllDevelopersBySkillsLevel() {
        System.out.println("--------------------------------------------------------------------------------------");
        String skillLevel = "middle";
        List<Skill> skills = skillDAO.getAllSkillsByLevel(skillLevel);

        if (skills != null) {
            for (Skill skill : skills) {
                System.out.println(skill.showDevelopersBySkillLevel());
            }
        } else {
            System.out.println("Розробники відсутні в базі даних!");
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }
}