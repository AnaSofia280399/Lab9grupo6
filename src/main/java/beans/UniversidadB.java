package beans;

public class UniversidadB {
    private int idUniversidad;
    private String nombre;
    private int ranking;
    private int num_estud;
    private String url_foto;
    private  PaisB Pais_idPais;




    public int getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(int idUniversidad) {
        this.idUniversidad = idUniversidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getNum_estud() {
        return num_estud;
    }

    public void setNum_estud(int num_estud) {
        this.num_estud = num_estud;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    public PaisB getPais_idPais() {
        return Pais_idPais;
    }

    public void setPais_idPais(PaisB pais_idPais) {
        Pais_idPais = pais_idPais;
    }
}
