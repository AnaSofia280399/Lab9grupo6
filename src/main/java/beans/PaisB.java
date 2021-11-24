package beans;

public class PaisB {

    private int idPais;
    private String nombre;
    private int poblacion;
    private int tamano;
    private ContinenteB Continente_idContinente;

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public ContinenteB getContinente_idContinente() {
        return Continente_idContinente;
    }

    public void setContinente_idContinente(ContinenteB continente_idContinente) {
        Continente_idContinente = continente_idContinente;
    }
}
