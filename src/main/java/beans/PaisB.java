package beans;

public class PaisB {
    private int idPais;
    private String nombrePais;
    private String poblacion;
    private String tamaño;
    private ContinenteB continenteB;


    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public ContinenteB getContinenteB() {
        return continenteB;
    }

    public void setContinenteB(ContinenteB continenteB) {
        this.continenteB = continenteB;
    }
}
