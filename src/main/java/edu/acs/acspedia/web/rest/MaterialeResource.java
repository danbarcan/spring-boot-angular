package edu.acs.acspedia.web.rest;

import com.codahale.metrics.annotation.Timed;
import edu.acs.acspedia.domain.Materiale;
import edu.acs.acspedia.service.MaterialeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

@RestController
@RequestMapping("/api")
public class MaterialeResource {

    private final MaterialeService materialeService;

    public MaterialeResource(MaterialeService materialeService) {
        this.materialeService = materialeService;
    }

    @GetMapping("/materiale/{cid}/{type}")
    @Timed
    public Set<Materiale> getFilesName(@PathVariable("cid") String cid, @PathVariable("type") String type) {
        return materialeService.getFilesNameAfterType(type, cid);
    }

    @PostMapping("/materiale/upload")
    @Timed
    public void uploadMateriale(@RequestParam("uploadFile") MultipartFile file){
        if(file == null){
            System.out.println("fuck");
            return ;
        }
        System.out.println("file found " + file);
    }
}
