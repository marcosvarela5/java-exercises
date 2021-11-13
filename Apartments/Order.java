package e2;
import java.util.Comparator;

public abstract class Order implements Comparator<Apartment> {
    @Override
    public abstract int compare(Apartment a1, Apartment a2);
}

class OrderByZIP extends Order{
    @Override
    public int compare(Apartment a1, Apartment a2){
     return Integer.compare(a1.getZIP(), a2.getZIP());
    }
}

class OrderByPrice extends Order{
    @Override
    public int compare(Apartment a1, Apartment a2){
        return a1.getPrice() - a2.getPrice();
    }
}

class OrderByTotalPrice extends Order{
    @Override
    public int compare(Apartment a1, Apartment a2){
        return a1.getTotalPrice() - a2.getTotalPrice();
    }
}

class OrderByRooms extends Order{
    @Override
    public int compare(Apartment a1, Apartment a2){
        return a1.getNumberOfRooms() - a2.getNumberOfRooms();
    }
}
