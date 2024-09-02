package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    
    private Nodo raiz;

    private class Nodo {
        T valor;
        ABB<T> izq;
        ABB<T> der;
        ABB<T> arriba;

        public Nodo() {
            valor = null;
            izq = null;
            der = null;
            arriba = null;
        }
    }

    public ABB() {
        raiz = null;
    }

    public int cardinal() {
        if (this.raiz == null) {
            return 0;

        } else if (this.raiz.izq == null && this.raiz.der == null){
            return 1;

        } else if (this.raiz.izq == null) {
            return 1 + this.raiz.der.cardinal();

        } else if (this.raiz.der == null) {
            return 1 + this.raiz.izq.cardinal();

        } else {
            return 1 + this.raiz.izq.cardinal() + this.raiz.der.cardinal();
        }
    }

    public T minimo(){
        Nodo actual = new Nodo();
        actual = raiz;
        
        if (this.raiz == null) {
            return null;
        }

        while (actual.izq != null) {
            actual = actual.izq.raiz;
        }

        return actual.valor;
    }

    public T maximo(){
        Nodo actual = new Nodo();
        actual = raiz;
        
        if (this.raiz == null) {
            return null;
        }

        while (actual.der != null) {
            actual = actual.der.raiz;
        }

        return actual.valor;
    }

    public void insertar(T elem){
        if (!this.pertenece(elem)) {

            if (this.raiz == null) {
            this.raiz = new Nodo();
            raiz.valor = elem;

            } else if (elem.compareTo(this.raiz.valor) < 0) {
                
                if (this.raiz.izq != null) {
                    this.raiz.izq.insertar(elem);
    
                } else  {
                    this.raiz.izq = new ABB<>();
                    this.raiz.izq.raiz = new Nodo();
                    this.raiz.izq.raiz.valor = elem;
                    this.raiz.izq.raiz.arriba = this;
    
                }


            } else if (elem.compareTo(this.raiz.valor) > 0) {
                
                if (this.raiz.der != null) {
                    this.raiz.der.insertar(elem);
    
                } else  {
                    this.raiz.der = new ABB<>();
                    this.raiz.der.raiz = new Nodo();
                    this.raiz.der.raiz.valor = elem;
                    this.raiz.der.raiz.arriba = this;
    
                }
            
            }

        }    
            
    }

    public boolean pertenece(T elem){
        if (this.raiz == null) {
            return false;
        
        } else if (elem.compareTo(this.raiz.valor) == 0) {
            return true;

        } else if (elem.compareTo(this.raiz.valor) < 0) {

            if (this.raiz.izq != null) {
                return this.raiz.izq.pertenece(elem);

            } else  {
                return false;

            }

        } else {

            if (this.raiz.der != null) {
                return this.raiz.der.pertenece(elem);

            } else  {
                return false;
                
            }

        }

    }

    public void eliminar(T elem){
        if (this.raiz != null && this.pertenece(elem)) {
            if (elem.compareTo(this.raiz.valor) == 0) {
                if (this.raiz.der == null && this.raiz.izq == null) {
                    if (this.raiz.arriba != null) {
                        if (this.raiz.valor.compareTo(this.raiz.arriba.raiz.valor) < 0) {
                            this.raiz.arriba.raiz.izq = null;

                        } else {
                            this.raiz.arriba.raiz.der = null;

                        }
                    } else {
                        raiz = null;

                    }
                } else if (this.raiz.der == null) {
                    if (this.raiz.arriba != null) {
                        if (this.raiz.valor.compareTo(this.raiz.arriba.raiz.valor) < 0) {
                            this.raiz.arriba.raiz.izq = this.raiz.izq;
                            this.raiz.izq.raiz.arriba = this.raiz.arriba;

                        } else {
                            this.raiz.arriba.raiz.der = this.raiz.izq;
                            this.raiz.izq.raiz.arriba = this.raiz.arriba;
                        }
                    } else {
                        this.raiz.izq.raiz.arriba = null;
                        this.raiz = this.raiz.izq.raiz;

                    }

                } else if (this.raiz.izq == null) {
                    if (this.raiz.arriba != null) {
                        if (this.raiz.valor.compareTo(this.raiz.arriba.raiz.valor) < 0) {
                            this.raiz.arriba.raiz.izq = this.raiz.der;
                            this.raiz.der.raiz.arriba = this.raiz.arriba;

                        } else {
                            this.raiz.arriba.raiz.der = this.raiz.der;
                            this.raiz.der.raiz.arriba = this.raiz.arriba;

                        }
                    } else {
                        this.raiz.der.raiz.arriba = null;
                        this.raiz = this.raiz.der.raiz;

                    }

                } else if (this.raiz.izq != null && this.raiz.der != null) {
                    if (this.raiz.arriba != null) {
                        if (this.raiz.valor.compareTo(this.raiz.arriba.raiz.valor) < 0) {
                            T sucesor = this.sucesor();
                            this.eliminar(this.sucesor());
                            this.raiz.valor = sucesor;
                            this.raiz.arriba.raiz.izq.raiz.valor = sucesor;

                        } else {
                            T sucesor = this.sucesor();
                            this.eliminar(this.sucesor());
                            this.raiz.valor = sucesor;
                            this.raiz.arriba.raiz.der.raiz.valor = sucesor;
                            

                        }
                    } else {
                        T sucesor = this.sucesor();
                        this.eliminar(this.sucesor());
                        this.raiz.valor = sucesor;

                    }
                }

            } else if (elem.compareTo(this.raiz.valor) < 0) {
                this.raiz.izq.eliminar(elem);

            } else if (elem.compareTo(this.raiz.valor) > 0) {
                this.raiz.der.eliminar(elem);

            }

        } 

    }

    public String toString(){
        StringBuffer sbuffer = new StringBuffer();
        ABB<T> actual = new ABB<T>();
        actual = minimoArbol();
        sbuffer.append("{");

        while (actual.tieneArbolSucesor()) {
            sbuffer.append(actual.raiz.valor);
            sbuffer.append(",");
            actual = actual.arbolSucesor();
        }

        sbuffer.append(actual.raiz.valor);
        sbuffer.append("}");

        return sbuffer.toString();
        

    }

    private ABB<T> minimoArbol(){
        ABB<T> actual = new ABB<T>();
        actual = this;
        while (actual.raiz.izq != null) {
            actual = actual.raiz.izq;
        }

        return actual;
    }

    private boolean tieneArbolSucesor(){
        if (this.raiz.der != null){
            return true;

        } else {
            ABB<T> actual = new ABB<T>();
            ABB<T> padre = new ABB<T>();
            actual = this;
            padre = this.raiz.arriba;

            while (padre != null){
                if (actual.raiz.valor.compareTo(padre.raiz.valor) > 0) {
                    padre = padre.raiz.arriba;

                } else {
                    return true;

                }
            
            }

            return false;
        }
    }

    private ABB<T> arbolSucesor(){
        if (this.raiz.der != null) {
            return this.raiz.der.minimoArbol();

        } else {
            ABB<T> actual = new ABB<T>();
            actual = this;
            while (actual.raiz.valor.compareTo(actual.raiz.arriba.raiz.valor) > 0) {
                actual = actual.raiz.arriba;
            }

            return actual.raiz.arriba;

        }
    }

    private T sucesor(){
        if (this.raiz.der != null) {
            return this.raiz.der.minimo();

        } else {
            Nodo actual = new Nodo();
            actual = raiz;
            while (actual.valor.compareTo(actual.arriba.raiz.valor) > 0) {
                actual = actual.der.raiz;
            }

            return actual.arriba.raiz.valor;

        }
    }

    private class ABB_Iterador implements Iterador<T> {
        private ABB<T> _actual;

        public ABB_Iterador() {
            _actual = minimoArbol();
        }

        public boolean haySiguiente() {            
            return _actual.tieneArbolSucesor();
        }
    
        public T siguiente() {
            T valor = _actual.raiz.valor;
            if (haySiguiente()) _actual = _actual.arbolSucesor();
            return valor;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
