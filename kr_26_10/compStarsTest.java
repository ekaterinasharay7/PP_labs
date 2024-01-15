import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class compStarsTest {

    @Test
    void compare_stars_nemen() {
        Hotel one = new Hotel("alushta","name",5);
        Hotel two = new Hotel("alushta","name",4);
        ArrayList<Hotel> hotels= new ArrayList<>(2);
        hotels.add(one);
        hotels.add(two);
        Collections.sort(hotels,new compStars());
        assertTrue(one==hotels.get(0)&&two==hotels.get(1));
    }

    @Test
    void compare_stars_men() {
        Hotel one = new Hotel("alushta","name",2);
        Hotel two = new Hotel("alushta","name",5);
        ArrayList<Hotel> hotels= new ArrayList<>(2);
        hotels.add(one);
        hotels.add(two);
        Collections.sort(hotels,new compStars());
        assertTrue(one==hotels.get(1)&&two==hotels.get(0));
    }

}