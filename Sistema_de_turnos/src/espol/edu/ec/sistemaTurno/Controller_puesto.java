/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.sistemaTurno;

import espol.edu.ec.tda.Medico;
import espol.edu.ec.tda.Puesto;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
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
    TextField cedula,nombre,apellido,profesion;
    @FXML
    Label mensaje,cantPuestos;
    Puesto puesto;
    @FXML 
    ComboBox cantidadBox;
    
    //LinkedList<Puesto> puestoMedicos;
    int contador =0;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //puesto = new Puesto();
        //puestoMedicos=new LinkedList<>();
        cantPuestos.setText(String.valueOf(Controller_menu.PUESTO_MEDICO.size()));
        cantidadBox.getItems().addAll(Controller_menu.PUESTO_MEDICO);
    }    

    public Controller_puesto() {
    }
    @FXML
    public void registrarPuesto() throws InterruptedException{
       if(cedula.getText().equals("")||nombre.getText().equals("")){
            mensaje.setTextFill(Color.BLUE);
            mensaje.setText("Campos Obligatorios!!");
            return;
        }
            Controller_menu.PUESTO_MEDICO.addLast(new Puesto(new Medico(cedula.getText(),nombre.getText(),apellido.getText(),profesion.getText())));
            contador++;
            this.cantPuestos.setText(String.valueOf(Controller_menu.PUESTO_MEDICO.size()));
            cantidadBox.getItems().clear();
            cantidadBox.getItems().addAll(Controller_menu.PUESTO_MEDICO);
            mensaje.setText("Registro completo");
    }
    
    @FXML
    public void crearPuesto(){
        Puesto puesto = new Puesto();
        Controller_menu.PUESTO_MEDICO.add(puesto);
        cantPuestos.setText(String.valueOf(Controller_menu.PUESTO_MEDICO.size()));
        cantidadBox.getItems().clear();

    }
    public void borrarPuesto(int numero){
        Controller_menu.PUESTO_MEDICO.remove(numero);
        cantPuestos.setText(String.valueOf(Controller_menu.PUESTO_MEDICO.size()-1));

    }
    public void setMedico(){
        Medico medic = new Medico(cedula.getText(), nombre.getText(), apellido.getText(), profesion.getText());
        Controller_menu.PUESTO_MEDICO.set(2, new Puesto(medic));
        cantidadBox.getItems().clear();
        cantidadBox.getItems().addAll(Controller_menu.PUESTO_MEDICO);
    }
}
