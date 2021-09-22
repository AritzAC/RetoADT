/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplication;

/**
 *
 * @author Aritz, Mikel y Daniel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opc = 0;
        
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
            
            
            switch(opc){
                case 1:
                    crearCliente();
                    break;
                case 2:
                    consultarDatosCliente();
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
    
    /*
    CREAR UN CLIENTE
    */
    private static void crearCliente() {
        
    }

    /*
    CONSULTAR TODOS LOS DATOS DE UN CLIENTE
    */
    private static void consultarDatosCliente() {
        
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
