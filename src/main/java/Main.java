import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
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
          System.out.println("1.Dodaj zadanie\n2.Wyświetl liste zadań aktualnych\n3.Wyświetl liste zadań zakończonych.\n4.Oznacz zadanie jako skonczone\n5.Sprawdź swoje dane\n6.Posortuj dane \n7.Zapisz dane do pliku i wyloguj się");

          b=in.nextInt();
         if(b==1){
         try{ dodajZadanie(user);}catch (InputMismatchException e){
             System.out.println("Czas powininen zawierać tylko cyfry!!\n--------------------");
             Thread.sleep(2000);
         }


      }else if(b==2){

             user.getListaZadan().wyswietl();
             TimeUnit.SECONDS.sleep(3);
             System.out.println("-------------------");
         }else if(b==3){
               Collections.sort(user.getListaZadan().getListaZadan());
             user.getListaZadanZakonczonych().wyswietl();
         }else if(b==4){
             int i;
             System.out.println("Wybierz zadanie\n---------------");
             user.getListaZadan().wyswietl();
             TimeUnit.SECONDS.sleep(3);
             System.out.println("-------------------");
             i=in.nextInt();
             user.getListaZadanZakonczonych().dodaj(user.getListaZadan().getListaZadan().get(i-1));
             user.getListaZadan().getListaZadan().remove(i-1);
         }else if(b==5) {
             int a;
             System.out.println(user.toString());
             System.out.println("-----------\nCzy chcesz zaaktualizować swoje dane??\n1.Tak 2.Nie");
             a=in.nextInt();
             if(a==1){
                 String imie,nazwisko;
                 in=new Scanner(System.in);
                 System.out.println("Podaj imie");
                 imie=in.nextLine();
                 user.setImie(imie);
                 System.out.println("Podaj nazwisko");
                 nazwisko=in.nextLine();
                 user.setNazwisko(nazwisko);
             }
         }else if(b==6){
             if(user.getListaZadan().getListaZadan().isEmpty()){
                 System.out.println("Nie ma czego sortować, lista jest pusta!!!");
                 Thread.sleep(2000);
             }else{
             System.out.println("1.Posortuj dane ze wzlęgu na czas trwania\n2.Posortuj dane ze wzgledu na nazwe");
           int z=in.nextInt();
           if(z==2){
    Collections.sort(user.getListaZadan().getListaZadan(),(x1,x2)->{return x1.getNazwaZadania().compareTo(x2.getNazwaZadania());});
           }else if(z==1){
               Collections.sort(user.getListaZadan().getListaZadan(),(x1,x2)->x1.getCzasTrwania()-x2.getCzasTrwania());

           }
         }}

      }while(b!=7);
        System.out.println("Dziekuje za skorzystanie z programu\n Twoje postępy zostały zapisane do pliku!!!");
        ZapisDoPliku zapis=new ZapisDoPliku(user,LocalDate.now(),new BufferedWriter(new FileWriter(user.getLogin()+".txt",true)));
zapis.zapisz();
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
            System.out.println("1.Uzupelnie dane później.\n2.Logowanie z podaniem wszystkich danych od razu");
            int z=in.nextInt();
            if(z==1){
                String login;
                String haslo;
                String haslo2;
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
            }while(k==2);} else if(z==2){
                zarejestruj(in,listaUser);
            }
        }else if(a==3) {
            System.exit(0);
        }else{
            System.out.println("Podaj prawidłowo cyfre!!");
        }
        }

        while(a!=3 || a!=2 || a!=1);
        return null;

}
private static void zarejestrujBezDanych(Scanner in,ListaUser listaUser){
    String login;
    String haslo;
    String haslo2;
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
    private static void zarejestruj(Scanner in,ListaUser listaUser){
        String login;
        String haslo;
        String haslo2;
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
                System.out.println("Hasła są prawidłowe");
                System.out.println("Podaj imie");
                String imie=in.nextLine();
                System.out.println("Podaj nazwisko");
                String nazwisko=in.nextLine();
                listaUser.dodaj(new User(login,haslo,imie,nazwisko));
                listaUser.getListaUser().forEach(usa-> System.out.println(usa));
                k=1; }else{
                System.out.println("Hasła nie są identyczne spróbuj ponownie.");
                k=2;
            }
        }while(k==2);}
        private static void dodajZadanie(User user) throws InputMismatchException{
        Scanner in=null;
            int wyjdz;
            String zadanie;
            int dlugoscTrwania;
            do{
                in=new Scanner(System.in);
                System.out.println("Podaj nazwe zadania");
                zadanie=in.nextLine();
                System.out.println("Podaj czas trwania zadania wyrażony w minutach");
                dlugoscTrwania=in.nextInt();
                System.out.println("Chcesz dodać kolejne zadanie?\n1.Tak\n2.Nie");
                wyjdz=in.nextInt();
                user.getListaZadan().dodaj(new Zadanie(zadanie, dlugoscTrwania));}while(wyjdz==1);
        }
}




