package pl.retrix.smartfarm.exceptions;

public class MagazynNazwaExceptionResponse {

    private String nazwaTowaru;

    public MagazynNazwaExceptionResponse(String nazwaTowaru) {
        this.nazwaTowaru = nazwaTowaru;
    }

    public String getNazwaTowaru() {
        return nazwaTowaru;
    }

    public void setNazwaTowaru(String nazwaTowaru) {
        this.nazwaTowaru = nazwaTowaru;
    }
}
