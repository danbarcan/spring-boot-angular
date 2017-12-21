package edu.acs.acspedia.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "jhi_vot_ranking")
public class Ranking implements Serializable {

    @Id
    @SequenceGenerator(name="my_seq_rank", sequenceName="hibernate_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="my_seq_rank")
    private Long id;

    @NotNull
    @Column(name = "id_user")
    private Long id_user;

    @NotNull
    @Column(name = "id_course")
    private String id_course;

    @NotNull
    @Column(name = "id_pers")
    private Long id_pers;

    @NotNull
    @Column(name = "type")
    private Boolean type;

    public Boolean getType() {
        return type;
    }

    public String getId_course() {
        return id_course;
    }

    public void setId_course(String id_course) {
        this.id_course = id_course;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Long getId_pers() {
        return id_pers;
    }

    public void setId_pers(Long id_pers) {
        this.id_pers = id_pers;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Ranking user = (Ranking) o;
        boolean x = !(user.getId_user() == null || getId_user() == null) && Objects.equals(getId_user(), user.getId_user());
        x = x && (!(user.getId_pers() == null || getId_pers() == null) && Objects.equals(getId_pers(), user.getId_pers()));
        x = x && (!(user.getType() == null || getType() == null) && Objects.equals(getType(), user.getType()));
        x = x && (!(user.getId_course() == null || getId_course() == null) && Objects.equals(getId_course(), user.getId_course()));
        return x;
    }

    @Override
    public int hashCode() {
        int x = Objects.hashCode(getId_user());
        x = Objects.hashCode(getId_pers()) + x;
        x = Objects.hashCode(getType()) + x;
        x = Objects.hashCode(getId_course()) + x;
        return x;
    }

    @Override
    public String toString() {
        return "Vot{" +
            "iduser='" + id_user + '\'' +
            ", id_pers='" + id_pers + '\'' +
            "}";
    }
}
