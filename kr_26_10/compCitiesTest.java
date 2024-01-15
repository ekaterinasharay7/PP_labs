import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class compCitiesTest {

    @org.junit.jupiter.api.Test
    void compare_cities_nemen() {
        Hotel one = new Hotel("alushta","name",5);
        Hotel two = new Hotel("bobruisk","name",5);
        ArrayList<Hotel> hotels= new ArrayList<>(2);
        hotels.add(one);
        hotels.add(two);
        Collections.sort(hotels,new compCities());
        assertTrue(one==hotels.get(0)&&two==hotels.get(1));

    }
    @org.junit.jupiter.api.Test
    void compare_cities_men() {
        Hotel one = new Hotel("bobruisk","name",5);
        Hotel two = new Hotel("alushta","name",5);
        ArrayList<Hotel> hotels= new ArrayList<>(2);
        hotels.add(one);
        hotels.add(two);
        Collections.sort(hotels,new compCities());
        assertTrue(one==hotels.get(1)&&two==hotels.get(0));

    }

}