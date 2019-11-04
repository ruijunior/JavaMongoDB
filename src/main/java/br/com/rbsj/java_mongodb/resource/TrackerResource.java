package br.com.rbsj.java_mongodb.resource;

import br.com.rbsj.java_mongodb.model.Application;
import br.com.rbsj.java_mongodb.model.Release;
import br.com.rbsj.java_mongodb.model.Ticket;
import br.com.rbsj.java_mongodb.repositories.ApplicationRepository;
import br.com.rbsj.java_mongodb.repositories.ReleaseRepository;
import br.com.rbsj.java_mongodb.repositories.TicketRepository;
import br.com.rbsj.java_mongodb.service.ApplicationService;
import br.com.rbsj.java_mongodb.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/tracker")
public class TrackerResource {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ReleaseRepository releaseRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ApplicationService  applicationService;

    @Autowired
    private ReleaseService releaseService;

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

    @RequestMapping(value = "/applications/template", method = RequestMethod.PUT)
    public void updateApplicationWTemplate(@RequestBody Application application){
        this.applicationService.updateApplicationWTemplate(application, "Name to be updating");
    }

    @RequestMapping(value = "/tickets/count", method = RequestMethod.GET)
    public Long countAllTickets(){
        Stream<Ticket> stream = ticketRepository.findAllByCustomerAndStream("Open");
        Long count = stream.count();
        stream.close();

        return count;
    }

    @RequestMapping(value = "/releases/status/{status}", method = RequestMethod.GET)
    public List<Release> getReleaseByTicketStatus(@PathVariable("status") String status){
        return releaseService.getReleaseByTicketStatus(status);
    }

    @RequestMapping(value = "/releases/{id}", method = RequestMethod.PUT)
    public Release updateRelease(@PathVariable("id") String id, @RequestBody Release release){
        release.setId(id);
        return this.releaseService.save(release);
    }
}
