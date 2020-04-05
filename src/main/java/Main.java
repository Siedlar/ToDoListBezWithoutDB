import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
      User user= menu();
        System.out.println("Witaj "+user.getImie()+"  "+ user.getNazwisko());
    }
    public static ListaUser wykonaj(){
        ListaUser lista=new ListaUser(new ArrayList<User>());
        lista.dodaj(new User("Andrzej","Pyrtek","Pyrtowski","1234",new ListaZadan(),new ListaZadanZakonczonych()));
        lista.dodaj(new User("Anita","Witkac","WitAni","qwerty",new ListaZadan(),new ListaZadanZakonczonych()));
return lista;
    }
    public static User menu(){

        User user=null;
        int x;
        Scanner in=new Scanner(System.in);
        ListaUser listaUser=wykonaj();
        System.out.println("Witaj w ToDoList");
        System.out.println("Posiadasz już konto czy chcesz się zarejestrować??");
        int a=0;
        int licznikZlychWejsc=0;
        System.out.println("-----------------\n1.Mam konto\n2.Chcę sie zarejestrować\n3.Zamknij program");
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

        }else {
            System.exit(0);
        }
        return null;
    }
}
