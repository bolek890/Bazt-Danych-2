/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client_page;

/**
 *
 * @author Bolek
 */
public class client_product {
    private int id;
    private String nazwa;
    private int ilosc;
    private float cena;
    private String opis;
    private int warehouse_id;
    
    
    public client_product(int id, String nazwa, int ilosc, float cena, String opis, int warehouse_id){
        
        this.id= id;
        this.nazwa= nazwa;
        this.cena= cena;
        this.ilosc= ilosc;
        this.opis= opis;
        this.warehouse_id = warehouse_id;
        
    }

    public int getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(int warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getnazwa(){
      return nazwa;  
    }
    
    public int getilosc(){
      return ilosc;  
    }
        
    public float getcena(){
      return cena;  
    }
    
    public String getopis(){
        
      return opis;  
    }
}
