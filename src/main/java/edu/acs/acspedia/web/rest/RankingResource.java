package edu.acs.acspedia.web.rest;

import com.codahale.metrics.annotation.Timed;
import edu.acs.acspedia.domain.Asistent;
import edu.acs.acspedia.domain.Pair;
import edu.acs.acspedia.domain.Profesor;
import edu.acs.acspedia.service.RankingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RankingResource {
    private final RankingService rankingService;

    public RankingResource(RankingService rankingService){
        this.rankingService = rankingService;
    }

    @GetMapping("/ranking_ast/{cid}")
    @Timed
    public List<Pair<Long, Asistent>> getARanking(@PathVariable("cid") String cid) {
        return rankingService.getAllVotesA(cid);
    }

    @GetMapping("/ranking_prof/{cid}")
    @Timed
    public List<Pair<Long, Profesor>> getPRanking(@PathVariable("cid") String cid) {
        return rankingService.getAllVotesP(cid);
    }

    @GetMapping("/hasVotedP/{cid}/{uid}")
    @Timed
    public Boolean hasVotedP(@PathVariable("uid") Long uid, @PathVariable("cid") String cid) {
        return rankingService.hasVotedP(uid, cid);
    }

    @GetMapping("/hasVotedA/{uid}/{cid}")
    @Timed
    public Boolean hasVotedA(@PathVariable("uid") Long uid, @PathVariable("cid") String cid) {
        return rankingService.hasVotedA(uid, cid);
    }

    @GetMapping("/voteA/{cid}/{aid}/{uid}")
    @Timed
    public void voteA(@PathVariable("aid") Long aid, @PathVariable("cid") String cid, @PathVariable("uid") Long uid) {
        rankingService.voteA(cid, aid, uid);
    }

    @GetMapping("/voteP/{cid}/{pid}/{uid}")
    @Timed
    public void voteP(@PathVariable("pid") Long pid, @PathVariable("cid") String cid, @PathVariable("uid") Long uid) {
        rankingService.voteP(cid, pid, uid);
    }

}
