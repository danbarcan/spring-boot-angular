package edu.acs.acspedia.service;

import edu.acs.acspedia.domain.MatCursuri;
import edu.acs.acspedia.domain.MatExamene;
import edu.acs.acspedia.domain.MatLaboratoare;
import edu.acs.acspedia.repository.MatCursuriRepository;
import edu.acs.acspedia.repository.MatExameneRepository;
import edu.acs.acspedia.repository.MatLaboratoareRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class MaterialsService {
    private final Logger log = LoggerFactory.getLogger(UserService.class);

    private final MatCursuriRepository matCursuriRepository;
    private final MatLaboratoareRepository matLaboratoareRepository;
    private final MatExameneRepository matExameneRepository;

    public MaterialsService(MatCursuriRepository matCursuriRepository, MatLaboratoareRepository matLaboratoareRepository, MatExameneRepository matExameneRepository) {
        this.matCursuriRepository = matCursuriRepository;
        this.matExameneRepository = matExameneRepository;
        this.matLaboratoareRepository = matLaboratoareRepository;
    }

    @Transactional(readOnly = true)
    public List<MatCursuri> getMatCursuri(String cid) {
        return matCursuriRepository.getMatCursuri(cid);
    }

    @Transactional(readOnly = true)
    public Set<MatLaboratoare> getMatLaboratoare(String cid) {
        return matLaboratoareRepository.getMatLaboratoare(cid);
    }

    @Transactional(readOnly = true)
    public Set<MatExamene> getMatExamene(String cid) {
        return matExameneRepository.getMatExamene(cid);
    }

    public void uploadCurs(MatCursuri matCursuri) {
        matCursuriRepository.save(matCursuri);
    }

    public void uploadLab(MatLaboratoare matLaboratoare) {
        matLaboratoareRepository.save(matLaboratoare);
    }

    public void uploadExam(MatExamene matExamene) {
        matExameneRepository.save(matExamene);
    }

}
