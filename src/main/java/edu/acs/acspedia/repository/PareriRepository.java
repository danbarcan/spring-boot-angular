package edu.acs.acspedia.repository;

import edu.acs.acspedia.domain.Pareri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PareriRepository extends JpaRepository<Pareri, Long> {
}
