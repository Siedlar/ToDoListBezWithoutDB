import java.util.List;

public class ListaUser {
    private List<User> listaUser;

    public ListaUser(List<User> listaUser) {
        this.listaUser = listaUser;
    }

    public List<User> getListaUser() {
        return listaUser;
    }

    public void dodaj(User user){
        this.listaUser.add(user);
    }
    public int iloscUser(){
        int a=0;
        for (User user:listaUser){
            a++;
        }
        return a;
    }
}
