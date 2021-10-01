package control;

import classes.Account;
import classes.Customer;
import classes.Movement;

/**
 *
 * @author Aritz, Mikel y Daniel
 */
public interface DAO {
    
    public void crearCliente(Customer c);
    public Customer consuCliente(Customer c);
    public Account consuCuenta(Customer c, Account a);
    public void crearCuenta(Account a);
    public void addCliente(Customer c, Account a);
    public Account consuDatoC(Account a);
    public void movimi(Movement m);
    public Movement consuMovimi(Movement m, Account a);
    
}
