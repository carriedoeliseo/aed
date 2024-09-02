package aed;
import java.util.*;

public class DiccionarioDigital<T> {

    /*
     InvRep:
        - Los nodos tienen un solo padre, salvo la raiz que no tiene.
        - Los nodos si no tienen un significado, tienen hijos.
     */

    Nodo _raiz;
    int _tamanio;

    private class Nodo {
        ArrayList<Nodo> _hijos;
        T _definicion;

        public Nodo() {
            _hijos = new ArrayList<Nodo>(256); // O(256) ≡ O(1)

            for (int i = 0; i < 256; i++) { // Iteraciones: O(256)
                _hijos.add(null); // O(1)

            } // Ciclo: O(1)

            _definicion = null;

        } // Complejidad: O(1)
    }

    public DiccionarioDigital() {
        _raiz = new Nodo(); // O(1)
        _tamanio = 0; // O(1)

    } // Complejidad: O(1)

    public boolean esta(String key) {
        Nodo actual = _raiz; // O(1)

        for(int i = 0; i < key.length(); i++) { // Iteraciones: O(|k|); k ∈ Keys 
            char caracter = key.charAt(i); // O(1)
            actual = actual._hijos.get((int) caracter); // O(1)

            if (actual == null) { // O(1)
                return false; // O(1)

            } // Condicional: O(1)

        } // Ciclo: O(|k|)

        return true;

    } // Complejidad: O(|k|)
    
    public void definir(String key, T value) {
        Nodo actual = _raiz; // O(1)

        for(int i = 0; i < key.length(); i++) { // Iteraciones: O(|k|)
            char caracter = key.charAt(i); // O(1)
            Nodo nuevoNodo = actual._hijos.get((int) caracter); // O(1)

            if (nuevoNodo == null) { // O(1)
                nuevoNodo = new Nodo(); // O(1)
                actual._hijos.set((int) caracter, nuevoNodo); // O(1)

            } // Condicional: O(1)

            actual = nuevoNodo; // O(1)

        } // Ciclo: O(|k|)

        if (actual._definicion == null) { // O(1)
            _tamanio++; // O(1)

        } // Condicional: O(1)

        actual._definicion = value; // O(1)

    } // Complejidad: O(|k|)

    public int tamanio() {
        return _tamanio; // O(1)

    } // Complejidad: O(1)

    public T obtener(String key) {
        Nodo actual = _raiz; // O(1)

        for(int i = 0; i < key.length(); i++) { // Iteraciones: O(|k|)
            char caracter = key.charAt(i); // O(1)
            actual = actual._hijos.get((int) caracter); // O(1)

            if (actual == null) { // O(1)
                return null; // O(1)

            } // Condiconal: O(1)

        } // Ciclo: O(|k|)
        
        return actual._definicion;

    } // Complejidad: O(|k|)

    public void borrar(String key) {
        Nodo actual = borrarRecursivo(key, _raiz, 0); // O(|k|)

        if (actual != null) { // O(1)
            _raiz = actual; // O(1)

        } // Condicional: O(1)

    } // Complejidad: O(|k|)

    private Nodo borrarRecursivo(String key, Nodo actual, int i) {  // Recorre el largo de la clave key (|k|)
        if (actual == null) { // O(1)
            return null; // O(1)

        } // Condicional: O(1)

        if (i < key.length()) { // O(1)
            char caracter = key.charAt(i); // O(1)
            actual._hijos.set((int) caracter, borrarRecursivo(key, actual._hijos.get((int) caracter), i + 1)); // O(|k|)

        } else if (actual._definicion != null) { // O(1)
            actual._definicion = null; // O(1)
            _tamanio--; // O(1)

        } // Condicional: O(|k|)

        if (actual._definicion != null) { // O(1)
            return actual; // O(1)

        } // Condicional: O(1)

        for (int j = 0; j < 256; j++) { // Iteraciones: O(256) ≡ O(1)

            if (actual._hijos.get(j) != null) { // O(1)
                return actual; // O(1)

            } // Condicional: O(1)

        } // Ciclo: O(1)
        
        return null; // O(1)

    } // Complejidad: O(|k| + 3) ≡ O(|k|)

    public String[] inorder() { 
        ArrayList<String> lista = new ArrayList<String>(this._tamanio); // O(|Keys|) ≡ O(k∈Keys∑ 1)
        inorderRecursivo("", this._raiz, lista); // O(k∈Keys∑ |k|); Keys el conjunto de claves.
        return arrayAString(lista); // O(|Keys|) ≡ O(k∈Keys∑ 1)

    } // O(k∈Keys∑ |k| + k∈Keys∑ 2) ≡ O(k∈Keys∑ |k|+2) ≡ O(k∈Keys∑ |k|)

    private String[] arrayAString (ArrayList<String> lista) {
        String[] res = new String[lista.size()]; // O(|lista|)

        for (int i = 0; i < lista.size(); i++){ // Iteraciones: O(|lista|)
            res[i] = lista.get(i); // O(1)

        } // Ciclo: O(|lista|)

        return res; // O(1)

    } // Complejidad: O(2|lista|) ≡ O(|lista|)

    private void inorderRecursivo(String key, Nodo nodo, ArrayList<String> lista) { // Recorre el largo de todas las claves k
        if (nodo == null) { // O(1)
            return; // O(1)

        } // Condicional: O(1)
        if (nodo._definicion != null) { // O(1)
            lista.add(key); /* O(1)
            ; Notar que en ningun momento se redimenciona el ArrayList, entonces agregar elementos es O(1)*/

        } // Condicional: O(1)

        for (int i = 0; i < 256; i++) { // Iteraciones: O(256) ≡ O(1) 

            if (nodo._hijos.get(i) != null) { // O(1)
                inorderRecursivo(key + (char) i, nodo._hijos.get(i), lista); // O(k∈Keys∑ |k|)

            } // Condicional: O(k∈Keys∑ |k|)

        } // Ciclo: O(k∈Keys∑ |k|)

    } // Complejidad: O(k∈Keys∑ |k|)

}