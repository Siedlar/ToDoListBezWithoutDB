public class UserAcc {
    private final String login="Krystek";
    private final String haslo="12345";

    public UserAcc() {
    }

    public String getLogin() {
        return login;
    }

    public String getHaslo() {
        return haslo;
    }

    @Override
    public String toString() {
        return "UserAcc{" +
                "login='" + login + '\'' +
                ", haslo='" + haslo + '\'' +
                '}';
    }

    public boolean walidacja(String login,String haslo){
    if(this.login.equals(login) && this.haslo.equals(haslo) ){
        return true;
    }
    else return false;
    }
}
