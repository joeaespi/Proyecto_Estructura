/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.moduloInstrucciones;

import espol.edu.ec.tda.Instruccion;
import espol.edu.ec.tda.Operandos;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

/**
 *
 * @author cjgue
 */
public class PaneAdmin {
   PriorityQueue<Instruccion> instrucciones = new PriorityQueue<>((Instruccion t1, Instruccion t2)->t1.getPrioridad()- t2.getPrioridad());
   LinkedList<Operandos> OPERACIONES=Operandos.leerOperandos();
   LinkedList<Instruccion> INSTRUCCIONES=Instruccion.leerInstrucciones();
    AnchorPane _root ;
   Label mensaje;
    public PaneAdmin() {
        instrucciones.addAll(INSTRUCCIONES);
        _root = new AnchorPane();
        mensaje = new Label();
        mensaje.setTextFill(Color.BLUE);
        mensaje.setLayoutX(100);
        mensaje.setText("Pila Interactiva");
        _root.getChildren().add(mensaje);
    }

    public AnchorPane getRoot() {
        return _root;
    }

    public void AnchorPane(AnchorPane _root) {
        this._root = _root;
    }
    public void ejercutarInstrucciones(){
        Deque<Integer> pila = new LinkedList<>();
        while (!instrucciones.isEmpty()) {
                Instruccion in = instrucciones.poll();
                pila.push(in.getOperando().getValor());
               
        }
        System.out.println(pila);
    }
    
    
}
