/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import classes.Customer;

/**
 *
 * @author Aritz, Mikel y Daniel
 */
public interface DAO {
    
    public void crearCliente(Customer c);
    public Customer consuCliente( );
    public void consuCuenta( );
    public void crearCuenta( );
    public void addCliente( );
    public void consuDatoC( );
    public void movimi();
    public void consuMovimi();
    
}
