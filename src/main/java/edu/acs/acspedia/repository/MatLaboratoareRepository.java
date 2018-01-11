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

    @Query("SELECT id, idCurs, path FROM MatLaboratoare m where m.idCurs = :cid")
    Set<MatLaboratoare> getMatLaboratoare(@Param("cid") String cid);

}
