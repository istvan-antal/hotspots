package ro.avantmedia.hotspots.model;

import java.util.ArrayList;

public class NetworkConsistModeller {
    
    private final Registry<AccessPoint> accessPointRegistry = new Registry<>(AccessPoint.class);
    private final Registry<Carriage> carriageRegistry = new Registry<>(Carriage.class);
    
    public void addData(String host, String name, String value) throws Exception {
        switch (name) {
            case "sysLocation":
                Carriage carriage = carriageRegistry.findById(value);
                
                if (carriage == null) {
                    carriage = carriageRegistry.createItem(value);
                }
                
                AccessPoint accessPoint = accessPointRegistry.createItem(host);
                carriage.addAccessPoint(accessPoint);
                break;
            case "meshPeer":
                AccessPoint accessPoint1 = accessPointRegistry.findById(host);
                AccessPoint accessPoint2 = accessPointRegistry.findById(value);
                
                accessPoint1.setMeshPair(accessPoint2);
                break;
            default:
                throw new Exception("Unsupported data type " + name);
        }
    }
    
    public NetworkConsistModel getModel() {
        NetworkConsistModel model = new NetworkConsistModel();
        model.carriages = carriageRegistry.findAll();
        
        //TODO: finish the carriage/access point swapping/validating algorithm
        /*for (int i = 0; i < model.carriages.size(); i ++) {
            Carriage currentCarriage = model.carriages.get(i);
            ArrayList<AccessPoint> currentCarriageAccessPoints = currentCarriage.getAccessPoints();
            
            // size can either be 1 or 2
            if (currentCarriageAccessPoints.size() == 1) {
                AccessPoint linkedAp = currentCarriageAccessPoints.get(0).getMeshPair();
                if (linkedAp == null) {
                    continue;
                }
                
                Carriage linkedCarriage = findCarriageByAccessPoint(model.carriages, linkedAp);
                
                if (Math.abs(model.carriages.indexOf(linkedCarriage) - i) != 1) {
                    // 
               }
            } else {
                
            }
        }*/
        
        return model;
    }
    
    private Carriage findCarriageByAccessPoint(ArrayList<Carriage> carriages, AccessPoint ap) {
        for (Carriage carriage: carriages) {
            if (carriage.getAccessPoints().indexOf(ap) != -1) {
                return carriage;
            }
        }
        
        return null;
    }
}
