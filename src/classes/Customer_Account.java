package classes;

import java.io.Serializable;

/**
 *
 * @author Aritz, Mikel y Daniel
 */
public class Customer_Account implements Serializable{

    //ATRIBUTOS
    
    private int customerId;
    private int accountId;

    //CONSTRUCTORES
    
    public Customer_Account() {
    }
    
    //SETTERS y GETTERS
    
    /**
     * @return the customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
}
