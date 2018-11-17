/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.ListaCircularDoble;

import java.util.Iterator;

/**
 *
 * @author Luis
 */
public class MianListaCircularDoble {
    public static void main(String[] args) throws Exception{
        ListaCircularDoble<Integer> num=new ListaCircularDoble<>();
        ListaCircularDoble<Integer> num2=new ListaCircularDoble<>();
        
        num.addLast(1);
        num.addLast(20);
        num.addLast(30);
        num.addLast(40);
        //num.set(0,69);
        //System.out.println(num.removeFirst());
        //System.out.println(num.removeLast());
        //System.out.println(num.getFirst());
        //System.out.println(num.getLast());
        //System.out.println(num.constains(1));
        //System.out.println(num.get(0));
        //System.out.println(num.indexOf(40));
        //System.out.println(num.removeE(30));
        //System.out.println(num.remove(2));
//        System.out.println(num.insert(3, 69));
//        System.out.println(num.toString());
//        System.out.println(num.size());
        Iterator it = num.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
