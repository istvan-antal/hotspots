package ro.avantmedia.hotspots;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.avantmedia.hotspots.model.NetworkConsistInput;
import ro.avantmedia.hotspots.model.NetworkConsistInputRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
    
    @Autowired
    NetworkConsistInputRepository repository;
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Override
    public void run(String... strings) throws Exception {
        repository.save(new NetworkConsistInput("AP1", "sysLocation", "Carriage-1"));
        repository.save(new NetworkConsistInput("AP2", "sysLocation", "Carriage-1"));
        repository.save(new NetworkConsistInput("AP3", "sysLocation", "Carriage-2"));
        repository.save(new NetworkConsistInput("AP4", "sysLocation", "Carriage-2"));
        
        repository.save(new NetworkConsistInput("AP2", "meshPeer", "AP3"));
        repository.save(new NetworkConsistInput("AP3", "meshPeer", "AP2"));
    }
    
}
