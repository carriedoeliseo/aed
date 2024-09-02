package aed;

class Funciones {
    int cuadrado(int x) {
        int res = x*x;
        return res;
    }

    double distancia(double x, double y) {
        double res =  Math.sqrt( x*x + y*y ) ; 
        return res;
    }

    boolean esPar(int n) {
        boolean res = (n%2 == 0) ;
        return res;
    }

    boolean esBisiesto(int n) {
        boolean res = (n%4 == 0) && (!(n%100 == 0) || (n%400 == 0)) ; 
        return res;
    }

    int factorialIterativo(int n) {
        int res = 1 ;
        int i = 1 ;
        if (n != 0){
            while (i != (n+1)){
                res = res*i; 
                i += 1; 
            }
        }
        return res;
    }

    int factorialRecursivo(int n) {
        int res = 1 ;
        if (n != 0){
            res = n * factorialRecursivo(n-1) ;
        }
        return res;
    }

    boolean esPrimo(int n) {
        int cant_divisores = 0;
        for (int i=1 ; i != n+1 ; i++){
            if (n%i == 0) cant_divisores += 1 ;
        }
        return (cant_divisores == 2);
    }

    int sumatoria(int[] numeros) {
        int res = 0 ;
        for (int i = 0; i != numeros.length ; i++){
            res += numeros[i] ;
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        int res = -1 ;
        for (int i = 0 ; i != numeros.length ; i++){
            if (numeros[i] == buscado) res = i ;
        }
        return res;
    }

    boolean tienePrimo(int[] numeros) {
        for(int i = 0; i != numeros.length ; i++){
            if (esPrimo(numeros[i]) == true) return true ;
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
        for(int i : numeros){
            if(!(esPar(i))) return false ;
        }
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        for(int i = 0 ; i != s1.length() ; i++){
            if (i >= s2.length()) return false ;
            if (s1.charAt(i) != s2.charAt(i)) return false ;
        }
        return true;
    }

    boolean esSufijo(String s1, String s2) {
        int lenght_dif = s2.length() - s1.length() ;
        if (lenght_dif < 0) return false ;
        for(int i = s2.length()-1 ; i != lenght_dif-1 ; i--){
            if (s1.charAt(i-lenght_dif) != s2.charAt(i)) return false ;
        }
        return true;
    }
}
