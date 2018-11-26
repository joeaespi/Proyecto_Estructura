/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.sistemaTurno;

import espol.edu.ec.tda.Puesto;
import espol.edu.ec.tda.Turno;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
        //se muestran los datos del paciente que sera atendido
        atencionNombre.setText(PantallaPrincipal.TURNO.peek().getPaciente().getNombre());
        atencionApellido.setText(PantallaPrincipal.TURNO.peek().getPaciente().getApellido());
        atencionEdad.setText(String.valueOf(PantallaPrincipal.TURNO.peek().getPaciente().getEdad()));
         
    }    
    @FXML 
    public void atenderPaciente() throws InterruptedException{
        //turnos.poll();
        Pantallas pantalla=new Pantallas();
        //Aqui se verifica que exista algun diagnostico
        if (diagnostico.getText().isEmpty())
            mensajeError.setText("Debe dar un diagnostico");
        
        else if(!PantallaPrincipal.TURNO.isEmpty()){
            // se extrae el turno que sera atendido
            Turno t=PantallaPrincipal.TURNO.poll();
            t.getPaciente().setDiagnostico(diagnostico.getText());
            if (PantallaPrincipal.TURNO.isEmpty()){
                PantallaPrincipal.mensaje.setText("TurnosAtendidos");
                PantallaPrincipal.mostrarTurno.setText("---");
                Pantallas.stagePaciente.close();
                pantalla.pantallaPaciente();
                
            }else{
                //se muestra el proximo turno a atender en pantalla
                PantallaPrincipal.mostrarTurno.setText(String.valueOf(PantallaPrincipal.TURNO.peek().
                        getPaciente().getLetra()+PantallaPrincipal.TURNO.peek().getNumero()));
            PantallaPrincipal.mostrarPuesto.setText(PantallaPrincipal.PUESTO_MEDICO.peek().getNombrePuesto());
            Puesto p=PantallaPrincipal.PUESTO_MEDICO.poll();
           // 
            mensajeError.setTextFill(Color.GREEN);
            PantallaPrincipal.PUESTO_MEDICO.offer(p);
            
            Pantallas.stagePaciente.close();
            }
            
        }
            
        
        
        
        
        
    }
    
}
