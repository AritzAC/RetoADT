/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import classes.Account;
import classes.Customer;
import classes.Movement;

/**
 *
 * @author 2dam
 */
public interface DAO {
    
    public void crearCliente(Customer c);
    public Customer consuCliente(Customer c);
    public Account consuCuenta(Customer c, Account a);
    public void crearCuenta(Account a);
    public void addCliente(Customer c, Account a);
    public Account consuDatoC(Account a);
    public void movimi(Movement m);
    public Movement consuMovimi(Movement m);
    
}
