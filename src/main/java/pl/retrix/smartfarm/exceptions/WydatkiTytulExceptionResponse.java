package pl.retrix.smartfarm.exceptions;

public class WydatkiTytulExceptionResponse {
    private String tytul;

    public WydatkiTytulExceptionResponse(String tytul) {
        this.tytul = tytul;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }
}
