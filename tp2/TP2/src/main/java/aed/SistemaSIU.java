package aed;

public class SistemaSIU {
    
    /*
    clase SistemaSIU
        carreras: Dict Digital < nom_carrera, Carrera¹ >
        estudiantes: Dict Digital < LU, Estudiante² >

    clase Carrera
        materias: Dic Digital < nom_materia, Materia >

    clase Materia
        cantInscriptos: int
        profes: int
        jtps: int
        ay1s: int
        ay2s: int
        alumnos: Dict Digital < LU, Estudiante² >
        nombres: Dict Digital < nom_materia, ArrayList<Carrera¹> >

    clase Estudiante
        cantMaterias: int

    ¹ Aliassing entre Carreras
    ² Aliassing entre Estudiantes
    */

    /*
     InvRep:
        - No hay dos nom_carrera iguales y no hay dos carreras iguales para dos nom_carrera distintos.
        - No hay dos LU iguales y no hay dos Estudiante iguales para dos LU distintos.
        - Si una Carrera de nombre nom_carrera está en carreras, entonces existe una materia en Carrera de nombre nom_materia
        tal que (ArrayList<Carrera>) carreras[nom_carrera].materias[nom_materia].nombres[nom_materia] contiene a Carrera.
        - Si una Materia tiene un nombre nom_materia, entonces existe una Carrera en carreras tal que tiene una materia llamada
        nom_materia.
        - No existen dos materias distintas de mismo nombre nom_materia en una misma carrera.
        - La suma de cantInscriptos de todas las materias es igual a la suma de cantMaterias de todos los estudiantes.
        ⋮
        + Invariantes de representacion de las otras clases. 
     */

    private DiccionarioDigital<Carrera> carreras;
    private DiccionarioDigital<Estudiante> estudiantes;

    enum CargoDocente{
        AY2,
        AY1,
        JTP,
        PROF
    }

    public SistemaSIU(InfoMateria[] materiasEnCarreras, String[] libretasUniversitarias){

        this.carreras = new DiccionarioDigital<Carrera>();
        this.estudiantes = new DiccionarioDigital<Estudiante>();

        for (int i = 0; i < materiasEnCarreras.length; i++){ // Iteraciones: O(|M|)
            InfoMateria infomateria = materiasEnCarreras[i]; // O(1)
            Materia actualmateria = new Materia(); // O(1)

            for (int j = 0; j < infomateria.carreras.length; j++){ // Iteraciones: O(|Nm|)
                String nombrecarrera = infomateria.carreras[j]; // O(1) 
                String nombremateria = infomateria.nombresEnCarreras[j]; // O(1)

                if (!this.carreras.esta(nombrecarrera)){ // O(|c|)
                    Carrera actualcarrera = new Carrera(nombrecarrera); // O(1)
                    this.carreras.definir(nombrecarrera, actualcarrera); // O(|c|)
                    actualcarrera.agregarMateria(nombremateria, actualmateria); // O(|n|)

                    actualmateria.definirNombre(nombremateria, actualcarrera); // O(|n| + ~1)

                } else {
                    Carrera actualcarrera = carreras.obtener(nombrecarrera); // O(|c|)
                    actualcarrera.agregarMateria(nombremateria, actualmateria); // O(|n|)

                    actualmateria.definirNombre(nombremateria, actualcarrera); // O(|n| + ~1)

                } // Condicional: O(|c| + |m| + ~1)
            
            } /* Ciclo: O(n∈Nm∑ |n|+|c| + |Nm|) ≡ O(n∈Nm∑ |n|+|c| + n∈Nm∑ 1) ≡ O(n∈Nm∑ |n|+|c|+1) ≡ O(n∈Nm∑ |n|+|c|)
            ; Notar que en un ArrayList, agregar |Nm| elementos es O(|Nm|) */

        } /* Ciclo: O(m∈M∑ (n∈Nm∑ |n|+|c|)) ≡ O(m∈M∑ n∈Nm∑ |n| +  m∈M∑ n∈Nm∑ |c|) ≡ O(m∈M∑ n∈Nm∑ |n| + c∈C∑ |c|*Mc)
        ; Notar que  m∈M∑ n∈Nm∑ |c| ≡ c∈C∑ |c|*Mc ya que para cada materia de todas las carreras tendremos 
        que definir u obtener el objeto Carrera desde el diccionario */


        for (int e = 0; e < libretasUniversitarias.length; e++){ // Iteraciones: O(E)
            Estudiante actualestudiante = new Estudiante(); // O(1)
            String nombreestudiante = libretasUniversitarias[e]; // O(1)
            this.estudiantes.definir(nombreestudiante, actualestudiante); // O(1)

        } // Ciclo: O(E)

    } // Complejidad: O(c∈C∑ |c|*Mc + m∈M∑ n∈Nm∑ |n| + E)

    public void inscribir(String estudiante, String carrera, String materia){
        Estudiante actualEstudiante = estudiantes.obtener(estudiante); // O(1)
        Carrera actualcarrera = carreras.obtener(carrera); // O(|c|)
        Materia actualmateria = actualcarrera.obtenerMateria(materia); // O(|m|)
        actualmateria.definirAlumno(estudiante,actualEstudiante); // O(1)
        actualEstudiante.sumarMateria(); // O(1)

    } // Complejidad: O(|c| + |m|)

    public void agregarDocente(CargoDocente cargo, String carrera, String materia){
        Carrera actualcarrera = carreras.obtener(carrera); // O(|c|)
        Materia actualmateria = actualcarrera.obtenerMateria(materia); // O(|m|)
        actualmateria.agregarDocente(cargo); // O(1)

    } // Complejidad: O(|c| + |m|)

    public int[] plantelDocente(String materia, String carrera){
        Carrera actualcarrera = carreras.obtener(carrera); // O(|c|)
        Materia actualmateria = actualcarrera.obtenerMateria(materia); // O(|m|)
        return actualmateria.plantelDocente(); // O(1)

    } // Complejidad: O(|c| + |m|)

    public void cerrarMateria(String materia, String carrera){
        Carrera actualcarrera = carreras.obtener(carrera); // O(|c|)
        Materia actualmateria = actualcarrera.obtenerMateria(materia); // O(|m|)
        actualmateria.cerrarMateria(); // O(n∈Nm∑ |n| + Em)

    } // Complejidad: O(|c| + |m| + n∈Nm∑ |n| + Em)

    public int inscriptos(String materia, String carrera){
        Carrera actualcarrera = carreras.obtener(carrera); // O(|c|)
        Materia actualmateria = actualcarrera.obtenerMateria(materia); // O(|m|)
        return actualmateria.cantInscriptos(); // O(1)

    } // Complejidad: O(|c| + |m|)

    public boolean excedeCupo(String materia, String carrera){
        Carrera actualcarrera = carreras.obtener(carrera); // O(|c|)
        Materia actualmateria = actualcarrera.obtenerMateria(materia); // O(|m|)
        return actualmateria.excedeCupo(); // O(1)

    } // Complejidad: O(|c| + |m|)

    public String[] carreras(){
        return carreras.inorder(); // O(c∈C∑ |c|)

    } // Complejidad: O(c∈C∑ |c|)

    public String[] materias(String carrera){
        Carrera actualcarrera = carreras.obtener(carrera); // O(|c|)
        return actualcarrera.materiasInorder(); // O(mc∈Mc∑ |mc|)

    } // Complejidad: O(|c| + mc∈Mc∑ |mc|)

    public int materiasInscriptas(String estudiante){
        Estudiante actualEstudiante = estudiantes.obtener(estudiante); // O(1)
        return actualEstudiante.cantMaterias(); // O(1)

    } // Complejidad: O(1)
}
