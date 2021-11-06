package e3;

public enum Accidentals {
    FLAT("b"),
    SHARP("#"),
    NATURAL("");

    private final String symbol;

    Accidentals(String symbol) {
        this.symbol = symbol;
    }

    public String toString(){
        return symbol;
    }
}
