/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.Modelo;

import java.util.Date;

/**
 *
 * @author Alvaro
 */
public class CentrosInvestigacion {

    private String resolucion; 
    private String nombre_institucion;
    private String area_cientifica; 
    private String subarea_cientifica;
    private String disciplina_cientifica;
    private String fortalezas_del_centro;
    private String investigacion_cientifica;
    private String desarrollo_tecnologico;
    private String innovacion_tecnologica;
    private String vigencia_inicio;
    private String vigencia_fin;
    private String contacto1_nombre;
    private String contacto1_email;
    private String contacto1_telefono;
    private String contacto2_nombre;
    private String contacto2_email;
    private String contacto2_telefono;

    public CentrosInvestigacion(String resolucion, String nombre_institucion, String area_cientifica, String subarea_cientifica, String disciplina_cientifica, String fortalezas_del_centro, String investigacion_cientifica, String desarrollo_tecnologico, String innovacion_tecnologica, String vigencia_inicio, String vigencia_fin, String contacto1_nombre, String contacto1_email, String contacto1_telefono, String contacto2_nombre, String contacto2_email, String contacto2_telefono) {
        this.resolucion = resolucion;
        this.nombre_institucion = nombre_institucion;
        this.area_cientifica = area_cientifica;
        this.subarea_cientifica = subarea_cientifica;
        this.disciplina_cientifica = disciplina_cientifica;
        this.fortalezas_del_centro = fortalezas_del_centro;
        this.investigacion_cientifica = investigacion_cientifica;
        this.desarrollo_tecnologico = desarrollo_tecnologico;
        this.innovacion_tecnologica = innovacion_tecnologica;
        this.vigencia_inicio = vigencia_inicio;
        this.vigencia_fin = vigencia_fin;
        this.contacto1_nombre = contacto1_nombre;
        this.contacto1_email = contacto1_email;
        this.contacto1_telefono = contacto1_telefono;
        this.contacto2_nombre = contacto2_nombre;
        this.contacto2_email = contacto2_email;
        this.contacto2_telefono = contacto2_telefono;
    }
    public CentrosInvestigacion(String nombre_institucion, String area_cientifica){
        this.nombre_institucion = nombre_institucion;
        this.area_cientifica = area_cientifica;
    }
    public CentrosInvestigacion(String nombre_institucion, String vigencia_inicio, String vigencia_fin){
        this.nombre_institucion = nombre_institucion;
        this.vigencia_inicio = vigencia_inicio;
        this.vigencia_fin = vigencia_fin;
    }
    public CentrosInvestigacion(String nombre_institucion, String contacto1_nombre, String contacto1_email, String contacto1_telefono){
        this.nombre_institucion = nombre_institucion;
        this.contacto1_nombre = contacto1_nombre;
        this.contacto1_email = contacto1_email;
        this.contacto1_telefono = contacto1_telefono;
    }
    public CentrosInvestigacion(String nombre_institucion, String disciplina_cientifica, String innovacion_tecnologica, String vigencia_inicio, String vigencia_fin){
        this.nombre_institucion = nombre_institucion;
        this.disciplina_cientifica = disciplina_cientifica;
        this.innovacion_tecnologica = innovacion_tecnologica;
        this.vigencia_inicio = vigencia_inicio;
        this.vigencia_fin = vigencia_fin;
    }
    
    public String getResolucion() {
        return resolucion;
    }
    public String getNombre_institucion() {
        return nombre_institucion;
    }
    public String getArea_cientifica() {
        return area_cientifica;
    }
    public String getSubarea_cientifica() {
        return subarea_cientifica;
    }
    public String getDisciplina_cientifica() {
        return disciplina_cientifica;
    }
    public String getFortalezas_del_centro() {
        return fortalezas_del_centro;
    }
    public String getInvestigacion_cientifica() {
        return investigacion_cientifica;
    }
    public String getDesarrollo_tecnologico() {
        return desarrollo_tecnologico;
    }
    public String getInnovacion_tecnologica() {
        return innovacion_tecnologica;
    }
    public String getVigencia_inicio() {
        return vigencia_inicio;
    }
    public String getVigencia_fin() {
        return vigencia_fin;
    }
    public String getContacto1_nombre() {
        return contacto1_nombre;
    }
    public String getContacto1_email() {
        return contacto1_email;
    }
    public String getContacto1_telefono() {
        return contacto1_telefono;
    }
    public String getContacto2_nombre() {
        return contacto2_nombre;
    }
    public String getContacto2_email() {
        return contacto2_email;
    }
    public String getContacto2_telefono() {
        return contacto2_telefono;
    }
    
    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }
    public void setNombre_institucion(String nombre_institucion) {
        this.nombre_institucion = nombre_institucion;
    }
    public void setArea_cientifica(String area_cientifica) {
        this.area_cientifica = area_cientifica;
    }
    public void setSubarea_cientifica(String subarea_cientifica) {
        this.subarea_cientifica = subarea_cientifica;
    }
    public void setDisciplina_cientifica(String disciplina_cientifica) {
        this.disciplina_cientifica = disciplina_cientifica;
    }
    public void setFortalezas_del_centro(String fortalezas_del_centro) {
        this.fortalezas_del_centro = fortalezas_del_centro;
    }
    public void setInvestigacion_cientifica(String investigacion_cientifica) {
        this.investigacion_cientifica = investigacion_cientifica;
    }
    public void setDesarrollo_tecnologico(String desarrollo_tecnologico) {
        this.desarrollo_tecnologico = desarrollo_tecnologico;
    }
    public void setInnovacion_tecnologica(String innovacion_tecnologica) {
        this.innovacion_tecnologica = innovacion_tecnologica;
    }
    public void setVigencia_inicio(String vigencia_inicio) {
        this.vigencia_inicio = vigencia_inicio;
    }
    public void setVigencia_fin(String vigencia_fin) {
        this.vigencia_fin = vigencia_fin;
    }
    public void setContacto1_nombre(String contacto1_nombre) {
        this.contacto1_nombre = contacto1_nombre;
    }
    public void setContacto1_email(String contacto1_email) {
        this.contacto1_email = contacto1_email;
    }
    public void setContacto1_telefono(String contacto1_telefono) {
        this.contacto1_telefono = contacto1_telefono;
    }
    public void setContacto2_nombre(String contacto2_nombre) {
        this.contacto2_nombre = contacto2_nombre;
    }
    public void setContacto2_email(String contacto2_email) {
        this.contacto2_email = contacto2_email;
    }
    public void setContacto2_telefono(String contacto2_telefono) {
        this.contacto2_telefono = contacto2_telefono;
    }
   
}
