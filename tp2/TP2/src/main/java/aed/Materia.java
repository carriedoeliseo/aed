package aed;
import aed.SistemaSIU.CargoDocente;
import java.util.*;

public class Materia {
   /*
   ¹carreras es ArrayList<Carrera>

   clase Materia
      cantInscriptos: int
      profes: int
      jtps: int
      ay1s: int
      ay2s: int
      alumnos: Dict Digital < LU, Estudiante >
      nombres: Dict Digital <nom_materia, carreras¹ >
   */

   /*
   InvRep:
      - cantInscriptos, profes, jtps, ay1s, ay2s ≥ 0.
      - No puede haber dos Estudiante iguales para dos LU distintos.
      - No puede haber dos carreras iguales para dos nom_materia distintos.
      - No puede haber dos Carrera iguales en un mismo carreras¹.
   */

   private int cantInscriptos;
   private int profes;
   private int jtps;
   private int ay1s;
   private int ay2s;
   private DiccionarioDigital<Estudiante> alumnos;
   private DiccionarioDigital<ArrayList<Carrera>> nombres;

  public Materia() {
   this.cantInscriptos = 0;
   this.profes = 0;
   this.jtps = 0;
   this.ay1s = 0;
   this.ay2s = 0;
   this.alumnos = new DiccionarioDigital<>();
   this.nombres = new DiccionarioDigital<>();
  }

   public int cantInscriptos() { 
      return this.cantInscriptos; // O(1)

   } // Complejidad: O(1)

   public void agregarDocente(CargoDocente c) {
      if (c == SistemaSIU.CargoDocente.PROF) { // O(1)
         this.profes++; // O(1)

      } else if (c == SistemaSIU.CargoDocente.JTP) { // O(1)
         this.jtps++; // O(1)

      } else if (c == SistemaSIU.CargoDocente.AY1) { // O(1)
         this.ay1s++; // O(1)

      } else if (c == SistemaSIU.CargoDocente.AY2) { // O(1)
         this.ay2s++; // O(1)

      } // Condicional: O(1)

   } // Complejidad: O(1)

   public int[] plantelDocente() {
      return new int[]{this.profes,this.jtps,this.ay1s,this.ay2s}; // O(1)

   } // Complejidad: O(1)

   public void cerrarMateria() {
      String[] estudiantes = this.alumnos.inorder(); // O(e∈E∑ 1) ≡ O(Em) 
      String[] nombres = this.nombres.inorder(); // O(n∈Nm∑ |n|) ≡ O(|Nm|)

      for (int i = 0; i < estudiantes.length; i++) { // Iteraciones: O(Em)
         Estudiante estudiante = this.alumnos.obtener(estudiantes[i]); // O(1)
         estudiante.restarMateria(); // O(1)

      } // Ciclo: O(Em)

      for (int i = 0; i < nombres.length; i++) { // Iteraciones: O(|Nm|)
         ArrayList<Carrera> carreras = this.nombres.obtener(nombres[i]); // O(|n|)

         // k es la cantidad carreras en las una materia tiene el mismo nombre.
         for (int j = 0; j < carreras.size(); j++) {  // Iteraciones: O(k)
            Carrera carrera = carreras.get(j); // O(1)
            carrera.borrarMateria(nombres[i]); // O(|n|)

         } // Ciclo: O(k*|n|) 

      } /* Ciclo: O(k₁|n₁| + ... + kᵢ|nᵢ|) ≡ O(n∈Nm∑ |n|)
      ; Notar que j∈[1,i]∑ kⱼ = |Nm| */

   } // Complejidad: O(2(n∈Nm∑ |n|) + 2Em) ≡ O(n∈Nm∑ |n| + Em)

   public void definirNombre(String nombre, Carrera carrera){
         ArrayList<Carrera> carreras = this.nombres.obtener(nombre); // O(|nombre|)

         if (carreras == null) { // O(1)
            carreras = new ArrayList<>(); // O(10) ≡ O(1)
            this.nombres.definir(nombre, carreras); // O(|nombre|)

         } // Condicional: // O(2|nombre|) ≡ O(|nombre|)

         carreras.add(carrera); // O(~1) (Amortizado)

   } // Complejidad: O(|nombre| + ~1)

   public boolean excedeCupo(){
      return this.cantInscriptos > this.profes*250 || // O(1)
             this.cantInscriptos > this.jtps*100 || // O(1)
             this.cantInscriptos > this.ay1s*20 || // O(1)
             this.cantInscriptos > this.ay2s*30; // O(1)

   } // Complejidad: O(1)

   public void definirAlumno(String LU, Estudiante estudiante) {
      this.alumnos.definir(LU, estudiante); // O(|LU|) ≡ O(1)
      this.cantInscriptos++; // O(1)

  } // Complejidad: O(1)
}
