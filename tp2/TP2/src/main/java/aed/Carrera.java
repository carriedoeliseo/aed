package aed;

public class Carrera {
    /*
    clase Carrera
        materias Dic Digital < nom_materia, Materia > 
    */

    /*
     InvRep:
        - tamaño(materias) ≥ 0.
        - No puede haber dos Materia iguales para dos nom_materia distintos.
     */

    private DiccionarioDigital<Materia> materias;

    public Carrera(String nombrecarrera) { 
        this.materias = new DiccionarioDigital<>(); // O(1)

    } // Complejidad: O(1)

    public void agregarMateria(String nombremateria, Materia m) {
        this.materias.definir(nombremateria, m); // O(|nombremateria|)

    } // Complejidad: O(|nombremateria|)

    public Materia obtenerMateria(String nombremateria) {
        return this.materias.obtener(nombremateria); // O(|nombremateria|)

    } // Complejidad: O(|nombremateria|)

    public String[] materiasInorder() {
        return this.materias.inorder(); // O(n∈Nm∑ |n|)

    } // Complejidad: O(n∈Nm∑ |n|)

    public void borrarMateria (String nombremateria) {
        this.materias.borrar(nombremateria); // O(|nombremateria|)

    } // Complejidad: O(|nombremateria|)

}
