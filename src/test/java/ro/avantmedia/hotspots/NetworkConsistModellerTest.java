package ro.avantmedia.hotspots;

import org.springframework.util.Assert;
import ro.avantmedia.hotspots.model.NetworkConsistModeller;


public class NetworkConsistModellerTest {
    
    public void testHappyPath() throws Exception {
        NetworkConsistModeller networkConsistModeller = new NetworkConsistModeller();
        
        networkConsistModeller.addData("AP1", "sysLocation", "Carriage-1");
        networkConsistModeller.addData("AP2", "sysLocation", "Carriage-1");
        networkConsistModeller.addData("AP3", "sysLocation", "Carriage-2");
        networkConsistModeller.addData("AP4", "sysLocation", "Carriage-2");
        
        networkConsistModeller.addData("AP2", "meshPeer", "AP3");
        networkConsistModeller.addData("AP3", "meshPeer", "AP2");
    }
    
    //TODO: make the implementation pass the following test
    /*public void testReorderedCarriages() throws Exception {
        NetworkConsistModeller networkConsistModeller = new NetworkConsistModeller();
        
        networkConsistModeller.addData("AP1", "sysLocation", "Carriage-1");
        networkConsistModeller.addData("AP2", "sysLocation", "Carriage-1");
        networkConsistModeller.addData("AP3", "sysLocation", "Carriage-2");
        networkConsistModeller.addData("AP4", "sysLocation", "Carriage-2");
        networkConsistModeller.addData("AP5", "sysLocation", "Carriage-3");
        networkConsistModeller.addData("AP6", "sysLocation", "Carriage-3");
        
        networkConsistModeller.addData("AP4", "meshPeer", "AP5");
        networkConsistModeller.addData("AP5", "meshPeer", "AP4");
        
        networkConsistModeller.addData("AP1", "meshPeer", "AP6");
        networkConsistModeller.addData("AP6", "meshPeer", "AP1");
        
        Assert.isTrue(networkConsistModeller.getModel().carriages.get(0).getId() == "Carriage-2");
    }*/
    
    //TODO add non-happy path tests
    
}
