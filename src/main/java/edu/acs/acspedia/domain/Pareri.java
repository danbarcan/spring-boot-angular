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
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "parinte")
    @ManyToOne
    @JsonIgnore
    private Pareri parinte;

    @Column(name = "id_type")
    private Long idType;

    @Column(name = "id_materie")
    private String idMaterie;

    @Column(name = "type")
    private String type;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "parinte")
    private Set<Pareri> copii = new HashSet<>();

    public Long getId() {
        return id;
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

    public Pareri getParinte() {
        return parinte;
    }

    public void setParinte(Pareri parinte) {
        this.parinte = parinte;
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
