package edu.acs.acspedia.repository;

import edu.acs.acspedia.domain.FisierP;
import edu.acs.acspedia.domain.MatCursuri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface FisierPRepository extends JpaRepository<FisierP, Long> {

    @Query("SELECT f FROM FisierP f where f.pid = :pid and f.activated = true")
    List<FisierP> getFiles(@Param("pid") Long pid);

    @Query("SELECT m FROM FisierP m where m.activated = false")
    List<FisierP> getFilesNA();
}
