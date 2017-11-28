/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.prof.software;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Duoc UC
 */
public class Conexion {
    private String url = "jdbc:mysql://localhost:3306/inventario";
    private String user = "taller-prof-soft";
    private String pass = "system"; 
    public void conectar(){
        try(Connection con = DriverManager.getConnection(url,user,pass)){
            System.out.println("conectado :) ");
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public void agregar(int cod,String nom,int sto,String carac){
        try(Connection con = DriverManager.getConnection(url,user,pass)){
            Statement s = con.createStatement();
            String query = "insert into prueba(nombre) values('"+nom+"');";
            s.execute(query);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public void consultar(){
        try(Connection con = DriverManager.getConnection(url,user,pass)){
            Statement s = con.createStatement();
            String query = "select * from prueba;";
            ResultSet rs = s.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getString("nombre"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
