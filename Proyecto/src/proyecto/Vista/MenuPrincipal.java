/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.Vista;

import java.util.Scanner;
import Proyecto.Controlador.UsuarioControlador;
import Proyecto.Controlador.CentrosControlador;
import Proyecto.Modelo.Usuario;
import java.text.ParseException;
/**
 *
 * @author Alvaro
 */
public class MenuPrincipal {
    public static void main(String[] args) throws ParseException {
        menuUsuario();
    }
    public static void menuUsuario() throws ParseException{
        UsuarioControlador metodosU = new UsuarioControlador();
        String menu = """
                      1. Agregar Usuario
                      2. Listar Usuarios
                      3. Acceder al sistema
                      4. Salir
                      
                      Ingrese una opcion [1-4]:
                      
                      """;
        Scanner lector = new Scanner(System.in);
        int indice;
        do {
            System.out.println(menu);
            indice = lector.nextInt();
            switch(indice){
                case 1 -> {
                    do {
                        lector.nextLine();
                        String usuario, password;
                        System.out.print("Ingresar usuario: ");
                        usuario = lector.nextLine();
                        System.out.print("Ingresar contrasena: ");
                        password = lector.nextLine();
                        boolean checkExpresiones = metodosU.ValidarEntradas(usuario, password);
                        boolean checkUsuario = metodosU.ValidarUsuario(usuario);
                        if (checkExpresiones && !checkUsuario) {
                            Usuario user = new Usuario(usuario,password);
                            metodosU.agregarUsuario(user);
                            System.out.println("Registro correcto");
                            System.out.println("");
                            break;
                        }               
                    } while (true);
                }
                case 2 -> {
                    metodosU.listarUsuarios();
                    System.out.printf("\nUsuarios listados\n");
                }
                case 3 -> {
                    if (UsuarioControlador.contadorIntentos>=3) {
                        System.out.println("Acceso denegado. Usuario bloqueado");
                        System.out.println("");
                    }else{
                        do {
                            lector.nextLine();
                            String usuario, password;
                            System.out.print("Ingresar usuario: ");
                            usuario = lector.nextLine();
                            System.out.print("Ingresar contrasena: ");
                            password = lector.nextLine();
                            Usuario user = new Usuario(usuario,password);
                            boolean check = metodosU.ValidarAcceso(user);
                            if (check) {
                                menuReportes();
                                break;
                            }
                        } while(UsuarioControlador.contadorIntentos<3);
                    }
                }
                case 4 -> System.out.println("Gracias por tu tiempo");
                default-> System.out.println("Opcion invalida");
            }        
        } while (indice!=4);
          
        
    }
    public static void menuReportes() throws ParseException{
        CentrosControlador metodosC = new CentrosControlador();
        String menu = """
                      1. Reporte de centros de investigación agrupados por área científica. 
                      2. Reporte de centros que tienen investigación científica activa.
                      3. Reporte de información de contacto de los centros de investigación.
                      4. Reporte de centros que tienen innovación tecnológica.
                      5. Regresar al menu principal
                      Indique la opcion [1 - 5]: 
                      """;
        Scanner lector = new Scanner(System.in);
        int indice;
        do {
            System.out.println(menu);
            indice = lector.nextInt();
            while (indice==1||indice==2||indice==3||indice==4) {                
                String menuInterno = """
                                     1. Imprimir por pantalla
                                     2. Exportar a archivo plano
                                     3. Volver al menu
                                     Indique la opcion [1-3]:
                                     """;
                System.out.println(menuInterno);
                int indiceInterno = lector.nextInt();
                switch(indiceInterno){
                    case 1 -> {
                            switch(indice){
                                case 1 -> metodosC.listarReporteAreaCientifica();
                                case 2 -> metodosC.listarReporteInvestigacionActiva();
                                case 3 -> metodosC.listarReporteInformacionContacto();
                                case 4 -> metodosC.listarReporteInnovacion();
                            }
                    }
                    case 2 -> {
                        String ruta="";
                        switch(indice){
                            case 1 ->
                                ruta = "D:\\AreaCientifica.txt";
                            case 2 ->
                                ruta = "D:\\InvestigacionActiva.txt";
                            case 3 ->
                                ruta = "D:\\InformacionContacto.txt";
                            case 4 ->
                                ruta = "D:\\InnovacionTecnologica.txt";
                        }
                        metodosC.exportarLista(ruta, indice);
                        System.out.println("Exportado completado");
                        System.out.println("");
                    }
                    case 3 -> {System.out.println("Retornando...");}
                    default -> System.out.println("Ingresa una opcion correcta");
                }
                if (indiceInterno==3) {
                    break;
                }
            }
        } while (indice!=5);
               
    }
}
