package ar.edu.utn.frbb.tup.jupfi.input;

import ar.edu.utn.frbb.tup.jupfi.logic.OperacionesCuenta;
import ar.edu.utn.frbb.tup.jupfi.model.Cuenta;

import java.util.List;
import java.util.Scanner;

public class SubMenu {
    public static void mostrarSubMenu(List<Cuenta> listaCuentas, int numeroCuenta) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("----- Submenú - Cuenta Bancaria -----");
            System.out.println("1 - Consultar Dinero");
            System.out.println("2 - Depositar en cuenta propia");
            System.out.println("3 - Retirar dinero");
            System.out.println("4 - Depositar dinero a cuenta propia u otra");
            System.out.println("5 - Mostrar todos los datos de una cuenta");
            System.out.println("6 - Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: //mostrar dinero guardado
                    boolean cuentaEncontrada = false;
                    for (Cuenta cuenta : listaCuentas) {
                        if (cuenta.getNumeroCuenta() == numeroCuenta) {
                            OperacionesCuenta.consultarDinero(cuenta);
                            cuentaEncontrada = true;
                            break;
                        }
                    }
                    if (!cuentaEncontrada) {
                        System.out.println("La cuenta con el número " + numeroCuenta + " no fue encontrada.");
                    }
                    break;

                case 2: // Depositar dinero
                    System.out.println("Ingrese el monto a depositar: ");
                    double montoDeposito = scanner.nextDouble();
                    scanner.nextLine();
                
                    Cuenta cuentaDeposito = null;
                    for (Cuenta cuenta : listaCuentas) {
                        if (cuenta.getNumeroCuenta() == numeroCuenta) {
                            cuentaDeposito = cuenta;
                            break;
                        }
                    }
                
                    if (cuentaDeposito != null) {
                        OperacionesCuenta.depositarDinero(cuentaDeposito, montoDeposito);
                    } else {
                        System.out.println("La cuenta con el número " + numeroCuenta + " no fue encontrada.");
                    }
                    break;
                
                case 3:// Retirar dinero
                    System.out.print("Ingrese el número de cuenta: ");
                    int numeroCuentaRetiro = scanner.nextInt();
                    scanner.nextLine();

                    boolean cuentaEncontradaRetiro = false;
                    for (Cuenta cuenta : listaCuentas) {
                        if (cuenta.getNumeroCuenta() == numeroCuentaRetiro) {
                            System.out.print("Ingrese el monto a retirar: ");
                            double montoRetiro = scanner.nextDouble();
                            scanner.nextLine(); // Limpiar el buffer de entrada
                            OperacionesCuenta.retirarDinero(cuenta, montoRetiro);
                            cuentaEncontradaRetiro = true;
                            break;
                        }
                    }
                    if (!cuentaEncontradaRetiro) {
                        System.out.println("La cuenta con el número " + numeroCuentaRetiro + " no fue encontrada.");
                    }
                    break;
                case 4: // Transferir dinero
                    System.out.println("Ingrese el número de cuenta destino: ");
                    int numeroCuentaDestino = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el monto a transferir: ");
                    double montoTransferencia = scanner.nextDouble();
                    scanner.nextLine();
                
                    //se buscan las cuentas correspondientes en la lista
                    Cuenta cuentaOrigen = null;
                    Cuenta cuentaDestino = null;
                    for (Cuenta cuenta : listaCuentas) {
                        if (cuenta.getNumeroCuenta() == numeroCuenta) {
                            cuentaOrigen = cuenta;
                        }
                        if (cuenta.getNumeroCuenta() == numeroCuentaDestino) {
                            cuentaDestino = cuenta;
                        }
                        // Si ambas cuentas fueron encontradas, salir del bucle
                        if (cuentaOrigen != null && cuentaDestino != null) {
                            break;
                        }
                    }
                
                    // Verificar si ambas cuentas fueron encontradas
                    if (cuentaOrigen != null && cuentaDestino != null) {
                        OperacionesCuenta.transferirDinero(cuentaOrigen, cuentaDestino, montoTransferencia);
                    } else {
                        System.out.println("Una o ambas cuentas no fueron encontradas.");
                    }
                    break;

                case 5: //mostrar los datos de una cuenta
                    System.out.print("Ingrese el número de cuenta: ");
                    int numeroCuentaConsulta = scanner.nextInt();
                    scanner.nextLine();
                    
                    OperacionesCuenta.mostrarDatosCuenta(listaCuentas, numeroCuentaConsulta);
                    break;

                case 6:
                    System.out.println("Volviendo al menu principal...");
                    break;

                default:
                    System.out.println("Opción invalida. Por favor, seleccione una opcion valida.");
                    break;
            }
        } while (opcion != 6);
    }
}
