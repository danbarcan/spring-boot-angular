package edu.acs.acspedia.web.rest;


import com.codahale.metrics.annotation.Timed;
import edu.acs.acspedia.domain.FisierP;
import edu.acs.acspedia.domain.Problema;
import edu.acs.acspedia.service.ProblemaService;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

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

    @GetMapping("/problemeR/{cid}")
    @Timed
    public List<Problema> getProblemeR(@PathVariable("cid") String cid) {
        return problemaService.getProblemeR(cid);
    }

    @PostMapping("/saveProblema")
    public Problema save(@Valid @RequestBody Problema p){
        return problemaService.save(p);
    }

    @PostMapping("/upload/probFile")
    @Timed
    public String uploadExam(@RequestParam("file") MultipartFile file) {
        checkNotNull(file, "Cannot parse null file");
        FisierP fisierP = new FisierP();
        String path = MATERIALS_PATH + "fisiereP/" + file.getOriginalFilename();
        fisierP.setPath(path);
        fisierP.setActivated(false);
        if (saveFileToDisk(file, path)) {
            problemaService.saveFile(fisierP);
            return "File saved";
        }
        return "File not saved";
    }

    @PutMapping("/activate/probFile")
    @Timed
    public void activateFile(@RequestBody @Valid FisierP fisierP) {
        fisierP.setActivated(true);
        problemaService.saveFile(fisierP);
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
