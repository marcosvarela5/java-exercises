import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DashboardTest {

    Apartment a1;
    Apartment a2;
    Apartment a3;
    Apartment a4;
    Apartment a5;
    Apartment a6;
    Comparator<Apartment> comparator;
    Dashboard d1;
    List<Apartment> apartmentList;

    @BeforeEach
    void setUp() {
        d1 = new Dashboard();
        comparator = null;
        apartmentList = new ArrayList<>();

        a1 = new Apartment(100000, 15623, new Address("Ares", 16, "1C"), 10000, 3);
        a2 = new ApartmentWithGarage(100000, 15623,
                new Address("Ares", 16, "1C"), 12000, 3, 10000, 6);
        a3 = new Apartment(100000, 15623, new Address("Ares", 16, "1C"), 11000, 3);
        a4 = new Apartment(150000, 15500, new Address("Fene", 12, "B"), 13000, 5);
        a5 = new ApartmentWithGarage(100000, 15623,
                new Address("Ares", 16, "1C"), 13000, 3, 10000, 6);
        a6 = new Apartment(150000, 15500, new Address("Fene", 12, "B"), 18000, 5);
    }

    @Test
    void applySort() {
        apartmentList.add(a1);
        apartmentList.add(a4);
        d1.setComparator(new OrderByPrice());
        d1.applySort(apartmentList);
        assertEquals(a1, apartmentList.get(0));
        assertEquals(a4, apartmentList.get(1));
        apartmentList.remove(a1);
        apartmentList.add(a2);
        d1.setComparator(new OrderByTotalPrice());
        d1.applySort(apartmentList);
        assertEquals(a4, apartmentList.get(0));
        assertEquals(a2, apartmentList.get(1));
        d1.setComparator(new OrderByRooms());
        d1.applySort(apartmentList);
        assertEquals(a2, apartmentList.get(0));
        assertEquals(a4, apartmentList.get(1));
        d1.setComparator(new OrderByZIP());
        d1.applySort(apartmentList);
        assertEquals(a4, apartmentList.get(0));
        assertEquals(a2, apartmentList.get(1));
    }
    @Test
    void TestNotEquals(){
        assertNotEquals(a1, a4);
        assertNotEquals(a1, a2);
    }

    @Test
    void TestEquals(){
        assertEquals(a1, a3);
        assertEquals(a2, a5);
        assertEquals(a4, a6);
    }

    @Test
    void TestHashCode(){
        assertEquals(a1.hashCode(), a3.hashCode());
        assertNotEquals(a2.hashCode(), a3.hashCode());
        assertNotEquals(a1.hashCode(), a4.hashCode());
        assertNotEquals(a1.hashCode(), a2.hashCode());
        assertEquals(a2.hashCode(), a5.hashCode());
    }

}
