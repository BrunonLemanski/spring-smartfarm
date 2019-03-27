package pl.retrix.smartfarm.exceptions;

public class WyplatyTytulExceptionResponse {

    private String tytul;

    public WyplatyTytulExceptionResponse(String tytul) {
        this.tytul = tytul;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }
}
