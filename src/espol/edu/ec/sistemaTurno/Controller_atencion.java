/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.sistemaTurno;

import espol.edu.ec.tda.Atencion;
import espol.edu.ec.tda.Puesto;
import espol.edu.ec.tda.Turno;
import java.net.URL;
import java.util.PriorityQueue;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Christian Guerrero
 */
public class Controller_atencion implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private TextField atencionNombre, atencionApellido, atencionEdad;
    @FXML private TextArea diagnostico;
    @FXML private Label mensajeError;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        atencionNombre.setText(PantallaPrincipal.TURNO.peek().getPaciente().getNombre());
        atencionApellido.setText(PantallaPrincipal.TURNO.peek().getPaciente().getApellido());
        atencionEdad.setText(String.valueOf(PantallaPrincipal.TURNO.peek().getPaciente().getEdad()));
       
        
        
        
    }    
    @FXML 
    public void atenderPaciente() throws InterruptedException{
        //turnos.poll();
        if (diagnostico.getText().isEmpty())
            mensajeError.setText("Debe dar un diagnostico");
        
        else if(!PantallaPrincipal.TURNO.isEmpty()){
            
            Turno t=PantallaPrincipal.TURNO.poll();
            t.getPaciente().setDiagnostico(diagnostico.getText());
            PantallaPrincipal.mostrarTurno.setText(PantallaPrincipal.TURNO.peek().getNumero());
            PantallaPrincipal.mostrarPuesto.setText(PantallaPrincipal.PUESTO_MEDICO.peek().getNombrePuesto());
            Puesto p=PantallaPrincipal.PUESTO_MEDICO.poll();
           // 
            mensajeError.setTextFill(Color.GREEN);
            PantallaPrincipal.PUESTO_MEDICO.offer(p);

            Platform.runLater(()->{
                mensajeError.setText("Turno Atendido");
            });
            
            Thread.sleep(2000);
            PantallaPrincipal.stagePaciente.close();
        }
            
        
        
        
        
        
    }
    
}
