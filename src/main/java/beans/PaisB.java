package beans;

public class PaisB {
    private int idPais;
    private String nombre;
    private String poblacion;
    private String tamano;
    private ContinenteB continenteB;


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

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public ContinenteB getContinenteB() {
        return continenteB;
    }

    public void setContinenteB(ContinenteB continenteB) {
        this.continenteB = continenteB;
    }
}
