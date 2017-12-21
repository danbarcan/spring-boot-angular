package edu.acs.acspedia.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "jhi_profesori")
public class Profesor implements Serializable {

    @Id
    @SequenceGenerator(name="my_seq_prof", sequenceName="hibernate_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="my_seq_prof")
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Profesor user = (Profesor) o;
        return !(user.getId() == null || getId() == null) && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Profesor{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            "}";
    }
}
