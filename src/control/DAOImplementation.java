package control;

import classes.Account;
import classes.Customer;
import classes.Movement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;

/**
 *
 * @author 2dam
 */
public class DAOImplementation implements DAO {

    private Connection con;
    private PreparedStatement stmt;
    private ResourceBundle configFile;
    private String driverDB;
    private String urlBD;
    private String userDB;
    private String passDB;

    private final String INSERTcliente = "INSERT INTO customer (id,city,email,firstName,lastName,middleInitial,phone,state,street,zip) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private final String SELECTcliente = "SELECT * FROM customer WHERE id = ?";
    private final String SELECTcuentascliente = "SELECT account.* FROM account,customer_account WHERE customer.id = ? AND customer.id = customer_account.customers_id AND account.id = customer_account.accounts_id";
    private final String INSERTcuenta = "INSERT INTO account (id,balance,beginBalance,beginBalanceTimestamp,creditLine,description,type) VALUES (?,?,?,?,?,?,?)";
    private final String INSERTclientecuenta = "INSERT INTO customer_account VALUES (?,?)";
    private final String SELECTcuenta = "SELECT * FROM account WHERE id = ?";
    private final String INSERTmovimiento = "INSERT INTO movement VALUES (?,?,?,?,?,?)";
    private final String SELECTmovimiento = "SELECT movement.* FROM movement,account WHERE account.id = ? AND account.id = movement.account_id";

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

    private void close() throws SQLException {
        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }
    }

    @Override
    public void crearCliente(Customer c) {
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
            
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            this.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la BD");

        }
    }

    @Override
    public Customer consuCliente(Customer c) {
        ResultSet rs = null;

        this.connection();

        try {
            stmt = con.prepareStatement(SELECTcliente);
            stmt.setLong(1, c.getCustomerID());

            rs = stmt.executeQuery();

            while (rs.next()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            this.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la BD");
        }

        return c;
    }

    @Override
    public Account consuCuenta(Customer c, Account a) {
        ResultSet rs = null;

        this.connection();

        try {
            stmt = con.prepareStatement(SELECTcuentascliente);
            stmt.setLong(1, c.getCustomerID());

            rs = stmt.executeQuery();

            while (rs.next()) {
                a.setAccountId(rs.getLong(1));
                a.setBalance(rs.getDouble(2));
                a.setBeginBalance(rs.getDouble(3));
                a.setBeginBalanceTimestamp(rs.getTimestamp(4));
                a.setCreditLine(rs.getDouble(5));
                a.setDescription(rs.getString(6));
                a.setAccountType(rs.getInt(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            this.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la BD");
        }

        return null;
    }

    @Override
    public void crearCuenta(Account a) {
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
            System.out.println("Error al cerrar la BD");
        }
    }

    @Override
    public void addCliente(Customer c, Account a) {
        this.connection();

        try {

            stmt = con.prepareStatement(INSERTclientecuenta);
            stmt.setLong(1, c.getCustomerID());
            stmt.setLong(2, a.getAccountId());
            
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            this.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la BD");
        }
    }

    @Override
    public Account consuDatoC(Account a) {
        ResultSet rs = null;

        this.connection();

        try {
            stmt = con.prepareStatement(SELECTcuenta);
            stmt.setLong(1, a.getAccountId());

            rs = stmt.executeQuery();

            while (rs.next()) {
                a.setBalance(rs.getDouble(2));
                a.setBeginBalance(rs.getDouble(3));
                a.setBeginBalanceTimestamp(rs.getTimestamp(4));
                a.setCreditLine(rs.getDouble(5));
                a.setDescription(rs.getString(6));
                a.setAccountType(rs.getInt(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            this.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la BD");
        }

        return a;
    }

    @Override
    public void movimi(Movement m) {
        this.connection();

        try {

            stmt = con.prepareStatement(INSERTmovimiento);
            stmt.setLong(1, m.getMovementId());
            stmt.setDouble(2, m.getAmount());
            stmt.setDouble(3, m.getBalance());
            stmt.setString(4, m.getDescription());
            stmt.setTimestamp(5, m.getTimestamp());
            stmt.setLong(6, m.getAccountId());
            
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            this.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la BD");
        }
    }

    @Override
    public Movement consuMovimi(Movement m, Account a) {
        ResultSet rs = null;

        this.connection();

        try {
            stmt = con.prepareStatement(SELECTmovimiento);
            stmt.setLong(1, a.getAccountId());

            rs = stmt.executeQuery();

            while (rs.next()) {
                m.setMovementId(rs.getLong(1));
                m.setAmount(rs.getDouble(2));
                m.setBalance(rs.getDouble(3));
                m.setDescription(rs.getString(4));
                m.setTimestamp(rs.getTimestamp(5));
                m.setAccountId(rs.getLong(6));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            this.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la BD");
        }

        return m;
    }
}
