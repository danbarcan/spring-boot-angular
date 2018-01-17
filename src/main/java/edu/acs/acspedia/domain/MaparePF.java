package edu.acs.acspedia.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "jhi_mapare_probleme_fisiere")
public class MaparePF {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    Long id;

    @Column(name="pid")
    Long pid;

    @Column(name="fid")
    Long fid;

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getFid() {
        return fid;
    }

    public Long getPid() {
        return pid;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MaparePF user = (MaparePF) o;
        boolean x = !(user.getFid() == null || getFid() == null) && Objects.equals(getFid(), user.getFid());
        x = x && !(user.getPid() == null || getPid() == null) && Objects.equals(getPid(), user.getPid());
        return x;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getFid()) + Objects.hashCode(getPid());
    }

    @Override
    public String toString() {
        return "Mapare{" +
            "pid='" + pid + '\'' +
            ", fid='" + fid + '\'' +
            "}";
    }
}
