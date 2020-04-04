import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Witaj w ToDoList");
        int a;
        do{
           a=1;
        Scanner pobierz=new Scanner(System.in);
        System.out.println("Podaj swój login");
        String login=pobierz.nextLine();
        System.out.println("Podaj hasło");
        String haslo=pobierz.nextLine();
        UserAcc konto=new UserAcc();
        if(konto.walidacja(login,haslo)==false){
            System.out.println("Podałeś złe dane !!!");
            a=2;
        }}while(a!=1);

    }
}
