package ro.avantmedia.hotspots.model;

public abstract class RegistryItem implements RegistryItemInterface {
    
    @Override
    public int compareTo(RegistryItem o) {
        return this.getIndex() - o.getIndex();
    }
    
}
