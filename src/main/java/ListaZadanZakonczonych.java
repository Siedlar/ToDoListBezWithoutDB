import java.util.List;

public class ListaZadanZakonczonych {
    private List<Zadanie> listaZadan;

    public List<Zadanie> getListaZadan() {
        return listaZadan;
    }

    public void setListaZadan(List<Zadanie> listaZadan) {
        this.listaZadan = listaZadan;
    }

    public ListaZadanZakonczonych(List<Zadanie> listaZadan) {
        this.listaZadan = listaZadan;
    }
}
