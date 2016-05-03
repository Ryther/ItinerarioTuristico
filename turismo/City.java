package turismo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.FileUtils;

/**
 *
 * @author Edoardo Zanoni
 */
public class City implements Serializable {
    
    private String id;
    private String name;
    private Set<SimplePOI> poi;
    private Map<String, Link> links;
    
    private class Link {
        
        public City link;
        public int distance;
    }

    public City(String id, String name) {
        
        this.id = id;
        this.name = name;
        this.poi = new TreeSet<>();
        this.links = new HashMap<>();
    }

    public String getId() {
        
        return this.id;
    }

    public void setId(String id) {
        
        this.id = id;
    }

    public String getName() {
        
        return this.name;
    }

    public void setName(String name) {
        
        this.name = name;
    }

    public Set<SimplePOI> getPoi() {
        
        return this.poi;
    }

    public SimplePOI getPoi(String name) {
        
        for (SimplePOI tempPOI: this.poi) {
            
            if (tempPOI.getPoiName().equals(name)) {
                
                return tempPOI;
            }
        }
        
        return null;
    }
    
    public SimplePOI getPoi(int position) {
        
        if (position < 0 || position >= this.poi.size()) {
            
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE,
                    "La posizione cercata è al di fuori del range del Set.");
            return null;
        }
        
        int counter = 0;
        for (SimplePOI tempPOI: this.poi) {
            
            if (counter == position) {
                
                return tempPOI;
            }
            counter++;
        }
        
        return null;
    }
    
    public void setPoi(Set<SimplePOI> poi) {
        
        this.poi = poi;
    }
    
    public boolean setPOI(SimplePOI poi) {
        
        return this.poi.add(poi);
    }

    public Map<String, Link> getLinks() {
        
        return this.links;
    }

    public void setLinks(Map<String, Link> links) {
        
        this.links = links;
    }
}