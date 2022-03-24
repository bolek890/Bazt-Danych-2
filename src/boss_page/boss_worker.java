/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boss_page;

/**
 *
 * @author Bolek
 */
public class boss_worker {

    private int id;
    private int uzytkownik_id;
    private String imie;
    private String nazwisko;
    private String typ_konta;
    
    public boss_worker(int id, int uzytkownik_id, String imie, String nazwisko, String typ_konta) {
        this.id = id;
        this.uzytkownik_id = uzytkownik_id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.typ_konta = typ_konta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUzytkownik_id() {
        return uzytkownik_id;
    }

    public void setUzytkownik_id(int uzytkownik_id) {
        this.uzytkownik_id = uzytkownik_id;
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

    public String getTyp_konta() {
        return typ_konta;
    }

    public void setTyp_konta(String typ_konta) {
        this.typ_konta = typ_konta;
    }
    
    
    
}
