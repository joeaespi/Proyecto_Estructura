/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.tda;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Christian Guerrero
 */
public class Puesto {
    private Medico medico;
    private String nombre, cedula;
    private Paciente paciente;
    private Turno  turno;
    private int contadorPacientes;
    public Puesto(){
    contadorPacientes=0;
    }
    
    public Puesto(Medico medico) {
        this.nombre = medico.getNombre();
        this.cedula=medico.getCedula();
        contadorPacientes++;
    }
//    public Puesto agregarPuesto(Medico medico){
//        
//    }
    public Puesto asginarPuesto(Medico medico){
        Puesto puesto = new Puesto(medico);
        return puesto;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Puesto{" + "medico=" + medico + ", nombre=" + nombre + ", cedula=" + cedula + ", turno=" + turno + ", contadorPacientes=" + contadorPacientes + '}';
    }
    
    
}
