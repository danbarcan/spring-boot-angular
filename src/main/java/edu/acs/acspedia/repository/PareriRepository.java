package edu.acs.acspedia.repository;

import edu.acs.acspedia.domain.MatExamene;
import edu.acs.acspedia.domain.Pareri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PareriRepository extends JpaRepository<Pareri, Long> {


    @Query("SELECT p FROM Pareri p where p.idMaterie = :cid and p.type= :tpe ")
    Set<Pareri> getPareri(@Param("cid") String cid, @Param("tpe") String tpe);

    @Query("SELECT p FROM Pareri p where p.idMaterie is null and p.type = :tpe ")
    Set<Pareri> getPareriG( @Param("tpe") String tpe);

    @Query("SELECT p FROM Pareri p where p.idMaterie is null and p.type = :tpe and p.idType = :pid")
    Set<Pareri> getPareriP( @Param("tpe") String tpe,  @Param("pid") Long pid);


}
