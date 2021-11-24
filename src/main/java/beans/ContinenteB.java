package beans;

public class ContinenteB {

    private int idContinente;
    private String nombreContinente;

    public String colorF() {

        String colorF="";
        if (nombreContinente.equals("Africa")) {
            colorF= "fila-blue";
        } else if (nombreContinente.equals("America")) {
            colorF= "fila-purple";
        } else if (nombreContinente.equals("Asia")) {
            colorF= "fila-red";
        } else if (nombreContinente.equals("Europa")){
            colorF= "fila-yellow";
        }else if (nombreContinente.equals("Oceania")){
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

    public String getNombreContinente() {
        return nombreContinente;
    }

    public void setNombreContinente(String nombreContinente) {
        this.nombreContinente = nombreContinente;
    }
}
