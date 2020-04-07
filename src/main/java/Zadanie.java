import java.time.LocalDate;

public class Zadanie {
    private String nazwaZadania;
    int czasTrwania;
    public Zadanie(String nazwaZadania,int czasTrwania) {
        this.nazwaZadania = nazwaZadania;
        this.czasTrwania=czasTrwania;
    }

    @Override
    public String toString() {
        return nazwaZadania + " " +  czasTrwania ;
    }
}
