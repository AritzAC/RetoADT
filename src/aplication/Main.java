package aplication;

import classes.Account;
import classes.Customer;
import classes.Movement;
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
        Movement m = new Movement();
        
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
                    consultarDatosCliente(d,c);
                    break;
                case 3:
                    ConsultarCuentasCliente(d,c,a);
                    break;
                case 4:
                    crearCuentaCliente(d,a);
                    break;
                case 5:
                    agregarClienteCuenta(d,c,a);
                    break;
                case 6:
                    consultarDatosCuenta(d,a);
                    break;
                case 7:
                    realizarMovimientoCuenta(d,m);
                    break;
                case 8:
                    consultarMovimientosCuenta(d,m,a);
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
    private static void consultarDatosCliente(DAO d, Customer c) {
        long id = Util.leerLong("Introduce el id del cliente: ");
        c.setCustomerID(id);
        d.consuCliente(c);
        System.out.println(c.toString());
        
    }

    /*
    CONSULTAR TODAS LAS CUENTAS DE UN CLIENTE
    */
    private static void ConsultarCuentasCliente(DAO d, Customer c, Account a) {
        long id = Util.leerLong("Introduce el id del cliente: ");
        c.setCustomerID(id);
        d.consuCuenta(c, a);
        System.out.println(a.toString());

    }

    /*
    CREAR UNA CUENTA PARA UN CLIENTE
    */
    private static void crearCuentaCliente(DAO d, Account a) {
        a.setDatos();
        d.crearCuenta(a);
        System.out.println("Cuenta creada satisfactoriamente");
    }

    /*
    AGREGAR UN CLIENTE A UNA CUENTA
    */
    private static void agregarClienteCuenta(DAO d, Customer c, Account a) {
        c.setCustomerID(Util.leerLong("Introduce id del cliente: "));
        a.setAccountId(Util.leerLong("Introduce id de la cuenta: "));
        d.addCliente(c, a);
        System.out.println("cliente añadido satisfactoriamente a la cuenta");
    }

    /*
    CONSULTAR TODOS LOS DATOS DE UNA CUENTA
    */
    private static void consultarDatosCuenta(DAO d, Account a) {
        a.setAccountId(Util.leerLong("Introduce el id de la cuenta: "));
        d.consuDatoC(a);
        System.out.println(a.toString());
        
    }

    /*
    REALIZAR UN MOVIMIENTO SOBRE UNA CUENTA
    */
    private static void realizarMovimientoCuenta(DAO d, Movement m) {
        m.setDatos();
        d.movimi(m);
        System.out.println("Movimiento realizado satisfactoriamente");
        
    }

    /*
    CONSULTAR MOVIMIENTOS DE UNA CUENTA
    */
    private static void consultarMovimientosCuenta(DAO d, Movement m, Account a) {
        a.setAccountId(Util.leerLong("Introduce el id de la cuenta: "));
        d.consuMovimi(m, a);
        System.out.println(m.toString());
    }
}
