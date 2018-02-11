package wado.model;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "characteristics")
@Entity
public class Characteristic implements Serializable {
    private static final long serialVersionUID = -3516853150778243353L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id", nullable = false)
    private Project project;

    @Column(name = "characteristic_type")
    private String characteristicType;

    @Column(name = "characteristic_value")
    private String characteristicValue;

    public Integer getId() {
        return id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getCharacteristicType() {
        return characteristicType;
    }

    public void setCharacteristicType(String characteristicType) {
        this.characteristicType = characteristicType;
    }

    public String getCharacteristicValue() {
        return characteristicValue;
    }

    public void setCharacteristicValue(String characteristicValue) {
        this.characteristicValue = characteristicValue;
    }

}