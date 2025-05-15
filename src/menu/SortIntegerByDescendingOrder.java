package menu;

import java.util.Comparator;

/**
 * A helper class supporting MenuGenerator class 
 * to determine largest string.
 * 
 * @author Hardikkumar Bhakta
 */
public class SortIntegerByDescendingOrder implements Comparator {

    @Override
    public int compare(Object object1, Object object2) {
        Integer x = (Integer) object1;
        Integer y = (Integer) object2;
        
        if (x > y) {
            return -1;
        }
        if (x < y) {
            return 1;
        }
        return 0;
    }
    
}
