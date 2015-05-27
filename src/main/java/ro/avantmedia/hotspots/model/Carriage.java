package ro.avantmedia.hotspots.model;

import java.util.ArrayList;

public class Carriage extends RegistryItem {
    
    private int index;
    private String id;
    
    private final ArrayList<AccessPoint> accessPoints = new ArrayList<>();

    @Override
    public String getId() {
        return id;
    }
    
    @Override
    public void setId(String id) {
        this.id = id;
    }
    
    public void addAccessPoint(AccessPoint ap) throws Exception {
        if (accessPoints.size() > 1) {
            throw new Exception("Too many Access Points for one Carriage");
        }
        
        accessPoints.add(ap);
    }
    
    public ArrayList<AccessPoint> getAccessPoints() {
        return (ArrayList<AccessPoint>) accessPoints.clone();
    }

    @Override
    public void setIndex(int index) {
        this.index = index;
    }
    
    public int getIndex() {
        return index;
    }
    
}
