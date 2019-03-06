package pl.retrix.smartfarm.exceptions;

public class PolaUprawneExceptionResponse {

    private String nazwaPola;

    public PolaUprawneExceptionResponse(String nazwaPola){this.nazwaPola = nazwaPola;}

    public String getNazwaPola() { return nazwaPola; }

    public void setNazwaPola(String nazwaPola) {
        this.nazwaPola = nazwaPola;
    }
}
