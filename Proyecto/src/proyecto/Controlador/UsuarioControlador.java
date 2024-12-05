/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.Controlador;
import Proyecto.Modelo.Usuario;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Alvaro
 */

public class UsuarioControlador {
    public static int contadorIntentos = 0;
    public void agregarUsuario(Usuario usuario){     //Agregar usuario al txt
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter("D:\\usuarios.txt", true));
            escritor.write(usuario.getUser() + "," + usuario.getPassword());
            escritor.newLine();
            escritor.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo " + e.getMessage());
        }
    }
    public boolean ValidarUsuario(String usuario){ //Validar que usuario no exista
        boolean check = false;
        try {
            BufferedReader lector = new BufferedReader(new FileReader("D:\\usuarios.txt"));
            String linea = "";
            while((linea = lector.readLine())!=null){
                String[] bloques = linea.split(",");
                if(bloques.length>1){
                    Usuario lista = new Usuario(bloques[0],bloques[1]);
                    check = lista.getUser().equals(usuario);
                    if (check) {
                        System.out.print("Usuario existente. Presiona Enter");
                        break;
                    }
                }else{
                    break;
                }
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer en el archivo "+e.getMessage());
        }
        return check;
    }
    public boolean ValidarEntradas(String usuario, String password){
        
        boolean validacion = false;
        Pattern patronUsuario = Pattern.compile("[U]\\d{8}");
        Pattern patronPassword = Pattern.compile("[A-Za-z0-9@$*+-]{8,15}");
        
        Matcher compararUsuario = patronUsuario.matcher(usuario);
        Matcher compararPassword = patronPassword.matcher(password);
        
        if (!compararUsuario.matches()){
            System.out.println("El usuario debe tener el formato de U########");
        }
        if (!compararPassword.matches()){
            System.out.println("La contrasena debe tener de 8 a 15 caracteres, esta permitido usar: @$*+-");
        }
        if (compararUsuario.matches()&&compararPassword.matches()) {
            validacion = true;
        }
        return validacion;
    }
    
    public void listarUsuarios(){
        try {
            BufferedReader lector = new BufferedReader(new FileReader("D:\\usuarios.txt"));
            String linea = "";
            StringBuilder s = new StringBuilder();
            s.append(System.out.printf("Usuario \tContrasena \n"));
            while ((linea = lector.readLine()) != null) {
                String[] bloques = linea.split(",");
                if(bloques.length>1){
                    Usuario lista = new Usuario(bloques[0], bloques[1]);
                    System.out.println(lista.toString());
                }else{
                    break;
                }
            }
            lector.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public boolean ValidarAcceso(Usuario user){
        boolean validadorAcceso = false;
        if (contadorIntentos>=3) {
            System.out.println("Acceso denegado. Usuario bloqueado");
        }else{
            try {
                BufferedReader lector = new BufferedReader(new FileReader("C:\\usuarios.txt"));
                String linea = "";
                do {
                    while((linea = lector.readLine())!=null){
                        String[] bloques = linea.split(",");
                        Usuario lista = new Usuario(bloques[0], bloques[1]);
                        boolean validadorUsuario = lista.getUser().equals(user.getUser()) && lista.getPassword().equals(user.getPassword());
                        if (validadorUsuario) {
                            System.out.println("Acceso correcto");
                            System.out.println("");
                            validadorAcceso = true;
                            break;
                        }
                    }
                    if((linea = lector.readLine())!=null){
                        break;
                    }
                } while (validadorAcceso==false);
                if (validadorAcceso) {
                    contadorIntentos = 0;
                }else{
                    contadorIntentos++;
                    if (contadorIntentos<3) {
                        System.out.print("Intenta de nuevo. Presiona Enter");
                    }else{
                        System.out.println("Usuario bloqueado");
                        System.out.println("");
                    }
                }
                lector.close();
            } catch (IOException e) {
                System.out.println("Error al leer en el archivo "+e.getMessage());
            }
        }
        return validadorAcceso;
    }
    
}
