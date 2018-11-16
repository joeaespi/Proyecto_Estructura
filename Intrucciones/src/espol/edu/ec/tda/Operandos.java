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
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cjgue
 */
public class Operandos {
    
    private String dirMemoria;
    private int valor;
    private Instruccion Dinstruccion;

    public Operandos(String dirMemoria, int valor) {
        this.dirMemoria = dirMemoria;
        this.valor = valor;
    }

    public String getDirMemoria() {
        return dirMemoria;
    }

    public void setDirMemoria(String dirMemoria) {
        this.dirMemoria = dirMemoria;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Operandos{" + "dirMemoria=" + dirMemoria + ", valor=" + valor + '}';
    }
    
    public static LinkedList<Operandos> leerOperandos(){
        LinkedList<Operandos> nueva = new LinkedList<>();
        String file = "src/espol/edu/ec/files/memoria.txt";
        try(BufferedReader bf = new BufferedReader(new FileReader(file))){
            String linea=null;
            while ((linea = bf.readLine())!=null) {
                String[] separador = linea.split("\\|");
                nueva.add(new Operandos(separador[0],Integer.parseInt(separador[1])));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("error IOException");
        }
        return nueva;
        
    }
    public static LinkedList<Operandos> leerDireccion(String direccion){
        LinkedList<Operandos> nueva = new LinkedList<>();
        String file = "src/espol/edu/ec/files/memoria.txt";
        try(BufferedReader bf = new BufferedReader(new FileReader(file))){
            String linea=null;
            while ((linea = bf.readLine())!=null) {
                String[] separador = linea.split("\\|");
                if(separador[0].equals(direccion)){
                nueva.add(new Operandos(separador[0],Integer.parseInt(separador[1])));
                }
            }
        }catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("error IOException");
        }
        return nueva;
        
    }
}
