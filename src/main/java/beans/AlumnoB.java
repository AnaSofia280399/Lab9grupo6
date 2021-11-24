package beans;

public class AlumnoB {

    private int idAlumno;
    private int codigo;
    private int promedio;
    private String condicion;
    private UniversidadB Universidad_idUniversidad;
    private ParticipanteB idParticipante;

    public ParticipanteB getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(ParticipanteB idParticipante) {
        this.idParticipante = idParticipante;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int  getPromedio() {
        return promedio;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public UniversidadB getUniversidad_idUniversidad() {
        return Universidad_idUniversidad;
    }

    public void setUniversidad_idUniversidad(UniversidadB universidad_idUniversidad) {
        Universidad_idUniversidad = universidad_idUniversidad;
    }

    public String getColorNombre() {
        String colornombre="";
        if (condicion.equals("E")) {
            colornombre= "color:red";
        }
        return colornombre;
    }

    public Boolean EliminaroNo() {
        Boolean elimi = false;
        if (condicion.equals("E")) {
            elimi = false;
        }else{
            elimi=true;
        }
        return elimi;
    }
}
