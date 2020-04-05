public class User {
    private String imie;
    private String nazwisko;
    private String login;
    private String haslo;
    private ListaZadan listaZadan;
    private ListaZadanZakonczonych listaZadanZakonczonych;
    public User(String login, String haslo) {
        this.login = login;
        this.haslo = haslo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public User(String imie, String nazwisko, String login, String haslo, ListaZadan listaZadan, ListaZadanZakonczonych listaZadanZakonczonych) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.login = login;
        this.haslo = haslo;
        this.listaZadan = listaZadan;
        this.listaZadanZakonczonych = listaZadanZakonczonych;
    }

    public User(String imie, String nazwisko, String login, String haslo) {

        this.imie = imie;
        this.nazwisko = nazwisko;
        this.login = login;
        this.haslo = haslo;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
}