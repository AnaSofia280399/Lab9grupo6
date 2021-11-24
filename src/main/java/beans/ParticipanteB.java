package beans;

public class ParticipanteB {
    private int idParticipante;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private PaisB idpais;

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public PaisB getIdpais() {
        return idpais;
    }

    public void setIdpais(PaisB idpais) {
        this.idpais = idpais;
    }
}
