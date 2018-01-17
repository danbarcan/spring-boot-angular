package edu.acs.acspedia.repository;

import edu.acs.acspedia.domain.MatLaboratoare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface MatLaboratoareRepository extends JpaRepository<MatLaboratoare, Long> {

    @Query("SELECT m FROM MatLaboratoare m where m.idCurs = :cid and m.activated = true")
    Set<MatLaboratoare> getMatLaboratoare(@Param("cid") String cid);

    @Query("SELECT m FROM MatLaboratoare m where m.activated = false")
    List<MatLaboratoare> getFilesNA();

    Optional<MatLaboratoare> findOneById(Long id);

}
