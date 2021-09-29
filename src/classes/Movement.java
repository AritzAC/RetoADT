/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 *
 * @author Aritz, Mikel y Daniel
 */
public class Movement implements Serializable{

    //ATRIBUTOS
    
    private long movementId;
    private long accountId;
    private Timestamp timestamp;
    private float amount;
    private float balance;
    private String description;
    
    //CONSTRUCTORES
    public Movement() {
    }

    //SETTERS y GETTERS
    
    /**
     * @return the movementId
     */
    public long getMovementId() {
        return movementId;
    }

    /**
     * @param movementId the movementId to set
     */
    public void setMovementId(long movementId) {
        this.movementId = movementId;
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
     * @return the timestamp
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the amount
     */
    public float getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(float amount) {
        this.amount = amount;
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
}
