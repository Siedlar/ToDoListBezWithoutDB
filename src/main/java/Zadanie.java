import java.time.LocalDate;

public class Zadanie implements Comparable<Zadanie>{
    private String nazwaZadania;
    int czasTrwania;
    public Zadanie(String nazwaZadania,int czasTrwania) {
        this.nazwaZadania = nazwaZadania;
        this.czasTrwania=czasTrwania;
    }

    public String getNazwaZadania() {
        return nazwaZadania;
    }

    public void setNazwaZadania(String nazwaZadania) {
        this.nazwaZadania = nazwaZadania;
    }

    public int getCzasTrwania() {
        return czasTrwania;
    }

    public void setCzasTrwania(int czasTrwania) {
        this.czasTrwania = czasTrwania;
    }

    @Override
    public String toString() {
        return nazwaZadania + " " +  czasTrwania ;
    }

    @Override
    public int compareTo(Zadanie o) {
     return getNazwaZadania().compareTo(o.getNazwaZadania());
    }
}
