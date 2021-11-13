package e2;

public class Address {
    public String street;
    public int number;
    public String door;

    Address(String street, int number, String door){
        this.street = street;
        this.number = number;
        this.door = door;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String toString(){
        return "Calle " + getStreet() + " nº " + getNumber() + " piso " + getDoor();
    }
}
