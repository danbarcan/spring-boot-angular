package edu.acs.acspedia.service;

import edu.acs.acspedia.domain.Asistent;
import edu.acs.acspedia.domain.Pair;
import edu.acs.acspedia.domain.Profesor;
import edu.acs.acspedia.repository.RankingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class RankingService {
    private final RankingRepository rankingRepository;
    private final CursService cursService;

    public RankingService(RankingRepository rankingRepository,
                            CursService cursService) {
        this.rankingRepository = rankingRepository;
        this.cursService = cursService;
    }

    @Transactional(readOnly = true)
    public Long getNrVotesP(Long pid, String cid ) {
        return rankingRepository.getNrOfVotesForProfesor(pid, cid);
    }

    @Transactional(readOnly = true)
    public Boolean hasVotedP(Long uid, String cid ) {
        return rankingRepository.hasVotedP(uid, cid)>=1;
    }

    @Transactional(readOnly = true)
    public Boolean hasVotedA(Long uid, String cid ) {
        return rankingRepository.hasVotedA(uid, cid)>=1;
    }

    @Transactional(readOnly = true)
    public Long getNrVotesA(Long aid, String cid ) {
        return rankingRepository.getNrOfVotesForAssistant(aid, cid);
    }

    @Transactional(readOnly = true)
    public List<Pair<Long, Asistent>> getAllVotesA(String cid ) {
        Set<Asistent> ast = cursService.getAssistants(cid);
        List<Pair<Long, Asistent>> lst = new ArrayList<>();
        for (Asistent asistent : ast) {
            lst.add(new Pair<>(getNrVotesA(asistent.getId(), cid),asistent));
        }
        return lst;
    }

    @Transactional(readOnly = true)
    public List<Pair<Long, Profesor>> getAllVotesP(String cid ) {
        Set<Profesor> ast = cursService.getProfessors(cid);
        List<Pair<Long, Profesor>> lst = new ArrayList<>();
        for (Profesor asistent : ast) {
            lst.add(new Pair<>(getNrVotesP(asistent.getId(), cid),asistent));
        }
        return lst;
    }




}
