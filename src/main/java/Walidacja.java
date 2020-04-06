import java.util.Scanner;

public class Walidacja {
private ListaUser listaUser;

    public Walidacja(ListaUser listaUser) {
        this.listaUser = listaUser;
    }
    public User zaloguj(){
        Scanner in=new Scanner(System.in);
        System.out.println("Podaj nazwe użytkownika");
        String login=in.nextLine();
        System.out.println("Podaj hasło ");
        String hasło=in.nextLine();
        for(User user:listaUser.getListaUser()){
           if(user.getLogin().equals(login) && user.getHaslo().equals(hasło)){
               return user;
           }
        }
        return null;
    }
    public  static boolean sprawdzCzyHasloJestIdentyczne(String haslo,String haslo2){
        if(haslo.equals(haslo2)){
            return true;
        }
        else return false;
    }
}
