package aed;

class EspecificacionesTP {
    boolean esElMax (double x, double[] s){
        for (int i = 0; i < s.length; i++){
            if (x != s[i]){
                if (x <= s[i]) return false;
            }
        }
        return true;
    }

    int indiceMaximo (double[] s){
        int res = 0;
        for (int i = 0; i < s.length; i++){
            if (esElMax(s[i],s)) {res += i;}
            else {res += 0;}
        }
        return res;
    }

    boolean hayUnicoMaxLocal (double[] s){
        for (int i = 1; i <= indiceMaximo(s); i++){
            if (s[i-1] >= s[i]) {return false;}
        }
        for (int i = indiceMaximo(s); i < s.length-1; i++){
            if (s[i] <= s[i+1]) {return false;}
        }
        return true;
    }

    boolean trayectoriaExtrañaEscalera (double[] s){
        return (hayUnicoMaxLocal(s));
    }
}
