package edu.acs.acspedia.service;

import edu.acs.acspedia.domain.Asistent;
import edu.acs.acspedia.domain.Curs;
import edu.acs.acspedia.domain.MatCursuri;
import edu.acs.acspedia.domain.Profesor;
import edu.acs.acspedia.repository.CursRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class CursService {
    private final Logger log = LoggerFactory.getLogger(UserService.class);

    private final CursRepository cursRepository;

    public CursService(CursRepository cursRepository) {
        this.cursRepository = cursRepository;
    }

    @Transactional(readOnly = true)
    public Curs getCurs(String id) {
        return cursRepository.getOne(id);
    }

    @Transactional(readOnly = true)
    public Set<Profesor> getProfessors(String id) {
        return cursRepository.findOneWithProfesorsById(id).getProfesors();
    }

    @Transactional(readOnly = true)
    public Set<Asistent> getAssistants(String id) {
        return cursRepository.findOneWithAsistentsById(id).getAsistents();
    }
}
