import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

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
          System.out.println("1.Dodaj zadanie\n2.Wyświetl liste zadań aktualnych\n2.Wyświetl liste zadań zakończonych.\n3.Sprawdź swoje dane\n4.Wyloguj się");

          b=in.nextInt();
         if(b==1){
             user.getListaZadan().getListaZadan().add(new Zadanie("Java", 60));
         }
      }while(b!=4);
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
            String login;
            String haslo;
            String haslo2;
            System.out.println("1.Logowanie z podaniem wszystkich danych od razu\n2.Uzupełnie dane później");
            int z=in.nextInt();
            if(z==1){
                int k;
                do{
                    k=2;
                    in=new Scanner(System.in);
                    System.out.println("Login");
                login=in.nextLine();
                    System.out.println("Hasło");
                    haslo=in.nextLine();
                    System.out.println("Potwierz hasło");

                    haslo2=in.nextLine();

if(Walidacja.sprawdzCzyHasloJestIdentyczne(haslo,haslo2)){
                listaUser.dodaj(new User(login,haslo));
                listaUser.getListaUser().forEach(usa-> System.out.println(usa));
                k=1; }else{
    System.out.println("Hasła nie są identyczne spróbuj ponownie.");
    k=2;
}
            }while(k==2);}
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
