package edu.acs.acspedia.web.rest;

import com.codahale.metrics.annotation.Timed;
import edu.acs.acspedia.domain.*;
import edu.acs.acspedia.service.MaterialsService;
import edu.acs.acspedia.service.RankingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class MaterialsResource {
    private final MaterialsService materialsService;

    public MaterialsResource(MaterialsService materialsService){
        this.materialsService = materialsService;
    }

    @GetMapping("/mat_courses/{cid}")
    @Timed
    public List<MatCursuri> getMatCursuri(@PathVariable("cid") String cid) {
        return materialsService.getMatCursuri(cid);
    }

    @GetMapping("/m_labs/{cid}")
    @Timed
    public Set<MatLaboratoare> getMatLaboratoare(@PathVariable("cid") String cid) {
        return materialsService.getMatLaboratoare(cid);
    }

    @GetMapping("/m_exams/{cid}")
    @Timed
    public Set<MatExamene> getMatExamene(@PathVariable("cid") String cid) {
        return materialsService.getMatExamene(cid);
    }
}
