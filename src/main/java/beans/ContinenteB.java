package beans;

public class ContinenteB {

    private int idContinente;
    private String nombre;

    public String colorF() {

        String colorF="";
        if (nombre.equals("Africa")) {
            colorF= "fila-blue";
        } else if (nombre.equals("America")) {
            colorF= "fila-purple";
        } else if (nombre.equals("Asia")) {
            colorF= "fila-red";
        } else if (nombre.equals("Europa")){
            colorF= "fila-yellow";
        }else if (nombre.equals("Oceania")){
            colorF= "fila-green";
        }
        return colorF;
    }

    public int getIdContinente() {
        return idContinente;
    }

    public void setIdContinente(int idContinente) {
        this.idContinente = idContinente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
