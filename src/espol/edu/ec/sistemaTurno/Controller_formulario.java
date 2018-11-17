/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.sistemaTurno;

import espol.edu.ec.tda.Paciente;
import espol.edu.ec.tda.ReaderWriter;
import espol.edu.ec.tda.Turno;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class Controller_formulario implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField nombres,apellidos,genero,sintomas,edad;
    @FXML
    private Label lnombre,lapellido,lgenero,lsintomas,mensaje;
    int num =0;
    ArrayList<String> arreglo= new ArrayList<>();
    @FXML
    
    private ComboBox combSintomas;
    private ObservableList<String> opciones ;
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        combSintomas.getItems().addAll(ReaderWriter.cargarSintomas());
        
        

    }    
    
    @FXML
    public void buttonAceptar() throws IOException, InterruptedException{
        if(nombres.getText().equals("")||apellidos.getText().equals("")||genero.getText().equals("")||sintomas.getText().equals("")||edad.getText().equals("")){
            mensaje.setTextFill(Color.BLUE);
            mensaje.setText("Campos Obligatorios!!");
            return;
        } 
        BufferedWriter output=null;
        FileWriter fw =null;
        Turno turnos;
        try{
            File file = new File("src/espol/edu/ec/recursos/files/formulario.txt");
            output = new BufferedWriter(new FileWriter(file.getAbsolutePath(),true));
            output.write(nombres.getText()+","+apellidos.getText()+","+genero.getText()+","+edad.getText()+","+(String)combSintomas.getValue());
            output.newLine();
            mensaje.setTextFill(Color.BLACK);
            mensaje.setText("Registrado...");
            turnos = new Turno(String.valueOf(num++), new Paciente(nombres.getText(),apellidos.getText(), genero.getText(),(String)combSintomas.getValue()));
            Controller_menu.TURNO.offer(turnos);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                if(output!=null)
                    output.close();
                if(fw!=null)
                    fw.close();
            }catch(IOException e){
                e.getMessage();
            }
        }
    }
    public void generarCola(){
            
    }
    private void selectBox(ActionEvent e){
        combSintomas.getValue();
    }
    
      
    @FXML
    public void buttonBorrar(){
        nombres.setText("");
        apellidos.setText("");
        genero.setText("");
        sintomas.setText("");
        edad.setText("");
        mensaje.setText("");
    }
    
    
}
