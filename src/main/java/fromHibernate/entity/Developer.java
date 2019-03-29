package fromHibernate.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "developers")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "age")
    private int age;

    @Column(name = "salary")
    private int salary;


    @ManyToOne
    @JoinColumn(name = "id_company", referencedColumnName = "id")
    private Company company;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "developers_projects",
            joinColumns = @JoinColumn(name = "id_developer"),
            inverseJoinColumns = @JoinColumn(name = "id_project"))
    private Set<Project> projects;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "developers_skills",
            joinColumns = @JoinColumn(name = "id_developer"),
            inverseJoinColumns = @JoinColumn(name = "id_skill"))
    private Set<Skill> skills;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }


    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", company='" + company.getName() + '\'' +
                ", salary=" + salary +
                '}';
    }


    public String showDeveloperSkills() {
        String skillsList = "";
        int numeration = 0;
        for (Skill skill : skills) {
            numeration++;
            skillsList += "\n  " + numeration + ". " + skill;
        }

        return "В базі даних є інформація про " + skills.size() + " вмінь розробника " + firstName + ":" + skillsList;
    }
}