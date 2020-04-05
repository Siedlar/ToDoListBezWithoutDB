import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    ListaUser listaUser=wykonaj();
        System.out.println("Witaj w ToDoList");
        System.out.println("Posiadasz już konto czy chcesz się zarejestrować??");


    }
    public static ListaUser wykonaj(){
        ListaUser lista=new ListaUser(new ArrayList<User>());
        lista.dodaj(new User("Andrzej","Pyrtek","Pyrtowski","1234",new ListaZadan(),new ListaZadanZakonczonych()));
        lista.dodaj(new User("Anita","Witkac","WitAni","qwerty",new ListaZadan(),new ListaZadanZakonczonych()));
return lista;
    }
}
