package fromHibernate.menu;

import fromHibernate.dao.CompanyDAO;
import fromHibernate.dao.DeveloperDAO;
import fromHibernate.dao.SkillDAO;
import fromHibernate.entity.Company;
import fromHibernate.entity.Developer;
import fromHibernate.entity.Skill;

import java.util.List;
import java.util.Scanner;

public class DevelopersMenu {
    private Developer developer = new Developer();
    private DeveloperDAO developerDAO = new DeveloperDAO();
    private Company company = new Company();
    private CompanyDAO companyDAO = new CompanyDAO();
    private Skill skill = new Skill();
    private SkillDAO skillDAO = new SkillDAO();
    private Scanner input = new Scanner(System.in);

    public DevelopersMenu() {
        show();
    }

    private void show() {
        System.out.println("\n * Меню developers * ");
        System.out.println("Виберіть дію з переліку:" +
                "\n 1 - записати інформацію про розробника" +
                "\n 2 - показати інформацію про розробника" +
                "\n 3 - показати інформацію про всіх розробників" +
                "\n 4 - оновити інформацію про розробника" +
                "\n 5 - видалити інформацію про розробника" +
                "\n 6 - показати інформацію про вміння розробника" +
                "\n 7 - додати інформацію про вміння розробника" +
                "\n s - повернутися до головного меню" +
                "\n x - завершити роботу програми"
        );

        System.out.print("\nВведіть символ вибраної дії: ");
        String numberObj = input.next();
        switch (numberObj) {
            case "1":
                createDeveloper();
                show();
                break;
            case "2":
                getDeveloperById();
                show();
                break;
            case "3":
                getAllDevelopers();
                show();
                break;
            case "4":
                updateDeveloperById();
                show();
                break;
            case "5":
                deleteDeveloperById();
                show();
                break;
            case "6":
                showSkillsByDeveloperId();
                show();
                break;
            case "7":
                assignSkillToDeveloper();
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


    private void createDeveloper() {
        System.out.println("Введіть наступну інформацію про розробника:");
        System.out.print("\tім'я - ");
        String firstName = input.next();

        System.out.print("\tвік - ");
        int age = input.nextInt();

        System.out.print("\tмісце праці (idCompany) - ");
        long idCompany = input.nextLong();
        company = companyDAO.getCompanyById(checkExistingIdCompany(idCompany));

        System.out.print("\tзарплата - ");
        int salary = input.nextInt();


        developer.setFirstName(firstName);
        developer.setAge(age);
        developer.setCompany(company);
        developer.setSalary(salary);
        developerDAO.createDeveloper(developer);

        System.out.println("-------------------------------------------");
        System.out.println("Iнформацію про розробника внесено в базу даних");
        System.out.println("-------------------------------------------");
    }


    private void getDeveloperById() {
        System.out.println("-------------------------------------------");
        System.out.print("Введіть id розробника - ");
        long id = input.nextLong();
        developer = developerDAO.getDeveloperById(id);

        if (developer != null) {
            System.out.println("Під id " + id + " в базі даних наявна наступна інформація: \n" + developer);
        } else {
            System.out.println("Розробник з id " + id + " відсутній в базі даних!");
        }
        System.out.println("-------------------------------------------");
    }


    private void getAllDevelopers() {
        List<Developer> developers = developerDAO.getAllDevelopers();

        System.out.println("-------------------------------------------");
        if (developers != null) {
            System.out.println("В базі є інформація про " + developers.size() + " розробників:");
            for (Developer developer : developers) {
                System.out.println(developer);
            }
        } else {
            System.out.println("Розробники відсутні в базі даних!");
        }
        System.out.println("-------------------------------------------");
    }


    private void updateDeveloperById() {
        System.out.println("-------------------------------------------");
        System.out.print("Введіть id розробника - ");
        long id = input.nextLong();
        developer = developerDAO.getDeveloperById(id);

        if (developer != null) {
            System.out.println("Під id " + id + " в базі наявна наступна інформація: \n" + developer);
            System.out.println("Введіть нову інформацію про розробника:");
            System.out.print("\tім'я - ");
            String firstName = input.next();

            System.out.print("\tвік - ");
            int age = input.nextInt();

            System.out.print("\tмісце праці (idCompany) - ");
            long idCompany = input.nextLong();
            company = companyDAO.getCompanyById(checkExistingIdCompany(idCompany));

            System.out.print("\tзарплата - ");
            int salary = input.nextInt();

            developer.setFirstName(firstName);
            developer.setAge(age);
            developer.setCompany(company);
            developer.setSalary(salary);
            developerDAO.updateDeveloper(developer);

            System.out.println("Інформацію про розробника оновлено");
        } else {
            System.out.println("Розробник з id " + id + " відсутній в базі даних!");
        }
        System.out.println("-------------------------------------------");
    }


    private long checkExistingIdCompany(long idCompany) {
        long newIdCompany = idCompany;

        company = companyDAO.getCompanyById(idCompany);
        if (company != null) {
            newIdCompany = idCompany;
        } else {
            System.out.print("Інформація про компанію з id " + newIdCompany + " відсутня в базі даних!" +
                    "\nВведіть місце праці (idCompany) - ");
            newIdCompany = input.nextLong();
            newIdCompany = checkExistingIdCompany(newIdCompany);
        }

        return newIdCompany;
    }


    private void deleteDeveloperById() {
        System.out.println("-------------------------------------------");
        System.out.print("Введіть id розробника - ");
        long id = input.nextLong();
        developer = developerDAO.getDeveloperById(id);

        if (developer != null) {
            developerDAO.deleteDeveloper(developer);
            System.out.println("Інформацію про розробника з id " + id + " видалено з бази даних");
        } else {
            System.out.println("Розробник з id " + id + " відсутній в базі даних!");
        }
        System.out.println("-------------------------------------------");
    }


    private void showSkillsByDeveloperId() {
        System.out.println("-------------------------------------------");
        System.out.print("Введіть id розробника - ");
        long id = input.nextLong();
        developer = developerDAO.getDeveloperById(id);

        if (developer != null) {
            System.out.println(developer.showDeveloperSkills());
        } else {
            System.out.println("Розробник з id " + id + " відсутній в базі даних!");
        }
        System.out.println("-------------------------------------------");
    }


    private void assignSkillToDeveloper() {
        System.out.println("-------------------------------------------");
        System.out.print("Введіть id розробника - ");
        long idDeveloper = input.nextLong();
        developer = developerDAO.getDeveloperById(idDeveloper);

        if (developer != null) {
            System.out.print("Введіть id вміння - ");
            long idSkill = input.nextLong();
            skill = skillDAO.getSkillById(idSkill);
            if (skill != null) {
                skillDAO.assignSkillToDeveloper(developer, skill);
                System.out.println("Для розробника з id " + idDeveloper + " вміння з id " + idSkill + " додане до бази даних.");

            } else {
                System.out.println("Вміння з id " + idSkill + " відсутнє в базі даних!");
            }

        } else {
            System.out.println("Розробник з id " + idDeveloper + " відсутній в базі даних!");
        }
        System.out.println("-------------------------------------------");
    }
}