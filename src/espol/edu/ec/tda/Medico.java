/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.tda;


/**
 *
 * @author Christian Guerrero
 */
public class Medico {
    private String cedula;
    private String nombre;
    private String apellido;
    private String Profesion;
    private String genero;
    private int edad;
    
    public Medico(String cedula, String nombre,String apellido, String Profesion, String genero, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido=apellido;
        this.Profesion = Profesion;
        this.genero = genero;
        this.edad = edad;
        
    }
    public Medico(String cedula, String nombre,String apellido,String profesion){
        this.cedula=cedula;
        this.nombre=nombre;
        this.apellido=apellido;
        this.Profesion=profesion;
        
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesion() {
        return Profesion;
    }

    public void setProfesion(String Profesion) {
        this.Profesion = Profesion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Medico{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", Profesion=" + Profesion + '}';
    }
    
    
    
    
    
    
            
}
