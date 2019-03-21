package pl.retrix.smartfarm.exceptions;

public class LacznyPlonTypUprawyExceptionResponse {

    private Integer typUprawy;

    public LacznyPlonTypUprawyExceptionResponse(Integer typUprawy) {
        this.typUprawy = typUprawy;
    }

    public Integer getTypUprawy() {
        return typUprawy;
    }

    public void setTypUprawy(Integer typUprawy) {
        this.typUprawy = typUprawy;
    }
}
