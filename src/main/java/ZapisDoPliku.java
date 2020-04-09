import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class ZapisDoPliku {
    private User user;
    private LocalDate localDate;
    private BufferedWriter bufferedWriter;

    public BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }

    public void setBufferedWriter(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    public User getUser() {
        return user;
    }

    public ZapisDoPliku(User user, LocalDate localDate,BufferedWriter bufferedWriter) {
        this.user = user;
        this.localDate = localDate;
        this.bufferedWriter=bufferedWriter;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
    public void zapisz(){
        try{
            bufferedWriter.append(localDate.toString()+ " "+ user.getImie()+" "+user.getNazwisko()+"\n"+"Zadania dzisiaj wykonane to:\n"+user.getListaZadanZakonczonych().wypisz()+"\nZadanie wpisane ale nie skonczone to:\n"+user.getListaZadan().wypisz()+"\n-----------------\n");
            bufferedWriter.close();
            }catch (IOException e){
            System.out.println("");
            }
    }
}
