package edu.acs.acspedia.web.rest;

import com.codahale.metrics.annotation.Timed;
import edu.acs.acspedia.domain.Pareri;
import edu.acs.acspedia.service.PareriService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class PareriResource {

    private final PareriService pareriService;

    public PareriResource(PareriService pareriService){
        this.pareriService = pareriService;
    }

    @Timed
    @GetMapping("/pareri/{type}/{cid}")
    public Set<Pareri> getPareri(@PathVariable("cid") String cid, @PathVariable("type")  String tpe){
        return pareriService.getPareri(cid, tpe);
    }

    @Timed
    @GetMapping("/pareriG/{type}")
    public Set<Pareri> getPareriG(@PathVariable("type") String tpe){
        return pareriService.getPareriG(tpe);
    }

    @Timed
    @GetMapping("/pareriP/{type}/{pid}")
    public Set<Pareri> getPareriP(@PathVariable("type") String tpe,@PathVariable("pid")  Long pid){
        return pareriService.getPareriP(tpe, pid);
    }

    @Timed
    @DeleteMapping("/delete/{pid}")
    public void getPareriP(@PathVariable("pid")  Long pid){
        pareriService.delete(pid);
    }

    @PostMapping("/savePareri")
    public Pareri save(@Valid @RequestBody Pareri p){
        return pareriService.save(p);
    }
}
