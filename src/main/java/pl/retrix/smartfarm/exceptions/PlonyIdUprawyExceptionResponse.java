package pl.retrix.smartfarm.exceptions;

public class PlonyIdUprawyExceptionResponse {
    private String idUprawy;

    public PlonyIdUprawyExceptionResponse(String idUprawy) {
        this.idUprawy = idUprawy;
    }

    public String getIdUprawy() {
        return idUprawy;
    }

    public void setIdUprawy(String idUprawy) {
        this.idUprawy = idUprawy;
    }
}
