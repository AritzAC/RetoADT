package classes;

import java.io.Serializable;
import utilidades.Util;

/**
 *
 * @author Aritz, Mikel y Daniel
 */
public class Customer implements Serializable{
    //ATRIBUTOS
    
    private long customerID;
    private String firstName;
    private String lastname;
    private String middleIntial;
    private String street;
    private String city;
    private String state;
    private int zip;
    private long phone;
    private String email;
    
    //CONSTRUCTORES
    
    public Customer() {
    }
    
    //SETTERS y GETTERS

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the middleIntial
     */
    public String getMiddleIntial() {
        return middleIntial;
    }

    /**
     * @param middleIntial the middleIntial to set
     */
    public void setMiddleIntial(String middleIntial) {
        this.middleIntial = middleIntial;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the zip
     */
    public int getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(int zip) {
        this.zip = zip;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }
    /**
     * 
     * @return the phone
     */
    public long getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(long phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    //Metodos
    public void setDatos(){
        this.customerID = Util.leerLong("Introduce el ID: ");
        this.firstName = Util.introducirCadena("Introduce el nombre: ");
        this.lastname = Util.introducirCadena("Introduce el apellido: ");
        this.middleIntial = Util.introducirCadena("Introduce la inicial del segundo nombre: ");
        this.street = Util.introducirCadena("Introduce la calle: ");
        this.city = Util.introducirCadena("Introduce la ciudad: ");
        this.state = Util.introducirCadena("Introduce el estado: ");
        this.zip = Util.leerInt("Introduce el código ZIP: ");
        this.phone = Util.leerLong("Introduce el teléfono: ");
        this.email = Util.introducirCadena("Introduce el email: ");
    }

    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID + ", firstName=" + firstName + ", lastname=" + lastname + ", middleIntial=" + middleIntial + ", street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + ", phone=" + phone + ", email=" + email + '}';
    }
    
    
}
