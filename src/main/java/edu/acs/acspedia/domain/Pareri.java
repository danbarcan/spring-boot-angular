package edu.acs.acspedia.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "jhi_pareri")
public class Pareri implements Serializable {

    @Id
    @SequenceGenerator(name="my_seq_p", sequenceName="hibernate_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="my_seq_p")
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "id_type")
    private Long idType;

    @Column(name = "id_materie")
    private String idMaterie;

    @Column(name = "type")
    private String type;

    @Column(name = "username")
    private String username;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getIdType() {
        return idType;
    }

    public void setIdType(Long idType) {
        this.idType = idType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdMaterie() {

        return idMaterie;
    }

    public void setIdMaterie(String idMaterie) {
        this.idMaterie = idMaterie;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Pareri user = (Pareri) o;
        return !(user.getId() == null || getId() == null) && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Pareri{" +
            "id='" + id + '\'' +
            ", content='" + text + '\'' +
            "}";
    }
}
