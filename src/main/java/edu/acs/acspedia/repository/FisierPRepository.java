package edu.acs.acspedia.repository;

import edu.acs.acspedia.domain.FisierP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FisierPRepository extends JpaRepository<FisierP, Long> {
}
