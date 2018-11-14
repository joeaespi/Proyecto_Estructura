/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.sistemaTurno;

import espol.edu.ec.tda.Atencion;
import espol.edu.ec.tda.Turno;
import java.net.URL;
import java.util.PriorityQueue;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Christian Guerrero
 */
public class Controller_atencion implements Initializable {

    /**
     * Initializes the controller class.
     */
    PriorityQueue<Turno> turnos;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        turnos = new PriorityQueue<>((Turno t1, Turno t2)-> 
        t1.getPaciente().getNivelPrioridad()-t2.getPaciente().getNivelPrioridad());
    }    
    @FXML 
    public void atenderPaciente(){
        turnos.poll();
    }
    
}
