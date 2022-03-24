/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package worker_page;

/**
 *
 * @author Bolek
 */
public class worker_deliverer {
    private String nazwa;
    private int id;
    private float cena;
    private int czas_oczekiwania;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public int getCzas_oczekiwania() {
        return czas_oczekiwania;
    }

    public void setCzas_oczekiwania(int czas_oczekiwania) {
        this.czas_oczekiwania = czas_oczekiwania;
    }

    public worker_deliverer(String nazwa, int id, float cena, int czas_oczekiwania) {
        this.nazwa = nazwa;
        this.id = id;
        this.cena = cena;
        this.czas_oczekiwania = czas_oczekiwania;
    }
}
