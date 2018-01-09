package edu.acs.acspedia.repository;

import edu.acs.acspedia.domain.Materiale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MaterialeRepository extends JpaRepository<Materiale, Long> {

    @Query("SELECT m FROM Materiale m where m.type = :type and m.idCurs = :cid")
    Set<Materiale> getNameByType(@Param("type") String type, @Param("cid") String cid);

}
