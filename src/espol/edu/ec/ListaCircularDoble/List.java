/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.ListaCircularDoble;

/**
 *
 * @author Luis
 */
public interface List <E> {
    boolean addFirst(E elements);
    boolean addLast(E elements);
    boolean removeFirst();
    boolean removeLast();
    E getFirst() throws Exception;
    E getLast()throws Exception;
    boolean constains(E elements);
    boolean insert(int index,E elements) throws Exception;
    E get(int i)throws Exception;
    int indexOf(E element) throws Exception;
    boolean isEmpty();
    E remove(int index) throws Exception;
    boolean removeE(E element)throws Exception;
    E set(int index, E element)throws Exception;
    int size();
    //boolean remove(int index) throws Exception;
    //List<E> slicing(int start, int end)throws Exception;
    //List<E> reverse()throws Exception;
    
}
