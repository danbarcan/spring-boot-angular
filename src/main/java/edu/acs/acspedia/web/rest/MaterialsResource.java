package edu.acs.acspedia.web.rest;

import com.codahale.metrics.annotation.Timed;
import edu.acs.acspedia.domain.MatCursuri;
import edu.acs.acspedia.domain.MatExamene;
import edu.acs.acspedia.domain.MatLaboratoare;
import edu.acs.acspedia.service.MaterialsService;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@RestController
@RequestMapping("/api")
public class MaterialsResource {
    private final MaterialsService materialsService;
    private final String MATERIALS_PATH = "F:/";

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

    @PostMapping("/upload/curs/{cid}")
    @Timed
    public String uploadCurs(@PathVariable("cid") String cid, @RequestParam("file") MultipartFile file) {
        checkNotNull(file, "Cannot parse null file");

        MatCursuri matCurs = new MatCursuri();
        matCurs.setIdCurs(cid);
        String path = MATERIALS_PATH + "courses/" + cid + "/" + file.getOriginalFilename();
        matCurs.setPath(path);
        matCurs.setActivated(false);
        matCurs.setYear("2018");
        if (saveFileToDisk(file, path)) {
            materialsService.uploadCurs(matCurs);
            return "File saved";
        }
        return "File not saved";
    }

    @PutMapping("/activate/matCursuri")
    @Timed
    public void activateFile(@RequestBody @Valid MatCursuri fisier) {
        fisier.setActivated(true);
        materialsService.uploadCurs(fisier);
    }

    @PostMapping("/upload/lab/{cid}")
    @Timed
    public String uploadLaborator(@PathVariable("cid") String cid, @RequestParam("file") MultipartFile file) {
        checkNotNull(file, "Cannot parse null file");

        MatLaboratoare matLaboratoare = new MatLaboratoare();
        matLaboratoare.setIdCurs(cid);
        String path = MATERIALS_PATH + "labs/" + cid + "/" + file.getOriginalFilename();
        matLaboratoare.setPath(path);
        matLaboratoare.setActivated(false);
        matLaboratoare.setYear("2018");
        if (saveFileToDisk(file, path)) {
            materialsService.uploadLab(matLaboratoare);
            return "File saved";
        }
        return "File not saved";
    }

    @PutMapping("/activate/matLab")
    @Timed
    public void activateFile(@RequestBody @Valid MatLaboratoare fisier) {
        fisier.setActivated(true);
        materialsService.uploadLab(fisier);
    }

    @PostMapping("/upload/exam/{cid}")
    @Timed
    public String uploadExam(@PathVariable("cid") String cid, @RequestParam("file") MultipartFile file) {
        checkNotNull(file, "Cannot parse null file");

        MatExamene matExamene = new MatExamene();
        matExamene.setIdCurs(cid);
        String path = MATERIALS_PATH + "exams/" + cid + "/" + file.getOriginalFilename();
        matExamene.setPath(path);
        matExamene.setActivated(false);
        matExamene.setYear("2018");
        if (saveFileToDisk(file, path)) {
            materialsService.uploadExam(matExamene);
            return "File saved";
        }
        return "File not saved";
    }

    @PutMapping("/activate/matExam")
    @Timed
    public void activateFile(@RequestBody @Valid MatExamene fisier) {
        fisier.setActivated(true);
        materialsService.uploadExam(fisier);
    }

    private boolean saveFileToDisk(MultipartFile file, String path) {
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path));
            return true;
        } catch (IOException ioe) {
            log.println(ioe);
            return false;
        }
    }
}
