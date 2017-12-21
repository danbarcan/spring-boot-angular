package edu.acs.acspedia.service;

import edu.acs.acspedia.domain.Materiale;
import edu.acs.acspedia.repository.MaterialeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class MaterialeService {

    private final MaterialeRepository materialeRepository;

    public MaterialeService(MaterialeRepository materialeRepository) {
        this.materialeRepository = materialeRepository;
    }

    public Set<Materiale> getFilesNameAfterType(String type, String cid) {
        return materialeRepository.getNameByType(type, cid);
    }

    public void uploadMateriale(Materiale materiale){
        materialeRepository.save(materiale);
    }

}
