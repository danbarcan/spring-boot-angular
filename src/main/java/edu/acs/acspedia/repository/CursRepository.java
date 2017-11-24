package edu.acs.acspedia.repository;

import edu.acs.acspedia.domain.Curs;
import edu.acs.acspedia.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursRepository extends JpaRepository<Curs, String> {

    @EntityGraph(attributePaths = "asistents")
    Curs findOneWithAsistentsById(String id);

    @EntityGraph(attributePaths = "profesors")
    Curs findOneWithProfesorsById(String id);
}
