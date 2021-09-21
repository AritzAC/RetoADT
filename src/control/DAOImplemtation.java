/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import classes.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.ResourceBundle;

/**
 *
 * @author 2dam
 */
public class DAOImplemtation {

    private Connection con;
    private PreparedStatement stmt;
    //private CallableStatment cSmt;
    private ResourceBundle configFile;
    private String driverDB;
    private String urlBD;
    private String userDB;
    private String passDB;

    public DAOImplemtation() {
        this.configFile = ResourceBundle.getBundle("control.config");
        this.driverDB = configFile.getString("driver");
        this.urlBD = configFile.getString("con");
        this.userDB = configFile.getString("DBUSER");
        this.passDB = configFile.getString("DBPASS");
    }

    private void connection() {
        try {
            con = DriverManager.getConnection(this.urlBD, this.userDB, this.passDB);
        } catch (SQLException e) {
            System.out.println("Error al intentar abrir la base de datos");
        }
    }

    private void close() throws SQLException {
        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }

    }

    public void crearClient(Customer c) {
        this.connection();
        try {
            /*stmt = con.prepareStatement(INSERTclient);  //// CREAR EL STAMENT*/
            stmt.setInt(1, c.getCustomerID());
            stmt.setString(1, c.getCity());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
;

/*public String consuClient( );
    public void consuCuent( );
    public void crearCuenta( );
    public void addClient( );
    public void consuDatoC( );
    public void movimi();
    public void consuMovimi();*/
}
