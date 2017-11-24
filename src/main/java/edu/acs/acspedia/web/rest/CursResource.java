package edu.acs.acspedia.web.rest;

import com.codahale.metrics.annotation.Timed;
import edu.acs.acspedia.domain.Asistent;
import edu.acs.acspedia.domain.Curs;
import edu.acs.acspedia.domain.Profesor;
import edu.acs.acspedia.service.CursService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class CursResource {
    private final Logger log = LoggerFactory.getLogger(UserResource.class);
    private final CursService cursService;

    public CursResource(CursService cursService) {
        this.cursService = cursService;
    }

    @GetMapping("/cursuri/{id}")
    @Timed
    public Curs getCurs(@PathVariable("id") String id) {
        return cursService.getCurs(id);
    }

    @GetMapping("/cprof/{id}")
    @Timed
    public Set<Profesor> getCursProf(@PathVariable("id") String id) {
        return cursService.getProfessors(id);
    }

    @GetMapping("/casis/{id}")
    @Timed
    public Set<Asistent> getCursAsis(@PathVariable("id") String id) {
        return cursService.getAssistants(id);
    }

}
