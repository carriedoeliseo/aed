# TP2-AED

carreras: Dict Digital < nom carrera, Carrera³ >
estudiantes: Dict Digital < LU, Estudiante² >

clase Carrera
  nombre: String
  materias Dic Digital < nom materia, Materia¹ >

clase Materia
  cant inscriptos: int
  cupo: int
  plantel docente: enum(PROFE, JTP, AY1, AY2)
  estudiantes materia: Dict Digital < LU, Estudiante² >
  nombres: Dict Digital <nom materia, Carrera³ >

clase Estudiante
  cant materias: int

¹ Aliassing entre Materias
² Aliassing entre Estudiantes
³ Aliassing entre Carreras
