/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.tda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cjgue
 */
public class Instruccion {
    private String instrucciones;
    private Operandos operando;
    private int prioridad;
    private LinkedList<Operandos> operation;

    public Instruccion(String instrucciones,LinkedList<Operandos> operando, int prioridad) {
        this.instrucciones = instrucciones;
        this.operation = operando;
        this.prioridad = prioridad;
    }

    public LinkedList<Operandos> getOperation() {
        return operation;
    }

    public void setOperation(LinkedList<Operandos> operation) {
        this.operation = operation;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public Operandos getOperando() {
        return operando;
    }

    public void setOperando(Operandos operando) {
        this.operando = operando;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "Instruccion{" + "instrucciones=" + instrucciones +  ", prioridad=" + prioridad + ", operation=" + operation + '}';
    }
    
      public static LinkedList<Instruccion> leerInstrucciones(){
        LinkedList<Instruccion> nueva = new LinkedList<>();
        LinkedList<Operandos> operandos = Operandos.leerOperandos();
        String file = "src/espol/edu/ec/files/instrucciones.txt";
        try(BufferedReader bf = new BufferedReader(new FileReader(file))){
            String linea=null;
            while ((linea = bf.readLine())!=null) {
                String[] separador = linea.split("\\|");
                nueva.add(new Instruccion(separador[0],Operandos.leerDireccion(separador[1]),Integer.parseInt(separador[2])));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("error IOException");
        }
        return nueva;
        
    }
      public static void escribirMemoria(int numero){
          String file = "src/espol/edu/ec/files/memoria.txt";
          try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))){
              bw.write("\nX|"+numero);
          } catch (IOException ex) {
            Logger.getLogger(Instruccion.class.getName()).log(Level.SEVERE, null, ex);
        }
          
      }
    
}
