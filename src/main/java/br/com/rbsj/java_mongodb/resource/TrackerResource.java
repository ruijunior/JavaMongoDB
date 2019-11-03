package br.com.rbsj.java_mongodb.resource;

import br.com.rbsj.java_mongodb.model.Application;
import br.com.rbsj.java_mongodb.repositories.ApplicationRepository;
import br.com.rbsj.java_mongodb.repositories.ReleaseRepository;
import br.com.rbsj.java_mongodb.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tracker")
public class TrackerResource {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ReleaseRepository releaseRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @RequestMapping(value = "/applications", method = RequestMethod.GET)
    public List<Application> getApplications(){
        return this.applicationRepository.findAll();
    }

    @RequestMapping(value = "/applications/{id}", method = RequestMethod.GET)
    public Optional<Application> getApplicationBy(@PathVariable("id") String id){
        return this.applicationRepository.findById(id);
    }

    @RequestMapping(value = "/applications", method = RequestMethod.POST)
    public Application addApplication(@RequestBody Application application){
        return this.applicationRepository.save(application);
    }
}
