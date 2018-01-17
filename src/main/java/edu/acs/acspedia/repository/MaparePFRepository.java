package edu.acs.acspedia.repository;

import edu.acs.acspedia.domain.MaparePF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaparePFRepository extends JpaRepository<MaparePF, Long> {
}
