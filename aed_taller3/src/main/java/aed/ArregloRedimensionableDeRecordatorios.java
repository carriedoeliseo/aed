package aed;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {

    private Recordatorio[] _recordatorios;

    public ArregloRedimensionableDeRecordatorios() {
        this._recordatorios = new Recordatorio[0];
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this._recordatorios = new Recordatorio[vector.longitud()];
        for (int j = 0; j < vector.longitud(); j++){
            this._recordatorios[j] = vector.obtener(j);
        }
    }

    public int longitud() {
        return this._recordatorios.length;
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio[] arreglo = new Recordatorio[this._recordatorios.length +1];
        for (int j = 0; j < arreglo.length -1; j++){
            arreglo[j] = this._recordatorios[j]; 
        }
        arreglo[this._recordatorios.length] = i;
        this._recordatorios = arreglo;
    }

    public Recordatorio obtener(int i) {
        return this._recordatorios[i];
    }

    public void quitarAtras() {
        Recordatorio[] arreglo = new Recordatorio[this._recordatorios.length -1];
        for (int j = 0; j < arreglo.length; j++){
            arreglo[j] = this._recordatorios[j];
        }
        this._recordatorios = arreglo;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        this._recordatorios[indice] = valor;

    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios arreglo = new ArregloRedimensionableDeRecordatorios();
        for (int j = 0; j < this._recordatorios.length; j++){
            arreglo.agregarAtras(this._recordatorios[j]);
        }
        return arreglo;
    }

}
