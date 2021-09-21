/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author 2dam
 */
public class Movement implements Serializable{

    private int movementId;
    private int accountId;
    private LocalDate timestamp;
    private float amount;
    private float balance;
    private String description;

    /**
     * @return the movementId
     */
    public int getMovementId() {
        return movementId;
    }

    /**
     * @param movementId the movementId to set
     */
    public void setMovementId(int movementId) {
        this.movementId = movementId;
    }

    /**
     * @return the accountId
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * @param accountId the accountId to set
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    /**
     * @return the timestamp
     */
    public LocalDate getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(LocalDate timestamp) {
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

    public Movement() {
    }
}
