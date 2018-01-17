package edu.acs.acspedia.repository;

import edu.acs.acspedia.domain.MatExamene;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface MatExameneRepository extends JpaRepository<MatExamene, Long> {

    @Query("SELECT m FROM MatExamene m where m.idCurs = :cid and m.activated = true")
    Set<MatExamene> getMatExamene(@Param("cid") String cid);

    Optional<MatExamene> findOneById(Long id);

}
