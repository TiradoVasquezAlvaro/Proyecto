/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.Controlador;

import Proyecto.Modelo.CentrosInvestigacion;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Alvaro
 */
public class CentrosControlador {
    public void listarReporteAreaCientifica(){
        try {
            BufferedReader lector = new BufferedReader(new FileReader("D:\\BD Centros de investigacion.txt"));
            StringBuilder s = new StringBuilder();
            String linea = "";
            s.append(String.format("%-80s|%-40s|%-40s\n","Nombre de institucion","Area Cientifica","Subarea Cientifica"));
            while ((linea = lector.readLine())!=null) {                
                String[] bloques = linea.split(";");
                if (bloques.length>1) {
                    CentrosInvestigacion centros = new CentrosInvestigacion(bloques[1],bloques[2],bloques[3]);
                    s.append(String.format("%-80s|%-40s|%-40s\n",centros.getNombre_institucion(),centros.getArea_cientifica(),centros.getSubarea_cientifica()));
                }
            }
            System.out.println(s);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo "+e.getMessage());
        }
    }
    public void listarReporteInvestigacionActiva() {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("D:\\BD Centros de investigacion.txt"));
            StringBuilder s = new StringBuilder();
            String linea = "";
            s.append(String.format("%-80s|%-40s|%-40s\n", "Nombre de institucion", "Vigencia Inicio", "Vigencia Fin"));
            while ((linea = lector.readLine()) != null) {
                String[] bloques = linea.split(";");
                if (bloques.length > 1) {
                    CentrosInvestigacion centros = new CentrosInvestigacion(bloques[1], bloques[6], bloques[9],bloques[10]);
                    boolean check = centros.getInvestigacion_cientifica()!=null;
                    if(check)
                        s.append(String.format("%-80s|%-40s|%-40s\n", centros.getNombre_institucion(), centros.getVigencia_inicio(), centros.getVigencia_fin()));
                    }
            }
            System.out.println(s);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
        }
    }    
    public void exportarLista(String ruta,int indice){
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta,true));
            try {
                BufferedReader lector = new BufferedReader(new FileReader("D:\\BD Centros de investigacion.txt"));
                String linea="";
                while ((linea = lector.readLine())!=null) {                
                    String[] bloques = linea.split(";");
                    if (bloques.length>1) {
                        switch(indice){
                            case 1 -> {
                                CentrosInvestigacion centros = new CentrosInvestigacion(bloques[1],bloques[2],bloques[3]);
                                escritor.write(centros.getNombre_institucion()+";"+centros.getArea_cientifica()+";"+centros.getSubarea_cientifica());
                                escritor.newLine();
                            }
                            case 2 -> {
                            
                            }
                            case 3 -> {
                                
                            }
                            case 4 ->{
                            
                            }
                        }
                    }
                }
            } catch (IOException e) {
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo "+e.getMessage());
        }
    }
}
