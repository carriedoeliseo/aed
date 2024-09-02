package aed;

public class Fecha {

    private int _dia;
    private int _mes;


    public Fecha(int dia, int mes) {
        this._dia = dia;
        this._mes = mes;
    }

    public Fecha(Fecha fecha) {
        this._dia = fecha.dia();
        this._mes = fecha.mes();
        
    }

    public Integer dia() {
        return this._dia;
    }

    public Integer mes() {
        return this._mes;
    }

    public String toString() {
        StringBuffer sbuffer = new StringBuffer();

        sbuffer.append(dia().toString() + "/");
        sbuffer.append(mes().toString());

        return sbuffer.toString();
    }

    @Override
    public boolean equals(Object otra) {
        boolean oen = (otra == null);
        boolean cd = otra.getClass() != this.getClass();
        if (oen || cd){
            return false;
        }

        Fecha otraFecha = (Fecha) otra;
        return this._dia == otraFecha._dia && this._mes == otraFecha._mes;
    }

    public void incrementarDia() {
        if (dia() == diasEnMes(_mes) && mes() == 12){
            this._dia = 1;
            this._mes = 1;
        }
        else if (dia() == diasEnMes(_mes) && mes() != 12){
            this._dia = 1;
            this._mes++;
        }
        else {
            this._dia++;
        }
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
