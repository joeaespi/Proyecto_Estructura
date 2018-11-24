/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.tda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian Guerrero
 */
public class Paciente {
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String sintoma;
    private int nivelPrioridad;
    private String diagnostico;

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Paciente(String nombre, String apellido,String genero,int edad, String sintoma,int nivel) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.sintoma = sintoma;
        this.nivelPrioridad =nivel; 
    }
    public Paciente(String nombre,String apellido,String genero,String sintoma){
        this.nombre=nombre;
        this.apellido=apellido;
        this.genero=genero;
        this.sintoma=sintoma;
    }

    public int getNivelPrioridad() {
        return nivelPrioridad;
    }

    public void setNivelPrioridad(int nivelPrioridad) {
        this.nivelPrioridad = nivelPrioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", genero=" + genero + ", sintoma=" + sintoma + ", nivelPrioridad=" + nivelPrioridad + '}';
    }
    
    
    
    
}
