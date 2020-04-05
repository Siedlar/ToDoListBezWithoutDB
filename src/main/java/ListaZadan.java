import java.util.List;

public class ListaZadan {
    private List<Zadanie> listaZadan;

    public ListaZadan(List<Zadanie> listaZadan) {
        this.listaZadan = listaZadan;
    }

    public List<Zadanie> getListaZadan() {
        return listaZadan;
    }

    public void setListaZadan(List<Zadanie> listaZadan) {
        this.listaZadan = listaZadan;
    }
}
