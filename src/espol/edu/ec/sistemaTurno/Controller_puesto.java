/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.sistemaTurno;

import espol.edu.ec.tda.Medico;
import espol.edu.ec.tda.Puesto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Christian Guerrero
 */
public class Controller_puesto implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField cedula,nombre,apellido,profesion,genero,namePuesto;
    @FXML
    Label mensaje,cantPuestos;
    Puesto puesto;
    //LinkedList<Puesto> puestoMedicos;
    int contador =0;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //puesto = new Puesto();
        //puestoMedicos=new LinkedList<>();
        cantPuestos.setText(String.valueOf(PantallaPrincipal.PUESTO_MEDICO.size()));
        
    }    

    public Controller_puesto() {
    }
    @FXML
    public void registrarPuesto() throws InterruptedException{
        //En esta seccion se pueden crear nuevos puestos
       if(cedula.getText().isEmpty()||nombre.getText().isEmpty() || apellido.getText().isEmpty()|| profesion.getText().isEmpty()|| namePuesto.getText().isEmpty()){
            mensaje.setTextFill(Color.RED);
            mensaje.setText("Existen campos en blanco!!!");
            //return;
        }else{
           PantallaPrincipal.PUESTO_MEDICO.add(new Puesto(new Medico(cedula.getText(),nombre.getText(),apellido.getText(),profesion.getText()),namePuesto.getText()));
            contador++;
            this.cantPuestos.setText(String.valueOf(PantallaPrincipal.PUESTO_MEDICO.size()));
            mensaje.setTextFill(Color.GREEN);
            mensaje.setText("Registro completo");
       }
            
    }
    @FXML
    public void borrarCampos(){
        cedula.setText("");
        apellido.setText("");
        nombre.setText("");
        profesion.setText("");
        genero.setText("");
        mensaje.setText("");
        namePuesto.setText("");
    }
    
    
    
    
    
}
