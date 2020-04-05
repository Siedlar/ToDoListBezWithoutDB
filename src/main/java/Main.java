import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        User user=null;
        Scanner in=new Scanner(System.in);
      try {
          user= menu();
      }
      catch (InputMismatchException e){
          System.out.println("Prosze podać cyfrę z menu!!! ");
          user= menu();
      }
      int b;
      user.setListaZadan(new ListaZadan(new ArrayList<Zadanie>()));
      user.setListaZadanZakonczonych(new ListaZadanZakonczonych(new ArrayList<Zadanie>()));
      do {
          b=in.nextInt();
          System.out.println("1.Dodaj zadanie\n2.Wyświetl liste zadań aktualnych\n2.Wyświetl liste zadań zakończonych.\n3.Sprawdź swoje dane\n4.Wyloguj się");
         if(b==1){
             user.getListaZadan().getListaZadan().add(new Zadanie("Java", 60));
         }
          b=in.nextInt();
      }while(b==4);
        System.out.println("Dziekuje za skorzystanie z programu");
    }
    public static ListaUser wykonaj(){
        ListaUser lista=new ListaUser(new ArrayList<User>());
        lista.dodaj(new User("Andrzej","Pyrtek","Pyrtowski","1234"));
        lista.dodaj(new User("Anita","Witkac","WitAni","qwerty"));
return lista;
    }
    public static User menu() throws InputMismatchException {

        User user=null;
        int x;
        Scanner in=new Scanner(System.in);
        ListaUser listaUser=wykonaj();
        System.out.println("Witaj w ToDoList");
        System.out.println("Posiadasz już konto czy chcesz się zarejestrować??");
        int a=0;
        int licznikZlychWejsc=0;
        do{
            System.out.println("-----------------\n1.Mam konto\n2.Chcę sie zarejestrować\n3.Zamknij program\n4.Każda inna uruchomi wybór ponownie");
            a=in.nextInt();
        if(a==1){
            do{
                user= new Walidacja(listaUser).zaloguj();
                x=2;
                if(user==null){
                    x=0;
                    licznikZlychWejsc++;
                    if(licznikZlychWejsc==5){
                        System.out.println("------------\nZa dużo błędnych prób logowania. Aplikacja zostanie wyłączona");
                        System.exit(0);
                    }
                    System.out.println("Podałeś błedne dane. Spróbuj ponownie");
                }
            }
            while(x==0);
            return user;
        }else if(a==2){

        }else if(a==3) {
            System.exit(0);
        }else{
            System.out.println("Podaj prawidłowo cyfre!!");
        }
        }

        while(a!=3 || a!=2 || a!=1);
        return null;

}
}
