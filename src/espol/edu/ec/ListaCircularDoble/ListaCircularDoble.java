/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.ListaCircularDoble;

import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author Luis
 */
public class ListaCircularDoble<E> implements List<E>, Iterable<E> {
    private Node<E> last;
    private int efectivo;
    
    ListaCircularDoble(){
        this.last=null;
        this.efectivo=0;
    }

    @Override
    public boolean addFirst(E elements) {
        Node<E> nodo=new Node<>(elements);
        if (elements==null)
            return false;
        else if(isEmpty()){
            last=nodo;
            last.setNext(nodo);
            last.setPrevious(nodo);
            efectivo++;
            return true;
        }
        else{
            Node<E> tmp=last.getNext();
            last.setNext(nodo);
            tmp.setPrevious(nodo);
            nodo.setPrevious(last);
            nodo.setNext(tmp);
            efectivo++;
            return true;
        }
    }

    @Override
    public boolean addLast(E elements) {
        Node<E> nodo=new Node<>(elements);
        if (elements==null)
            return false;
        else if(isEmpty()){
            last=nodo;
            last.setNext(nodo);
            last.setPrevious(nodo);
            efectivo++;
            return true;
            
        }
        else{
            
            Node<E> tmp=last.getNext();
            last.setNext(nodo);
            tmp.setPrevious(nodo);
            nodo.setPrevious(last);
            nodo.setNext(tmp);
            last=nodo;
            efectivo++;
            return true;
            
        }
        }

    @Override
    public boolean removeFirst() {
        if(isEmpty())
            return false;
        else if(efectivo==1){
            last=null;
            return true;
        }
        else{
            Node<E> tmp=last.getNext().getNext();
            last.getNext().setNext(null);
            tmp.setPrevious(last);
            last.setNext(tmp);
            efectivo--;
            return true;
            
            
        }
            
        
        
    }

    @Override
    public boolean removeLast() {
        if(isEmpty())
            return false;
        else if (efectivo==1){
            last=null;
            return true;
        }
            
        
        else{
            Node<E> tmp=last.getPrevious();
            tmp.setNext(last.getNext());
            last.getNext().setPrevious(tmp);
            last.setNext(null);
            last=tmp;
            efectivo--;
            return true;
            
        }
    }

    @Override
    public E getFirst() throws Exception {
        return last.getNext().getData();
    }

    @Override
    public E getLast() throws Exception {
        return last.getData();
    }

    @Override
    public boolean constains(E elements) {
        if (isEmpty())
            return false;
        else if (last==last.getNext())
            return last.getData().equals(elements);
        else{
            Node<E> nodo=last.getNext();
            do{
                if(nodo.getData().equals(elements))
                    return true;
                nodo=nodo.getNext();
            }while(nodo!=last.getNext());
        }
        return false;
    }

    @Override
    public boolean insert(int index, E elements) throws Exception {
        Node<E> nuevo=new Node<>(elements);
        if (index<0 || index>=efectivo || elements==null)
            throw new Exception("Ha ocurrido un problema con algun dato");
        else if(isEmpty())
            return false;
        else if(index==0)
            return this.addFirst(elements);
        else{
            int cont=0;
            Node<E> nodo=last.getNext();
            do{
                if(cont==index-1){
                    Node<E> tmp=nodo.getNext();
                    nodo.setNext(nuevo);
                    nuevo.setNext(tmp);
                    tmp.setPrevious(nuevo);
                    nuevo.setPrevious(nodo);
                    efectivo++;
                    return true;
                }
                nodo=nodo.getNext();
                cont+=1;
                    
            }while(nodo!=last.getNext());
        }
        return false;
    }

    @Override
    public E get(int i) throws Exception {
        if(i<0 || i>=efectivo)
            throw new Exception("El indice es incorrecto");
        else if(i==0)
            return this.getFirst();
        else if(i==efectivo-1)
            return this.getLast();
        else{
            Node<E> nodo=last.getNext().getNext();
            int cont=1;
            do{
                if(cont==i)
                    return nodo.getData();
                nodo=nodo.getNext();
                cont+=1;
            }while(nodo!=last);
        }
        return null;
    }

    @Override
    public int indexOf(E element) throws Exception {
        if(element==null)
            throw new Exception("El elemento no puede ser nulo");
        else if(isEmpty())
            throw new Exception("La lista esta vacia");
        else if(!this.constains(element))
            throw new Exception("El elemento no esta en la lista");
        else if(last.getNext().getData().equals(element))
            return 0;
        else if(last.getData().equals(element))
            return efectivo-1;
        else{
            int cont=1;
            Node<E> nodo=last.getNext().getNext();
            do{
               if(nodo.getData().equals(element))
                   return cont;
               cont+=1;
               nodo=nodo.getNext();
            }while(nodo!=last);
        }
        return 0;
    }

    @Override
    public boolean isEmpty() {
       return last==null;
    }

    @Override
    public E remove(int index) throws Exception {
        if(index<0 || index>=efectivo)
            throw new Exception("El indice esta fuera de rango");
        else if(index==0){
            E elm=last.getNext().getData();
            this.removeFirst();
            return elm;
        }
            
        else if(index==efectivo-1){
            E elm=last.getData();
            this.removeLast();
            return elm;
        }
            
        else {
            int cont=0;
            Node<E> nodo=last.getNext();
            do{
                if (cont==index-1){
                    E elm=nodo.getNext().getData();
                    Node<E> tmp=nodo.getNext().getNext();
                    nodo.getNext().setNext(null);
                    nodo.getNext().setPrevious(null);
                    nodo.setNext(tmp);
                    tmp.setPrevious(nodo);
                    efectivo--;
                    return elm;
                
                }
                cont+=1;
                nodo=nodo.getNext();
                    
                
            }while(nodo!=last);
        }
        return null;
    }

    @Override
    public boolean removeE(E element) throws Exception {
        if(element == null)
            return false;
        else if(isEmpty())
            return false;
            
        else if(efectivo==1)
            return this.removeLast();
            
        else if(last.getNext().getData().equals(element))
            return this.removeFirst();
        else if (last.getData().equals(element))
            return this.removeLast();
        else{
            Node<E> nodo=last.getNext();
            do{
                
                if (nodo.getNext().getData().equals(element)){
                    
                    Node<E> tmp=nodo.getNext().getNext();
                    nodo.getNext().setNext(null);
                    nodo.getNext().setPrevious(null);
                    nodo.setNext(tmp);
                    tmp.setPrevious(nodo);
                    
                    
                    efectivo--;
                    return true;
                }
                nodo=nodo.getNext();
                    
                
            }while(nodo!=last);
        }
        return false;
    }

    @Override
    public E set(int index, E element) throws Exception {
        if(index<0||index>=efectivo || element==null)
            throw new Exception("Ha ocurrido un error con algun dato");
        else if (index==0){
            last.getNext().setData(element);
            return last.getNext().getData();
        }
        else if(index==efectivo-1){
            last.setData(element);
            return last.getData();
            
        }else{
            int cont=1;
            Node<E> nodo=last.getNext().getNext();
            do{
                if (cont==index){
                    nodo.setData(element);
                    return nodo.getData();
                }
                cont+=1;
                nodo=nodo.getNext();
      
            }while(nodo!=last);
        }
        return null;
    }

    @Override
    public int size() {
        return efectivo;
    }
    
    public String toString(){
        StringBuilder s=new StringBuilder("[");
        Node<E> i=last.getNext();
        do{
            s.append(i.getData());
            if(i!=last)
              s.append(",");
            i=i.getNext();
            
        }while(i!=last.getNext());
        
        s.append("]");
        return s.toString();
    }
    
    public boolean equals(Object o){
        if (o==null || !(o instanceof ListaCircularDoble))
            return false;
        ListaCircularDoble<E> other=(ListaCircularDoble<E>)o;
        if (this.efectivo!=other.efectivo)
            return false;
        Node<E> i=this.last.getNext();
        Node<E> j=other.last.getNext();
        do{
            if(i.getData()!=j.getData())
                return false;
            i=i.getNext();
            j=j.getNext();
        }while(i!=last.getNext());
        return true;
        
    }

    @Override
    public Iterator<E> iterator() {
        Iterator it= new Iterator() {
            Node<E> current = last.getNext();
            @Override
            public boolean hasNext() {
                return current!=null;
            }

            @Override
            public E next() {
                E data = current.getData();
                    current = current.getNext();
                return data;
            }
            
            public E previous(){
                E data = current.getData();
                    current = current.getPrevious();
                return data;
            }
            
        };
        return it;
    }
    
    public ListIterator<E> listIterator(int index){
        ListIterator<E> it=new ListIterator<E>(){
            private Node<E> getNode(int index){
                if(index==0)
                    return last.getNext();
                else if(index==efectivo-1)
                    return last;
                
                else{
                    int con=1;   
                    for (Node<E> nodo=last.getNext().getNext();nodo!=last; nodo=nodo.getNext()){
                    if(con==index)
                        return nodo;
                    con++;
                  } 
               }
                return null;  
            }
            
            private Node<E> p=getNode(index);
            int currentIndex=index;
           
            
            @Override
            public boolean hasNext() {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return p!=null;
            }

            @Override
            public E next() {
                E data=p.getData();
                p=p.getNext();
                currentIndex++;
                return data;  
            }

            @Override
            public boolean hasPrevious() {
               //return current!=null;
                return p!=null;
                
            }

            @Override
            public E previous() {
                E data=p.getData();
                p=p.getPrevious();
                currentIndex--;
                return data;
            }

            @Override
            public int nextIndex() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int previousIndex() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void set(E e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void add(E e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        };
                
    return it;
    }
    
    
    
    
    }
    
    

