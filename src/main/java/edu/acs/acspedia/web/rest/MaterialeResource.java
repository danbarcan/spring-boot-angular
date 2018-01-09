package edu.acs.acspedia.web.rest;

import com.codahale.metrics.annotation.Timed;
import edu.acs.acspedia.domain.Materiale;
import edu.acs.acspedia.service.MaterialeService;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PostMapping("/upload/material")
    @Timed
    public String getEmailsFromExcel(@RequestParam("file") MultipartFile file) {
        checkNotNull(file, "Cannot parse null file");

        /*Materiale material = new Materiale();
        try {
            material.setFile(file.getBytes());
        } catch(Exception e) {

        }

        material.setName(file.getName());
        material.setType("curs");
        material.setIdUser(4l);
        material.setActivated(false);
        material.setIdCurs("a1s1pc");
        materialeService.uploadMateriale(material);*/
        try (InputStream inputStream = file.getInputStream()) {
            System.out.println(inputStream);
            //return excelService.parseEmails(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            return "file not received";
        }
        return "File received";
    }
}
