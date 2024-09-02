package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    
    private Nodo first;
    private Nodo last;
    int lenght;

    private class Nodo {
        
        T data;
        Nodo next;
        Nodo previous;

        public Nodo(T elem) {
            this.data = elem;
            this.next = null;
            this.previous = null;
        }
        
    }

    public ListaEnlazada() {
        this.first = null;
        this.last = null;
        this.lenght = 0; 
    }

    public int longitud() {
        return this.lenght;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        
        if (this.longitud() == 0) {
            this.last = nuevo;}

        else {
            nuevo.next = this.first;
            this.first.previous = nuevo;}

        this.first = nuevo;
        this.lenght++;
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);

        if (this.longitud() == 0) {
            this.first = nuevo;}

        else {
            nuevo.previous = this.last;
            this.last.next = nuevo;}
        
        this.last = nuevo;
        this.lenght++;
    }

    public T obtener(int i) {
        Nodo actual = this.first;
        for (int j = 0; j != i; j++) {
            actual = actual.next;
        }
        return actual.data;
    }

    public void eliminar(int i) {
        Nodo actual = this.first;

        for (int j = 0; j != i; j++) {
            actual = actual.next;
        }
       
        if (this.longitud() == 1) {
            this.first = null;
            this.last = null;
        } else if (i == 0) {
            actual.next.previous = actual.previous;
            this.first = actual.next;
        } else if (i == this.longitud()-1) {
            actual.previous.next = actual.next;
            this.last = actual.previous;
        } else {
            actual.next.previous = actual.previous;
            actual.previous.next = actual.next;
        }
        this.lenght--;
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo nuevo = new Nodo(elem);
        Nodo actual = this.first;

        for (int j = 0; j != indice; j++){
            actual = actual.next;
        }

        nuevo.next = actual.next;
        nuevo.previous = actual.previous;

        if (indice != 0 && indice != this.longitud()-1)
            actual.previous.next = nuevo;
            actual.next.previous = nuevo;
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> copia = new ListaEnlazada<>();

        copia.first = this.first;
        copia.last = this.last;
        copia.lenght = this.longitud();

        return copia;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {

        this.first = lista.first;
        this.last = lista.last;
        this.lenght = lista.longitud();
    }
    
    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append("[");
        for (int j = 0; j < this.longitud(); j++) {
            sbuffer.append(this.obtener(j).toString());

            if (j != this.longitud()-1) {sbuffer.append(", ");}
            else {sbuffer.append("]");}
        }

        return sbuffer.toString();
    }

    private class ListaIterador implements Iterador<T> {
    	int index;

        public ListaIterador(int i) {
            this.index = i;
        }

        public boolean haySiguiente() {
	        return index != lenght;
        }
        
        public boolean hayAnterior() {
	        return index != 0;
        }

        public T siguiente() {
	        int i = this.index;
            this.index = this.index + 1;
            return obtener(i);
        }
        

        public T anterior() {
            int i = this.index - 1;
            this.index = i;
	        return obtener(i);
        }
    }

    public Iterador<T> iterador() {
	    return new ListaIterador(0);
            
        }
    }


