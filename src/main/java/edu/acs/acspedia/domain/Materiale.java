package edu.acs.acspedia.domain;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "jhi_materiale")
public class Materiale implements Serializable {

    @Id
    @SequenceGenerator(name="my_seq_mat", sequenceName="hibernate_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="my_seq_mat")
    private Long id;

    @Column(name="name")
    private String name;

    @Lob
    @Column(name="file")
    private MultipartFile file;

    @Column(name = "id_curs")
    private String idCurs;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "activated")
    private Boolean activated;

    @Column(name = "type")
    private String type;



    public MultipartFile  getFile() {
        return file;
    }

    public void setFile(MultipartFile  file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Materiale user = (Materiale) o;
        return !(user.getId() == null || getId() == null) && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Materiale{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            "}";
    }
}
