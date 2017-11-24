package edu.acs.acspedia.repository;

import edu.acs.acspedia.domain.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, Long> {

    @Query("SELECT count(r) FROM Ranking r where r.id_pers = :pid and r.type = true and r.id_course = :cid")
    Long getNrOfVotesForProfesor(@Param("pid") Long pid, @Param("cid") String cid);

    @Query("SELECT count(r) FROM Ranking r where r.id_pers = :aid and r.type = false and r.id_course = :cid")
    Long getNrOfVotesForAssistant(@Param("aid") Long aid, @Param("cid") String cid);

    @Query("SELECT count(r) from Ranking r where r.id_user = :uid and r.id_course = :cid and r.type = true")
    int hasVotedP(@Param("uid") Long uid, @Param("cid") String cid);

    @Query("SELECT count(r) from Ranking r where r.id_user = :uid and r.id_course = :cid and r.type = false")
    int hasVotedA(@Param("uid") Long uid, @Param("cid") String cid);

}
