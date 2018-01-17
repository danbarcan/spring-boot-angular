package edu.acs.acspedia.repository;

import edu.acs.acspedia.domain.Problema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemeRepository extends JpaRepository<Problema, Long> {

    @Query("SELECT m FROM Problema m where m.idMaterie = :cid and m.resolved = false")
    List<Problema> getProbleme(@Param("cid") String cid);

    @Query("SELECT m FROM Problema m where m.idMaterie = :cid and m.resolved = true")
    List<Problema> getProblemeR(@Param("cid") String cid);
}
