package edu.acs.acspedia.repository;

import edu.acs.acspedia.domain.MatCursuri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatCursuriRepository extends JpaRepository<MatCursuri, String> {

    @Query("SELECT m FROM MatCursuri m where m.idCurs = :cid and m.activated = 1")
    List<MatCursuri> getMatCursuri(@Param("cid") String cid);

}