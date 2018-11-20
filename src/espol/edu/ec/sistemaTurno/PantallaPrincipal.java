/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.sistemaTurno;




import espol.edu.ec.tda.Puesto;
import espol.edu.ec.tda.Turno;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedList;

import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Luis
 */
public class PantallaPrincipal {
    private final BorderPane root;
    private Label tiempo;
    private ListIterator<String> it;
    private MediaView reproductor;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Parent rootPaciente, rootPuesto,rootAtencion;
    @FXML
    public Stage stageRegistrar,stagePuesto,stagePaciente,stageMenu;
    static final PriorityQueue<Turno> TURNO = new PriorityQueue<>((Turno t1, Turno t2)-> t1.getTipo()-t2.getTipo());
    static final LinkedList<Puesto> PUESTO_MEDICO  = new LinkedList<>();
    
    public PantallaPrincipal() throws InterruptedException {
        root=new BorderPane();
        root.setLeft(crearIzquierda());
        root.setBottom(crearBajo());
        root.setTop(crearArriba());
        root.setCenter(crearDerecha());
        Thread t1=new Thread(new tiempo());
        t1.start();
        
    }
    
    public Pane crearIzquierda(){
        VBox video=new VBox();
      
        video.setStyle("-fx-background-color:#00FF7F");
        video.setAlignment(Pos.CENTER);
        video.setPadding(new Insets(5,5,5,5));
        HBox botones=new HBox();
        botones.setAlignment(Pos.CENTER);
        botones.setPadding(new Insets(5,5,5,5));
        botones.setSpacing(20);
        ListaCircularDoble<String> lista=new ListaCircularDoble<>();
        lista.addLast("src/espol/edu/ec/recursos/files/broma1.mp4");
        lista.addLast("src/espol/edu/ec/recursos/files/broma2.mp4");
        //lista.addLast("src/espol/edu/ec/recursos/perdoname.mp4");
        it=lista.listIterator(0);
        reproductor=this.createMediaView(it);
        reproductor.setFitHeight(300);
        reproductor.setFitWidth(450);
        Button siguiente=new Button("Siguiente");
        siguiente.setOnAction((e)->{
            reproductor.getMediaPlayer().stop();
            File f=new File(it.next());
            MediaPlayer sig=new MediaPlayer(new Media(f.toURI().toString()));
            Platform.runLater(()->{
                reproductor.setMediaPlayer(sig);
                sig.play();
            
            });
            
            //reproductor=this.createMediaView(it);
        });
        
        Button anterior=new Button("Anterior");
        anterior.setOnAction(z->{
            reproductor.getMediaPlayer().stop();
            File f=new File(it.previous());
            MediaPlayer ant=new MediaPlayer(new Media(f.toURI().toString()));
            ant.play();
            reproductor.setMediaPlayer(ant);
        });
        botones.getChildren().addAll(anterior,siguiente);
        video.getChildren().addAll(reproductor,botones);
        return video;
    }

    public Pane getRoot() {
        return root;
    }
    
    public Pane crearBajo(){
        VBox abajo = new VBox();
        abajo.setAlignment(Pos.CENTER);
        abajo.setPadding(new Insets(5,5,5,5));
        HBox botones=new HBox();
        botones.setAlignment(Pos.CENTER);
        Button crearPaciente=new Button("Crear Paciente");
        Button puestoMedico=new Button("Puesto Medico");
        botones.setSpacing(30);
        botones.setPadding(new Insets(5,5,5,5));
        Button atenderTurno=new Button("Atender turno");
        botones.getChildren().addAll(crearPaciente,puestoMedico,atenderTurno);
        abajo.getChildren().add(botones);
        Label mensaje = new Label("Horario de atención de Lunes a Viernes de 10 a 18 Hs/ Sabado y Domingos"
                + "de 10 a 14 hs");
        mensaje.setStyle("-fx-background-color:#66CDAA");
        mensaje.setFont(new Font("Arial Black",12));
        mensaje.setTextFill(Color.web("#FFFFFF"));
        abajo.getChildren().add(mensaje);
        crearPaciente.setOnAction((e)-> {
            try {
                stageRegistrar = new Stage();
                stageRegistrar.setTitle("Registro Pacientes");
                rootPaciente =FXMLLoader.load(getClass().getResource("viewFormulario.fxml"));
                stageRegistrar.setScene(new Scene(rootPaciente));
                stageRegistrar.show();
            } catch (IOException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
});
        puestoMedico.setOnAction((e)->{
            try {
                stagePuesto = new Stage();
                stagePuesto.setTitle("Registrar Puesto");
                rootPuesto =FXMLLoader.load(getClass().getResource("viewPuesto.fxml"));
                stagePuesto.setScene(new Scene(rootPuesto));
                stagePuesto.show();
            } catch (IOException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        atenderTurno.setOnAction((e)->{
            try {
                stagePaciente=new Stage();
                stagePaciente.setTitle("Atencion");
                rootAtencion =FXMLLoader.load(getClass().getResource("viewAtencion.fxml"));
                stagePaciente.setScene(new Scene(rootAtencion));
                stagePaciente.show();
            } catch (IOException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return abajo; 
    }
    
    
    public Pane crearArriba(){
        HBox arriba=new HBox();
        arriba.setPadding(new Insets(5,5,5,5));
        arriba.setAlignment(Pos.CENTER_RIGHT);
        //arriba.setPadding(new Insets(10,10,10,10));
        tiempo=new Label("");
        tiempo.setFont(new Font("Arial Black",25));
        arriba.getChildren().add(tiempo);
        
        return arriba;
        
    }
    
    public Pane crearDerecha(){
        HBox panel=new HBox();
        panel.setSpacing(5);
        panel.setPadding(new Insets(5,5,5,5));
        
        VBox turno=new VBox();
        turno.setSpacing(5);
        
        HBox titulo1=new HBox();
        titulo1.setPrefHeight(100);
        titulo1.setPrefWidth(200);
        titulo1.setAlignment(Pos.CENTER);
        titulo1.setStyle("-fx-background-color:#87CEFA");
        HBox titulo2=new HBox();
        titulo2.setPrefHeight(100);
        titulo2.setPrefWidth(200);
        titulo2.setAlignment(Pos.CENTER);
        titulo2.setStyle("-fx-background-color:#87CEFA");
        
        Label nombreturno=new Label("Turno");
        nombreturno.setFont(new Font("Arial Black",20));
        titulo1.getChildren().add(nombreturno);
        
        
        turno.getChildren().addAll(titulo1,titulo2);
        
        
        
        VBox puesto=new VBox();
        puesto.setSpacing(5);
        
        HBox puesto1=new HBox();
        puesto1.setPrefHeight(100);
        puesto1.setPrefWidth(200);
        puesto1.setAlignment(Pos.CENTER);
        puesto1.setStyle("-fx-background-color:#4682B4");
        HBox puesto2=new HBox();
        puesto2.setPrefHeight(100);
        puesto2.setPrefWidth(200);
        puesto2.setAlignment(Pos.CENTER);
        puesto2.setStyle("-fx-background-color:#4682B4");
        
        Label nombrepuesto=new Label("Puesto");
        nombrepuesto.setFont(new Font("Arial Black",20));
        puesto1.getChildren().add(nombrepuesto);
        puesto.getChildren().addAll(puesto1,puesto2);
        
        
        panel.getChildren().addAll(turno,puesto);
        return panel;
        
    }
    
    public MediaView createMediaView(ListIterator<String> direcciones){
    MediaView mediaView = new MediaView();
    initMediaPlayer(mediaView, direcciones);
    return mediaView;
}

private void initMediaPlayer(final MediaView mediaView, final ListIterator<String>direcciones){
    if (direcciones.hasNext()){
        File f=new File(direcciones.next());
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(f.toURI().toString()));
        mediaPlayer.play();
        mediaPlayer.setOnEndOfMedia(() -> {
            initMediaPlayer(mediaView, direcciones);
        });
        mediaView.setMediaPlayer(mediaPlayer);
        
    } 
}

public class tiempo implements Runnable{

        @Override
        public void run() {
            
            while (true){
                try {
                LocalDateTime l2=LocalDateTime.now();
                Platform.runLater(()->{
                    
                    tiempo.setText(String.valueOf(l2.getHour())+" : "+String.valueOf(l2.getMinute())+" : "+String.valueOf(l2.getSecond()));
                });
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
        }
    
}

    
    
    
    
    
    
    
}
