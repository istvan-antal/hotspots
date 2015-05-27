package ro.avantmedia.hotspots.model;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class AccessPoint extends RegistryItem {
    
    private int index;
    private String id;
    
    private AccessPoint meshPair;

    @Override
    public String getId() {
        return id;
    }
    
    @Override
    public void setId(String id) {
        this.id = id;
    }
    
    public void setMeshPair(AccessPoint ap) throws Exception {
        if (meshPair != null) {
            throw new Exception("Access Point already paired.");
        }
        
        meshPair = ap;
    }
    
    @JsonIgnore
    public AccessPoint getMeshPair() {
        return meshPair;
    }
    
    public String getMeshPairId() {
        if (meshPair == null) {
            return null;
        }
        return meshPair.id;
    }
    
    @Override
    public void setIndex(int index) {
        this.index = index;
    }
    
    public int getIndex() {
        return index;
    }
    
}
