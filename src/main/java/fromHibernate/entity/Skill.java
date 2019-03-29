package fromHibernate.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "area")
    private String area;

    @Column(name = "level")
    private String level;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "developers_skills",
            joinColumns = @JoinColumn(name = "id_skill"),
            inverseJoinColumns = @JoinColumn(name = "id_developer"))
    private Set<Developer> developers;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }


    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", area='" + area + '\'' +
                ", level='" + level + '\'' +
                '}';
    }


    public String showDevelopersBySkillArea() {
        String developersList = "";
        int numeration = 0;
        for (Developer developer : developers) {
            numeration++;
            developersList += "\n  " + numeration + ". " + developer;
        }

        return "В базі даних є інформація про " + developers.size() + " розробників з рівнем '" + level +
                "' знання '" + area + "':" + developersList;
    }


    public String showDevelopersBySkillLevel() {
        String developersList = "";
        int numeration = 0;
        for (Developer developer : developers) {
            numeration++;
            developersList += "\n  " + numeration + ". " + developer;
        }

        return "В базі даних є інформація про " + developers.size() + " розробників з рівнем '" + level +
                "' знання '" + area + "':" + developersList;
    }
}