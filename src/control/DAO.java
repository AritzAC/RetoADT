package control;

import classes.Account;
import classes.Customer;

/**
 *
 * @author Aritz, Mikel y Daniel
 */
public interface DAO {
    
    public void crearCliente(Customer c);
    public Customer consuCliente();
    public void consuCuenta();
    public void crearCuenta(Account a);
    public void addCliente();
    public void consuDatoC();
    public void movimi();
    public void consuMovimi();
    
}
