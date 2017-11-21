package edu.acs.acspedia.repository;

import edu.acs.acspedia.domain.Curs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursRepository extends JpaRepository<Curs, String> {
}
