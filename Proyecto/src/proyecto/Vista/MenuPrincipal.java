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
        CentrosControlador centros = new CentrosControlador();
        centros.listarReporteInvestigacionActiva();
    }
    public static void menuUsuario(){
        UsuarioControlador metodosU = new UsuarioControlador();
        String menu = """
                      1. Agregar Usuario
                      2. Listar Usuarios
                      3. Acceder al sistema
                      4. Salir
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
                            break;
                        }               
                    } while (true);
                }
                case 2 -> {
                    metodosU.listarUsuarios();
                }
                case 3 -> {
                    if (UsuarioControlador.contadorIntentos>=3) {
                        System.out.println("Acceso denegado. Usuario bloqueado");
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
                                //llamar a metodo de menuReportes
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
}
