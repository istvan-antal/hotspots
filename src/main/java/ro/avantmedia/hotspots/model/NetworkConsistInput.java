package ro.avantmedia.hotspots.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NetworkConsistInput implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    public NetworkConsistInput() {
        
    }

    public NetworkConsistInput(String host, String name, String value) {
        this.host = host;
        this.name = name;
        this.value = value;
    }

    public String host;
    public String name;
    public String value;
    
    public long getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return String.format("NetworkConsistInput[id=%d, host=%s, name=%s, value=%s]", id, host, name, value);
    }
    
}
