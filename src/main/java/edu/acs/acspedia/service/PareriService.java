package edu.acs.acspedia.service;

import edu.acs.acspedia.domain.Pareri;
import edu.acs.acspedia.repository.PareriRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class PareriService {

    private final PareriRepository pareriRepository;

    public PareriService(PareriRepository pareriRepository) {
        this.pareriRepository = pareriRepository;

    }

    public Set<Pareri> getPareri(String cid,String tpe){
        return pareriRepository.getPareri(cid, tpe);
    }

    public Set<Pareri> getPareriG(String tpe){
        return pareriRepository.getPareriG(tpe);
    }

    public Set<Pareri> getPareriP(String tpe,  Long pid){
        return pareriRepository.getPareriP(tpe, pid);
    }

    public Pareri save(Pareri p){
        return pareriRepository.save(p);
    }

    public void delete(Long p){
        pareriRepository.delete(p);
    }

}
