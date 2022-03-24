/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login_page;

/**
 *
 * @author Bolek
 */
public class DataBaseConnector {

    private String URL;
    private String user;
    private String password;
    private String ClassName;

    public DataBaseConnector() {
        this.URL = "jdbc:mysql://localhost:3306/sklep_internetowy";
        this.user = "root";
        this.password = "";
        this.ClassName = "com.mysql.cj.jdbc.Driver";
    }
    
    public DataBaseConnector(String URL, String user, String password, String ClassName) {
        this.URL = URL;
        this.user = user;
        this.password = password;
        this.ClassName = ClassName;
    }

    public String getURL() {
        return URL;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getClassName() {
        return ClassName;
    }
}
