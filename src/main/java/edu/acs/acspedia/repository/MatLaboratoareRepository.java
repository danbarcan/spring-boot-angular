package edu.acs.acspedia.repository;

import edu.acs.acspedia.domain.MatCursuri;
import edu.acs.acspedia.domain.MatLaboratoare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MatLaboratoareRepository extends JpaRepository<MatLaboratoare, String> {

    @Query("SELECT m FROM MatLaboratoare m where m.idCurs = :cid and m.activated = 1")
    Set<MatLaboratoare> getMatLaboratoare(@Param("cid") String cid);

}
