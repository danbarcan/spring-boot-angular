package edu.acs.acspedia.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "jhi_probleme")
public class Problema {

    @Id
    @SequenceGenerator(name="my_seq_prob", sequenceName="hibernate_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="my_seq_prob")
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "title")
    private String title;

    @Column(name = "resolved")
    private Boolean resolved;

    @Column(name = "username")
    private String username;

    @Column(name = "id_materie")
    private String idMaterie;

    public Long getId() {
        return id;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
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
    public void setResolved(Boolean id) {
        this.resolved = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIdMaterie() {

        return idMaterie;
    }

    public void setIdMaterie(String idMaterie) {
        this.idMaterie = idMaterie;
    }



    @ManyToMany
    @JoinTable(
        name = "jhi_mapare_probleme_fisiere",
        joinColumns = {@JoinColumn(name = "pid", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "fid", referencedColumnName = "id")})
    private Set<FisierP> files = new HashSet<>();

    public Set<FisierP> getFiles() {
        return files;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Problema user = (Problema) o;
        return !(user.getId() == null || getId() == null) && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Probleme{" +
            "id='" + id + '\'' +
            ", content='" + text + '\'' +
            "}";
    }

}
