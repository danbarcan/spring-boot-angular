package edu.acs.acspedia.web.rest;


import com.codahale.metrics.annotation.Timed;
import edu.acs.acspedia.domain.FisierP;
import edu.acs.acspedia.domain.MatExamene;
import edu.acs.acspedia.domain.Problema;
import edu.acs.acspedia.service.ProblemaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static edu.acs.acspedia.web.rest.util.FileUtil.downloadFile;
import static edu.acs.acspedia.web.rest.util.FileUtil.saveFileToDisk;

@RestController
@RequestMapping("/api")
public class ProblemaResource {

    private final ProblemaService problemaService;
    private final String MATERIALS_PATH = "F:/";

    public ProblemaResource(ProblemaService problemaService){
        this.problemaService = problemaService;
    }

    @GetMapping("/probleme/{cid}")
    @Timed
    public List<Problema> getProbleme(@PathVariable("cid") String cid) {
        return problemaService.getProbleme(cid);
    }

    @GetMapping("/problema/{id}")
    @Timed
    public Problema getProbleme(@PathVariable("id") Long id) {
        return problemaService.get(id);
    }

    @GetMapping("/problemeR/{cid}")
    @Timed
    public List<Problema> getProblemeR(@PathVariable("cid") String cid) {
        return problemaService.getProblemeR(cid);
    }

    @GetMapping("/p/getfiles/{pid}")
    @Timed
    public List<FisierP> getFiles(@PathVariable("pid") Long pid) {
        return problemaService.getFiles(pid);
    }

    @PostMapping("/saveProblema")
    public Problema save(@Valid @RequestBody Problema p) {
        return problemaService.save(p);
    }

    @PostMapping("/upload/probFile/{pid}")
    @Timed
    public String uploadFile(@RequestParam("file") MultipartFile file, @PathVariable("pid") Long pid) {
        checkNotNull(file, "Cannot parse null file");
        FisierP fisierP = new FisierP();
        String path = MATERIALS_PATH + "fisiereP/" + file.getOriginalFilename();
        fisierP.setPath(path);
        fisierP.setActivated(false);
        fisierP.setPid(pid);
        if (saveFileToDisk(file, path)) {
            problemaService.saveFile(fisierP);
            return "File saved";
        }
        return "File not saved";
    }

    @GetMapping("/download/prez/{fid}")
    @Timed
    public void downloadExamen(@PathVariable("fid") Long fid, HttpServletResponse response) {
        FisierP matExam = problemaService.getFile(fid);
        if (matExam != null) {
            downloadFile(response, matExam.getPath());
        } else {
            System.out.println("err no file");
        }
    }

    @PutMapping("/activate/probFile")
    @Timed
    public void activateFile(@RequestBody @Valid FisierP fisierP) {
        fisierP.setActivated(true);
        problemaService.saveFile(fisierP);
    }

}
