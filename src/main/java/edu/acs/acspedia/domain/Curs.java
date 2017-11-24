package edu.acs.acspedia.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "jhi_cursuri")
public class Curs {

    @Id
    private String id;

    @NotNull
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "jhi_profesor_materie",
        joinColumns = {@JoinColumn(name = "id_materie", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "id_profesor", referencedColumnName = "id")})
    private Set<Profesor> profesors = new HashSet<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "jhi_asistent_materie",
        joinColumns = {@JoinColumn(name = "id_materie", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "id_asistent", referencedColumnName = "id")})
    private Set<Asistent> asistents = new HashSet<>();

    public Curs() {
    }

    public Curs(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
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

        Curs user = (Curs) o;
        return !(user.getId() == null || getId() == null) && Objects.equals(getId(), user.getId());
    }

    public Set<Asistent> getAsistents() {
        return asistents;
    }

    public void setAsistents(Set<Asistent> asistents) {
        this.asistents = asistents;
    }

    public Set<Profesor> getProfesors() {
        return profesors;
    }

    public void setProfesors(Set<Profesor> profesors) {
        this.profesors = profesors;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Curs{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            "}";
    }
}
