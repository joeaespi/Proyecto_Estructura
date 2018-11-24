/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.sistemaTurno;

import espol.edu.ec.tda.Medico;
import espol.edu.ec.tda.Paciente;
import espol.edu.ec.tda.Puesto;
import espol.edu.ec.tda.ReaderWriter;
import espol.edu.ec.tda.Turno;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Christian Guerrero
 */
public class Controller_menu implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Parent rootPaciente, rootPuesto,rootAtencion;
    @FXML
    public Stage stageRegistrar,stagePuesto,stagePaciente,stageMenu;
    //static final PriorityQueue<Turno> TURNO = new PriorityQueue<>((Turno t1, Turno t2)-> t1.getTipo()-t2.getTipo());
    //static final LinkedList<Puesto> PUESTO_MEDICO  = new LinkedList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO  colaPaciente = new PriorityQueue<>((Cliente c1, Cliente c2)->(c1.getNivelPrioridad()-c2.getNivelPrioridad()));  
    }
    @FXML
    public  void registrarPaciente() throws IOException{
        stageRegistrar = new Stage();
        stageRegistrar.setTitle("Registro Pacientes");
        rootPaciente =FXMLLoader.load(getClass().getResource("viewFormulario.fxml"));
        stageRegistrar.setScene(new Scene(rootPaciente));
        stageRegistrar.show();        
    }
    @FXML
    public void registrarPuesto() throws IOException{
        stagePuesto = new Stage();
        stagePuesto.setTitle("Registrar Puesto");
        rootPuesto =FXMLLoader.load(getClass().getResource("viewPuesto.fxml"));
        stagePuesto.setScene(new Scene(rootPuesto));
        stagePuesto.show();
    }
    @FXML
    public void atenderPaciente() throws IOException{
        stagePaciente=new Stage();
        stagePaciente.setTitle("Atencion");
        rootAtencion =FXMLLoader.load(getClass().getResource("viewAtencion.fxml"));
        stagePaciente.setScene(new Scene(rootAtencion));
        stagePaciente.show();
    }

    public Stage getStageMenu() {
        return stageMenu;
    }

    public void setStageMenu(Stage stageMenu) {
        this.stageMenu = stageMenu;
    }
   
     
    
}
