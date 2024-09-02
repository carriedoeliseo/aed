package aed;

public class Recordatorio {

    private String _mensaje;
    private Fecha _fecha;
    private Horario _horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this._mensaje = mensaje;
        this._fecha = new Fecha(fecha);
        this._horario = horario;
    }

    public Horario horario() {
        return this._horario;
    }

    public Fecha fecha() {
        Fecha f = new Fecha(this._fecha);
        return f;

    }

    public String mensaje() {
        return this._mensaje;
    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append(mensaje().toString());
        sbuffer.append(" @ ");
        sbuffer.append(fecha().toString() + " ");
        sbuffer.append(horario().toString());
        return sbuffer.toString();
    }

    @Override
    public boolean equals(Object otro) {
        boolean oen = (otro == null);
        if (oen){
            return false;
        }
        boolean cd = otro.getClass() != this.getClass();
        if (cd){
            return false;
        }

        Recordatorio otroRecordatorio = (Recordatorio) otro;
        return this._mensaje.equals(otroRecordatorio._mensaje) && this._fecha.equals(otroRecordatorio._fecha) && this._horario.equals(otroRecordatorio._horario);
    }

}
