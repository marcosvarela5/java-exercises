package e3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Melody {

    List<Notes> notesList = new ArrayList<>();
    List<Accidentals> accidentalsList = new ArrayList<>();
    List<Float> timeList = new ArrayList<>();

    public Melody() {
    }

    public void addNote(Notes note, Accidentals accidental, float time) {

        if(note == null) throw new IllegalArgumentException("Note can't be a null value");
        if(accidental == null) throw new IllegalArgumentException("Accidental can't be a null value");
        if(time <= 0) throw new IllegalArgumentException("Time has to be bigger than 0");
        notesList.add(note);
        accidentalsList.add(accidental);
        timeList.add(time);
    }

    public Notes getNote(int index) {
        if(index >= notesList.size() || index < 0) throw new IllegalArgumentException("This index does not exist");
        return notesList.get(index);
    }

    public Accidentals getAccidental(int index) {
        if(index >= accidentalsList.size() || index < 0) throw new IllegalArgumentException("This index does not exist");
        return accidentalsList.get(index);
    }

    public float getTime(int index) {
        if(index >= timeList.size() || index < 0) throw new IllegalArgumentException("This index does not exist");
        return timeList.get(index);
    }

    public int size() { //El tamaño de cualquier lista de la melodia, ya que no es posible insertar un elemento
                        // sin modificar las 3 listas, por lo que su tamaño sera siempre el mismo
        return notesList.size();
    }

    public float getDuration() { //Se suman los elementos de la lista de tiempo
        float sum = 0;
        for (Float aFloat : timeList) {
            sum += aFloat;
        }
        return sum;
    }

    @Override
    public int hashCode() { //Se utiliza el hash 31, se le asigna el mismo múltiplo a las notas equivalentes y se le suma uno
        int result = 0;
        for(int i = 0; i< notesList.size(); i++){
            switch (notesList.get(i)){
                case DO -> {
                    if(getAccidental(i) == Accidentals.SHARP) result = 1 + 31;
                    if(getAccidental(i) == Accidentals.NATURAL) result = 1 + 31 * 2;
                    if(getAccidental(i) == Accidentals.FLAT) result = 1 + 31 * 3;
                }
                case RE -> {
                    if(getAccidental(i) == Accidentals.FLAT) result = 1 + 31;
                    if(getAccidental(i) == Accidentals.SHARP) result = 1 + 31 * 4;
                    if(getAccidental(i) == Accidentals.NATURAL) result = 1 + 31 * 5;
                }
                case MI -> {
                    if(getAccidental(i) == Accidentals.FLAT) result = 1 + 31 * 4;
                    if(getAccidental(i) == Accidentals.SHARP) result = 1 + 31 * 6;
                    if(getAccidental(i) == Accidentals.NATURAL) result = 1 + 31 * 7;
                }
                case FA -> {
                    if(getAccidental(i) == Accidentals.FLAT) result = 1 + 31 * 7;
                    if(getAccidental(i) == Accidentals.SHARP) result = 1 + 31 * 8;
                    if(getAccidental(i) == Accidentals.NATURAL) result = 1 + 31 * 6;
                }
                case SOL -> {
                    if(getAccidental(i) == Accidentals.FLAT) result = 1 + 31 * 8;
                    if(getAccidental(i) == Accidentals.SHARP) result = 1 + 31 * 9;
                    if(getAccidental(i) == Accidentals.NATURAL) result = 1 + 31 * 10;
                }
                case LA -> {
                    if(getAccidental(i) == Accidentals.FLAT) result = 1 + 31 * 9;
                    if(getAccidental(i) == Accidentals.SHARP) result = 1 + 31 * 11;
                    if(getAccidental(i) == Accidentals.NATURAL) result = 1 + 31 * 12;
                }
                case SI -> {
                    if(getAccidental(i) == Accidentals.FLAT) result = 1 + 31 * 11;
                    if(getAccidental(i) == Accidentals.SHARP) result = 1 + 31 * 2;
                    if(getAccidental(i) == Accidentals.NATURAL) result = 1 + 31 * 3;
                }

            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        int i;
        if(o == null) return false;
        if(this == o) return true;
        if(this.size() != ((Melody) o).size()) return false;
        if(this.getClass() != o.getClass()) return false;
        if(this.size() == 0 && ((Melody) o).size() == 0) return true;
        if(Objects.equals(this.toString(), o.toString())) return true; //de tal forma que si las melodías son iguales devuelva true sin pasar por los switches
                                                                       // que no estan diseñados para funcionar cuando ambas melodías son iguales, siendo esta
                                                                       // condicion comprobada aqui mismo
        //esto no deberia hacerse de esta forma pero es funcional
        for(i = 0; i< notesList.size(); i++){
            switch (((Melody) o).getNote(i)){
                case DO -> {
                    if(((Melody) o).getAccidental(i) == Accidentals.SHARP &&
                            this.getNote(i) == Notes.RE && this.getAccidental(i) == Accidentals.FLAT) return true;
                    if(((Melody) o).getAccidental(i) == Accidentals.NATURAL &&
                            this.getNote(i) == Notes.SI && this.getAccidental(i) == Accidentals.SHARP) return true;
                    if(((Melody) o).getAccidental(i) == Accidentals.FLAT &&
                            this.getNote(i) == Notes.SI && this.getAccidental(i) == Accidentals.NATURAL) return true;
                }
                case RE -> {
                    if(((Melody) o).getAccidental(i) == Accidentals.SHARP &&
                            this.getNote(i) == Notes.MI && this.getAccidental(i) == Accidentals.FLAT) return true;
                    if(((Melody) o).getAccidental(i) == Accidentals.FLAT &&
                            this.getNote(i) == Notes.DO && this.getAccidental(i) == Accidentals.SHARP) return true;
                }
                case MI -> {
                    if(((Melody) o).getAccidental(i) == Accidentals.SHARP &&
                            this.getNote(i) == Notes.FA && this.getAccidental(i) == Accidentals.NATURAL) return true;
                    if(((Melody) o).getAccidental(i) == Accidentals.NATURAL &&
                            this.getNote(i) == Notes.FA && this.getAccidental(i) == Accidentals.FLAT) return true;
                    if(((Melody) o).getAccidental(i) == Accidentals.FLAT &&
                            this.getNote(i) == Notes.RE && this.getAccidental(i) == Accidentals.SHARP) return true;
                }
                case FA -> {
                    if(((Melody) o).getAccidental(i) == Accidentals.SHARP &&
                            this.getNote(i) == Notes.SOL && this.getAccidental(i) == Accidentals.FLAT) return true;
                    if(((Melody) o).getAccidental(i) == Accidentals.NATURAL &&
                            this.getNote(i) == Notes.MI && this.getAccidental(i) == Accidentals.SHARP) return true;
                    if(((Melody) o).getAccidental(i) == Accidentals.FLAT &&
                            this.getNote(i) == Notes.MI && this.getAccidental(i) == Accidentals.NATURAL) return true;
                }
                case SOL -> {
                    if(((Melody) o).getAccidental(i) == Accidentals.SHARP &&
                            this.getNote(i) == Notes.LA && this.getAccidental(i) == Accidentals.FLAT) return true;
                    if(((Melody) o).getAccidental(i) == Accidentals.FLAT &&
                            this.getNote(i) == Notes.FA && this.getAccidental(i) == Accidentals.SHARP) return true;
                }
                case LA -> {
                    if(((Melody) o).getAccidental(i) == Accidentals.SHARP &&
                            this.getNote(i) == Notes.SI && this.getAccidental(i) == Accidentals.FLAT) return true;
                    if(((Melody) o).getAccidental(i) == Accidentals.FLAT &&
                            this.getNote(i) == Notes.SOL && this.getAccidental(i) == Accidentals.SHARP) return true;
                }
                case SI -> {
                    if(((Melody) o).getAccidental(i) == Accidentals.SHARP &&
                            this.getNote(i) == Notes.DO && this.getAccidental(i) == Accidentals.NATURAL) return true;
                    if(((Melody) o).getAccidental(i) == Accidentals.NATURAL &&
                            this.getNote(i) == Notes.DO && this.getAccidental(i) == Accidentals.FLAT) return true;
                    if(((Melody) o).getAccidental(i) == Accidentals.FLAT &&
                            this.getNote(i) == Notes.LA && this.getAccidental(i) == Accidentals.SHARP) return true;
                }
            }
            switch (this.getNote(i)){
                case DO -> {
                    if(this.getAccidental(i) == Accidentals.SHARP &&
                            ((Melody) o).getNote(i) == Notes.RE &&  ((Melody) o).getAccidental(i) == Accidentals.FLAT) return true;
                    if(this.getAccidental(i) == Accidentals.NATURAL &&
                            ((Melody) o).getNote(i) == Notes.SI &&  ((Melody) o).getAccidental(i) == Accidentals.SHARP) return true;
                    if(this.getAccidental(i) == Accidentals.FLAT &&
                            ((Melody) o).getNote(i) == Notes.SI &&  ((Melody) o).getAccidental(i) == Accidentals.NATURAL) return true;
                }
                case RE -> {
                    if(this.getAccidental(i) == Accidentals.SHARP &&
                            ((Melody) o).getNote(i) == Notes.MI &&  ((Melody) o).getAccidental(i) == Accidentals.FLAT) return true;
                    if(this.getAccidental(i) == Accidentals.FLAT &&
                            ((Melody) o).getNote(i) == Notes.DO &&  ((Melody) o).getAccidental(i) == Accidentals.SHARP) return true;
                }
                case MI -> {
                    if(this.getAccidental(i) == Accidentals.SHARP &&
                            ((Melody) o).getNote(i) == Notes.FA &&  ((Melody) o).getAccidental(i) == Accidentals.NATURAL) return true;
                    if(this.getAccidental(i) == Accidentals.NATURAL &&
                            ((Melody) o).getNote(i) == Notes.FA &&  ((Melody) o).getAccidental(i) == Accidentals.FLAT) return true;
                    if(this.getAccidental(i) == Accidentals.FLAT &&
                            ((Melody) o).getNote(i) == Notes.RE &&  ((Melody) o).getAccidental(i) == Accidentals.SHARP) return true;
                }
                case FA -> {
                    if(this.getAccidental(i) == Accidentals.SHARP &&
                            ((Melody) o).getNote(i) == Notes.SOL &&  ((Melody) o).getAccidental(i) == Accidentals.FLAT) return true;
                    if(this.getAccidental(i) == Accidentals.NATURAL &&
                            ((Melody) o).getNote(i) == Notes.MI &&  ((Melody) o).getAccidental(i) == Accidentals.SHARP) return true;
                    if(this.getAccidental(i) == Accidentals.FLAT &&
                            ((Melody) o).getNote(i) == Notes.MI &&  ((Melody) o).getAccidental(i) == Accidentals.NATURAL) return true;
                }
                case SOL -> {
                    if(this.getAccidental(i) == Accidentals.SHARP &&
                            ((Melody) o).getNote(i) == Notes.LA &&  ((Melody) o).getAccidental(i) == Accidentals.FLAT) return true;
                    if(this.getAccidental(i) == Accidentals.FLAT &&
                            ((Melody) o).getNote(i) == Notes.FA &&  ((Melody) o).getAccidental(i) == Accidentals.SHARP) return true;
                }
                case LA -> {
                    if(this.getAccidental(i) == Accidentals.SHARP &&
                            ((Melody) o).getNote(i) == Notes.SI &&  ((Melody) o).getAccidental(i) == Accidentals.FLAT) return true;
                    if(this.getAccidental(i) == Accidentals.FLAT &&
                            ((Melody) o).getNote(i) == Notes.SOL &&  ((Melody) o).getAccidental(i) == Accidentals.SHARP) return true;
                }
                case SI -> {
                    if(this.getAccidental(i) == Accidentals.SHARP &&
                            ((Melody) o).getNote(i) == Notes.DO &&  ((Melody) o).getAccidental(i) == Accidentals.NATURAL) return true;
                    if(this.getAccidental(i) == Accidentals.NATURAL &&
                            ((Melody) o).getNote(i) == Notes.DO &&  ((Melody) o).getAccidental(i) == Accidentals.FLAT) return true;
                    if(this.getAccidental(i) == Accidentals.FLAT &&
                            ((Melody) o).getNote(i) == Notes.LA &&  ((Melody) o).getAccidental(i) == Accidentals.SHARP) return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        int i;
        StringBuilder melody = new StringBuilder(); //utilizando StringBuilder no peta
        for(i = 0; i < notesList.size(); i++){
            melody.append(notesList.get(i).toString()).append(accidentalsList.get(i).toString())
                    .append("(").append(timeList.get(i).toString());
            //esto es para que en el ultimo elemento no deje un espacio al final y pase los tests
            if(i < notesList.size() - 1) {
                melody.append(") ");
            }
            else
                melody.append(")");
        }
        return melody.toString();
    }
}
