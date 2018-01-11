package edu.acs.acspedia.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "jhi_mat_examene")
public class MatExamene {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "id_curs")
    private String idCurs;

    @NotNull
    @Column(name = "path")
    private String path;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdCurs() {
        return idCurs;
    }

    public void setIdCurs(String idCurs) {
        this.idCurs = idCurs;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatExamene that = (MatExamene) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "MatCursuri{" +
            "id=" + id +
            ", idCurs='" + idCurs + '\'' +
            ", path='" + path + '\'' +
            '}';
    }
}
