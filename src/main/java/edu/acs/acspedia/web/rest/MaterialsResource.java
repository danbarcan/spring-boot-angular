package edu.acs.acspedia.web.rest;

import com.codahale.metrics.annotation.Timed;
import edu.acs.acspedia.domain.MatCursuri;
import edu.acs.acspedia.domain.MatExamene;
import edu.acs.acspedia.domain.MatLaboratoare;
import edu.acs.acspedia.service.MaterialsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;
import static edu.acs.acspedia.web.rest.util.FileUtil.downloadFile;
import static edu.acs.acspedia.web.rest.util.FileUtil.saveFileToDisk;

@RestController
@RequestMapping("/api")
public class MaterialsResource {
    private final MaterialsService materialsService;
    private final String MATERIALS_PATH = "F:/";

    public MaterialsResource(MaterialsService materialsService) {
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

    @PostMapping("/upload/curs/{cid}/{year}")
    @Timed
    public String uploadCurs(@PathVariable("cid") String cid, @PathVariable("year") String year, @RequestParam("file") MultipartFile file) {
        checkNotNull(file, "Cannot parse null file");

        MatCursuri matCurs = new MatCursuri();
        matCurs.setIdCurs(cid);
        String path = MATERIALS_PATH + "courses/" + cid + "/" + file.getOriginalFilename();
        matCurs.setPath(path);
        matCurs.setActivated(false);
        matCurs.setYear(year);
        if (saveFileToDisk(file, path)) {
            materialsService.uploadCurs(matCurs);
            return "File saved";
        }
        return "File not saved";
    }

    @GetMapping("/download/curs/{cid}")
    @Timed
    public void downloadCurs(@PathVariable("cid") String cid, HttpServletResponse response) {
        MatCursuri matCurs = materialsService.getMatCursByIdCurs(cid);
        if (matCurs != null) {
            downloadFile(response, matCurs.getPath());
        } else {
            System.out.println("err no file");
        }

    }

    @PutMapping("/activate/matCursuri")
    @Timed
    public void activateFile(@RequestBody @Valid MatCursuri fisier) {
        fisier.setActivated(true);
        materialsService.uploadCurs(fisier);
    }

    @PostMapping("/upload/lab/{cid}/{year}")
    @Timed
    public String uploadLaborator(@PathVariable("cid") String cid,@PathVariable("year") String year, @RequestParam("file") MultipartFile file) {
        checkNotNull(file, "Cannot parse null file");

        MatLaboratoare matLaboratoare = new MatLaboratoare();
        matLaboratoare.setIdCurs(cid);
        String path = MATERIALS_PATH + "labs/" + cid + "/" + file.getOriginalFilename();
        matLaboratoare.setPath(path);
        matLaboratoare.setActivated(false);
        matLaboratoare.setYear(year);
        if (saveFileToDisk(file, path)) {
            materialsService.uploadLab(matLaboratoare);
            return "File saved";
        }
        return "File not saved";
    }

    @GetMapping("/download/lab/{cid}")
    @Timed
    public void downloadLaborator(@PathVariable("cid") String cid, HttpServletResponse response) {
        MatLaboratoare matLab = materialsService.getMatLabByIdCurs(cid);
        if (matLab != null) {
            downloadFile(response, matLab.getPath());
        } else {
            System.out.println("err no file");
        }
    }

    @PutMapping("/activate/matLab")
    @Timed
    public void activateFile(@RequestBody @Valid MatLaboratoare fisier) {
        fisier.setActivated(true);
        materialsService.uploadLab(fisier);
    }

    @PostMapping("/upload/exam/{cid}/{year}")
    @Timed
    public String uploadExam(@PathVariable("cid") String cid,@PathVariable("year") String year, @RequestParam("file") MultipartFile file) {
        checkNotNull(file, "Cannot parse null file");

        MatExamene matExamene = new MatExamene();
        matExamene.setIdCurs(cid);
        String path = MATERIALS_PATH + "exams/" + cid + "/" + file.getOriginalFilename();
        matExamene.setPath(path);
        matExamene.setActivated(false);
        matExamene.setYear(year);
        if (saveFileToDisk(file, path)) {
            materialsService.uploadExam(matExamene);
            return "File saved";
        }
        return "File not saved";
    }

    @GetMapping("/curs/getfilesNA")
    @Timed
    public List<MatCursuri> getFilesNAC() {
        return materialsService.getFilesNAC();
    }

    @GetMapping("/labs/getfilesNA")
    @Timed
    public List<MatLaboratoare> getFilesNAL() {
        return materialsService.getFilesNAL();
    }

    @GetMapping("/exams/getfilesNA")
    @Timed
    public List<MatExamene> getFilesNAE() {
        return materialsService.getFilesNAE();
    }

    @GetMapping("/download/exam/{cid}")
    @Timed
    public void downloadExamen(@PathVariable("cid") String cid, HttpServletResponse response) {
        MatExamene matExam = materialsService.getMatExamByIdCurs(cid);
        if (matExam != null) {
            downloadFile(response, matExam.getPath());
        } else {
            System.out.println("err no file");
        }
    }

    @PutMapping("/activate/matExam")
    @Timed
    public void activateFile(@RequestBody @Valid MatExamene fisier) {
        fisier.setActivated(true);
        materialsService.uploadExam(fisier);
    }
}
