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
import java.util.LinkedList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Christian Guerrero
 */

public class Sistema extends Application {
    Stage stageMenu;
    @Override
    public void start(Stage stageMenu) throws Exception {
        Stage videoTurn = new Stage();
                 
        FXMLLoader rootVideo = new FXMLLoader(this.getClass().getResource("ViewTurnos.fxml")); //load(getClass().getResource("ViewTurnos.fxml")); // FXML for second stage
        Parent anotherRoot = rootVideo.load();
        Scene anotherScene = new Scene(anotherRoot);
        videoTurn.setScene(anotherScene);
        videoTurn.show();
        
        Parent root = FXMLLoader.load(getClass().getResource("viewMenu.fxml"));
        Scene scene = new Scene(root);
        stageMenu.setScene(scene);
        stageMenu.show();
        
    }
        
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(Controller_menu.TURNO.size());
        System.out.println(Controller_menu.PUESTO_MEDICO.size());
        launch(args);
        Controller_menu.TURNO.forEach((t1) -> {
            System.out.println(t1);
        });
        System.out.println(Controller_menu.PUESTO_MEDICO.size());


        
    }
}
