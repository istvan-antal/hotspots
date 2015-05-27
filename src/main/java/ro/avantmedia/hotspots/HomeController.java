package ro.avantmedia.hotspots;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.avantmedia.hotspots.model.NetworkConsistInput;
import ro.avantmedia.hotspots.model.NetworkConsistInputRepository;
import ro.avantmedia.hotspots.model.NetworkConsistModel;
import ro.avantmedia.hotspots.model.NetworkConsistModeller;

@RestController
public class HomeController {
    
    @Autowired
    NetworkConsistInputRepository repository;
    
    @RequestMapping(value = "/inputs", method = RequestMethod.POST)
    public NetworkConsistInput create(@RequestParam("host") String host, @RequestParam("name") String name, @RequestParam("value") String value) {
        NetworkConsistInput input = new NetworkConsistInput();
        input.host = host;
        input.name = name;
        input.value = value;
        repository.save(input);
        return input;
    }
    
    @RequestMapping(value = "/inputs/{id}", method = RequestMethod.DELETE)
    public void deleteInput(@PathVariable long id) {
        repository.delete(id);
    }
    
    @RequestMapping("/inputs")
    public Iterable<NetworkConsistInput> home() {
        return repository.findAll();
    }
    
    @RequestMapping("/consist")
    public NetworkConsistModel consist() throws Exception {
        NetworkConsistModeller networkConsistModeller = new NetworkConsistModeller();
        for (NetworkConsistInput input: repository.findAll()) {
            networkConsistModeller.addData(input.host, input.name, input.value);
        }
        return networkConsistModeller.getModel();
    }
    
}
