/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.tda;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Christian Guerrero
 */
public class Puesto {
    private Medico medico;
    private String nombrePuesto;
    private String nombre, cedula;
    private List<Paciente> pacientes;
    private Turno  turno;
    private int contadorPacientes;
    
    public Puesto(Medico medico,String nombrePuesto) {
        this.nombre = medico.getNombre();
        this.cedula=medico.getCedula();
        this.nombrePuesto=nombrePuesto;
    }
//    public Puesto agregarPuesto(Medico medico){
//        
//    }
    /*public Puesto asginarPuesto(Medico medico,String nombrePuesto){
        Puesto puesto = new Puesto(medico);
        return puesto;
    }*/

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    @Override
    public String toString() {
        return "Puesto{" + "medico=" + medico + ", nombre=" + nombre + ", cedula=" + cedula + ", turno=" + turno + ", contadorPacientes=" + contadorPacientes + '}';
    }
    
    
}
