package ro.avantmedia.hotspots.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class Registry<T extends RegistryItem> {

    private int currentIndex = 0;
    private final HashMap<String, T> items = new HashMap<>();
    
    private final Class cls;

    public Registry(Class cls) {
        this.cls = cls;
    }

    public T createItem(String id) throws Exception {
        T existingItem = items.get(id);
        if (existingItem != null) {
            throw new Exception("Item with same name already exists");
        }

        T item = (T) cls.newInstance();
        item.setIndex(currentIndex);
        currentIndex += 1;
        item.setId(id);
        items.put(id, item);
        return item;
    }

    public T findById(String id) {
        return items.get(id);
    }
    
    public ArrayList<T> findAll() {
        ArrayList<T> results = new ArrayList<>();
        
        for (String key: items.keySet()) {
            results.add(items.get(key));
        }
        
        Collections.sort(results);
        
        return results;
    }

}
