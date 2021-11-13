package e2;

public class Apartment implements Comparable<Apartment> {
    public int price;
    public int ZIP;
    public Address address;
    public int referenceNumber;
    public int numberOfRooms;


    public int getZIP() {
        return ZIP;
    }

    public Address getAddress() {
        return address;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getReferenceNumber() {
        return referenceNumber;
    }

    public int getPrice() {
        return price;
    }

    public int getTotalPrice() {
        return price;
    }

    Apartment(int price, int ZIP, Address address, int referenceNumber, int numberOfRooms) {
        this.price = price;
        this.ZIP = ZIP;
        this.address = address;
        this.referenceNumber = referenceNumber;
        this.numberOfRooms = numberOfRooms;
    }

    public String toString() {
        return "\n Apartamento de " + getNumberOfRooms() +
                " habitaciones en " + getAddress() + " " + getZIP() + " con un precio de " + getPrice() + "€\n";
    }

    @Override
    public int compareTo(Apartment o) {
        return Integer.compare(this.getReferenceNumber(), o.getReferenceNumber());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.toString().equals(o.toString())) return true;
        Apartment apartment = (Apartment) o;
        return getPrice() == apartment.getPrice() && getZIP() == apartment.getZIP() && getNumberOfRooms() == apartment.getNumberOfRooms()
                && getAddress().equals(apartment.getAddress());
    }

    @Override
    public int hashCode() {
        int result;
        if (this instanceof ApartmentWithGarage) {
            result = address.getNumber() * 30;
            result = result + address.getStreet().length() * 31 + getZIP() * 31;
            result = result + getNumberOfRooms() * 31 + getPrice();
            return result + getPrice() * getZIP() * 31;
        }
            result = address.getNumber() * 31;
            result = result + address.getStreet().length() * 31 + getZIP() * 31;
            result = result + getNumberOfRooms() * 31 + getPrice();
            return result + getPrice() * getZIP() * 31;

    }
}
