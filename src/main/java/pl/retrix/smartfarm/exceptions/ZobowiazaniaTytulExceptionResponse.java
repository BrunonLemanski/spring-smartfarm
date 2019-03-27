package pl.retrix.smartfarm.exceptions;

public class ZobowiazaniaTytulExceptionResponse {
    private String tytul;

    public ZobowiazaniaTytulExceptionResponse(String tytul) {
        this.tytul = tytul;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }
}
