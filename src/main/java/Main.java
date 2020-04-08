import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
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
          System.out.println("1.Dodaj zadanie\n2.Wyświetl liste zadań aktualnych\n3.Wyświetl liste zadań zakończonych.\n4.Oznacz zadanie jako skonczone\n5.Sprawdź swoje dane\n6.Zapisz dane do pliku\n7.Posortuj dane \n8.Wyloguj się");

          b=in.nextInt();
         if(b==1){
            /* int wyjdz;
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
             user.getListaZadan().dodaj(new Zadanie(zadanie, dlugoscTrwania));}while(wyjdz==1);*/
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
         }else if(b==5){
             System.out.println(user.toString());
         }else if(b==6){
             System.out.println(user.toString());
         }else if(b==7){
             if(user.getListaZadan().getListaZadan().isEmpty()){
                 System.out.println("Nie ma czego sortować, lista jest pusta!!!");
                 Thread.sleep(2000);
             }else{
             System.out.println("1.Posortuj dane ze wzlęgu na czas trwania\n2.Posortuj dane ze wzgledu na nazwe");
           int z=in.nextInt();
           if(z==2){
    Collections.sort(user.getListaZadan().getListaZadan(), Comparator.comparing(Zadanie::getNazwaZadania));
           }else if(z==1){
               Collections.sort(user.getListaZadan().getListaZadan(),(x1,x2)->x1.getCzasTrwania()-x2.getCzasTrwania());

           }
         }}

      }while(b!=8);
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




