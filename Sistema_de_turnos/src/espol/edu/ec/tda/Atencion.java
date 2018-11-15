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
public enum Atencion {
    /**
    *Tipo de atencion con prioridad alta
    */
    Alta(0, "A"),
    /**
    *Tipo de atencion con prioridad media
    */
    Alta_medio(1, "B"),
    /**
    *Tipo de atencion
    */
    Alta_normal(2, "C"),
    /**
    *Tipo de atencion
    */
    Bajo(3, "D"),
    /**
    *Tipo de atencion
    */
    normal(4, "E"),
    /**
    *Tipo de atencion
    */
    muy_baja(5, "F");

    
    private final int prioridad;
    private final String tipo;
    //private final String name;
    Atencion(int prioridad, String tipo) {
        this.prioridad = prioridad;
        this.tipo = tipo;
    }
    
    public int getPrioridad(){
        return prioridad;
    }
    
    public String getTipo(){
        return tipo;
    }
//    
//    @Override
//   // public String toString() {
//        return name;
//    }
}
