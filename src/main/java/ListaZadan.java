import java.util.Comparator;
import java.util.List;

public class ListaZadan  {
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

    public void wyswietl(){
        if(listaZadan.isEmpty()){
            System.out.println("Nie ukonczyłeś jeszcze zadnych zadań!!!\n-------------------");
        }else{
            int i=1;
            for(Zadanie zadanie:listaZadan){
                System.out.println(i+". "+ zadanie);
            i++;}
    }}
    public void dodaj(Zadanie zadanie){
        listaZadan.add(zadanie);
        System.out.println("Zadanie dodane poprawnie!!\n--------------------");

    }

}
