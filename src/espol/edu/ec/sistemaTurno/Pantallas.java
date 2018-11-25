/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.sistemaTurno;

import espol.edu.ec.tda.Puesto;
import espol.edu.ec.tda.Turno;
import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author EVOTEC
 */
public class Pantallas {
    @FXML
    private AnchorPane rootPane;
    @FXML
    private FXMLLoader rootPaciente, rootPuesto,rootAtencion;
    @FXML
    static Stage stageRegistrar,stagePuesto,stagePaciente,stageMenu;
    
   public Pantallas(){
       
   }
    
    public void pantallaPaciente(){
        try {
                stageRegistrar = new Stage();
                stageRegistrar.setTitle("Registro Pacientes");
                rootPaciente =new FXMLLoader(this.getClass().getResource("viewFormulario.fxml"));
                stageRegistrar.setScene(new Scene(rootPaciente.load()));
                stageRegistrar.show();
            } catch (IOException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void pantallaMedico(){
        try {
                stagePuesto = new Stage();
                stagePuesto.setTitle("Registrar Puesto");
                rootPuesto=new FXMLLoader(this.getClass().getResource("viewPuesto.fxml"));
                stagePuesto.setScene(new Scene(rootPuesto.load()));
                stagePuesto.show();
            } catch (IOException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void pantallaAtencion(){
        try {
                stagePaciente=new Stage();
                stagePaciente.setTitle("Atencion");
                rootAtencion =new FXMLLoader(this.getClass().getResource("viewAtencion.fxml"));
                stagePaciente.setScene(new Scene(rootAtencion.load()));
                stagePaciente.show();
            } catch (IOException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
}
