/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package worker_page;

/**
 *
 * @author Bolek
 */
public class worker_product {

    public worker_product(int id, String nazwa, float cena, int ilosc, int magazyn) {
        
        this.id = id;
        this.nazwa = nazwa;
        this.cena = cena;
        this.ilosc = ilosc;
        this.magazyn = magazyn;
    }
    
    private int id;
    private String nazwa;
    private float cena;
    private int ilosc;
    private int magazyn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public int getMagazyn() {
        return magazyn;
    }

    public void setMagazyn(int magazyn) {
        this.magazyn = magazyn;
    }

}
