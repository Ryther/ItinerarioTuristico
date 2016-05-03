package turismo;

import java.util.Objects;

/**
 *
 * @author Edoardo Zanoni
 */
public class SimplePOI implements Comparable {
    
    private String poiName;

    public SimplePOI(String poiName) {
        
        this.poiName = poiName;
    }

    public String getPoiName() {
        
        return poiName;
    }

    public void setPoiName(String poiName) {
        
        this.poiName = poiName;
    }

    @Override
    public int compareTo(Object object) {
        
        return this.poiName.compareTo((String) object);
    }
    
    @Override
    public int hashCode() {
        
        return this.poiName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SimplePOI other = (SimplePOI) obj;
        return Objects.equals(this.poiName, other.poiName);
    }
}
