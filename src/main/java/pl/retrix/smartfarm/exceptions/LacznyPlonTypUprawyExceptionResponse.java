package pl.retrix.smartfarm.exceptions;

public class LacznyPlonTypUprawyExceptionResponse {

    private String typUprawy;

    public LacznyPlonTypUprawyExceptionResponse(String typUprawy) {
        this.typUprawy = typUprawy;
    }

    public String getTypUprawy() {
        return typUprawy;
    }

    public void setTypUprawy(String typUprawy) {
        this.typUprawy = typUprawy;
    }
}
