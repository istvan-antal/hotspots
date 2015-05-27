package ro.avantmedia.hotspots.model;


public interface RegistryItemInterface extends Comparable<RegistryItem> {

    String getId();

    void setId(String id);

    void setIndex(int index);
    int getIndex();
    
}
