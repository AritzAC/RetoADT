/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import classes.Account;
import classes.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aritz, Mikel y Daniel
 */
public class DAOImplemtation implements DAO{

    private Connection con;
    private PreparedStatement stmt;
    private ResourceBundle configFile;
    private String driverDB;
    private String urlBD;
    private String userDB;
    private String passDB;

    private final String INSERTclient = "INSERT INTO customer (id,city,email,firstName,lastName,middleInitial,phone,state,street,zip) ) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private final String INSERTcuenta = "INSERT INTO account (id,balance,beginBalance,beginBalanceTimestamp,creditLine,description,type) VALUES (?,?,?,?,?,?,?)";
    private final String SELECTcuenta ="SELECT * FROM Customer WHERE id = ?";
    
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
    
    @Override
    public void crearCliente(Customer c){
        this.connection();
        try {

            stmt = con.prepareStatement(INSERTclient);
            //stmt.setLong(0, c.getCustomerID()); innecesario
            stmt.setString(1, c.getCity());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getFirstName());
            stmt.setString(4, c.getLastname());
            stmt.setString(5, c.getMiddleIntial());
            stmt.setInt(6, c.getPhone());
            stmt.setString(7, c.getState());
            stmt.setString(8, c.getStreet());
            stmt.setInt(9, c.getZip());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            this.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplemtation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearCuenta(Account a){
        this.connection();
        try {

            stmt = con.prepareStatement(INSERTcuenta);
            stmt.setInt(1, a.getAccountId());
            stmt.setFloat(2, a.getBalance());
            stmt.setFloat(3, a.getBeginBalance());
            stmt.setTimestamp(4, a.getBeginBalanceTimestamp());
            stmt.setFloat(5, a.getCreditLine());
            stmt.setString(6, a.getDescription());
            stmt.setInt(7, a.getAccountType());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            this.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplemtation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Customer consuCuenta(Customer c){
        ResultSet rs = null;
        
        this.connection();
        
        try{
            stmt = con.prepareStatement(SELECTcuenta);
            stmt.setLong(1,c.getCustomerID());
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                c.setCustomerID(rs.getInt(1));
                c.setCity(rs.getString(2));
                c.setEmail(rs.getString(3));
                c.setFirstName(rs.getString(4));
                c.setLastname(rs.getString(5));
                c.setMiddleIntial(rs.getString(6));
                c.setPhone(rs.getInt(7));
                c.setState(rs.getString(8));
                c.setStreet(rs.getString(9));
                c.setZip(rs.getInt(10));        
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        if(rs != null){
            try{
                rs.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
            
        }
        try {
            this.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplemtation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return c;
    }

    @Override
    public Customer consuCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consuCuenta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearCuenta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consuDatoC() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void movimi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consuMovimi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
