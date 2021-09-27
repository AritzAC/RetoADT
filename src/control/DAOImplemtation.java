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
import utilidades.Util;

/**
 *
 * @author 2dam
 */
public class DAOImplemtation implements DAO{

    private Connection con;
    private PreparedStatement stmt;
    private ResourceBundle configFile;
    private String driverDB;
    private String urlBD;
    private String userDB;
    private String passDB;

    private final String INSERTcliente = "INSERT INTO customer (id,city,email,firstName,lastName,middleInitial,phone,state,street,zip) ) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private final String SELECTcliente ="SELECT * FROM customer WHERE id = ?";
    private final String SELECTcuenta ="SELECT account.* FROM account,customer_account WHERE customer_account.customers_id = ? AND account.id = customer_account.accounts_id";
    private final String INSERTcuenta = "INSERT INTO account (id,balance,beginBalance,beginBalanceTimestamp,creditLine,description,type) VALUES (?,?,?,?,?,?,?)";
    private final String INSERTclientecuenta = "INSERT INTO customer account VALUES (? ,?)";
    
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
            
            stmt = con.prepareStatement(INSERTcliente);
            
            stmt.setLong(1, c.getCustomerID());
            stmt.setString(2, c.getCity());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getFirstName());
            stmt.setString(5, c.getLastname());
            stmt.setString(6, c.getMiddleIntial());
            stmt.setLong(7, c.getPhone());
            stmt.setString(8, c.getState());
            stmt.setString(9, c.getStreet());
            stmt.setInt(10, c.getZip());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            this.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplemtation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Customer consuCliente(Customer c) {
        ResultSet rs = null;
        
        this.connection();
        
        try{
            stmt = con.prepareStatement(SELECTcliente);
            stmt.setLong(1,c.getCustomerID());
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                //c.setCustomerID(rs.getInt(1));  Innecesario
                c.setCity(rs.getString(2));
                c.setEmail(rs.getString(3));
                c.setFirstName(rs.getString(4));
                c.setLastname(rs.getString(5));
                c.setMiddleIntial(rs.getString(6));
                c.setPhone(rs.getLong(7));
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
    public Account consuCuenta(Customer c){
        ResultSet rs = null;
        
        this.connection();
        
        try {
            stmt = con.prepareStatement(SELECTcuenta);
            stmt.setLong(1,c.getCustomerID());
            
        } catch (Exception e) {
        }
        
        return null;
    }
    
    @Override
    public void crearCuenta(Account a){
        this.connection();
        try {

            stmt = con.prepareStatement(INSERTcuenta);
            stmt.setLong(1, a.getAccountId());
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
    
    @Override
    public void addCliente(Customer c, Account a) {
        this.connection();
        
        try {
            
            stmt = con.prepareStatement(INSERTclientecuenta);
            stmt.setLong(1, c.getCustomerID());
            stmt.setLong(2, a.getAccountId());
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            this.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplemtation.class.getName()).log(Level.SEVERE, null, ex);
        }
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
