package aed;

public class Horario {

    private int _hora;
    private int _minutos;

    public Horario(int hora, int minutos) {
        this._hora = hora;
        this._minutos = minutos;
    }

    public Integer hora() {
        return this._hora;
    }

    public Integer minutos() {
        return this._minutos;
    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();

        sbuffer.append(hora().toString() + ":");
        sbuffer.append(minutos().toString());

        return sbuffer.toString();
    }

    @Override
    public boolean equals(Object otro) {
        boolean oen = (otro == null);
        boolean cd = otro.getClass() != this.getClass();
        if (oen || cd){
            return false;
        }

        Horario otroHorario = (Horario) otro;
        return this._hora == otroHorario._hora && this._minutos == otroHorario._minutos;

    }

}
