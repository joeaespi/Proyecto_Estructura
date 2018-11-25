/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.tda;

import espol.edu.ec.ListaCircularDoble.ListaCircularDoble;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian Guerrero
 */
public class ReaderWriter {
    public static List<String> leerSintomas(String nombreSintoma){
        String filename ="src/espol/edu/ec/recursos/files/sintomas.txt";
        List<String> sintomas=new LinkedList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String linea;
            while((linea=br.readLine())!=null){
                String[] info =linea.split("\\|");
                if(info[0].equals(nombreSintoma)){
                    sintomas.add(info[1]);
                    sintomas.add(info[2]);
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sintomas;
    }
    public static  List<String> cargarSintomas(){
        List<String> lista = new LinkedList<>();
        String filename ="src/espol/edu/ec/recursos/files/sintomas.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String linea=null;
            while((linea=br.readLine())!=null){
                String[] info =linea.split("\\|");
                lista.add(info[0]);
            }
            //return lista;
        } catch (IOException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    public static LinkedList<Paciente> leerCliente(){
        String filename ="src/espol/edu/ec/recursos/files/formulario.txt";
        LinkedList<Paciente> pacientes = new LinkedList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String linea;
            while((linea=br.readLine())!=null){
                
                String[] data =linea.split(",");
                List<String> s=leerSintomas(data[4]);
                pacientes.add(new Paciente(data[0],data[1],data[2],Integer.parseInt(data[3]),data[4],Integer.valueOf(s.get(0)),s.get(1)));
            }
        } catch (IOException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pacientes;
    }
    
    public static ListaCircularDoble<String> leerVideos(){
        ListaCircularDoble<String> video=new ListaCircularDoble();
        try(BufferedReader br = new BufferedReader(new FileReader("src/espol/edu/ec/recursos/files/videos.txt"))){
            String linea;
            while((linea=br.readLine())!=null){
                video.addLast(linea);
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return video;
    }
    
}
