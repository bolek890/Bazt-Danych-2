/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client_page;

/**
 *
 * @author Bolek
 */
public class client_payment {
    private int id;
    private String name;
    private float comission;

    public client_payment(int id, String name, float comission) {
        this.id = id;
        this.name = name;
        this.comission = comission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getComission() {
        return comission;
    }

    public void setComission(float price) {
        this.comission = price;
    }
    
}
