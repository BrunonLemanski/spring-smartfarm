package pl.retrix.smartfarm.exceptions;

public class PozyczkiTytulExceptionRespone {

    private String tytul;

    public PozyczkiTytulExceptionRespone(String tytul) {
        this.tytul = tytul;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }
}
