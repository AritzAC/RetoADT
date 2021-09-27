/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import classes.Account;
import classes.Customer;

/**
 *
 * @author 2dam
 */
public interface DAO {
    
    public void crearCliente(Customer c);
    public Customer consuCliente(Customer c);
    public Account consuCuenta(Customer c);
    public void crearCuenta(Account a);
    public void addCliente(Customer c, Account a);
    public void consuDatoC( );
    public void movimi();
    public void consuMovimi();
    
}
