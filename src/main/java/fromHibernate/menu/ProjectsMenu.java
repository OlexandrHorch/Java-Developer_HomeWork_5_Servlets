package fromHibernate.menu;

import fromHibernate.dao.CompanyDAO;
import fromHibernate.dao.CustomerDAO;
import fromHibernate.dao.DeveloperDAO;
import fromHibernate.dao.ProjectDAO;
import fromHibernate.entity.Company;
import fromHibernate.entity.Customer;
import fromHibernate.entity.Developer;
import fromHibernate.entity.Project;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ProjectsMenu {
    private Project project = new Project();
    private ProjectDAO projectDAO = new ProjectDAO();
    private Company company = new Company();
    private CompanyDAO companyDAO = new CompanyDAO();
    private Customer customer = new Customer();
    private CustomerDAO customerDAO = new CustomerDAO();
    private Developer developer = new Developer();
    private DeveloperDAO developerDAO = new DeveloperDAO();
    private Scanner input = new Scanner(System.in);

    public ProjectsMenu() {
        show();
    }

    private void show() {
        System.out.println("\n * Меню projects * ");
        System.out.println("Виберіть дію з переліку:" +
                "\n 1 - створити проект" +
                "\n 2 - показати інформацію про проект" +
                "\n 3 - показати інформацію про всі проекти" +
                "\n 4 - оновити інформацію про проект" +
                "\n 5 - видалити інформацію про проект" +
                "\n 6 - призначити розробника на проект" +
                "\n s - повернутися до головного меню" +
                "\n x - завершити роботу програми"
        );

        System.out.print("\nВведіть символ вибраної дії: ");
        String numberObj = input.next();
        switch (numberObj) {
            case "1":
                createProject();
                show();
                break;
            case "2":
                getProjectById();
                show();
                break;
            case "3":
                getAllProjects();
                show();
                break;
            case "4":
                updateProjectById();
                show();
                break;
            case "5":
                deleteProjectById();
                show();
                break;
            case "6":
                assignDeveloperToProject();
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


    private void createProject() {
        System.out.println("Введіть наступну інформацію про проект:");
        System.out.print("\tназва - ");
        String name = input.next();

        System.out.print("\tid компанії виконавця - ");
        long idCompany = input.nextLong();
        company = companyDAO.getCompanyById(checkExistingIdCompany(idCompany));

        System.out.print("\tid компанії клієнта - ");
        long idCustomer = input.nextLong();
        customer = customerDAO.getCustomerById(checkExistingIdCustomer(idCustomer));

        System.out.print("\tвартість - ");
        int cost = input.nextInt();

        project.setName(name);
        project.setCompany(company);
        project.setCustomer(customer);
        project.setCost(cost);
        projectDAO.createProject(project);

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Iнформацію про проект внесено в базу");
        System.out.println("--------------------------------------------------------------------------------------");
    }


    private void getProjectById() {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.print("Введіть id проекта: ");
        long id = input.nextLong();
        project = projectDAO.getProjectById(id);

        if (project != null) {
            System.out.println("Під id " + id + " в базі даних наявна наступна інформація: \n" + project);
        } else {
            System.out.println("Проект з id " + id + " відсутній в базі даних!");
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }


    private void getAllProjects() {
        List<Project> projects = projectDAO.getAllProjects();

        System.out.println("--------------------------------------------------------------------------------------");
        if (projects != null) {
            System.out.println("В базі даних є інформація про " + projects.size() + " проектів:");
            for (Project project : projects) {
                System.out.println(project);
            }
        } else {
            System.out.println("Проекти відсутні в базі даних!");
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }


    private void updateProjectById() {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.print("Введіть id проекта: ");
        long id = input.nextLong();
        project = projectDAO.getProjectById(id);

        if (project != null) {
            System.out.println("Під id " + id + " в базі даних наявна наступна інформація: \n" + project);
            System.out.println("Введіть нову інформацію про проект:");

            System.out.print("\tназва - ");
            String name = input.next();

            System.out.print("\tid компанії виконавця - ");
            long idCompany = input.nextLong();
            company = companyDAO.getCompanyById(checkExistingIdCompany(idCompany));

            System.out.print("\tid компанії клієнта - ");
            long idCustomer = input.nextLong();
            customer = customerDAO.getCustomerById(checkExistingIdCustomer(idCustomer));

            System.out.print("\tвартість - ");
            int cost = input.nextInt();

            project.setName(name);
            project.setCompany(company);
            project.setCustomer(customer);
            project.setCost(cost);
            projectDAO.updateProjectById(project);

            System.out.println("Інформацію про проект оновлено");

        } else {
            System.out.println("Проект з id " + id + " відсутній в базі даних!");
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }


    private void deleteProjectById() {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.print("Введіть id проекта - ");
        long idProject = input.nextLong();
        project = projectDAO.getProjectById(checkExistingIdProject(idProject));
        long idProjectNew = project.getId();

        projectDAO.deleteProject(project);

        System.out.println("Інформацію про проект з id " + idProjectNew + " видалено з бази даних");
        System.out.println("--------------------------------------------------------------------------------------");

    }


    private void assignDeveloperToProject() {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.print("Введіть id проекта - ");
        long idProject = input.nextLong();
        project = projectDAO.getProjectById(checkExistingIdProject(idProject));

        showExistingDevelopersInCompany(idProject);
        System.out.print("Введіть id розробника зі списку вище - ");
        long idDeveloper = input.nextLong();
        developer = developerDAO.getDeveloperById(checkExistingIdDeveloperInCompanyByProjectId(idDeveloper, idProject));

        projectDAO.assignDeveloperToProject(developer, project);
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Розробника '" + developer.getFirstName() + "' призначено на проект '" + project.getName() + "'");
        System.out.println("--------------------------------------------------------------------------------------");
    }


    private void showExistingDevelopersInCompany(long idProject) {
        project = projectDAO.getProjectById(idProject);
        long idCompany = project.getCompany().getId();
        company = companyDAO.getCompanyById(idCompany);

        if (company != null) {
            System.out.println(company.showCompanyDevelopers());
        } else {
            System.out.print("В базі даних відсутня інформація про розробників, яких можливо призначати на проект!" +
                    "Змініть компанію, що виконує проект або додайте розробника до компанії.");
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }


    private long checkExistingIdCompany(long idCompany) {
        long newIdCompany = idCompany;
        company = companyDAO.getCompanyById(idCompany);

        if (company != null) {
        } else {
            System.out.print("Інформація про компанію з id " + newIdCompany + " відсутня в базі даних!" +
                    "\nВведіть id компанії виконавця - ");
            newIdCompany = input.nextLong();
            newIdCompany = checkExistingIdCompany(newIdCompany);
        }

        return newIdCompany;
    }


    private long checkExistingIdCustomer(long idCustomer) {
        long newIdCustomer = idCustomer;
        customer = customerDAO.getCustomerById(idCustomer);

        if (customer != null) {
        } else {
            System.out.print("Інформація про клієнта з id " + newIdCustomer + " відсутня в базі даних!" +
                    "\nВведіть id компанії клієнта - ");
            newIdCustomer = input.nextLong();
            newIdCustomer = checkExistingIdCustomer(newIdCustomer);
        }

        return newIdCustomer;
    }


    private long checkExistingIdProject(long idProject) {
        long newIdProject = idProject;
        project = projectDAO.getProjectById(idProject);

        if (project != null) {
        } else {
            System.out.print("Інформація про проект з id " + newIdProject + " відсутня в базі даних!" +
                    "\nВведіть id проекта - ");
            newIdProject = input.nextLong();
            newIdProject = checkExistingIdProject(newIdProject);
        }

        return newIdProject;
    }


    private long checkExistingIdDeveloperInCompanyByProjectId(long idDeveloper, long idProject) {
        long newIdDeveloper = idDeveloper;
        project = projectDAO.getProjectById(idProject);
        long idCompany = project.getCompany().getId();
        company = companyDAO.getCompanyById(idCompany);
        Set<Developer> developers = company.getDevelopers();

        int count = 0;
        for (Developer developer : developers) {
            long id = developer.getId();
            if (id == newIdDeveloper) {
                count++;
            }
        }

        if (count == 1) {
        } else {
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("Неможливо призначити розробника з id " + newIdDeveloper + " для проекту з id " + idProject + "!" +
                    "\n--------------------------------------------------------------------------------------");
            showExistingDevelopersInCompany(idProject); // покарує перелік розробників
            System.out.print("Введіть id розробника зі списку вище - ");
            newIdDeveloper = input.nextLong();
            newIdDeveloper = checkExistingIdDeveloperInCompanyByProjectId(newIdDeveloper, idProject);
        }

        return newIdDeveloper;
    }
}