package control;

import classes.Account;
import classes.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;

/**
 *
 * @author Aritz, Mikel y Daniel
 */
public class DAOImplementation implements DAO{

    //Atributos para la conexion a la base de datos
    private Connection con;
    private PreparedStatement stmt;
    private ResourceBundle configFile;
    private String driverDB;
    private String urlBD;
    private String userDB;
    private String passDB;

    //Sentencias SQL
    private final String INSERTclient = "INSERT INTO customer (id,city,email,firstName,lastName,middleInitial,phone,state,street,zip) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private final String INSERTcuenta = "INSERT INTO account (id,balance,beginBalance,beginBalanceTimestamp,creditLine,description,type) VALUES (?,?,?,?,?,?,?)";
    private final String SELECTcuenta ="SELECT * FROM Customer WHERE id = ?";
    
    //Conexion a base de datos
    public DAOImplementation() {
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

    /**
     * 
     * @throws SQLException suelta una exception si ocurre un error al cerrar la base de datos
     */
    private void close() throws SQLException {
        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }

    }
    /**
     * 
     * @param c recibe los datos de la clase customer
     */
    @Override
    public void crearCliente(Customer c){
        this.connection();
        try {

            stmt = con.prepareStatement(INSERTclient);
            stmt.setLong(1,c.getCustomerID());
            stmt.setString(2,c.getCity());
            stmt.setString(3,c.getEmail());
            stmt.setString(4,c.getFirstName());
            stmt.setString(5,c.getLastname());
            stmt.setString(6,c.getMiddleIntial());
            stmt.setLong(7,c.getPhone());
            stmt.setString(8,c.getState());
            stmt.setString(9,c.getStreet());
            stmt.setInt(10,c.getZip());
            
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al crear cliente");
        }
        
        try {
            this.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar bd");
        }
    }

    @Override
    public void crearCuenta(Account a){
        this.connection();
        try {

            stmt = con.prepareStatement(INSERTcuenta);
            stmt.setLong(1, a.getAccountId());
            stmt.setDouble(2, a.getBalance());
            stmt.setDouble(3, a.getBeginBalance());
            stmt.setTimestamp(4, a.getBeginBalanceTimestamp());
            stmt.setDouble(5, a.getCreditLine());
            stmt.setString(6, a.getDescription());
            stmt.setInt(7, a.getAccountType());
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            this.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar bd");
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
            System.out.println("Error al cerrar bd");
        }
        
        return c;
    }

    @Override
    public Customer consuCliente() {
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

    @Override
    public void consuCuenta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
