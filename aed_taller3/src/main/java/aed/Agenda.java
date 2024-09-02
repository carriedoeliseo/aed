package aed;

public class Agenda {
    private Fecha _fecha;
    private ArregloRedimensionableDeRecordatorios _arreglorecordatorios;

    public Agenda(Fecha fechaActual) {
        this._fecha = fechaActual;
        this._arreglorecordatorios = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        this._arreglorecordatorios.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append(fechaActual().toString() + "\n");
        sbuffer.append("=====\n");
        for (int j = 0; j < _arreglorecordatorios.longitud(); j++){
            if (this._fecha.equals((this._arreglorecordatorios.obtener(j)).fecha())){
                sbuffer.append((_arreglorecordatorios.obtener(j)).toString() + "\n");
            }
        }
        return sbuffer.toString();
    }

    public void incrementarDia() {
        this._fecha.incrementarDia();

    }

    public Fecha fechaActual() {
        Fecha fa = new Fecha(this._fecha);
        return fa;
    }

}
