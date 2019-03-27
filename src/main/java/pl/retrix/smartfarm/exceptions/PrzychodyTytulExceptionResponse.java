package pl.retrix.smartfarm.exceptions;

public class PrzychodyTytulExceptionResponse {
    private String tytul;

    public PrzychodyTytulExceptionResponse(String tytul) {
        this.tytul = tytul;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }
}
