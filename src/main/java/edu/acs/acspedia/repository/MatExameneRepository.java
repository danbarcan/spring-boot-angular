package edu.acs.acspedia.repository;

import edu.acs.acspedia.domain.MatExamene;
import edu.acs.acspedia.domain.MatLaboratoare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MatExameneRepository extends JpaRepository<MatExamene, String> {

    @Query("SELECT id, id_curs, path FROM MatExamene m where m.idCurs = :cid")
    Set<MatExamene> getMatExamene(@Param("cid") String cid);

}
