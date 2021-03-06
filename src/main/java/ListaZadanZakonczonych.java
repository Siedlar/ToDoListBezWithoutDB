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
    public String wypisz(){
        if(listaZadan.isEmpty()){
            return "Nie ukonczyłeś dzisiaj żadnych zadań!!!";
        }else{
        StringBuilder builder=new StringBuilder();
        int i=0;
        for(Zadanie zadanie:listaZadan){
            i++;
            builder.append(i+". "+zadanie.toString()+"\n");
        }
        return builder.toString();
    }}
}
