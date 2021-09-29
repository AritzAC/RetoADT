package aplication;

import classes.Account;
import classes.Customer;
import control.DAO;
import control.DAOImplementation;
import utilidades.Util;

/**
 *
 * @author Aritz, Mikel y Daniel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declaraciones
        int opc = 0;
        
        DAO d = new DAOImplementation();
        Customer c = new Customer();
        Account a = new Account();
        
        //Menu
        do{
            System.out.println("***********************************************");
            System.out.println("1- Crear Cliente");
            System.out.println("2- Consultar datos de un cliente");
            System.out.println("3- Consultar cuentas de un cliente");
            System.out.println("4- Crear cuenta para cliente");
            System.out.println("5- Agregar cliente a cuenta");
            System.out.println("6- Consultar datos de una cuenta");
            System.out.println("7- Realizar movimiento sobre una cuenta");
            System.out.println("8- Consultar movimientos de una cuenta");
            System.out.println("9- SALIR");
            System.out.println("***********************************************");
            System.out.println("Introduce una opción");
            opc = Util.leerInt();
            
            
            switch(opc){
                case 1:
                    crearCliente(d,c);
                    break;
                case 2:
                    consultarDatosCliente(d,a);
                    break;
                case 3:
                    ConsultarCuentasCliente();
                    break;
                case 4:
                    crearCuentaCliente();
                    break;
                case 5:
                    agregarClienteCuenta();
                    break;
                case 6:
                    consultarDatosCuenta();
                    break;
                case 7:
                    realizarMovimientoCuenta();
                    break;
                case 8:
                    consultarMovimientosCuenta();
                    break;
                case 9:
                    System.out.println("Has decidido salir del programa, ADIOS!");
                    break;
                default:
                    System.out.println("ERROR, opción no válida");
                    break;
            }
        }while(opc != 9);
    }

    //Metodos switch
    
    /**
     * CREAR UN CLIENTE
     * 
     * @param d recibe los datos de la implementacion
     * @param c contiene los datos de la clase customer
     */
    private static void crearCliente(DAO d, Customer c) {
        c.setDatos();
        d.crearCliente(c);
        System.out.println("Cliente creado satisfactoriamente");
    }

    /**
     * CONSULTAR TODOS LOS DATOS DE UN CLIENTE
     * 
     * @param d recibe los datos de la implementacion
     * @param a contiene los datos de la clase Account
     */
    private static void consultarDatosCliente(DAO d, Account a) {
        a.setDatos();
        d.crearCuenta(a);
        System.out.println("Cuenta creada satisfactoriamente");
    }

    /*
    CONSULTAR TODAS LAS CUENTAS DE UN CLIENTE
    */
    private static void ConsultarCuentasCliente() {
        
    }

    /*
    CREAR UNA CUENTA PARA UN CLIENTE
    */
    private static void crearCuentaCliente() {
        
    }

    /*
    AGREGAR UN CLIENTE A UNA CUENTA
    */
    private static void agregarClienteCuenta() {
        
    }

    /*
    CONSULTAR TODOS LOS DATOS DE UNA CUENTA
    */
    private static void consultarDatosCuenta() {
        
    }

    /*
    REALIZAR UN MOVIMIENTO SOBRE UNA CUENTA
    */
    private static void realizarMovimientoCuenta() {
        
    }

    /*
    CONSULTAR MOVIMIENTOS DE UNA CUENTA
    */
    private static void consultarMovimientosCuenta() {
        
    }
}
