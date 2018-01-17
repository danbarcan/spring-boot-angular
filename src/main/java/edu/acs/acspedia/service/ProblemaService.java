package edu.acs.acspedia.service;

import edu.acs.acspedia.domain.FisierP;
import edu.acs.acspedia.domain.Problema;
import edu.acs.acspedia.repository.FisierPRepository;
import edu.acs.acspedia.repository.ProblemeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProblemaService {

    private final ProblemeRepository problemeRepository;
    private final FisierPRepository fisierPRepository;

    public ProblemaService(ProblemeRepository problemeRepository, FisierPRepository fisierPRepository) {
        this.problemeRepository = problemeRepository;
        this.fisierPRepository = fisierPRepository;
    }

    public Problema get(Long id){
        return problemeRepository.getOne(id);
    }

    public List<Problema> getProbleme(String cid){
        return problemeRepository.getProbleme(cid);
    }

    public List<Problema> getProblemeR(String cid){
        return problemeRepository.getProblemeR(cid);
    }

    public Problema save(Problema p){
        return problemeRepository.save(p);
    }

    public FisierP saveFile(FisierP p){
        return fisierPRepository.saveAndFlush(p);
    }
}
