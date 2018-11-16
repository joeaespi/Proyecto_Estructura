/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.moduloInstrucciones;

import espol.edu.ec.tda.Instruccion;
import espol.edu.ec.tda.Operandos;
import espol.edu.ec.tda.tipoInstruccion;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author cjgue
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        PaneAdmin pane = new PaneAdmin();
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        AnchorPane mn = new AnchorPane();
        Scene scene = new Scene(pane.getRoot(), 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
   
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        launch(args);
//            PaneAdmin pane = new PaneAdmin();
//            pane.ejercutarInstrucciones();
//            
            PriorityQueue<Instruccion> instrucciones = new PriorityQueue<>((Instruccion t1, Instruccion t2)->t1.getPrioridad()- t2.getPrioridad());
            LinkedList<Operandos> OPERACIONES=Operandos.leerOperandos();
            LinkedList<Instruccion> INSTRUCCIONES=Instruccion.leerInstrucciones();
            Deque<Integer> pila = new LinkedList<>();
            instrucciones.addAll(INSTRUCCIONES);
            tipoInstruccion key;
            while(!instrucciones.isEmpty()){
                Instruccion in = instrucciones.poll();
                System.out.println(in);
                switch(in.getInstrucciones()){
                    case "PUSH":
                        pila.push(in.getOperation().getFirst().getValor());
                        break;
                    case "ADD":
                        int a = pila.pop();
                        int b = pila.pop();
                        pila.push(a+b);
                        break;
                    case "MUL":
                        int c = pila.pop();
                        int d = pila.pop();
                        pila.push(c*d);
                        break;
                    case "DIV":
                        int e = pila.pop();
                        int f = pila.pop();
                        if(f==0)
                            System.out.println("Division para cero");                           
                        pila.push(e/f);
                        break;
//                    case "POP": esto hace escrbir en el archivo.txt
//                        Instruccion.escribirMemoria(pila.pop());
//                        break;
                        
                       

                }
//                }if(in.getInstrucciones().equals("POP"))
//                    pila.pop();
                
            }
            for(Integer i: pila){
                System.out.println(i);
            }
          
             
            
            
    }
    
}
