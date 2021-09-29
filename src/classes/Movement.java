package classes;

import java.io.Serializable;
import java.sql.Timestamp;
import utilidades.Util;

/**
 *
 * @author Aritz, Mikel y Daniel
 */
public class Movement implements Serializable{

    //ATRIBUTOS
    
    private long movementId;
    private long accountId;
    private Timestamp timestamp;
    private double amount;
    private double balance;
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
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
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
    
    public void setDatos(){
        this.movementId = Util.leerLong("Introduce el id: "); //tiene que ser un auto incremento
        this.accountId = Util.leerLong("Introduce el id de la cuenta: ");
        this.amount = Util.leerDouble("Introduce la cantidad: ");
        this.balance = Util.leerDouble("Introduce el balance: ");
        this.description = Util.introducirCadena("Introduce una descripción: ");
        this.timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println("Movimiento realizado en "+timestamp);
        
    }

    @Override
    public String toString() {
        return "Movement{" + "movementId=" + movementId + ", accountId=" + accountId + ", timestamp=" + timestamp + ", amount=" + amount + ", balance=" + balance + ", description=" + description + '}';
    }
}
