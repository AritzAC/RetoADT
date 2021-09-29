/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.sql.Timestamp;
import utilidades.Util;

/**
 *
 * @author Aritz, Mikel y Daniel
 */
public class Account implements Serializable{

    //ATRIBUTOS
    
    private long accountId;
    private String description;
    private double balance;
    private double creditLine;
    private double beginBalance;
    private Timestamp beginBalanceTimestamp;
    private int accountType ;

    //CONSTRUCTORES
    
     public Account() {
    }
     
    //SETTERS y GETTERS
     
    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public int getAccountType() {
        return accountType;
    }

    /**
     * @return the accountId
     */
    public long getAccountId() {
        return accountId;
    }

    /**
     * @param accountId the accountId to set
     */
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * @return the creditLine
     */
    public double getCreditLine() {
        return creditLine;
    }

    /**
     * @param creditLine the creditLine to set
     */
    public void setCreditLine(double creditLine) {
        this.creditLine = creditLine;
    }

    /**
     * @return the beginBalance
     */
    public double getBeginBalance() {
        return beginBalance;
    }

    /**
     * @param beginBalance the beginBalance to set
     */
    public void setBeginBalance(double beginBalance) {
        this.beginBalance = beginBalance;
    }

    /**
     * @param beginBalanceTimestamp the beginBalanceTimestamp to set
     */
    public void setBeginBalanceTimestamp(Timestamp beginBalanceTimestamp) {
        this.beginBalanceTimestamp = beginBalanceTimestamp;
    }
    
    /**
     * @return the beginBalanceTimestmp
     */
    public Timestamp getBeginBalanceTimestamp() {
        return beginBalanceTimestamp;
    }
    
    public void setDatos(){
        this.accountId = Util.leerLong("Introduce un id: ");
        this.accountType = Util.leerInt("Introduce el tipo de cuenta (0 ó 1): ");
        this.beginBalance = Util.leerDouble("Introduce el balance inicial: ");
        this.balance = Util.leerDouble("Introduce el balance: ");
        this.creditLine = Util.leerDouble("Introduce la linea de credito: ");
        this.description = Util.introducirCadena("Introduce una descripción: ");
        this.beginBalanceTimestamp = new Timestamp(System.currentTimeMillis());
        System.out.println("Registrado correctamente en "+beginBalanceTimestamp);
        
    }
}
