/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import classes.Customer;

/**
 *
 * @author 2dam
 */
public interface DAO {
    
    public void crearClient( Customer c);
    public String consuClient( );
    public void consuCuent( );
    public void crearCuenta( );
    public void addClient( );
    public void consuDatoC( );
    public void movimi();
    public void consuMovimi();
    
}
