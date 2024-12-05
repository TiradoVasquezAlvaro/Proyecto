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
            s.append(String.format("Reporte de areas cientificas\n"));
            s.append("\n");
            s.append(String.format("%-80s|%-40s\n","Nombre de institucion","Area Cientifica"));
            while ((linea = lector.readLine())!=null) {                
                String[] bloques = linea.split(";");
                if (bloques.length>1) {
                    CentrosInvestigacion centros = new CentrosInvestigacion(bloques[1],bloques[2]);
                    s.append(String.format("%-80s|%-40s\n",centros.getNombre_institucion(),centros.getArea_cientifica()));
                }
            }
            System.out.println(s);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo "+e.getMessage());
        }
    }
    public void listarReporteInvestigacionActiva() throws ParseException {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("D:\\BD Centros de investigacion.txt"));
            StringBuilder s = new StringBuilder();
            String linea = "";
            s.append(String.format("Reporte de Investigaciones activas\n"));
            s.append("\n");
            s.append(String.format("%-80s|%-40s|%-40s\n", "Nombre de institucion", "Vigencia Inicio", "Vigencia Fin"));
            while ((linea = lector.readLine()) != null) {
                String[] bloques = linea.split(";");
                if (bloques.length>1) {
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    CentrosInvestigacion centros = new CentrosInvestigacion(bloques[1], bloques[9],bloques[10]);
                    LocalDateTime hoy = LocalDateTime.now();
                    String fechaHoy = hoy.toString();
                    boolean check = "X".equals(bloques[6]) && formato.parse(centros.getVigencia_fin()).after(formato.parse(fechaHoy));
                    if(check)
                        s.append(String.format("%-80s|%-40s|%-40s\n", centros.getNombre_institucion(), centros.getVigencia_inicio(), centros.getVigencia_fin()));
                    }
            }
            System.out.println(s);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
        }
    }
    public void listarReporteInformacionContacto(){
        try {
            BufferedReader lector = new BufferedReader(new FileReader("D:\\BD Centros de investigacion.txt"));
            StringBuilder s = new StringBuilder();
            String linea = "";
            s.append(String.format("Reporte de Informacion de Contacto\n"));
            s.append("\n");
            s.append(String.format("%-80s|%-40s|%-40s|%-40s\n","Nombre de institucion","Contacto 1 Nombre","Contacto 1 Email", "Contacto 1 Telefono"));
            while ((linea = lector.readLine())!=null) {                
                String[] bloques = linea.split(";");
                if (bloques.length>13) {
                    CentrosInvestigacion centros = new CentrosInvestigacion(bloques[1],bloques[11],bloques[12],bloques[13]);
                    s.append(String.format("%-80s|%-40s|%-40s|%-40s\n",centros.getNombre_institucion(),centros.getContacto1_nombre(),centros.getContacto1_email(), centros.getContacto1_telefono()));
                }else{
                    CentrosInvestigacion centros = new CentrosInvestigacion(bloques[1], bloques[11], bloques[12], "");
                    s.append(String.format("%-80s|%-40s|%-40s|%-40s\n", centros.getNombre_institucion(), centros.getContacto1_nombre(), centros.getContacto1_email(), centros.getContacto1_telefono()));
                }
            }
            System.out.println(s);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo "+e.getMessage());
        }
    }
    public void listarReporteInnovacion() throws ParseException {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("D:\\BD Centros de investigacion.txt"));
            StringBuilder s = new StringBuilder();
            String linea = "";
            s.append(String.format("Reporte de Innovaciones tecnologicas\n"));
            s.append("\n");
            s.append(String.format("%-80s|%-50s|%-30s|%-30s|%-30s\n", "Nombre de institucion", "Disciplina cientifica","Innovacion tecnologica","Vigencia Inicio", "Vigencia Fin"));
            while ((linea = lector.readLine()) != null) {
                String[] bloques = linea.split(";");
                if (bloques.length>1) {
                    CentrosInvestigacion centros = new CentrosInvestigacion(bloques[1],bloques[4], bloques[8], bloques[9],bloques[10]);
                    boolean check = "X".equals(bloques[8]);
                    if(check)
                        s.append(String.format("%-80s|%-50s|%-30s|%-30s|%-30s\n", centros.getNombre_institucion(), centros.getDisciplina_cientifica(),centros.getInnovacion_tecnologica(),centros.getVigencia_inicio(), centros.getVigencia_fin()));
                    }
            }
            System.out.println(s);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
        }
    }
    public void exportarLista(String ruta,int indice) throws ParseException{
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
                                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                                CentrosInvestigacion centros = new CentrosInvestigacion(bloques[1], bloques[9], bloques[10]);
                                LocalDateTime hoy = LocalDateTime.now();
                                String fechaHoy = hoy.toString();
                                boolean check = "X".equals(bloques[6]) && formato.parse(centros.getVigencia_fin()).after(formato.parse(fechaHoy));
                                if (check) {
                                   escritor.write(centros.getNombre_institucion()+";"+centros.getVigencia_inicio()+";"+centros.getVigencia_fin());
                                   escritor.newLine();
                                }
                            }
                            case 3 -> {
                                if (bloques.length>13) {
                                    CentrosInvestigacion centros = new CentrosInvestigacion(bloques[1], bloques[11], bloques[12], bloques[13]);
                                    escritor.write(centros.getNombre_institucion() + ";" + centros.getContacto1_nombre() + ";" + centros.getContacto1_email() + ";" + centros.getContacto1_telefono());
                                    escritor.newLine();
                                }else{
                                    CentrosInvestigacion centros = new CentrosInvestigacion(bloques[1], bloques[11], bloques[12], "");
                                    escritor.write(centros.getNombre_institucion() + ";" + centros.getContacto1_nombre() + ";" + centros.getContacto1_email() + ";" + centros.getContacto1_telefono());
                                    escritor.newLine();
                                }
                            }
                            case 4 ->{
                                CentrosInvestigacion centros = new CentrosInvestigacion(bloques[1], bloques[4], bloques[8], bloques[9], bloques[10]);
                                boolean check = "X".equals(bloques[8]);
                                if (check) {
                                    escritor.write(centros.getNombre_institucion()+";"+centros.getDisciplina_cientifica()+";"+centros.getInnovacion_tecnologica()+";"+centros.getVigencia_inicio()+";"+centros.getVigencia_fin());
                                }
                            }
                        }
                    }
                }
                lector.close();
            } catch (IOException e) {
                System.out.println("Error al leer el archivo "+e.getMessage());
            }
            escritor.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo "+e.getMessage());
        }
    }
}
