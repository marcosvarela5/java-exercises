package e2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Dashboard{

    Comparator<Apartment> comparator = null;

    Dashboard(){}

    public void applySort(List<Apartment> apartmentList){
        if(setComparator(this.comparator) == null) Collections.sort(apartmentList);
        else
        Collections.sort(apartmentList, setComparator(this.comparator));
    }

    public Comparator<Apartment> setComparator(Comparator<Apartment> comparator){
        this.comparator = comparator;
        return this.comparator;
    }

    /*public static void main(String[] args) {
        List<Apartment> apartmentList = new ArrayList<>();
        Dashboard d1 = new Dashboard();
        Apartment a1 = new Apartment(30000, 15005, new Address("Pocomaco", 15, "1C"), 490340, 4);
        Apartment a2 = new ApartmentWithGarage(200000,
                15003, new Address("Orzán", 12, "2D"),  490342, 3, 5000,3);
        Apartment a3 = new Apartment(40000, 15006, new Address("Elviña", 16, "12B"), 5232, 5);
        apartmentList.add(a1);
        apartmentList.add(a2);
        apartmentList.add(a3);
        System.out.println("--------- PRUEBA DE OUTPUT -----------");
        d1.applySort(apartmentList);
        System.out.println("Orden natural 1\n" + apartmentList);
        d1.setComparator(new OrderByPrice());
        d1.applySort(apartmentList);
        System.out.println("Ordenado por precio\n" + apartmentList);
        d1.setComparator(new OrderByZIP());
        d1.applySort(apartmentList);
        System.out.println("Ordenado por ZIP\n" + apartmentList);
        d1.setComparator(new OrderByRooms());
        d1.applySort(apartmentList);
        System.out.println("Ordenado por habitaciones\n" + apartmentList);
        d1.setComparator(null);
        d1.applySort(apartmentList);
        System.out.println("Orden natural 2\n" + apartmentList);
    }*/
}
© 2021 GitHub, Inc.
Terms
Priv
