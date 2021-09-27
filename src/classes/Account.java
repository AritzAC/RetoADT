/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Aritz, Mikel y Daniel
 */
public class Account implements Serializable{

    //ATRIBUTOS
    
    private long accountId;
    private String description;
    private float balance;
    private float creditLine;
    private float beginBalance;
    private Timestamp beginBalanceTimestamp;
    private int accountType;

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
    public void setAccountId(int accountId) {
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
    public float getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(float balance) {
        this.balance = balance;
    }

    /**
     * @return the creditLine
     */
    public float getCreditLine() {
        return creditLine;
    }

    /**
     * @param creditLine the creditLine to set
     */
    public void setCreditLine(float creditLine) {
        this.creditLine = creditLine;
    }

    /**
     * @return the beginBalance
     */
    public float getBeginBalance() {
        return beginBalance;
    }

    /**
     * @param beginBalance the beginBalance to set
     */
    public void setBeginBalance(float beginBalance) {
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
}
