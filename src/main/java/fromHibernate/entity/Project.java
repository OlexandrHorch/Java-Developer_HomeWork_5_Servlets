package fromHibernate.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private int cost;


    @ManyToOne
    @JoinColumn(name = "id_company", referencedColumnName = "id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id")
    private Customer customer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "developers_projects",
            joinColumns = @JoinColumn(name = "id_project"),
            inverseJoinColumns = @JoinColumn(name = "id_developer"))
    private Set<Developer> developers;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }


    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company.getName() + '\'' +
                ", customer='" + customer.getName() + '\'' +
                ", cost=" + cost +
                '}';
    }


    public String showDevelopers() {
        String developersList = "";

        if (developers != null) {
            int numeration = 0;
            for (Developer developer : developers) {
                numeration++;
                developersList += "\n  " + numeration + ". " + developer;
            }
        } else {
            System.out.println("В базі даних відсутня інформація про розробників проекту!");
        }
        return "В базі даних є інформація про " + developers.size() + " розробників проекта '" + name + "':" + developersList;
    }


    public int showSumDevelopersSalary() {
        int sumSalary = 0;
        if (developers != null) {
            for (Developer developer : developers) {
                sumSalary += developer.getSalary();
            }
        } else {
            System.out.println("В базі даних відсутня інформація про розробників проекту!");
        }
        return sumSalary;
    }
}