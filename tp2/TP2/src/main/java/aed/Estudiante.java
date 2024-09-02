package aed;

public class Estudiante {
    /*
     clase Estudiante
        cantMaterias: int
     */

    /*
     InvRep:
        - cantMaterias ≥ 0.
     */

   private int cantMaterias;

   public Estudiante(){
      this.cantMaterias = 0; // O(1)

   } // Complejidad: O(1)

   public void sumarMateria(){
      this.cantMaterias++; // O(1)

   } // Complejidad: O(1)

   public int cantMaterias(){
      return this.cantMaterias; // O(1)

   } // Complejidad: O(1)

   public void restarMateria() {
      this.cantMaterias--; // O(1)

   } // Complejidad: O(1)
}
